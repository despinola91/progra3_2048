package negocio;

public class Recomendacion {
    private Celda primeraCelda;
    private Celda segundaCelda;

    public Celda obtenerPrimeraCelda() {
        return primeraCelda;
    }
    
    public Celda obtenerSegundaCelda() {
        return segundaCelda;
    }

    public void definirPrimeraCelda(Celda celda) {
        this.primeraCelda = celda;
    }

    public void definirSegundaCelda(Celda celda) {
        this.segundaCelda = celda;
    }

    public Recomendacion () {
        this.primeraCelda = null;
        this.segundaCelda = null;
    }
}
