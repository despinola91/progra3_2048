package interfaz;

import java.util.Random;

public class Logica {
	private PantallaJuego pantalla;
	private int[][] tablero;
	private int size = 4;


	public Logica(PantallaJuego pantalla) {
		this.pantalla = pantalla;
		this.tablero = new int[size][size];
		agregarFichaNueva();
		agregarFichaNueva();
	}

	private void agregarFichaNueva() {
		Random random = new Random();
		int fila = random.nextInt(size);
		int columna = random.nextInt(size);

		while (tablero[fila][columna] != 0) {
			fila = random.nextInt(size);
			columna = random.nextInt(size);
		}
		double valorRandom = random.nextDouble();
		int valorFichaNueva = valorRandom < 0.9 ? 2 : 4; //90% De probabilidad de que salga un 2

		tablero[fila][columna] = valorFichaNueva;

	}

	public void moverArriba() {

	}

	public void moverAbajo() {
		

	}

	public void moverIzquierda() {
		

	}

	public void moverDerecha() {
	

	}

	public int obtenerValorCelda(int i, int j) {
		return tablero[i][j];
	}



}
