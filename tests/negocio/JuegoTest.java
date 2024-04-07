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
}
