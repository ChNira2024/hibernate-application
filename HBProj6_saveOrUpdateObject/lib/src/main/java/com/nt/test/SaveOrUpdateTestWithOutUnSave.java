package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateTestWithOutUnSave {

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
		member.setAddrs("MUMBAI");
		member.setRewardPoints(17L);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			   ses.update(member);  //using saveOrUpdate() i am getting error so that i am using update() method while no data is there in db
			  flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			//perform tx mgmt
			 if(flag) {
				 tx.commit();
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