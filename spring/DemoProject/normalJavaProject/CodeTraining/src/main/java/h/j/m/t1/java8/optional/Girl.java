package h.j.m.t1.java8.optional;


public class Girl {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Girl(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}
	
	
}
