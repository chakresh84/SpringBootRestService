package springBoot.rest.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {
	
	private long id;
	
	private String name;

	public Employee(long incrementAndGet, String format) {
		id = incrementAndGet;
		name = format; 
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlElement(name="id")
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
