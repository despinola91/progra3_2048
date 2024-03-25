package game_2048;

public class Negocio {
	
	//Propiedades
	private int [][] matriz = new int[4][4];
	
	private enum accion {
		Arriba,
		Abajo,
		Izquierda,
		Derecha
	}
	
	//Métodos públicos llamados por la interfaz de presentación
	public void IniciarMatriz() {
		int fila = ObtenerFilaRandom();
		int columna = ObtenerColumnaRandom();
		
		matriz[fila][columna] = ObtenerValorRandom();
	}
	
	public void ReordenarMatriz (accion AccionUsuario) {
		switch(AccionUsuario) {
			case accion.Arriba:
				break;
			case accion.Abajo:
				break;
			case accion.Izquierda:
				break;
			case accion.Derecha:
				break;
		}
	}
	
	public int[][] ObtenerMatriz() {
		return matriz;
	}

	//Métodos privados llamados internamente
	private int ObtenerValorRandom() {
		int valor = 2; //Debe ser 2 o 4.
		return valor;
	}
	
	private int ObtenerFilaRandom() {
		//Debe devolver una posición para asignar el número random. La posición debe ser una disponible luego del reordenamiento.
		int valor = 1;
		return valor;
	}
	
	private int ObtenerColumnaRandom() {
		//Debe devolver una posición para asignar el número random. La posición debe ser una disponible luego del reordenamiento.
		int valor = 1;
		return valor;
	}
}
