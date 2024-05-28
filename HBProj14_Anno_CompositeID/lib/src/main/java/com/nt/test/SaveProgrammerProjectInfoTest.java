package com.nt.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.util.HibernateUtil;

public class SaveProgrammerProjectInfoTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ProgrammerProjectInfo info=null;
		PrgmrProjId id=null;
		boolean flag=false;
			//get Session 
			ses=HibernateUtil.getSession();
			
			try {
				//begin Tx
				tx=ses.beginTransaction();
			     //prepare Entity object
			       id=new PrgmrProjId();
			       id.setPid(102); id.setProjId(5002);
			       info=new ProgrammerProjectInfo();
			       info.setId(id); info.setPname("raja"); info.setProjName("OA");
			       info.setDeptNo(567);
			       //save object
			        id=(PrgmrProjId) ses.save(info);
			        System.out.println("Generated id value::"+id);
				    flag=true;
		}//try
			catch(HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			catch(Exception e) {
				flag=false;
				e.printStackTrace();
			}
			finally {
				//Perform TxMgmt
				if(flag) {
					tx.commit();
					System.out.println("object is saved");
				}
				else {
					tx.rollback();
					System.out.println("Object is not saved");
				}
				//close objs
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}//class
}//main

/*
 Hibernate: 
    create table PROGRAMMER_PROJECT_INFO (
        pid number(10,0) not null,
        projId number(10,0) not null,
        pname varchar2(20 char),
        projName varchar2(20 char),
        deptNo number(10,0),
        primary key (pid, projId)
    )
Generated id value::PrgmrProjId [pid=101, projId=5001]
Hibernate: 
    insert 
    into
        PROGRAMMER_PROJECT_INFO
        (deptNo, pname, projName, pid, projId) 
    values
        (?, ?, ?, ?, ?)
object is saved
 */
