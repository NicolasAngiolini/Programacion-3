package src.main.java.tp1;

public class Main {

    public static void main(String[] args) {

        MySimpleLinkedList list = new MySimpleLinkedList();
        MySimpleLinkedList list2 = new MySimpleLinkedList();
        MySimpleLinkedList list3 = new MySimpleLinkedList();
        for (int i = 1; i < 6; i++)
            list.insertFront(i);

        //System.out.println(list.isEmpty());
        //System.out.println(list.get(1));
        //System.out.println(list.size());
        //System.out.println(list.extractFront());
        //System.out.println(list.size());

//        System.out.println(list.size());

        list2.insertFront(8);
        list2.insertFront(10);
        list2.insertFront(4);
        list2.insertFront(2);
        list2.insertLast(5);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.elementosEnComun(list2));


       // System.out.println(list3);
        //System.out.println(list.size());

        //System.out.println(list.indexOf(12));
    }

}
