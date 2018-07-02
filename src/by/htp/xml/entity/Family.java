package by.htp.xml.entity;

import java.util.ArrayList;

public class Family {
	private int id;
	private Father father;
	private Mother mother;
	private ArrayList<Child> children;
	
	public Family() {
		super();
	}

	public Family(int id, Father father, Mother mother, ArrayList<Child> children) {
		super();
		this.id = id;
		this.father = father;
		this.mother = mother;
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "\nFamily id=" + id + "\nfather=" + father + "\nmother=" + mother + "\nchildren=" + children + "\n";
	}
	
	
}
