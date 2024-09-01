package src.main.java.tp3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Tree ar = new Tree();

        ar.add(7);
        ar.add(5);
        ar.add(9);
        ar.add(4);
        ar.add(15);
        ar.add(6);
        ar.add(11);


       /* ar.inOrder();
        ar.preOrder();
        ar.postOrder();
        */

        //System.out.println(ar.getMaxElem());
        ArrayList<Integer> li = ar.getFrontera();
        System.out.println(li);

    }
}
