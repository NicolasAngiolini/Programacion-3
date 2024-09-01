package src.main.java.tp3;

import java.util.ArrayList;

public class Tree {

    private Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void postOrder() {
        if (root != null) {
            postOrder(root);
            System.out.println("--");
        }
    }

    public ArrayList<Integer> getLongestBranch() {
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        if (root != null)
            return getLongestBranch(root, li, l2);

        return new ArrayList<>();
    }

    private ArrayList<Integer> getLongestBranch(Node nodo, ArrayList<Integer> listi, ArrayList<Integer> listd) {
        if (nodo.getLeft() != null){
            listi.add(nodo.getKey());
        getLongestBranch(nodo.getLeft(), listi, listd);}
        if (nodo.getRight() != null){
            listd.add(nodo.getKey());
        getLongestBranch(nodo.getRight(), listi, listd);}
        if (listi.size() >= listd.size())
            return listi;
        else
            return listd;

    }

    public int getMaxElem() {
        if (this.root != null)
            return getMaxElem(this.root);
        return 0;
    }

    public ArrayList<Integer> getFrontera() {
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            return getFrontera(this.root, list);
        }
        return new ArrayList<>();
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
            System.out.println("--");
        }
    }

    public void inOrder() {
        if (root != null) {
            inOrder(root);
            System.out.println("--");
        }
    }


    public void add(int valor) {
        if (this.root == null)
            this.root = new Node(valor);
        else
            add(valor, this.root);
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean hasElem(int valor) {
        if (this.root == null) {
            return false;
        } else {
            return hasElem(valor, this.root);
        }
    }


    public int getHeight() {
        int contador = 0;
        if (isEmpty()) {
            return contador;
        } else {
            contador++;
            return getHeight(contador, this.getRoot());
        }

    }

    private boolean hasElem(int valor, Node nodo) {

        if (valor == nodo.getKey())
            return true;

        if (valor < nodo.getKey() && nodo.getLeft() != null)
            return hasElem(valor, nodo.getLeft());

        if (valor > nodo.getKey() && nodo.getRight() != null)
            return hasElem(valor, nodo.getRight());

        return false;
    }

    private void add(int valor, Node nodo) {
        if (valor < nodo.getKey()) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(new Node(valor));
            } else
                add(valor, nodo.getLeft());
        } else {
            if (nodo.getRight() == null) {

                nodo.setRight(new Node(valor));
            } else
                add(valor, nodo.getRight());
        }
    }


    private int getHeight(int contador, Node nodo) {
        int contadorIzquierda = contador;
        int contadorDerecha = contador;
        if (nodo.getLeft() != null) {
            contadorIzquierda = 1 + getHeight(contadorIzquierda, nodo.getLeft());
        }
        if (nodo.getRight() != null) {
            contadorDerecha = 1 + getHeight(contadorDerecha, nodo.getRight());
        }
        if (contadorIzquierda > contadorDerecha) {
            return contadorIzquierda;
        }
        if (contadorDerecha > contadorIzquierda) {
            return contadorDerecha;
        }
        return contadorIzquierda;
    }

    private ArrayList<Integer> getFrontera(Node nodo, ArrayList<Integer> list) {

        if (nodo.getLeft() == null && nodo.getRight() == null) {
            list.add(nodo.getKey());
        }
        if (nodo.getLeft() != null)
            getFrontera(nodo.getLeft(), list);
        if (nodo.getRight() != null)
            getFrontera(nodo.getRight(), list);
        return list;
    }


    private int getMaxElem(Node nodo) {
        if (nodo.getRight() == null)
            return nodo.getKey();
        return getMaxElem(nodo.getRight());
    }


    private void postOrder(Node nodo) {
        if (nodo != null) {
            postOrder(nodo.getLeft());
            postOrder(nodo.getRight());
            System.out.println(nodo.getKey());
        }
    }

    private void preOrder(Node nodo) {
        if (nodo != null) {
            System.out.println(nodo.getKey());
            preOrder(nodo.getLeft());
            preOrder(nodo.getRight());

        }
    }

    private void inOrder(Node nodo) {
        if (nodo != null) {
            inOrder(nodo.getLeft());
            System.out.println(nodo.getKey());
            inOrder(nodo.getRight());

        }
    }


}
