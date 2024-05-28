package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil;

public class FetchDataFromDBAndStoreInFirstLevelCacheTest1 {

	public static void main(String[] args) {
		Session ses = null;
		InsurancePolicy policy = null, policy1 = null;
		Transaction tx = null;
		boolean flag = false;
		// get SEssion object
		ses = HibernateUtil.getSession();
		try {
			// Load object
			policy = ses.get(InsurancePolicy.class, 101L);
			if (policy == null)
				System.out.println("Record not found");
			else {
				System.out.println("Record found  and displayed");
				System.out.println("First Time :" + policy);
			}
			System.out.println("========Data Fetch From L1Cache..After this No select query will generate========");
			policy1 = ses.get(InsurancePolicy.class, 101L);
			System.out.println("Second Time :" + policy1);
			System.out.println("To Confirm all the data fetch from cache object see the hashcode :"+policy.hashCode()+" "+policy1.hashCode());
		} // try
		catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
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
First Time :InsurancePolicy [policyId=101, policyName=JA, policyType=life, company=LIC, tenure=20]
========Data Fetch From Cache..After this also sql query will generate becuase of clear() cache========
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
Second Time :InsurancePolicy [policyId=101, policyName=JA, policyType=life, company=LIC, tenure=20]
To Confirm all the data fetch from DB by generating sql query multiple time see the hashcode :2035069547 414915464
*/
