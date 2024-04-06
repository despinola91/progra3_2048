package negocio;

public class Posicion {
	private int fila;
    private int columna;

    Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() {
        return columna;
    }
}
