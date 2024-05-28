package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class UpdateByIDStudentClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);

	    Session session = factory.openSession();
	    Student singleData = session.get(Student.class,210);
	    System.out.println("old data: "+singleData);
	    singleData.setName("Balarama");
	    singleData.setCity("keonjhar");
	    
	    Transaction tx = session.beginTransaction();
	    session.save(singleData);
	    tx.commit();
	    System.out.println("updated data: "+singleData);
	    session.close();
	    factory.close(); 
    }
}
