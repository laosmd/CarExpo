package com.hello.be.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//A Visitor can visit many Car(s)
@Entity
@Table(name = "visitor")
public class Visitor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String Name;
	@OneToMany
	private List<CarVisit> carVisits;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
