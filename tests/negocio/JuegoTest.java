package negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class JuegoTest {

	@Test
	void ObtenerValorRandomTest() {
		assertThat(Juego.ObtenerValorRandom(), anyOf(equalTo(2), equalTo(4)));
	}
	
	@Test
	void ObtenerPosicionDisponible() {
	Juego.matriz = new int[][]{
		{1, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1}
		};
	}
}
