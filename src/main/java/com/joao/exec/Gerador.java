package com.joao.exec;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Gerador {

	public static void main(String[] args) {

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("testRestJDBC");

		createEntityManagerFactory.close();

		//EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();



	}

}
