package negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {
    private Juego juego; // Instancia de Juego

    @BeforeEach
    void setUp() {
        juego = new Juego(); // Crear una nueva instancia de Juego antes de cada prueba
    }

    @Test
    void obtenerValorRandom() {
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

        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });
        
        posicion = juego.obtenerPosicionRandomDisponible(); 
        assertTrue(posicion == null);
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
    
    @Test
    void obtenerRecomendacion() {

        //Caso con celdas contiguas
        juego.definirMatriz(new int[][] {
            {0, 0, 0, 0},
            {0, 4, 0, 8},
            {2, 4, 0, 0},
            {0, 0, 0, 0}
        });

        Recomendacion recomendacion = juego.obtenerRecomendacion();

        Celda celdaEsperada1 = new Celda(4, 1, 1);
        Celda celdaEsperada2 = new Celda(4, 2, 1);
     
        assertThat(recomendacion.obtenerPrimeraCelda(), samePropertyValuesAs(celdaEsperada1));
        assertThat(recomendacion.obtenerSegundaCelda(), samePropertyValuesAs(celdaEsperada2));


        // Caso sin recomendaciones
        juego.definirMatriz(new int[][] {
            {0, 0, 0, 0},
            {0, 0, 0, 8},
            {0, 4, 0, 0},
            {2, 0, 0, 0}
        });

        recomendacion = juego.obtenerRecomendacion();
        assertTrue(recomendacion == null);


        //Caso con celdas distanciadas
        juego.definirMatriz(new int[][] {
            {0, 0, 0, 0},
            {0, 4, 0, 8},
            {2, 0, 0, 0},
            {0, 4, 0, 0}
        });

        recomendacion = juego.obtenerRecomendacion();

        celdaEsperada1 = new Celda(4, 1, 1);
        celdaEsperada2 = new Celda(4, 3, 1);

        assertThat(recomendacion.obtenerPrimeraCelda(), samePropertyValuesAs(celdaEsperada1));
        assertThat(recomendacion.obtenerSegundaCelda(), samePropertyValuesAs(celdaEsperada2));

        //Verificando cantidad de recomendaciones
        juego.definirMatriz(new int[][] {
            {16, 0, 16, 0},
            {0, 4, 0, 8},
            {2, 4, 2, 8},
            {0, 4, 0, 0}
        });

        assertEquals(4, juego.obtenerRecomendacionesPosibles().size());

        //Caso con celdas distanciadas con obstáculo
        juego.definirMatriz(new int[][] {
            {2, 0, 0, 0},
            {8, 4, 0, 8},
            {2, 8, 0, 0},
            {0, 4, 16, 4}
        });

        recomendacion = juego.obtenerRecomendacion();

        assertTrue(recomendacion == null);
    }

    @Test
    void juegoGanado() {

        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, 2048, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });

        assertTrue(juego.juegoGanado() == true);
        
        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, -2048, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });

        assertTrue(juego.juegoGanado() == false);

        juego.definirMatriz( new int[][]{
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });

        assertTrue(juego.juegoGanado() == false);
    }

    @Test
    void juegoPerdido() {

        juego.definirMatriz( new int[][]{
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 2}
        });

        assertTrue(juego.juegoPerdido() == true);

        juego.definirMatriz( new int[][]{
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 0}
        });

        assertTrue(juego.juegoPerdido() == false);

        juego.definirMatriz( new int[][]{
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 4}
        });

        assertTrue(juego.juegoPerdido() == false);
        
    }
}
    