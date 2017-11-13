package circularList;

import node.Node;

public class CircularList<T> {
	private Node<T> sentinel=null;
	private Node<T> actual=null;
	
	public CircularList() {
		sentinel = new Node<T>();
		actual = new Node<T>();
		
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}
	
	public CircularList(T value){
		this();
		sentinel.setNext(new Node<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}
	
	public boolean isEmpty(){
		return (sentinel.getNext() == null)?true:false;
	}
	
	public Node<T> Search(T value){
		return (!isEmpty())?Search(value,sentinel.getNext()):null;
	}
	
	private Node<T> Search(T value, Node<T> list) {
		if (list.getNext().getValue().equals(value)) {
			return list.getNext();
		}
		if (list.getNext().equals(sentinel.getNext())) {
			return null;
		}
		return Search(value,list.getNext());
	}
	
	public Node<T> getLast(){
		Node<T> tmp = sentinel.getNext();
		if(!isEmpty())
		while(!sentinel.getNext().equals(tmp.getNext())){
			tmp = tmp.getNext();
			return tmp;
		}
		return null;
	}
	
	public void Reindex() {
		Node<T> tmp=sentinel;
		int con = 0;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			tmp.setIndex(con++);
		}
	}
	
	public void AddFirst(T value){
		Node<T> nuevo = new Node<T>(value), last = getLast();
		if (isEmpty()) {
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}else {
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
	}
	public void pronter(){
		Node<T> tmp = sentinel.getNext();
		if(isEmpty())
		while(!tmp.getNext().equals(sentinel.getNext())){
			System.out.println(tmp.getValue());
			tmp = tmp.getNext();
		}
		System.out.println(tmp.getValue());
	}
	
	public void Remplace(T value, T newvalue){
		Node<T> finder = Search(value);
		if (finder != null) {
			finder.setValue(newvalue);
			}
		}
	public void remove(T value) {
		Node<T> finder = Search(value);
		if(finder != null) {
			finder.setNext(null);
		}
	}
	/*
	 	public boolean remove(T value) {
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)) {
				tmp.setNext(tmp.getNext().getNext());
			}else {
				tmp = tmp.getNext();
			}
		}
			
		return false; //No encontro el nodo a borrar
		
	}
	 */
	
	
	public void ClearAll(){
		Node<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			remove(tmp.getValue());
		}
	}
	
}