package negocio;

public class Celda {
	private Posicion posicion;
	private int valor;
	
	Celda(int valor, int fila, int columna) {
		this.valor = valor;
		this.posicion = new Posicion(fila, columna);
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
}
