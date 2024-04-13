package negocio;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	
	//Propiedades
	private int [][] matriz = new int[4][4];
	private int puntaje;
	
	public Juego() {
		this.iniciarMatriz();
		this.puntaje = 0;
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
		return this.matriz;
	}
	
	/**
	 * Redefine todos los valores de la matriz en instancia por los recibidos en parametros. Solo para testing.
	 * @return void
	 */
	public void definirMatriz(int[][] matrizParam) {
		
		if(matrizParam == null || matrizParam.length != 4 ) {
			throw new Error("La matriz debe ser 4x4. ");
		}
		
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
	 * Ejecuta la acción de mover los elementos hacia arriba y si hubo movimiento, agrega una nueva ficha.
	 */
	public void moverArriba() {
		boolean seMovio = moverElementosArriba();

	    //Si se realizó algún movimiento, se agrega una ficha 
	    if (seMovio) {
	        this.agregarNuevaFicha();
	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia arriba, sumando los que son iguales.
	 * @return valor booleano indicando si hubo movimiento en el tablero.
	 */
	public boolean moverElementosArriba() {
		boolean seMovio = false; //Registra si se realizó algún movimiento

	    for (int columna = 0; columna < this.matriz.length; columna++) {
	        int indiceUltimaFichaCombinada = -1; //Para que no se sume la misma ficha varias veces en una misma columna
	        for (int fila = 1; fila < this.matriz.length; fila++) {
	            if (this.matriz[fila][columna] != 0) {
	                int filaActual = fila;
	                while (filaActual > 0 && this.matriz[filaActual - 1][columna] == 0) {
	                    this.matriz[filaActual - 1][columna] = this.matriz[filaActual][columna];
	                    this.matriz[filaActual][columna] = 0;
	                    filaActual--;
	                    seMovio = true;
	                }
	                if (filaActual > 0 && this.matriz[filaActual - 1][columna] == this.matriz[filaActual][columna] && filaActual - 1 != indiceUltimaFichaCombinada) {
	                    this.matriz[filaActual - 1][columna] *= 2;
						this.incrementarPuntaje(this.matriz[filaActual - 1][columna]);
	                    this.matriz[filaActual][columna] = 0;
	                    indiceUltimaFichaCombinada = filaActual - 1;
	                    seMovio = true;
	                }
	            }
	        }
	    }

		return seMovio;
	}

	/**
	 * Ejecuta la acción de mover los elementos hacia abajo y si hubo movimiento, agrega una nueva ficha.
	 */
	public void moverAbajo() {
		boolean seMovio = moverElementosAbajo();

	    //Si se realizó algún movimiento, se agrega una ficha 
	    if (seMovio) {
	        this.agregarNuevaFicha();
	    }
	}
	/**
	 * Mueve todos los elementos de la matriz hacia abajo, sumando los que son iguales.
	 * @return valor booleano indicando si hubo movimiento en el tablero.
	 */
	public boolean moverElementosAbajo() {
		boolean seMovio = false; //Registra si se realizó algún movimiento
		int size = this.matriz.length;

	    for (int columna = 0; columna < this.matriz.length; columna++) {
	        int indiceUltimaFichaCombinada = size; //Para que no se sume la misma ficha varias veces en una misma columna
	        for (int fila = size - 2; fila >= 0; fila--) {
	            if (this.matriz[fila][columna] != 0) {
	                int filaActual = fila;
	                while (filaActual < size - 1 && this.matriz[filaActual + 1][columna] == 0) {
	                    this.matriz[filaActual + 1][columna] = this.matriz[filaActual][columna];
	                    this.matriz[filaActual][columna] = 0;
	                    filaActual++;
	                    seMovio = true;
	                }
	                if (filaActual < size - 1 && this.matriz[filaActual + 1][columna] == this.matriz[filaActual][columna] && filaActual + 1 != indiceUltimaFichaCombinada) {
	                    this.matriz[filaActual + 1][columna] *= 2;
						this.incrementarPuntaje(this.matriz[filaActual + 1][columna]);
	                    this.matriz[filaActual][columna] = 0;
	                    indiceUltimaFichaCombinada = filaActual + 1;
	                    seMovio = true;
	                }
	            }
	        }
	    }

		return seMovio;
	}

	/**
	 * Ejecuta la acción de mover los elementos hacia la izquierda y si hubo movimiento, agrega una nueva ficha.
	 */
	public void moverIzquierda() {
		boolean seMovio = moverElementosIzquierda();

	    //Si se realizó algún movimiento, se agrega una ficha 
	    if (seMovio) {
	        agregarNuevaFicha();
	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la izquierda, sumando los que son iguales.
	 * @return valor booleano indicando si hubo movimiento en el tablero.
	 */
	public boolean moverElementosIzquierda() {
		boolean seMovio = false; //Registra si se realizó algún movimiento

	    for (int fila = 0; fila < this.matriz.length; fila++) {
	        int indiceUltimaFichaCombinada = -1; //Para que no se sume la misma ficha varias veces en una misma fila
	        for (int columna = 1; columna < this.matriz.length; columna++) {
	            if (this.matriz[fila][columna] != 0) {
	                int columnaActual = columna;
	                while (columnaActual > 0 && this.matriz[fila][columnaActual - 1] == 0) {
	                    this.matriz[fila][columnaActual - 1] = this.matriz[fila][columnaActual];
	                    this.matriz[fila][columnaActual] = 0;
	                    columnaActual--;
	                    seMovio = true;
	                }
	                if (columnaActual > 0 && this.matriz[fila][columnaActual - 1] == this.matriz[fila][columnaActual] && columnaActual - 1 != indiceUltimaFichaCombinada) {
	                    this.matriz[fila][columnaActual - 1] *= 2;
						this.incrementarPuntaje(this.matriz[fila][columnaActual - 1]);
	                    this.matriz[fila][columnaActual] = 0;
	                    indiceUltimaFichaCombinada = columnaActual - 1;
	                    seMovio = true;
	                }
	            }
	        }
	    }

		return seMovio;
	}
	
	/**
	 * Ejecuta la acción de mover los elementos hacia la derecha y si hubo movimiento, agrega una nueva ficha.
	 */
	public void moverDerecha() {
		boolean seMovio = moverElementosDerecha();

	    //Si se realizó algún movimiento, se agrega una ficha 
	    if (seMovio) {
	        agregarNuevaFicha();
	    }
	}

	/**
	 * Mueve todos los elementos de la matriz hacia la derecha, sumando los que son iguales.
	 * @return valor booleano indicando si hubo movimiento en el tablero.
	 */	
	public boolean moverElementosDerecha() {
		boolean seMovio = false; //Registra si se realizó algún movimiento
		int size = this.matriz.length;

	    for (int fila = 0; fila < this.matriz.length; fila++) {
	        int indiceUltimaFichaCombinada = this.matriz.length; //Para que no se sume la misma ficha varias veces en una misma fila
	        for (int columna = size - 2; columna >= 0; columna--) {
	            if (this.matriz[fila][columna] != 0) {
	                int columnaActual = columna;
	                while (columnaActual < size - 1 && this.matriz[fila][columnaActual + 1] == 0) {
	                    this.matriz[fila][columnaActual + 1] = this.matriz[fila][columnaActual];
	                    this.matriz[fila][columnaActual] = 0;
	                    columnaActual++;
	                    seMovio = true;
	                }
	                if (columnaActual < size - 1 && this.matriz[fila][columnaActual + 1] == this.matriz[fila][columnaActual] && columnaActual + 1 != indiceUltimaFichaCombinada) {
	                    this.matriz[fila][columnaActual + 1] *= 2;
						this.incrementarPuntaje(this.matriz[fila][columnaActual + 1]);
	                    this.matriz[fila][columnaActual] = 0;
	                    indiceUltimaFichaCombinada = columnaActual + 1;
	                    seMovio = true;
	                }
	            }
	        }
	    }

		return seMovio;
	}

	/**
	 * Devuelve el puntaje de la partida actual.
	 * @return entero representando el puntaje actual.
	 */
	public int obtenerPuntaje() {
		return this.puntaje;
	}

	public void incrementarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	
	//Métodos internos
	/**
	 * Metodo privado, agrega una nueva ficha en algun espacio random que este disponible y con el valor 2
	 * @return void
	 */
	private void agregarNuevaFicha() {
		Posicion posicionDisponible = this.obtenerPosicionRandomDisponible();
		int filaDisponible = posicionDisponible.obtenerFila();
		int columnaDisponible = posicionDisponible.obtenerColumna();
		
		this.matriz[filaDisponible][columnaDisponible] = obtenerValorRandom();
	}
	
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

	// GANA JUEGO: si encuentra alguna celda con valor 2048
	public boolean juegoGanado() {
		for (int[] fila : matriz) {
			for (int valor : fila) {
				if (valor == 2048) {
					return true;
				}
			}
		}
		return false;
	}

	//PIERDE JUEGO: si no hay movimientos disponibles en ninguna direccion
	public boolean juegoPerdido() {
		return !hayMovimientosDisponibles();
	}
	
	// Verifica si aun hay movimientos disponibles
	private boolean hayMovimientosDisponibles() {
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
				// Verifica si hay alguna celda vacia
				if (matriz[fila][columna] == 0) {
					return true;
				}
				//Verifica si se pueden conbinar celdas en las 4 direcciones
				if (fila > 0 && matriz[fila][columna] == matriz[fila - 1][columna]) {
					return true;
				}
				if (fila < matriz.length - 1 && matriz[fila][columna] == matriz[fila + 1][columna]) {
					return true;
				}
				if (columna > 0 && matriz[fila][columna] == matriz[fila][columna - 1]) {
					return true;
				}
				if (columna < matriz[0].length - 1 && matriz[fila][columna] == matriz[fila][columna + 1]) {
					return true;
				}
			}
		}
		return false;
	}

	public void limpiarMatriz() {
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
		
					matriz[fila][columna] = 0;
			}
		}
	}
	
	/**
	 * Obtiene las posiciones de una jugada recomendada. Puede no existir una jugada recomendada hasta aparecer un nuevo numero.
	 * @return Array con posiciones en matriz de jugada recomendada. Puede ser NULL
	 */
	public Posicion[] obtenerPosicionesJugadaRecomendada() {
		int size = this.matriz.length;
		
		for (int fila = 0; fila < size; fila++) {
			for(int columna = 0; columna < size; columna++) {
				Celda CeldaArriba = (fila - 1)  < 0 ? null : new Celda(this.matriz[fila-1][columna], fila-1, columna);
				Celda CeldaAbajo = (fila + 1)  > this.matriz.length-1 ? null : new Celda(this.matriz[fila+1][columna], fila+1, columna);
				Celda CeldaIzquierda = (columna - 1 < 0) ? null : new Celda(this.matriz[fila][columna-1], fila, columna-1);
				Celda CeldaDerecha = (columna + 1) > this.matriz.length-1 ? null : new Celda(this.matriz[fila][columna+1], fila, columna+1);
				
				Celda[] CeldasProximas = {CeldaArriba, CeldaAbajo, CeldaIzquierda, CeldaDerecha};
				
				for(Celda celda : CeldasProximas) {
					if(celda != null) {
						int valorCelda = celda.getValor();
						
						if(valorCelda == this.matriz[fila][columna] && valorCelda != 0) {
							Posicion[] arrayPosicionesJugadaRecomendada = new Posicion[] {new Posicion(fila, columna), celda.getPosicion()};
							return arrayPosicionesJugadaRecomendada;
						}
					}
				}
			}
		}
		
		return null;
	}
}
