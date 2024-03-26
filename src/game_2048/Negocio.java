package game_2048;
import java.util.ArrayList;
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
		int fila = ObtenerFilaRandomDisponible();
		int columna = ObtenerColumnaRandomDisponible(fila);
		
		matriz[fila][columna] = ObtenerValorRandom();

		fila = ObtenerFilaRandomDisponible();
		columna = ObtenerColumnaRandomDisponible(fila);
		
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
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4); 
    
		return getRandom(list);
	}
	
	private static int ObtenerFilaRandomDisponible() {
		//Debe devolver una posición para asignar el número random. La posición debe ser una disponible luego del reordenamiento.
		int valor = 1;
		return valor;
	}
	
	private static int ObtenerColumnaRandomDisponible(int fila) {
		//Debe devolver una posición para asignar el número random. La posición debe ser una disponible luego del reordenamiento.
		int valor = 1;
		return valor;
	}
	
	private static int getRandom(ArrayList<Integer> list) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
    }
}
