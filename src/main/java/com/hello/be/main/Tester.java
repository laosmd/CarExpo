package com.hello.be.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.hello.be.model.Brand;
import com.hello.be.model.CarVisit;
import com.hello.be.model.Visitor;

public class Tester {

	private EntityManager em;
	
	public Tester() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("abc");
		em = emfactory.createEntityManager();
		em.getTransaction().begin();
	}
//method is supposed to return for a brand, all the visitors
	public List<Visitor> visitorsByBrand(Brand brand) {

		List<Visitor> visitors = new ArrayList<Visitor>();

		TypedQuery<CarVisit> query = em.createNamedQuery("CarVisit.findAll", CarVisit.class);
		List<CarVisit> results = query.getResultList();

		for (CarVisit carVisit : results) {
			if (carVisit.getCar().getCarModel().getBrand() == brand)
				visitors.add(carVisit.getVisitor());
		}
		return visitors;
	}

	public static void main(String[] args) {
		Tester newTester = new Tester();
		Brand brandTest = newTester.em.find(Brand.class, 1);
		List<Visitor> visitorsTest = newTester.visitorsByBrand(brandTest);
		System.out.println("hello world");
		System.out.println(visitorsTest);

	}
}