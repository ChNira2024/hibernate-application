package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Membership member=null;
		Transaction tx=null;
		boolean flag=false;
	     //get Session
		ses=HibernateUtil.getSession();
		//prepare object
		member=new Membership();
		member.setMid(9827378577L);
		member.setName("Niranjana");
		member.setAddrs("krpd");
		member.setRewardPoints(19L);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			   Membership mergedata = ses.merge(member);
			   System.out.println("a");
			   System.out.println("MERGE DATA: "+mergedata);
			   System.out.println("b");
			  flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			//perform tx mgmt
			 if(flag) {
				 System.out.println("c");
				 tx.commit();
				 System.out.println("d");
				 System.out.println("Object is saved or updated");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is not saved or updated");
			 }
			 //close objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		}
		
		}//main
}//class