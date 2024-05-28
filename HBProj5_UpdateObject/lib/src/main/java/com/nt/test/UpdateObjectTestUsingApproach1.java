package com.nt.test;	//Approach1)updating total object i.e full object modification

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTestUsingApproach1 {
	
	public static void main(String[] args) {
		System.out.println("UpdateObjectTestUsingApproach1.main()");
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=true;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare full object for modifcation with exiting id
		account=new BankAccount();
		account.setAcno(101L);
		account.setHolderName("rakesh"); account.setBalance(400000);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.update(account);
             flag=true;			
		}
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