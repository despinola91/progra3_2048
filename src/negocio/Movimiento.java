package negocio;

public class Movimiento {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//MUEVE ARRIBA TODAS LAS COLUMNAS
	public void moverArriba() {
		for(int c=0; c<COL; c++) {
			moverArribaColumna(c);
		}
		if(!finPartida())
			ponerDos();
	}

	private void moverArribaColumna(int c) {
		colocarArriba(c);
		sumarArriba(c);
		colocarArriba(c); //por si queda un hueco en el medio. para que todas queden arriba
	}

	//coloca arrriba una columna
	private void colocarArriba(int c) {      
		if(vaciasEnColumna(c) < COL) { //compruebo si hay nros en la columna
			for(int veces = 0;veces < COL-1;veces++) { //se hace 3 veces el recorrido
				for(int f=0;f<FIL-1;f++) {
					if(tablero[f][c]==0) { //si la celda esta vacia 
						tablero[f][c] = tablero[f+1][c]; //copio el valor debajo
						tablero[f+1][c] = 0; //la celda que se movio se convierte en 0
					}
				}
			}
		}

	}

	private void sumarArriba(int c) {
		if(vaciasEnColumna(c)<FIL-1) {
			for(int f=0;f<FIL-1;f++) {
				if(tablero[f][c] == tablero[f+1][c]) {
					tablero[f][c] *= 2;
					tablero[f+1][c] = 0;
				}
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private int vacias() {
	int n=0;
	for(int f=0;f<FIL;f++) {
		for(int c=0;c<COL;c++) {
			if(tablero[f][c]==0) {
				n++;
			}
		}
	}
	return n;
}

private int vaciasEnFila(int f) {
	int n=0;
	for(int c=0;c<COL;c++) {
		if(tablero[f][c]==0) {
			n++;
		}
	}
	return n;
}

private int vaciasEnColumna(int c) {
	int n=0;
	for(int f=0;f<FIL;f++) {
		if(tablero[f][c]==0) {
			n++;
		}
	}
	return n;
}


}
