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

    public boolean delete(int key) {
        if (root != null) {
            this.root = delete(key, this.root);
            return true;
        }
        return false;
    }

    private Node delete(int key, Node nodo) {
        if (nodo == null) {
            return null;
        }
        //Recorre
        if (key < nodo.getKey()) {
            nodo.setLeft(delete(key, nodo.getLeft()));
        } else if (key > nodo.getKey()) {
            nodo.setRight(delete(key, nodo.getRight()));
        } else {
            ///nodo sin hijos
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                return null;
            }

            /// nodo con un solo hijo
            else if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            //Nodo con dos hijos
            else {
                nodo.setKey(getMinElem(nodo.getRight()));
                nodo.setRight(delete(nodo.getKey(), nodo.getRight()));
            }
        }
        return nodo;
    }

    public ArrayList<Integer> getElemAtLevel(int nivel) {
        ArrayList<Integer> li = new ArrayList<>();
        if (root != null)
            return getElemAtLevel(nivel, this.root, 1, li);
        return new ArrayList<>();
    }


    public ArrayList<Integer> getLongestBranch() {
        if (root != null)
            return getLongestBranch(root);
        return new ArrayList<>();
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

    /////////////////////////////////////////////////////////////////////
    private ArrayList<Integer> getElemAtLevel(int nivel, Node nodo, int actual, ArrayList<Integer> li) {
        if (actual == nivel)
            li.add(nodo.getKey());
        else {
            if (nodo.getLeft() != null)
                getElemAtLevel(nivel, nodo.getLeft(), actual + 1, li);
            if (nodo.getRight() != null)
                getElemAtLevel(nivel, nodo.getRight(), actual + 1, li);
        }
        return li;
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

    public ArrayList<Integer> hojasMayoresQue(int k) {
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            return hojasMayoresQue(k, root, list);
        }
        return new ArrayList<>();
    }

    private ArrayList<Integer> hojasMayoresQue(int k, Node nodo, ArrayList<Integer> lista) {
        if (nodo.isLeaf() && nodo.getKey() > k) {
            lista.addFirst(nodo.getKey());
        }
        if (nodo.getKey() >= k && nodo.getRight() != null)
            hojasMayoresQue(k, nodo.getRight(), lista);
        if (nodo.getKey() >= k && nodo.getLeft() != null)
            hojasMayoresQue(k, nodo.getLeft(), lista);
        return lista;
    }


    public int sumaNodo() {
        if (root != null)
            return sumaNodo(root);
        return 0;
    }

    private int sumaNodo(Node nodo) {
        int acum = 0;
        if (!nodo.isLeaf()) {
            acum += nodo.getKey();
        }
        if (nodo.getLeft() != null)
            acum += sumaNodo(nodo.getLeft());
        if (nodo.getRight() != null)
            acum += sumaNodo(nodo.getRight());
        return acum;
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

    private ArrayList<Integer> getLongestBranch(Node nodo) {
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> ld = new ArrayList<>();
        if (nodo.getLeft() != null)
            li = getLongestBranch(nodo.getLeft());
        if (nodo.getRight() != null)
            ld = getLongestBranch(nodo.getRight());

        if (li.size() > ld.size()) {
            li.addFirst(nodo.getKey());
            return li;
        } else {
            ld.addFirst(nodo.getKey());
            return ld;
        }
    }


    private int getMaxElem(Node nodo) {
        if (nodo.getRight() == null)
            return nodo.getKey();
        return getMaxElem(nodo.getRight());
    }

    private int getMinElem(Node nodo) {
        if (nodo.getLeft() == null)
            return nodo.getKey();
        return getMinElem(nodo.getLeft());
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

    public void fill() {
        if (root != null) {
            fill(root);
        }
    }

    private int fill(Node nodo) {

        if (nodo.isLeaf())
            return nodo.getKey();

        int izq;
        if (nodo.getLeft() != null)
            izq = fill(nodo.getLeft());
        else
            return 0;

        int der;
        if (nodo.getRight() != null)
            der = fill(nodo.getRight());
        else
            return 0;
        nodo.setKey(der - izq);
        return nodo.getKey();
    }


}
