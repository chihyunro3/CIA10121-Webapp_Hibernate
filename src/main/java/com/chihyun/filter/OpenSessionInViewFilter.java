package com.chihyun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;

import com.chihyun.util.*;

@WebFilter(urlPatterns = { "/*" }) //*代表不管要去哪裡"都"可以拜訪此網頁，用於過濾使用者能否拜訪哪些網頁
public class OpenSessionInViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			System.out.println("filter open transaction");
			factory.getCurrentSession().beginTransaction();
			chain.doFilter(req, res);
			factory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			chain.doFilter(req, res);
		}
	}

}



