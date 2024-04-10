package negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {
    private Juego juego; // Instancia de Juego

    @BeforeEach
    void setUp() {
        juego = new Juego(); // Crear una nueva instancia de Juego antes de cada prueba
    }

    @Test
    void obtenerValorRandomTest() {
        assertThat(juego.obtenerValorRandom(), anyOf(equalTo(2), equalTo(4)));
    }
    
    @Test
    void obtenerPosicionDisponible() {
        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1}
        });
        
        Posicion posicion = juego.obtenerPosicionRandomDisponible(); 
        assertTrue(posicion.obtenerFila() == 2 && posicion.obtenerColumna() == 0);
        
        juego.definirMatriz( new int[][]{
            {1, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });
        
        posicion = juego.obtenerPosicionRandomDisponible(); 
        assertTrue(posicion.obtenerFila() == 0 && posicion.obtenerColumna() == 3);
        
        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1}
        });
        
        posicion = juego.obtenerPosicionRandomDisponible(); 
        assertTrue(posicion.obtenerFila() == 3 && posicion.obtenerColumna() == 2);
    }
    
    @Test
    void moverArriba () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverElementosArriba();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();

        assertArrayEquals(new int[]{4,8,0,16}, estadoMatriz[0]);
        assertArrayEquals(new int[]{4,8,0,16}, estadoMatriz[1]);
        assertArrayEquals(new int[]{0,0,0,0}, estadoMatriz[2]);
        assertArrayEquals(new int[]{0,0,0,0}, estadoMatriz[3]);
    }
    
    @Test
    void moverAbajo () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverElementosAbajo();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();

        assertArrayEquals(new int[]{0,0,0,0}, estadoMatriz[0]);
        assertArrayEquals(new int[]{0,0,0,0}, estadoMatriz[1]);
        assertArrayEquals(new int[]{4,8,0,16}, estadoMatriz[2]);
        assertArrayEquals(new int[]{4,8,0,16}, estadoMatriz[3]);
    }
    
    @Test
    void moverIzquierda () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverElementosIzquierda();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();

        assertArrayEquals(new int[]{2,4,8,0}, estadoMatriz[0]);
        assertArrayEquals(new int[]{2,4,8,0}, estadoMatriz[1]);
        assertArrayEquals(new int[]{2,4,8,0}, estadoMatriz[2]);
        assertArrayEquals(new int[]{2,4,8,0}, estadoMatriz[3]);
    }
    
    @Test
    void moverDerecha () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverElementosDerecha();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();
    	
    	assertArrayEquals(new int[]{0,2,4,8}, estadoMatriz[0]);
        assertArrayEquals(new int[]{0,2,4,8}, estadoMatriz[1]);
        assertArrayEquals(new int[]{0,2,4,8}, estadoMatriz[2]);
        assertArrayEquals(new int[]{0,2,4,8}, estadoMatriz[3]);
    }

    @Test
    void incrementarPuntaje() {
        juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,0,8,8}
    	});

        juego.moverElementosDerecha();

        assertEquals(16, juego.obtenerPuntaje());
    }
}
