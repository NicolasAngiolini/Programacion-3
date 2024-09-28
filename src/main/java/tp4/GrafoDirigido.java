package src.main.java.tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private final HashMap<Integer, ArrayList<Arco<T>>> vertices;
    private int cantidadArcos;

    public GrafoDirigido() {
        this.vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
    }


    //O(1)
    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId))
            vertices.put(verticeId, new ArrayList<Arco<T>>());

    }

    @Override
    public void borrarVertice(int verticeId) {

    }

    //O(1)
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (this.vertices.containsKey(verticeId1)) {
            vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
            this.cantidadArcos++;
        } else
            this.agregarVertice(verticeId1);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {

    }

    @Override
    //O(1) el hash ayuda a que sea constante
    public boolean contieneVertice(int verticeId) {
        return (this.vertices.containsKey(verticeId));

    }

    //o(n) donde n es la cantidad de arcos del verticeid1
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (vertices.containsKey(verticeId1)) {
            return obtenerArco(verticeId1, verticeId2) != null;
        }
        return false;
    }

    //O(n)donde n es la cantidad de arcos del vertice id1
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

    //O(1)
    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    //O(1)
    @Override
    public int cantidadArcos() {
        return this.cantidadArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> listaAdyacentes = new ArrayList<>();
        for (Arco<T> arco : vertices.get(verticeId)) {
            listaAdyacentes.add(arco.getVerticeDestino());
        }
        return listaAdyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }

    public HashMap<Integer, ArrayList<Arco<T>>> getVertices() {
        return this.vertices;
    }
}
