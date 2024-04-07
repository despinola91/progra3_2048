package negocio;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	
	//Propiedades
	private int [][] matriz = new int[4][4];
	
	Juego() {
		this.iniciarMatriz();
	};
	
	//Métodos disponibles para la interfaz
	
	/**
	 * Inicializa la matriz completando 2 posiciones random con 2 o 4.
	 */
	public void iniciarMatriz() {
		
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
	public int[][] obtenerMatriz() {
		return matriz;
	}
	
	/**
	 * Redefine todos los valores de la matriz en instancia por los recibidos en parametros. Solo para testing.
	 * @return void
	 */
	public void definirMatriz(int[][] matrizParam) {
		this.matriz = matrizParam;
	}

	/**
	 * Devuelve una posicion (fila y columna) random disponible dentro de la matriz.
	 * @return objeto posicion compuesto de fila y columna.
	 */
	public Posicion obtenerPosicionRandomDisponible() {
		int[][] matriz = this.obtenerMatriz();
		ArrayList<Posicion> posicionesDisponibles = new ArrayList<Posicion>();
		
		for( int col = 0; col < matriz.length; col++ ) {
			for( int fila = 0; fila < matriz.length; fila++ ) {
				if(matriz[fila][col] == 0) {
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
	public int obtenerValorRandom() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4); 
    
		return obtenerRandom(list);
	}
	
	/**
	 * Mueve todos los elementos de la matriz hacia arriba, sumando los que son iguales.
	 */
	public void moverArriba() {
//		boolean seMovio = false; //Registra si se realizó algún movimiento
//
//	    for (int columna = 0; columna < this.matriz.length; columna++) {
//	        int indiceUltimaFichaCombinada = -1; //Para que no se sume la misma ficha varias veces en una misma columna
//	        for (int fila = 1; fila < this.matriz.length; fila++) {
//	            if (this.matriz[fila][columna] != 0) {
//	                int filaActual = fila;
//	                while (filaActual > 0 && this.matriz[filaActual - 1][columna] == 0) {
//	                    this.matriz[filaActual - 1][columna] = this.matriz[filaActual][columna];
//	                    this.matriz[filaActual][columna] = 0;
//	                    filaActual--;
//	                    seMovio = true;
//	                }
//	                if (filaActual > 0 && this.matriz[filaActual - 1][columna] == this.matriz[filaActual][columna] && filaActual - 1 != indiceUltimaFichaCombinada) {
//	                    this.matriz[filaActual - 1][columna] *= 2;
//	                    this.matriz[filaActual][columna] = 0;
//	                    indiceUltimaFichaCombinada = filaActual - 1;
//	                    seMovio = true;
//	                }
//	            }
//	        }
//	    }
//	    //Si se realizó algún movimiento, se agrega una ficha 
//	    if (seMovio) {
//	        //agregarFichaNueva();
//	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia abajo, sumando los que son iguales.
	 */
	public void moverAbajo() {
//		boolean seMovio = false; //Registra si se realizó algún movimiento
//
//	    for (int columna = 0; columna < this.matriz.length; columna++) {
//	        int indiceUltimaFichaCombinada = size; //Para que no se sume la misma ficha varias veces en una misma columna
//	        for (int fila = size - 2; fila >= 0; fila--) {
//	            if (this.matriz[fila][columna] != 0) {
//	                int filaActual = fila;
//	                while (filaActual < size - 1 && this.matriz[filaActual + 1][columna] == 0) {
//	                    this.matriz[filaActual + 1][columna] = this.matriz[filaActual][columna];
//	                    this.matriz[filaActual][columna] = 0;
//	                    filaActual++;
//	                    seMovio = true;
//	                }
//	                if (filaActual < size - 1 && this.matriz[filaActual + 1][columna] == this.matriz[filaActual][columna] && filaActual + 1 != indiceUltimaFichaCombinada) {
//	                    this.matriz[filaActual + 1][columna] *= 2;
//	                    this.matriz[filaActual][columna] = 0;
//	                    indiceUltimaFichaCombinada = filaActual + 1;
//	                    seMovio = true;
//	                }
//	            }
//	        }
//	    }
//	    //Si se realizó algún movimiento, se agrega una ficha 
//	    if (seMovio) {
//	        //agregarFichaNueva();
//	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la izquierda, sumando los que son iguales.
	 */
	public void moverIzquierda() {
//		boolean seMovio = false; //Registra si se realizó algún movimiento
//
//	    for (int fila = 0; fila < this.matriz.length; fila++) {
//	        int indiceUltimaFichaCombinada = -1; //Para que no se sume la misma ficha varias veces en una misma fila
//	        for (int columna = 1; columna < this.matriz.length; columna++) {
//	            if (this.matriz[fila][columna] != 0) {
//	                int columnaActual = columna;
//	                while (columnaActual > 0 && this.matriz[fila][columnaActual - 1] == 0) {
//	                    this.matriz[fila][columnaActual - 1] = this.matriz[fila][columnaActual];
//	                    this.matriz[fila][columnaActual] = 0;
//	                    columnaActual--;
//	                    seMovio = true;
//	                }
//	                if (columnaActual > 0 && this.matriz[fila][columnaActual - 1] == this.matriz[fila][columnaActual] && columnaActual - 1 != indiceUltimaFichaCombinada) {
//	                    this.matriz[fila][columnaActual - 1] *= 2;
//	                    this.matriz[fila][columnaActual] = 0;
//	                    indiceUltimaFichaCombinada = columnaActual - 1;
//	                    seMovio = true;
//	                }
//	            }
//	        }
//	    }
//	    //Si se realizó algún movimiento, se agrega una ficha 
//	    if (seMovio) {
//	        //agregarFichaNueva();
//	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la derecha, sumando los que son iguales.
	 */
	public void moverDerecha() {
//		boolean seMovio = false; //Registra si se realizó algún movimiento
//
//	    for (int fila = 0; fila < this.matriz.length; fila++) {
//	        int indiceUltimaFichaCombinada = this.matriz.length; //Para que no se sume la misma ficha varias veces en una misma fila
//	        for (int columna = size - 2; columna >= 0; columna--) {
//	            if (this.matriz[fila][columna] != 0) {
//	                int columnaActual = columna;
//	                while (columnaActual < size - 1 && this.matriz[fila][columnaActual + 1] == 0) {
//	                    this.matriz[fila][columnaActual + 1] = this.matriz[fila][columnaActual];
//	                    this.matriz[fila][columnaActual] = 0;
//	                    columnaActual++;
//	                    seMovio = true;
//	                }
//	                if (columnaActual < size - 1 && this.matriz[fila][columnaActual + 1] == this.matriz[fila][columnaActual] && columnaActual + 1 != indiceUltimaFichaCombinada) {
//	                    this.matriz[fila][columnaActual + 1] *= 2;
//	                    this.matriz[fila][columnaActual] = 0;
//	                    indiceUltimaFichaCombinada = columnaActual + 1;
//	                    seMovio = true;
//	                }
//	            }
//	        }
//	    }
//	    //Si se realizó algún movimiento, se agrega una ficha 
//	    if (seMovio) {
//	        //agregarFichaNueva();
//	    }
	}

	
	//Métodos internos
	
	/**
	 * Obtiene un valor entero random a partir de una lista dada.
	 * @param list lista de enteros.
	 * @return entero dentro de la lista.
	 */
	private int obtenerRandom(ArrayList<Integer> list) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
    }
		
	/**
	 * Obtiene una posicion random a partir de una lista dada.
	 * @param list lista de posiciones disponibles en la matriz.
	 * @return posicion dentro de la lista.
	 */
	private Posicion obtenerPosicionRandom(ArrayList<Posicion> list) {
		Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
	}
}
