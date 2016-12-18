package com.example.spring.tx.dao.imp;

import com.example.spring.tx.dao.BookShopDao;
import com.example.spring.tx.exception.BookStockException;
import com.example.spring.tx.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据isbn编号得到书的价格
	 * @param isbn
	 * @return
     */
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	/**
	 * 更新书的库存，当书的总数小于1时抛出异常
	 * @param isbn
     */
	public void updateBookStock(String isbn) {
		String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock == 0){
			throw new BookStockException("库存不足!");
		}
		
		String sql = "UPDATE book_stock SET stock = stock -1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

   /**
	*根据书的价格更新账户余额，当账户余额小于书的价格时抛出异常
    */
	public void updateUserAccount(String username, int price) {
		String sql2 = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if(balance < price){
			throw new UserAccountException("余额不足!");
		}
		
		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}
