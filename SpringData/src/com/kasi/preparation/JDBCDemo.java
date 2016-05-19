package com.kasi.preparation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kasi.preparation.model.HibernateDaoImpl;
import com.kasi.preparation.model.JdbcDaoSupportImpl;

public class JDBCDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//JdbcDaoSupportImpl impl = context.getBean("jdbcDaoSupportImpl", JdbcDaoSupportImpl.class);
		HibernateDaoImpl impl = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
//		Circle circle = impl.getCircle(1);
//		System.out.println(circle.getName());
//		System.out.println(impl.getCircleCount());
//		System.out.println(impl.getCircleName(1));
//		System.out.println(impl.getCircleForId(1).getName());
//		System.out.println(impl.getAllCircle().size());
		System.out.println(impl.getCircleCount());

	}

}
