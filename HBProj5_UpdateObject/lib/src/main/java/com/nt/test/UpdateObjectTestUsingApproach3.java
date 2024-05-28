package com.nt.test;	//Approach3)updating partial modification(our own choice) without calling ses.update(-) method.

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTestUsingApproach3 {
	
		public static void main(String[] args) {
			Session ses=null;
			BankAccount account=null;
			Transaction tx=null;
			boolean flag=false;
			//get Session
			ses=HibernateUtil.getSession();
			try {
				
			//Load object for partial moidification of the object
		    account=ses.get(BankAccount.class,101L);
		  //begin Tx
			tx=ses.beginTransaction();
		     if(account!=null) {
				
				  //modify object
				 account.setBalance(490000);
				  //ses.update(account);   //NOTE:
	             flag=true;	
		     }
		     else {
		    	 System.out.println("record /object not found");
		    	 return ;
		     }
			}//try
			catch(HibernateException  he) {
				flag=false;
				he.printStackTrace();
			}
			finally {
				 if(flag) {
					 tx.commit();
					 System.out.println("Object updated");
				 }
				 else {
					 tx.rollback();
					 System.out.println("object not updated");
				 }
					 
				//close objs
				 HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
			
			
		}//main

}//class