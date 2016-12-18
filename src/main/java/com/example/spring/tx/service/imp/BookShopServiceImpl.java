package com.example.spring.tx.service.imp;

import com.example.spring.tx.dao.BookShopDao;
import com.example.spring.tx.exception.UserAccountException;
import com.example.spring.tx.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 1.通过isbn号得到书的价格
     * 2.更新书的库存
     * 3.根据账户名更新客户账户余额 （整个过程就是一个事务的过程）
     * @param username
     * @param isbn
     */

    /**
     * 1.事务的传播行为：使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
     * 如何使用事务，默认取值为REQUIRED,即使用当前调用方法的事务；REQUIRED_NEW:事务自己的事务，调用的事务方法的
     * 事务将会被挂起。（注意是当前事务，当前事务在外层事务中的行为；REQUIRED表示当前事务嵌入到外层事务中，
     * 只要一个嵌入外层事务中的事务抛出异常其他的全部回滚；REQUIRED_NEW表示嵌入到外层事务中的某个事务与外层事务无关，
     * 自己的事务执行完就提交，其他嵌入的事务抛出异常与它无关，外层事务涉及到里层事务的挂起和继续）
     * <p/>
     * 2.事务的隔离级别：使用isolation指定事务的隔离级别,最常用的取值为READ_COMMIT。
     * <p/>
     * 3.事务的回滚与异常：默认情况下Spring对所有（运行时的异常）进行回滚，可以通过设置属性来设定对那些异常回滚，那些异常不回滚
     *
     * @Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED,
     * noRollbackFor={UserAccountException.class}) 这里设置的对UserAccountException异常不进行回滚。
     * <p/>
     * 4.事务只读：使用readOnly指定事务是否为只读，表示这个事务只读取数据，但是不更新数据，提高事务效率.
     * <p/>
     * 5.事务超时设定：使用timeout属性指定强制回滚之前事务可以占用的时间。
     */
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false, timeout = 3)
    public void purchase(String username, String isbn) {
//
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {}

        int price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateUserAccount(username, price);
    }


    /***
     * ===============================================================
     *  瞧一瞧最传统的事务处理方式（基于最基本的jdbc数据库连接方式）
     *
     *  public void purchase(String username,String isbn){
     *      Connection connection=null;
     *
     *      try{
     *      //开启事务
     *         connection=dataSource.getConnection();
     *         connection.setAutoCommit(false);
     *
     *             ...... //业务逻辑
     *
     *      //提交事务
     *         conn.commit()
     *      }
     *      catch(SQLException e){
     *      //当业务逻辑抛出异常，会在这里进行捕获，然后进行事务的回滚
     *         e.printStackTrace();
     *         if(connection!=null){
     *             try{
     *                connection.rollback();
     *
     *             }catch(SQLException e1){
     *                 e1.printStackTrace();
     *             }
     *         }
     *         //同时将异常重新抛出去
     *         throw new RuntimeException(e);
     *
     *      }finally{
     *          //如果正常执行完逻辑，则在最后关闭连接
     *              if(connection!=null){
     *                  try{
     *                       connection.close();
     *                  }catch(SQLException e2){
     *                      e2.printStackTrace();
     *                  }
     *              }
     *
     *
     *      }
     *  }
     *=======================================================================
     *
     * 通过上面的代码再看上面被Transactional标注的方法，逻辑就会很清晰了，spring帮我们将除了
     * 代码逻辑以外的代码进行了封装，然后运行时，将我们用Transactional注解标注的方法嵌入到事务的封装代码中，
     * 一切是那么完美。
     *
     * 而且，我们可以将代码逻辑 前执行的代码理解为 "前置通知"
     *
     * 事务的提交理解为"返回通知"
     *
     * 代码逻辑异常的捕获以及回滚理解为"异常通知"
     *
     * finally中关闭连接为"后置通知"
     *
     *========================================================================
     *
     */
}
