package src.main.java.tp1;

public class Main {

	public static void main(String[] args) {

		MySimpleLinkedList list = new MySimpleLinkedList();

		list.insertFront(1);
		list.insertFront(2);
		list.insertFront(3);
		list.insertFront(4);
		list.insertFront(5);
	
		//System.out.println(list.isEmpty());
		//System.out.println(list.get(1));
		//System.out.println(list.size());
		//System.out.println(list.extractFront());
		//System.out.println(list.size());
		
		System.out.println(list.size());
		
		list.insertLast(6);
		list.insertLast(6);
		list.insertLast(6);
		list.insertLast(6);
		list.insertLast(6);
		list.insertLast(12);
		list.insertFront(5);
		
		list.insertLast(11);
		
		
		System.out.println(list.size());
		
		System.out.println(list.indexOf(12));
	}

}
