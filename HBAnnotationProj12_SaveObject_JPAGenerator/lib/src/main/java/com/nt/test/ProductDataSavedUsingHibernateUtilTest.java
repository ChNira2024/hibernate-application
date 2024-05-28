package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Prodtab;
import com.nt.util.HibernateUtil;

public class ProductDataSavedUsingHibernateUtilTest {

	public static void main(String[] args) {
		 Session ses=null;
		 Prodtab prod=null;
		 Transaction tx=null;
		 boolean flag=false;
		 Integer idVal=0;
		   // get HB session object
		  ses=HibernateUtil.getSession();
		  
		  //create Entity  object to save with Db s/w
		prod=new Prodtab();
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
 * tx objecct class name::class org.hibernate.engine.transaction.internal.TransactionImpl
Hibernate: 
    select
        gen1.nextval 
    from
        dual
Generated id value is::52
Hibernate: 
    insert 
    into
        Prodtab
        (pcode, pcost, pname, pqty, pid) 
    values
        (?, ?, ?, ?, ?)
Object is saved
 */
/*
 * Hibernate: 
    select
        PID_SEQ.nextval 
    from
        dual
Generated id value is::102
Hibernate: 
    insert 
    into
        Prodtab
        (pcode, pcost, pname, pqty, pid) 
    values
        (?, ?, ?, ?, ?)
Object is saved
 */
