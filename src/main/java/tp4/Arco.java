package src.main.java.tp4;

public class Arco<T> {
    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }


    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
    @Override
    public String toString() {
        return "Arco  Origen: " + verticeOrigen + " Destino: " + verticeDestino + " etiqueta: " + etiqueta + "  ";
    }

}
