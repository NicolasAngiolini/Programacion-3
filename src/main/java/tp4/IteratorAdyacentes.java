package src.main.java.tp4;

import java.util.Iterator;

public class IteratorAdyacentes<T> implements Iterator<Integer> {

    private Iterator<Arco<T>> iterator;


    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Integer next() {
        return this.iterator.next().getVerticeDestino();
    }

    public Iterator<Arco<T>> getIterator() {
        return iterator;
    }
}
