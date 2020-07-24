package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.OrderLineQueryCondition;
import cn.itcast.domain.OrderLineQueryResult;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMyBatis {
    private static SqlSessionFactory factory;

    static {
        // 加载配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 条件动态查询订单行数据
     */
    @Test

    public void selectCondition() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
//         条件动态查询订单行数据
        OrderLineQueryCondition condition = new OrderLineQueryCondition();
        condition.setCustomerUserId((long) 2);
        List<OrderLineQueryResult> list = dao.selectOrderLinesByCondition(condition);
        for (OrderLineQueryResult order : list) {
            System.out.println(order);
        }
    }

    @Test
    public void inserUser() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user = new User();
        user.setUserNumber("20005");
        user.setUserId((long) 4);
        user.setUserName("徐莉");
        user.setAddress("上海");
        user.setCreatedBy(1L);
        user.setLastUpdatedBy(1L);
        user.setCreationDate(new Date());
        user.setLastUpdateDate(new Date());
        dao.insertUser(user);
        System.out.println("当前创建的用户user_id是:" + user.getUserId());
    }

    @Test
    public void deleteUser() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        int i = dao.deleteUser((long) 3);
        System.out.println("当前删除的用户的数量是：" + i);
    }


    @Test
    public void updateUser() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user=new User();
        user.setUserName("徐莉");
        user.setUserId((long) 1);
        user.setUserNumber("20007");
        int i = dao.updateUser(user);
        if (i>0){
            System.out.println("当前用户更新成功.....");
        }
    }
}
