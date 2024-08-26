package src.main.java.tp1;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int cont;
    private Node<T> last;

    public MySimpleLinkedList() {
        this.first = null;
        this.cont = 0;
        this.last = null;
    }

    //O(1)
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        if (this.isEmpty()) {
            this.last = tmp;
        }
        this.first = tmp;
        this.cont++;

    }


    // O(1)
    public void insertLast(T info) {
        if (this.isEmpty()) {
            this.insertFront(info);
        } else {
            this.last.setNext(new Node<T>(info, null));
            this.last = last.getNext();
            this.cont++;
        }
    }

    // O(1)
    public T extractFront() {
        if (!this.isEmpty()) {
            Node<T> aux = this.first;
            this.first = first.getNext();
            this.cont--;
            if (this.first == null)
                this.last = null;
            return aux.getInfo();

        }
        return null;
    }

    //O(1)
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    // O(n)
    public T get(int index) {
        Node<T> aux = this.first;
        int cont = 0;
        while (cont != index) {
            cont++;
            aux = aux.getNext();
        }
        return aux.getInfo();
    }

    //O(1)
    public int size() {
        return cont;
    }

    public void sort() {
        Node<T> aux = this.first;
        while (aux == last) {

        }
    }


    public int indexOf(T info) {
        Node<T> aux = this.first;
        int contador = 0;
        while (aux != null && !aux.getInfo().equals(info)) {
            contador++;
            aux = aux.getNext();
        }
        if (aux != null && aux.getInfo().equals(info)) {
            return contador;
        } else
            return -1;
    }

    public MySimpleLinkedList<T> elementosEnComun(MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
        Node<T> me = this.first;
        while (me != null) {
            Node<T> l2 = list2.first;
            while (l2 != null) {
                if (me.getInfo().equals(l2.getInfo())) {
                    aux.insertFront(l2.getInfo());
                }
                l2 = l2.getNext();
            }
            me = me.getNext();
        }
        return aux;
    }

    public MySimpleLinkedList<T> elementosDistintos(MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
        Node<T> me = this.first;
        while (me != null) {
            Node<T> l2 = list2.first;
            while (l2 != null) {
                // System.out.println(aux.indexOf(me.getInfo()));
                if (list2.indexOf(me.getInfo()) == -1) {

                    aux.insertFront(me.getInfo());
                }

                l2 = l2.getNext();
            }
            me = me.getNext();
        }
        return aux;
    }


    @Override
    public String toString() {
        String result = "";
        Node<T> aux = this.first;
        while (aux != null) {
            result += aux.getInfo();
            if (aux.getNext() != null) {
                result += " -> ";
            }
            aux = aux.getNext();
        }
        return result;

    }

}