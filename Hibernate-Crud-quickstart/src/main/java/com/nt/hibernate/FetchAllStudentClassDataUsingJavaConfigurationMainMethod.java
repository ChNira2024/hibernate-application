package com.nt.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class FetchAllStudentClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);

	    Session session = factory.openSession();
	    List<Student> list = session.createQuery("from Student",Student.class).list();
	    list.forEach(e->System.out.println(e));
	    session.close();
	    factory.close(); 
    }
}
