package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class InsertStudentClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);
        
        //create Student object
        Student st = new Student();
        st.setId(210);
        st.setName("shyama");
        st.setCity("Chatrapur");
	    
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(st);
	    tx.commit();
	    session.close();
	    factory.close(); 
    }
}
