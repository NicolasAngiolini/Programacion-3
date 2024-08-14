
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

//O(n)
	/*
	 * public void insertLast(T info) { if(this.isEmpty()) { this.insertFront(info);
	 * }else { Node<T> aux = this.first; while (aux.getNext() != null) { aux =
	 * aux.getNext(); } aux.setNext(new Node<T>(info, null)); cont++;
	 * 
	 * 
	 * 
	 * }
	 */

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
		if (this.first != null) {
			return false;
		}
		return true;
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

	public int indexOf(T info) {
		Node<T> aux = this.first;
		int cont = 0;
		if (!this.isEmpty()) {
			while (aux.getInfo().equals(info) && aux.getNext() != null) {
				aux = aux.getNext();
				cont++;
			}
			if (aux.getInfo() == info)
				return cont;
			else
				return -1;
		}
		return -1;
	}

	@Override
	public String toString() {
		// TODO
		return "";
	}

}