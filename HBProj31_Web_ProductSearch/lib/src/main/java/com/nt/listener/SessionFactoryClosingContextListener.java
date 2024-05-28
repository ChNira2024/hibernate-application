package com.nt.listener;


import com.nt.utility.HibernateUtil;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryClosingContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("SessionFactoryClosingContextListener.contextDestroyed()");
	   HibernateUtil.closeSessionFactory();
	}

}
