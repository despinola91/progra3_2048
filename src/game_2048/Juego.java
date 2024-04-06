package game_2048;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	
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
		Posicion posicionRandom = obtenerPosicionRandomDisponible();
		int fila = posicionRandom.getFila();
		int columna = posicionRandom.getColumna();
		
		matriz[fila][columna] = ObtenerValorRandom();
		
		posicionRandom = obtenerPosicionRandomDisponible();
		fila = posicionRandom.getFila();
		columna = posicionRandom.getColumna();
		
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
	
	private static int getRandom(ArrayList<Integer> list) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
    }
	
	public Posicion obtenerPosicionRandomDisponible() {
		int[][] matriz = ObtenerMatriz();
		ArrayList<Posicion> posicionesDisponibles = new ArrayList<Posicion>();
		
		for( int col = 0; col < matriz.length; col++ ) {
			for( int fila = 0; fila < matriz.length; fila++ ) {
				if(matriz[col][fila] == 0) {
					posicionesDisponibles.add(new Posicion(fila, col));
				}
			}
		}
		
		return getPosicionRandom(posicionesDisponibles);
	};
	
	private Posicion getPosicionRandom(ArrayList<Posicion> list) {
		Random generator = new Random();
        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
	}
}
