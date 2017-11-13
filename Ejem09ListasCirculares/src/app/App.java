package app;

import circularList.CircularList;

public interface App {
	public static void main(String[] args) {
		
		CircularList<String> name = new CircularList <String> ();
		
		name.AddFirst("any");
		name.AddFirst("juanga");
		name.Remplace("juanga", "ja");
		name.pronter();
		name.remove("any");
	}
}
