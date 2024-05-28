package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class FetchByIDStudentClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);

	    Session session = factory.openSession();
	    Student singleData = session.get(Student.class,210);
	    System.out.println("fetched singleData: "+singleData);
	    session.close();
	    factory.close(); 
    }
}
