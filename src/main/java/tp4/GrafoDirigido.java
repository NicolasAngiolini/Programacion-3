package src.main.java.tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
    }

    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId))
            vertices.put(verticeId, new ArrayList<Arco<T>>());

    }

    @Override
    public void borrarVertice(int verticeId) {

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (this.vertices.containsKey(verticeId1))
            vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
        else
            this.agregarVertice(verticeId1);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return (this.vertices.containsKey(verticeId));

    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (this.vertices.containsKey(verticeId1)) {
            for (Arco<T> arco : vertices.get(verticeId1)) {
                if (arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
            }
        }
        return null;
    }
    @Override
    public int cantidadVertices() {
        return 0;
    }

    @Override
    public int cantidadArcos() {
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }
}
