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
		int valorFichaNueva = valorRandom < 0.9 ? 2 : 4; // 90% De probabilidad de que salga un 2

		tablero[fila][columna] = valorFichaNueva;

	}

	public void moverAbajo() {
		boolean seMovio = false; // Registra si se realizó algún movimiento

		for (int columna = 0; columna < size; columna++) {
			int indiceUltimaFichaCombinada = size; // Para que no se sume la misma ficha varias veces en una misma
													// columna
			for (int fila = size - 2; fila >= 0; fila--) {
				if (tablero[fila][columna] != 0) {
					int filaActual = fila;
					while (filaActual < size - 1 && tablero[filaActual + 1][columna] == 0) {
						tablero[filaActual + 1][columna] = tablero[filaActual][columna];
						tablero[filaActual][columna] = 0;
						filaActual++;
						seMovio = true;
					}
					if (filaActual < size - 1 && tablero[filaActual + 1][columna] == tablero[filaActual][columna]
							&& filaActual + 1 != indiceUltimaFichaCombinada) {
						tablero[filaActual + 1][columna] *= 2;
						tablero[filaActual][columna] = 0;
						indiceUltimaFichaCombinada = filaActual + 1;
						seMovio = true;
					}
				}
			}
		}
		// Si se realizó algún movimiento, se agrega una ficha
		if (seMovio) {
			agregarFichaNueva();
		}
	}

	public void moverIzquierda() {
		boolean seMovio = false; // Registra si se realizó algún movimiento

		for (int fila = 0; fila < size; fila++) {
			int indiceUltimaFichaCombinada = -1; // Para que no se sume la misma ficha varias veces en una misma fila
			for (int columna = 1; columna < size; columna++) {
				if (tablero[fila][columna] != 0) {
					int columnaActual = columna;
					while (columnaActual > 0 && tablero[fila][columnaActual - 1] == 0) {
						tablero[fila][columnaActual - 1] = tablero[fila][columnaActual];
						tablero[fila][columnaActual] = 0;
						columnaActual--;
						seMovio = true;
					}
					if (columnaActual > 0 && tablero[fila][columnaActual - 1] == tablero[fila][columnaActual]
							&& columnaActual - 1 != indiceUltimaFichaCombinada) {
						tablero[fila][columnaActual - 1] *= 2;
						tablero[fila][columnaActual] = 0;
						indiceUltimaFichaCombinada = columnaActual - 1;
						seMovio = true;
					}
				}
			}
		}
		// Si se realizó algún movimiento, se agrega una ficha
		if (seMovio) {
			agregarFichaNueva();
		}
	}

	public void moverDerecha() {
		boolean seMovio = false; // Registra si se realizó algún movimiento

		for (int fila = 0; fila < size; fila++) {
			int indiceUltimaFichaCombinada = size; // Para que no se sume la misma ficha varias veces en una misma fila
			for (int columna = size - 2; columna >= 0; columna--) {
				if (tablero[fila][columna] != 0) {
					int columnaActual = columna;
					while (columnaActual < size - 1 && tablero[fila][columnaActual + 1] == 0) {
						tablero[fila][columnaActual + 1] = tablero[fila][columnaActual];
						tablero[fila][columnaActual] = 0;
						columnaActual++;
						seMovio = true;
					}
					if (columnaActual < size - 1 && tablero[fila][columnaActual + 1] == tablero[fila][columnaActual]
							&& columnaActual + 1 != indiceUltimaFichaCombinada) {
						tablero[fila][columnaActual + 1] *= 2;
						tablero[fila][columnaActual] = 0;
						indiceUltimaFichaCombinada = columnaActual + 1;
						seMovio = true;
					}
				}
			}
		}
		// Si se realizó algún movimiento, se agrega una ficha
		if (seMovio) {
			agregarFichaNueva();
		}
	}

	public void moverArriba() {
		boolean seMovio = false; // Registra si se realizó algún movimiento

		for (int columna = 0; columna < size; columna++) {
			int indiceUltimaFichaCombinada = -1; // Para que no se sume la misma ficha varias veces en una misma columna
			for (int fila = 1; fila < size; fila++) {
				if (tablero[fila][columna] != 0) {
					int filaActual = fila;
					while (filaActual > 0 && tablero[filaActual - 1][columna] == 0) {
						tablero[filaActual - 1][columna] = tablero[filaActual][columna];
						tablero[filaActual][columna] = 0;
						filaActual--;
						seMovio = true;
					}
					if (filaActual > 0 && tablero[filaActual - 1][columna] == tablero[filaActual][columna]
							&& filaActual - 1 != indiceUltimaFichaCombinada) {
						tablero[filaActual - 1][columna] *= 2;
						tablero[filaActual][columna] = 0;
						indiceUltimaFichaCombinada = filaActual - 1;
						seMovio = true;
					}
				}
			}
		}
		// Si se realizó algún movimiento, se agrega una ficha
		if (seMovio) {
			agregarFichaNueva();
		}
	}

	public int obtenerValorCelda(int i, int j) {
		return tablero[i][j];
	}

}
