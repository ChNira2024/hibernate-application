package com.nt.niranjana;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OracleMainClass 
{

	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {
			//1. (Loads Driver, Creates DB Connections, Prepare stmt)
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleAppDB");
			System.out.println(emf.getClass().getName());
			
			
			//2. (TODO Operations--insert, update,....)
			EntityManager em = emf.createEntityManager();
			System.out.println(em.getClass().getName());
			
			//3. create Transaction
			tx = em.getTransaction();
			System.out.println(tx.getClass().getName());
			//4. Start Transaction
			tx.begin();
			
			//5. Perform operation
			//save data into DB
			Product prod = new Product();
			prod.setProdId(101);
			prod.setProdCode("PEN");
			prod.setProdCost(200.00);
			
			em.persist(prod); //SQL: INSERT INTO ...
			
			//6. commit
			tx.commit();
			
			//7. close
			emf.close();
		} catch (Exception e) {
			//rollback if any problem
			if (tx != null && tx.isActive())
			{
		        tx.rollback();
		    }
			e.printStackTrace();
		}
	}
}

//Note:always keep xml file as persistence.xml otherwise it will not work