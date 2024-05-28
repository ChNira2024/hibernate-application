package com.nt.thread.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;


public class MultiThreadedGeneratorsTest {

	public static void main(String[] args) throws Exception{
		Session ses1=null,ses2=null,ses3=null;
		Product prod=null,prod1=null,prod2=null,prod3=null;
		Transaction tx=null;
		Integer idVal=0,idVal1=0;
		boolean flag=false;
		//get Session
		ses1=HibernateUtil.getSession();
		ses2=HibernateUtil.getSession();
		ses3=HibernateUtil.getSession();
		  //create Entity  object to save with Db s/w
		prod1=new Product();
		prod1.setPname("stoogcd");prod1.setPcost(2100.0f);prod1.setPcode("SwTaOLf-CODE");prod1.setPqty(10.0f);
		 
			prod2=new Product();
			prod2.setPname("stoold");prod2.setPcost(210.0f);prod2.setPcode("SwTaOf-CODE");prod2.setPqty(16.0f);
			 
				prod3=new Product();
				prod3.setPname("oolgcd");prod3.setPcost(2200.0f);prod3.setPcode("TaOOLf-CODE");prod3.setPqty(45.0f);
		
		 
		 MyRequest req1=new MyRequest(ses1, prod1);
		 MyRequest req2=new MyRequest(ses2, prod2);
		 MyRequest req3=new MyRequest(ses3, prod3);
		 Thread t1=new Thread(req1);
		 t1.setName("t1");
		 Thread t2=new Thread(req2);
		 t2.setName("t2");
		 Thread t3=new Thread(req3);
		 t3.setName("t3");
		 t1.start(); t2.start();t3.start();
		 
			    Thread.sleep(60000);
	    //close  session object
	    HibernateUtil.closeSession(ses1);
	    HibernateUtil.closeSession(ses2);
	    HibernateUtil.closeSession(ses3);
	    //close SessionFactroy
	 		    HibernateUtil.closeSessionFactory();
	
		  

	}//main
}//class