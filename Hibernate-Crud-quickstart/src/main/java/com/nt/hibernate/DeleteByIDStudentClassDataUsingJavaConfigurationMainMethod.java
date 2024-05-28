package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class DeleteByIDStudentClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);

	    Session session = factory.openSession();
	    Student singleData = session.get(Student.class,210);
	    System.out.println("fetched singleData: "+singleData);
	    Transaction tx = session.beginTransaction();
	    session.remove(singleData);
	    tx.commit();
	    System.out.println("Data deleted successfully ");
	    session.close();
	    factory.close(); 
    }
}
