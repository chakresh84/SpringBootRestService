package springBoot.rest.controller;


public class Dept {
		
	private long id;
	
	private String name;

	public Dept(long incrementAndGet, String format) {
		id = incrementAndGet;
		name = format; 
	}

	public Dept() {
	}
	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
