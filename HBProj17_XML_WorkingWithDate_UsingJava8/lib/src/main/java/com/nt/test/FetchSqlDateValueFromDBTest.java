package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.PersonInfoHavingLocalDate;
import com.nt.util.HibernateUtil;

public class FetchSqlDateValueFromDBTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonInfoHavingLocalDate info=null;
		
		  //get Session
		ses=HibernateUtil.getSession();
		try {
		  info=ses.get(PersonInfoHavingLocalDate.class, 2);
		  if(info!=null) {
			  System.out.println(info);
		  }
		  else {
			  System.out.println("record not found");
		  }
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			  //close objs
			  HibernateUtil.closeSession(ses);
			  HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class