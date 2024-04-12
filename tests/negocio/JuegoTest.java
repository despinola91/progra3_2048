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
    void ObtenerValorRandomTest() {
        assertThat(juego.obtenerValorRandom(), anyOf(equalTo(2), equalTo(4)));
    }
    
    @Test
    void ObtenerPosicionDisponible() {
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
    void MoverArriba () {
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
    void MoverAbajo () {
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
    void MoverIzquierda () {
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
    void MoverDerecha () {
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
    void obtenerPosicionesJugadaRecomendada() {
        juego.definirMatriz(new int[][] {
            {0, 0, 0, 0},
            {0, 4, 0, 8},
            {2, 4, 0, 8},
            {2, 4, 0, 8}
        });

        Posicion[] posicionesJugadaRecomendada = juego.obtenerPosicionesJugadaRecomendada();
        Posicion posicionJugadaRecomendadaEsperada = new Posicion(1, 1);

        // Verifico si la posicion buscada está dentro del array 
        boolean posicionEncontrada = false;
        for (Posicion posicionJugada : posicionesJugadaRecomendada) {
            if (posicionJugada.equals(posicionJugadaRecomendadaEsperada)) {
                posicionEncontrada = true;
            }
        }
        
        // Caso Null
        juego.definirMatriz(new int[][] {
            {0, 0, 0, 0},
            {0, 0, 0, 8},
            {0, 4, 0, 0},
            {2, 0, 0, 8}
        });

        posicionesJugadaRecomendada = juego.obtenerPosicionesJugadaRecomendada();

        // Verifico si la posicion buscada está dentro del array 
        boolean posicionNoEncontrada = posicionesJugadaRecomendada == null;
        
        
        assertTrue(posicionEncontrada, "La posición esperada no está en las posiciones recomendadas");
        assertTrue(posicionNoEncontrada, "No deberían existir jugadas recomendadas");
    }

}
