package negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class JuegoTest {

	@Test
	void ObtenerValorRandomTest() {
		assertThat(Juego.obtenerValorRandom(), anyOf(equalTo(2), equalTo(4)));
	}
	
	@Test
	void ObtenerPosicionDisponible() {
	Juego.matriz = new int[][]{
		{1, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1}
		};
		
	Posicion posicion = Juego.obtenerPosicionRandomDisponible();	
	assertTrue(posicion.obtenerFila() == 2 && posicion.obtenerColumna() == 0);
	
	Juego.matriz = new int[][]{
		{1, 1, 1, 0},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}
		};
		
	posicion = Juego.obtenerPosicionRandomDisponible();	
	assertTrue(posicion.obtenerFila() == 0 && posicion.obtenerColumna() == 3);
	
	Juego.matriz = new int[][]{
		{1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 1}
		};
		
	posicion = Juego.obtenerPosicionRandomDisponible();	
	assertTrue(posicion.obtenerFila() == 3 && posicion.obtenerColumna() == 2);
	}
}
