package com.hello.be.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// Car Brand : Each Brand has many car models
@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@OneToMany
	private List<CarModel> carModels;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CarModel> getCarModels() {
		return carModels;
	}

	public void setCarModels(List<CarModel> carModels) {
		this.carModels = carModels;
	}


}
