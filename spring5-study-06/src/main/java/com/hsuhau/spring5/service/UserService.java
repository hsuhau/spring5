package com.hsuhau.spring5.service;

import com.hsuhau.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link org.springframework.transaction.annotation.Transactional}可以添加到类上面，也可以添加到方法上面<br>
 * 如果把这个注解添加到类上面，这个类里面所有的方法都添加事务<br>
 * 如果把这个注解添加到方法上面，为这个方法添加了事务<br>
 * 事务操作（声明式事务管理参数配置）<br>
 * 在service类上面添加注解@Transactional，在这个注解里面可以配置事务相关参数<br>
 * <p>
 * 1.propagation:事务传播行为<br>
 * 事务方法：对数据库表数据进行变化的操作<br>
 * 多事务方法直接进行调用，这个过程中事务是如何进行管理的<br>
 * <img style="-webkit-user-select: none;margin: auto;cursor: zoom-in;" src="https://images3.alphacoders.com/107/1072651.jpg" width="720" height="480">
 * <br>
 * <table border="1">
 *         <tr>
 *             <td>传播属性</td><td>描述</td><td>解释</td>
 *         </tr>
 *         <tr>
 *             <td>REQUIRED（默认）</td><td>如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行</td><td>如果add方法本身有事务，调用update方法后之后，update使用当前add方法里面事务 如果add方法本身没有实物，调用update方法之后，创建新事务</td>
 *         </tr>
 *         <tr>
 *             <td>REQUIRED_NEW</td><td>当前的方法必须启动新事务，并在它自己的事务内进行，如果有事务正在运行，应该将它挂起</td><td>使用add方法调用update方法，如果add无论是否有事务，都创建新的事务</td>
 *         </tr>
 *         <tr>
 *             <td>SUPPORTS</td>如果有事务在运行，当前的方法就在这个事务内运行否则它可以不运行在事务中<td></td><td></td>
 *         </tr>
 *         <tr>
 *             <td>NOT_SUPPORTED</td><td>当前的方法不应该运行在事务中，如果有运行中的事务，将它挂起</td><td></td>
 *         </tr>
 *         <tr>
 *             <td>MANDATORY</td><td>当前的方法必须运行在事务内部，如果没有正在运行的事务，就抛出异常</td><td></td>
 *         </tr>
 *         <tr>
 *             <td>NEVER</td><td>当前的方法不应该运行在事务中，如果有运行的事务，就抛出异常</td><td></td>
 *         </tr>
 *         <tr>
 *             <td>NESTED</td><td>如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则，就启动一个新的事务，并在它自己的事务内进行</td><td></td>
 *         </tr>
 * </table>
 * </p>
 * <p>
 * 2.isolation:事务隔离级别<br>
 *      事务有特性成为隔离性，多实务操作之间不会产生影响。不考虑隔离性产生很多问题<br>
 *      有三个读问题：脏读、不可重复读、幻（虚）读<br>
 *          <table>
 *              <tr>
 *                  <td>脏读</td><td>一个未提交事务读取到另一个未提交事务的数据</td>
 *              </tr>
 *              <tr>
 *                  <td>不可重复读</td><td>一个未提交事务读取到另一个提交事务中修改的数据</td>
 *              </tr>
 *              <tr>
 *                  <td>幻（虚）读</td><td>一个未提交事务读取到另一个提交事务添加数据</td>
 *              </tr>
 *          </table>
 *       通过设置事务隔离级别，解决读问题
 *      <table border="1" summary="事务隔离级别">
 *          <tr>
 *             <td>事务隔离级别</td><td>脏读</td><td>不可重复读</td><td>幻读</td>
 *         </tr>
 *             <td>READ UNCOMMITTED<br>（读未提交）</td><td>有</td><td>有</td><td>有</td>
 *         </tr>
 *             <td>READ COMMITTED<br>（读已提交）</td><td>无</td><td>有</td><td>有</td>
 *         </tr>
 *             <td>REPEATABLE READ<br>（可重复读）</td><td>无</td><td>无</td><td>有</td>
 *         </tr>
 *             <td>SERIALIZABLE<br>（串行化）</td><td>无</td><td>无</td><td>无</td>
 *         </tr>
 *      </table>
 * </p>
 * <p>
 * 3.timeout:超时时间<br>
 * &#9; 1) 事务需要在一定时间内进行提交，如果不提交进行回滚<br>
 * &#9; 2) 默认值是-1，设置时间以秒单位进行计算<br>
 * </p>
 * <p>
 * 4.readOnly:是否只读<br>
 * &#9; 1) 读：查询操作，写：添加修改删除<br>
 * &#9; 2) readOnly默认值false，表示可以查询，可以添加修改删除操作<br>
 * &#9; 3) 设置readOnly值是true,设置成true之后，只能查询<br>
 * </p>
 * <p>
 * 5.rollbackFor:回滚<br>
 * &#9; 1) 设置出现哪些异常进行事务回滚
 * </p>
 * <p>
 * 6.noRollbackFor:不回滚<br>
 * &#9; 1) 设置出现哪些异常不进行事务回滚
 * </p>
 *
 * @author hsuhau
 * @date 2020/7/3 18:58
 */
@Service
// 使用配置文件
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false, rollbackFor = {Exception.class})
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 转账
     */
    public void accountMoney() {
        userDao.reduceMoney();
        int i = 10 / 0;
        userDao.addMoney();
    }
}
