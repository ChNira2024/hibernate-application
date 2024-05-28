package com.nt.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.nt.hibernate.entity.Address;
import com.nt.hibernate.entity.Student;

public class HibernateConfigurationUsingJavaConfigurationHavingFirstLevelCache
{
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			 Configuration cfg = new Configuration();
			 
			 Properties properties = new Properties();
			 properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			 properties.put(Environment.URL,"jdbc:mysql://localhost:3306/projecteidiko");
			 properties.put(Environment.USER,"root");
			 properties.put(Environment.PASS,"root");
			 properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
			 properties.put(Environment.HBM2DDL_AUTO,"update");
			 properties.put(Environment.SHOW_SQL,true);
			 properties.put(Environment.FORMAT_SQL,true);
			 
			 cfg.setProperties(properties);//set property details into cfg
			 cfg.addAnnotatedClass(Student.class); //for Student class
			 
			 //then store the cfg details in service registry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			
			//then pass service registry object in build session factory
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			
			 
		}
		return sessionFactory;
	}

}
