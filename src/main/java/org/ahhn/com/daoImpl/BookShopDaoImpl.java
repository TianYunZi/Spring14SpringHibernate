package org.ahhn.com.daoImpl;

import org.ahhn.com.dao.BookShopDao;
import org.ahhn.com.test.BookStockException;
import org.ahhn.com.test.UserAccountException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by XJX on 2016/3/13.
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public int findBookPriceByIsbn(String isbn) {
		Query query = getSession().createQuery("select b.price from Book b where b.isbn = :isbn").setString("isbn", isbn);
		return (Integer) query.uniqueResult();
	}

	public void updateBookStore(String isbn) {
		//验证书的库存是否充足
		int stock = (Integer) getSession().createQuery("select b.stock from Book b where b.isbn=:isbn")
				.setString("isbn", isbn).uniqueResult();

		if (stock == 0) {
			throw new BookStockException("库存不足");
		}

		Query query = getSession().createQuery("update Book b set b.stock = b.stock-1 where b.isbn=:isbn").setString("isbn", isbn);
		query.executeUpdate();
	}

	public void updateUserAccount(String username, int price) {
		int balance = (Integer) getSession().createQuery("select a.balance from Account a where a.usename=:username")
				.setString("username", username).uniqueResult();

		if (balance < price) {
			throw new UserAccountException("余额不足");
		}

		Query query = getSession().createQuery("update Account a set a.balance=a.balance-:price")
				.setInteger("price", price);
		query.executeUpdate();
	}
}
