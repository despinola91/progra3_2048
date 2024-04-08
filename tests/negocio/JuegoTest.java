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
    	
    	juego.moverArriba();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();
    	
    	assertTrue(estadoMatriz[0][0] == 4 && estadoMatriz[0][1] == 8 && estadoMatriz[0][3] == 16);
    	assertTrue(estadoMatriz[1][0] == 4 && estadoMatriz[1][1] == 8 && estadoMatriz[1][3] == 16);
    }
    
    @Test
    void MoverAbajo () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverAbajo();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();
    	
    	assertTrue(estadoMatriz[2][0] == 4 && estadoMatriz[2][1] == 8 && estadoMatriz[2][3] == 16);
    	assertTrue(estadoMatriz[3][0] == 4 && estadoMatriz[3][1] == 8 && estadoMatriz[3][3] == 16);
    }
    
    @Test
    void MoverIzquierda () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverIzquierda();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();
    	
    	assertTrue(estadoMatriz[0][0] == 2 && estadoMatriz[0][1] == 4 && estadoMatriz[0][2] == 8);
    	assertTrue(estadoMatriz[1][0] == 2 && estadoMatriz[1][1] == 4 && estadoMatriz[1][2] == 8);
    	assertTrue(estadoMatriz[2][0] == 2 && estadoMatriz[2][1] == 4 && estadoMatriz[2][2] == 8);
    	assertTrue(estadoMatriz[3][0] == 2 && estadoMatriz[3][1] == 4 && estadoMatriz[3][2] == 8);
    }
    
    @Test
    void MoverDerecha () {
    	juego.definirMatriz( new int[][] {
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8},
    		{2,4,0,8}
    	});
    	
    	juego.moverDerecha();
    	
    	int[][] estadoMatriz = juego.obtenerMatriz();
    	
    	assertTrue(estadoMatriz[0][1] == 2 && estadoMatriz[0][2] == 4 && estadoMatriz[0][3] == 8);
    	assertTrue(estadoMatriz[1][1] == 2 && estadoMatriz[1][2] == 4 && estadoMatriz[1][3] == 8);
    	assertTrue(estadoMatriz[2][1] == 2 && estadoMatriz[2][2] == 4 && estadoMatriz[2][3] == 8);
    	assertTrue(estadoMatriz[3][1] == 2 && estadoMatriz[3][2] == 4 && estadoMatriz[3][3] == 8);
    }
}
