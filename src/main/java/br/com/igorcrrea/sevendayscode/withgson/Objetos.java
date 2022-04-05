package br.com.igorcrrea.sevendayscode.withgson;

import java.io.Serializable;
import java.util.List;

public class Objetos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
