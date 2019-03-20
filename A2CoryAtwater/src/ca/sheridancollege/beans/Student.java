package ca.sheridancollege.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA = Java Persistence API (manages data between Java objects/ classes and a database
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name="Student.getStudentList", query="from Student")

public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@Embedded
	private Music music;
	
	public Student(String name) {
		super();
		this.name = name;
	}
}
