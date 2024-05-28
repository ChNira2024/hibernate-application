package com.nt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Student;

public class FetchStudentClassDataUsingJavaConfigurationMainMethodHavingFirstLevelCache 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome To Java Config based Hibernate Program of Student class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);
        
       
        Session session = factory.openSession();
        Student st = session.get(Student.class,205);
        System.out.println("ST: "+st);
        
        Student st2 = session.get(Student.class,205);
        System.out.println("ST2: "+st2);
        
        Student st3 = session.get(Student.class,205);
        System.out.println("ST3: "+st3);
        System.out.println();
        
        Session session2 = factory.openSession();
        Student st4 = session2.get(Student.class,205);
        System.out.println("ST4: "+st4);
        
        Student st5 = session2.get(Student.class,205);
        System.out.println("ST5: "+st5);
        
        Student st6 = session2.get(Student.class,205);
        System.out.println("ST6: "+st6);
        
	    session.close();
	    factory.close(); 
    }
}
//First level cache by default enable.Here i am fetching 3 type but query will execute only once becoz of First level cache