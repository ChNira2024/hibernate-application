package com.nt.listener;


import com.nt.utility.HibernateUtil;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SessionClosingServletRequestListener implements ServletRequestListener {

	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("SessionClosingServletRequestListener.requestDestroyed(-)");
	   HibernateUtil.closeSession();
	}
	
}
