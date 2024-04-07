package negocio;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	
	//Propiedades
	public static int [][] matriz = new int[4][4];
	
	//Métodos disponibles para la interfaz
	
	/**
	 * Inicializa la matriz completando 2 posiciones random con 2 o 4.
	 */
	public static void iniciarMatriz() {
		
		//Al iniciar la matriz se deben completar 2 celdas random con 2 o 4.
		Posicion posicionRandom = obtenerPosicionRandomDisponible();
		int fila = posicionRandom.obtenerFila();
		int columna = posicionRandom.obtenerColumna();
		
		matriz[fila][columna] = obtenerValorRandom();
		
		posicionRandom = obtenerPosicionRandomDisponible();
		fila = posicionRandom.obtenerFila();
		columna = posicionRandom.obtenerColumna();
		
		matriz[fila][columna] = obtenerValorRandom();
	}
	
	/**
	 * Devuelve la matriz en con sus valores actuales.
	 * @return matriz de enteros.
	 */
	public static int[][] obtenerMatriz() {
		return matriz;
	}

	/**
	 * Devuelve una posicion (fila y columna) random disponible dentro de la matriz.
	 * @return objeto posicion compuesto de fila y columna.
	 */
	public static Posicion obtenerPosicionRandomDisponible() {
		int[][] matriz = obtenerMatriz();
		ArrayList<Posicion> posicionesDisponibles = new ArrayList<Posicion>();
		
		for( int col = 0; col < matriz.length; col++ ) {
			for( int fila = 0; fila < matriz.length; fila++ ) {
				if(matriz[col][fila] == 0) {
					posicionesDisponibles.add(new Posicion(fila, col));
				}
			}
		}
		
		return obtenerPosicionRandom(posicionesDisponibles);
	};

	/**
	 * Devuelve un valor entero random ya sea 2 o 4.
	 * @return entero variando entre 2 y 4.
	 */
	public static int obtenerValorRandom() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4); 
    
		return obtenerRandom(list);
	}
	
	/**
	 * Mueve todos los elementos de la matriz hacia arriba, sumando los que son iguales.
	 */
	public static void moverArriba() {
		// Iteramos sobre cada columna de la matriz
		for (int j = 0; j < matriz.length; j++) {
			// Iteramos sobre cada fila, comenzando desde la segunda
			for (int i = 1; i < matriz.length; i++) {
				// Si la celda actual no está vacía
				if (matriz[i][j] != 0) {
					// Buscamos una celda vacía por encima
					int k = i - 1;
					while (k >= 0 && matriz[k][j] == 0) {
						k--;
					}
					// Si encontramos una celda vacía, movemos el número actual hacia arriba
					if (k >= 0) {
						if (matriz[k][j] == matriz[i][j]) {
							// Si la celda vacía contiene el mismo número, los sumamos
							matriz[k][j] *= 2;
							matriz[i][j] = 0;
						} else {
							// Si la celda vacía es diferente, simplemente movemos el número
							matriz[k + 1][j] = matriz[i][j];
							if (k + 1 != i) {
								matriz[i][j] = 0;
							}
						}
					}
				}
			}
		}
	}
	/**
	 * Mueve todos los elementos de la matriz hacia abajo, sumando los que son iguales.
	 */
	public static void moverAbajo() {
		
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la izquierda, sumando los que son iguales.
	 */
	public static void moverIzquierda() {
		
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la derecha, sumando los que son iguales.
	 */
	public static void moverDerecha() {
		
	}

	
	//Métodos internos
	
	/**
	 * Obtiene un valor entero random a partir de una lista dada.
	 * @param list lista de enteros.
	 * @return entero dentro de la lista.
	 */
	private static int obtenerRandom(ArrayList<Integer> list) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
    }
		
	/**
	 * Obtiene una posicion random a partir de una lista dada.
	 * @param list lista de posiciones disponibles en la matriz.
	 * @return posicion dentro de la lista.
	 */
	private static Posicion obtenerPosicionRandom(ArrayList<Posicion> list) {
		Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
	}
}
