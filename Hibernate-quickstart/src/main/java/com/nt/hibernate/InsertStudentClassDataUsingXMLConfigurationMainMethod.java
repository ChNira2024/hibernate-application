package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.hibernate.entity.Student;

public class InsertStudentClassDataUsingXMLConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Xml Config based Hibernate Program" );
        
      //SessionFactory factory = new Configuration().configure().buildSessionFactory(); //one line
        
        //Create a configuration for hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        //Then create a session factory for get session object of SessionFactory Impl class
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);
        
      //create Student object
        Student st = new Student();
        st.setId(205);
        st.setName("Sisu");
        st.setCity("Chatrapur");
	    
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(st);
	    tx.commit();
	    session.close();
	    factory.close(); 
    }
}
