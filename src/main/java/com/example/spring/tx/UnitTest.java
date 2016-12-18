package com.example.spring.tx;

import com.example.spring.tx.dao.BookShopDao;
import com.example.spring.tx.service.BookShopService;
import com.example.spring.tx.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by Forrest on 2016/12/18.
 */
public class UnitTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationTx.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    /**
     * 模拟某个用户买多本书，（这里申明事务，然后purchase方法声明事务，事务中管理事务，事务的传播行为）
     */

    @Test
    public void testTransactionlPropagation(){
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    /**
     * 模拟某个用户买书
     *
     */
    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA", "1001");
    }

    /**
     * 模拟某个用户买书后更新账户余额
     */
    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA", 50);
    }

    /**
     * 模拟书店卖出一本书后更新书的库存
     */
    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    /**
     * 根据isbn号得到书的价格
     */
    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

}
