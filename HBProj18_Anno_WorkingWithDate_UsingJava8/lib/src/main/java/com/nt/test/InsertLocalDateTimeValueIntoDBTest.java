package com.nt.test;//sql date only accept Date but util date allow both Date and Time 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonInfoHavingLocalDateTime;
import com.nt.util.HibernateUtil;

public class InsertLocalDateTimeValueIntoDBTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonInfoHavingLocalDateTime info=null;
		Transaction tx=null;
		boolean flag=false;
		  //get Session
		ses=HibernateUtil.getSession();
		//prepare Entity object
		 info=new PersonInfoHavingLocalDateTime();
		    info.setPname("wef");  info.setPaddrs("hyd");
		    info.setDob(LocalDateTime.of(1990,11,23,12,5,45));  // year(1900+),month,day,hours,min,sec
			 info.setDoj(LocalTime.now());
			 info.setDom(LocalDate.of(2018,10,12));  
		 
		try {
			//begin Tx
			tx=ses.beginTransaction();
			    ses.save(info);
			   flag=true; 
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform TxMgmt
			  if(flag) {
				  tx.commit();
				  System.out.println("Object is saved");
			  }
			  else {
				  tx.rollback();
				  System.out.println("Object is not saved");
			  }
			  //close objs
			  HibernateUtil.closeSession(ses);
			  HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class

/*
Hibernate: 
create table PERSON_INFO (
    pid number(10,0) not null,
    pname varchar2(20 char),
    paddrs varchar2(20 char),
    dob timestamp(6),
    dom date,
    doj timestamp(6),
    primary key (pid)
)
Hibernate: 
create sequence PERSON_INFO_SEQ start with 1 increment by 50
Hibernate: 
select
    PERSON_INFO_SEQ.nextval 
from
    dual
Hibernate: 
insert 
into
    PERSON_INFO
    (dob, doj, dom, paddrs, pname, pid) 
values
    (?, ?, ?, ?, ?, ?)
Object is saved
*/