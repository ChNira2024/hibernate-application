package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil;

public class UpdateDataIntoDBAndStoreInFirstLevelCache3 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.get(InsurancePolicy.class,101L);
			//verify
			if(policy==null)
				System.out.println("Record not found");
			else {
				System.out.println("Record found  and displayed");
				System.out.println(policy);
				tx=ses.beginTransaction();
				   policy.setTenure(11);  //Tenure means duration
				   ses.update(policy);
				   System.out.println("========Data Update and Fetch From L1Cache..After this No update sql query will generate========");
				   policy.setTenure(31);
				   policy.setPolicyType("home");
				   ses.update(policy);
				   flag=true;
			}
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
			 //Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object updated");
			}
			else {
				tx.rollback();
				System.out.println("Object not updated");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
/*
Hibernate: 
select
    ip1_0.POLICYID,
    ip1_0.COMPANY,
    ip1_0.POLICYNAME,
    ip1_0.POLICYTYPE,
    ip1_0.TENURE 
from
    INSURANCEPOLICY ip1_0 
where
    ip1_0.POLICYID=?
Record found  and displayed
InsurancePolicy [policyId=101, policyName=JA, policyType=life, company=LIC, tenure=20]
========Data Update and Fetch From L1Cache..After this No update sql query will generate========
Hibernate: 
update
    INSURANCEPOLICY 
set
    COMPANY=?,
    POLICYNAME=?,
    POLICYTYPE=?,
    TENURE=? 
where
    POLICYID=?
Object updated
*/
//it is pre-generated query so it is updating all the property..because we didn't add dynamic-query