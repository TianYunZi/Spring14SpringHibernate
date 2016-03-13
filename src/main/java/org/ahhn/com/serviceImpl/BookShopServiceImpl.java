package org.ahhn.com.serviceImpl;

import org.ahhn.com.dao.BookShopDao;
import org.ahhn.com.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XJX on 2016/3/13.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStore(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
