package by.htp.xml.entity;

import java.util.ArrayList;
import java.util.List;


public class Families {
	
	private List<Family> families;
	
	public Families() {
		families = new ArrayList<Family>(); 
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	@Override
	public String toString() {
		return "Families [families=" + families + "]";
	}
	
	
	
}
