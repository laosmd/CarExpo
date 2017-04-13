package com.hello.be.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//Join table for the ManyToMany relation between Car and Visitor
@Entity
@Table
@NamedQuery(name="CarVisit.findAll", query="SELECT c FROM CarVisit c")
public class CarVisit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn
	private Visitor visitor;
	@ManyToOne
	@JoinColumn
	private Car car;
	public Long getId() {
		return id;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	

}
