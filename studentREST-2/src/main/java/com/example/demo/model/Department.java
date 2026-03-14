package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String location;
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee> employees;
	public Department(String name, String location, List<Employee> employees) {
		super();
		this.name = name;
		this.location = location;
		this.employees = employees;
	}
	
}
