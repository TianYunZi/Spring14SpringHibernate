package org.ahhn.com.service;

import java.util.List;

/**
 * Created by XJX on 2016/3/5.
 */
public interface Cashier {
	void checkout(String username, List<String> isbns);
}
