package org.ahhn.com.test;

import org.ahhn.com.service.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by XJX on 2016/3/13.
 */
public class SpringHibernateTest {

	private ApplicationContext context = null;
	private BookShopService bookShopService=null;

	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService=context.getBean(BookShopService.class);
	}

	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA","1001");
	}

	@Test
	public void test() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
