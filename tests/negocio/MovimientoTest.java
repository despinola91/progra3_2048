package negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovimientoTest {

	@Test
	void moverArribaTest() {
		Juego.matriz = new int[][]{
			{2, 4, 4, 8},
	        {0, 2, 4, 16},
	        {0, 0, 0, 0},
	        {4, 2, 0, 2}
			};
			
		
		int[][] matrizEsperada = {
			{2, 4, 8, 8},
	        {4, 4, 0, 16},
	        {0, 0, 0, 2},
	        {0, 0, 0, 0}
			};
	}
	
	@Test
	void moverAbajoTest() {
		Juego.matriz = new int[][]{
			{2, 4, 4, 8},
	        {0, 2, 4, 16},
	        {0, 0, 0, 0},
	        {4, 2, 0, 2}
			};
			
		
		int[][] matrizEsperada = {
			{0, 0, 0, 0},
	        {0, 0, 0, 8},
	        {2, 4, 0, 16},
	        {4, 4, 8, 2}
			};
	}
	
	@Test
	void moverIzquierdaTest() {
		Juego.matriz = new int[][]{
			{2, 4, 4, 8},
	        {0, 2, 4, 16},
	        {0, 0, 0, 0},
	        {4, 2, 0, 2}
			};
			
		
		int[][] matrizEsperada = {
			{2, 8, 8, 0},
	        {2, 4, 16, 0},
	        {0, 0, 0, 0},
	        {4, 4, 0, 0}
			};
	}
	
	@Test
	void moverDerechaTest() {
		Juego.matriz = new int[][]{
			{2, 4, 4, 8},
	        {0, 2, 4, 16},
	        {0, 0, 0, 0},
	        {4, 2, 0, 2}
			};
			
		
		int[][] matrizEsperada = {
			{0, 2, 8, 8},
	        {0, 2, 4, 16},
	        {0, 0, 0, 0},
	        {0, 0, 4, 4}
			};
	}

}
