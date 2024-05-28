package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveProductObjectTest {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory = null;
		Session ses = null;
		Product prod = null;
		Transaction tx = null;
		boolean flag = false;
		
		
		//here create Hibernate F/W(Bootstrap hibernate)
		cfg = new org.hibernate.cfg.Configuration();
		
		//supply hibernate cfg file as input file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		
		//build session factory
		factory = cfg.buildSessionFactory();  //store level2 cache
		
		ses = factory.openSession();  //store level1 cache
		
		//to create entity class object to save with DB s/
		prod = new Product();
		prod.setPid(453);prod.setPcode("pen444");prod.setPcost(50);prod.setPqty(1);//prod.setPname("PEN");
		
		try {
			tx = ses.beginTransaction(); //internally calls con.setAutoCommit(false) to begin to tx(here we are disable autoComit mode)
			//ses.save(prod);	//deprecated
			
			System.out.println("1");
			ses.persist(prod);  //here he is not inserting data to db,only give object data to hibernate.hibernate store the details in Level1 cache then tx.commit() will generate insert query and save into db
			System.out.println("2");
			flag = true;	//if no issue
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
			flag = false;
		}
		finally
		{
			//commit or rollback tx
			if(flag == true)
			{
				System.out.println("3");
				tx.commit();	//internally calls commit()
				System.out.println("4");
				System.out.println("Product object data is saved..");
			}
			else
			{
				tx.rollback();	//internally calls rollback()
				System.out.println("Product object data is not saved..");
				//close session block
				ses.close();
				factory.close();
				
			}
		}//end of finally
	}//end of main method

}//end of class
