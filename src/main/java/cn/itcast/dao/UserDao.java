package cn.itcast.dao;

import cn.itcast.domain.OrderLineQueryCondition;
import cn.itcast.domain.OrderLineQueryResult;
import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //保存用户
    void insertUser(User user);
    //更新用户
    int updateUser(User user);
    //删除用户
    int deleteUser(@Param("userId") Long userId);
    // 查询所有用户
    List<OrderLineQueryResult> selectOrderLinesByCondition(OrderLineQueryCondition condition);
    /**
     * 开发List<OrderLineQueryResult>
     * selectOrderLinesByCondition(OrderLineQueryCondition condition);方法，
     * 用以根据传入条件动态查询订单行数据。
     * 查询条件包含订单编号(模糊)、订单行号、物料编码(模糊)、物料名称(模糊)、订单创建人id、订单客户id。
     * 查询结果包含订单编号、客户名称、客户地址、订单备注、
     * 订单创建人、订单行号、物料编码、物料名称、单价、数量、行总价
     * @return
     */

}
