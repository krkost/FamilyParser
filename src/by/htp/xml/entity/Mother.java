package by.htp.xml.entity;

public class Mother {
	private String name;
	private String surname;
	private int age;
	private String maidenName;

	public Mother() {
		super();
	}

	public Mother(String name, String surname, int age, String maidenName) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.maidenName = maidenName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	@Override
	public String toString() {
		return "Mother [name=" + name + ", surname=" + surname + ", age=" + age + ", maidenName=" + maidenName + "]";
	}
	
	

}
