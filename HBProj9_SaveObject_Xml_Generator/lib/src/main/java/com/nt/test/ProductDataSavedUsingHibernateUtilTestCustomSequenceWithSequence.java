package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class ProductDataSavedUsingHibernateUtilTestCustomSequenceWithSequence {

	public static void main(String[] args) {
		 Session ses=null;
		 Product prod=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Integer idVal=0;
		   // get HB session object
		  ses=HibernateUtil.getSession();
		  
		  //create Entity  object to save with Db s/w
		prod=new Product();
		 prod.setPname("stoolgcd");prod.setPcost(2100.0f);prod.setPcode("SwTaOOLf-CODE");prod.setPqty(10.0f);
		  try {
			  tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			  System.out.println("tx objecct class name::"+tx.getClass());
			      //save object
			   idVal = (int)  ses.save(prod);
			   System.out.println("Generated id value is::"+idVal);
			     flag=true;
		  }
		  catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
		  }
		  finally {
			   //commit or rollback  Tx
			    if(flag==true) {
			    	   tx.commit();  //internally calls con.commit()
			    	   System.out.println("Object is saved");
			    }
			    else {
			    	tx.rollback(); //internally calls  con.rollback()
			    	 System.out.println("Object is not saved");
			    }
			    
			    //close  session object
			    HibernateUtil.closeSession(ses);
			    //close SessionFactroy
	   		    HibernateUtil.closeSessionFactory();
		  }//finally 
		  

	}//main
}//class

/*
 * Hibernate: 
    create sequence PID_SEQ start with 1 increment by 50
tx objecct class name::class org.hibernate.engine.transaction.internal.TransactionImpl
Hibernate: 
    select
        PID_SEQ.nextval 
    from
        dual
Generated id value is::1
Hibernate: 
    insert 
    into
        PRODTAB
        (PCODE, PCOST, PNAME, PQTY, PID) 
    values
        (?, ?, ?, ?, ?)
Object is saved
 */