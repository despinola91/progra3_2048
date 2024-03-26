package game_2048;
import java.util.Random;

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
		
		//Al iniciar la matriz se deben completar 2 celdas random con 2 o 4.
		int fila = ObtenerFilaRandom();
		int columna = ObtenerColumnaRandom();
		
		matriz[fila][columna] = ObtenerValorRandom();

		fila = ObtenerFilaRandom();
		columna = ObtenerColumnaRandom();
		
		matriz[fila][columna] = ObtenerValorRandom();
	}
	
	public void ReordenarMatriz (accion AccionUsuario) {
		switch(AccionUsuario) {
			case Arriba:
				break;
			case Abajo:
				break;
			case Izquierda:
				break;
			case Derecha:
				break;
		}
	}
	
	public int[][] ObtenerMatriz() {
		return matriz;
	}

	//Métodos privados llamados internamente
	private int ObtenerValorRandom() {
		
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Puede ser 0 o 1
        int valor = (randomNumber == 0) ? 2 :4; 
    
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
