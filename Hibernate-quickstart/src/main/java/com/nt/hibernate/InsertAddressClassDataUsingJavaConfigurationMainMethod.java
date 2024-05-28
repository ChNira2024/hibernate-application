package com.nt.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.hibernate.config.HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache;
import com.nt.hibernate.entity.Address;

public class InsertAddressClassDataUsingJavaConfigurationMainMethod 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Welcome To Java Config based Hibernate Program Of Address class" );
        SessionFactory factory = HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache.getSessionFactory();
        System.out.println(factory);
        
      //create Address object
      Address address = new Address();
      address.setStreet("Hoogly");
      address.setCity("Kolkata");
      address.setCityIsOpen(true);
      address.setDob(new Date());        
      address.setAccountBalance(30000.292);  //ignored field using @Transient..so value doesn't stored in db
      
      //Reading image and store in DB
      FileInputStream fis = new FileInputStream("src/main/java/ShahRukhKhan.jpg");
      byte[] data = new byte[fis.available()];
      fis.read(data);
      address.setImage(data);
      System.out.println(address);
	    
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(address);
	    tx.commit();
	    session.close();
	    factory.close(); 
    }
}
