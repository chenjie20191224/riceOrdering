package com.springbook.rice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.OrderFoodExample;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderingService")
public class OrderingServiceImp implements OrderingService {
    Integer pageNum=1;
    Integer pageSize=10;
    List<OrderFood> sreachResult=null;
    @Autowired
    OrderFoodMapper orderFoodMapper;
//退款
    public Boolean refund(String orderId){
        OrderFood orderFood=new OrderFood();
        orderFood.setOrderState("已退款");
        orderFood.setOrderId(orderId);
        int i = orderFoodMapper.updateByPrimaryKeySelective(orderFood);
        return i!=0?true:false;
    }
//    搜索订单
   public List<OrderFood> sreach(String start,String end,String orderId,String status){
       OrderFoodExample orderFoodExample=new OrderFoodExample();
       if (!orderId.equals("")){
           orderFoodExample.createCriteria().andOrderIdEqualTo(orderId);

       }
       if (!start.equals("")&&!end.equals("")){
           System.out.println("start:"+start+"  end:"+end);
           String[] split = start.split("-");
           start=split[0]+"年"+split[1]+"月"+split[2]+"日";
           String[] split2 = end.split("-");
           end=split2[0]+"年"+split2[1]+"月"+split2[2]+"日 23:59";
           System.out.println(start+end);
           orderFoodExample.createCriteria().andOrderTimeBetween(start,end).andOrderStateEqualTo(status);

       }
       if (!start.equals("")&&end.equals("")){
           System.out.println("start:"+start);
           String[] split = start.split("-");
           start=split[0]+"年"+split[1]+"月"+split[2]+"日";
           System.out.println(start+start+" 23:59");
           orderFoodExample.createCriteria().andOrderTimeBetween(start,start+" 23:59").andOrderStateEqualTo(status);

       }
       if (start.equals("")&&!end.equals("")){
           System.out.println("end:"+end);
           String[] split = end.split("-",3);
           for (String s : split) {
               System.out.println(s);
           }
           end=split[0]+"年"+split[1]+"月"+split[2]+"日";
           System.out.println(end+end+" 23:59");
           orderFoodExample.createCriteria().andOrderTimeBetween(end,end+" 23:59").andOrderStateEqualTo(status);

       }
       orderFoodExample.setOrderByClause("order_id DESC");
       List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
       this.sreachResult=orderFoods;
       return orderFoods;
}
    public Boolean completeOrder(String orderId){
        OrderFood orderFood=new OrderFood();
        orderFood.setOrderState("已配送");
        orderFood.setOrderId(orderId);
        int i = orderFoodMapper.updateByPrimaryKeySelective(orderFood);
        return i!=0?true:false;
    }
    public List<OrderFood> orderAll() {
        OrderFoodExample orderFoodExample = new OrderFoodExample();
        List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
        return orderFoods;
    }
    public List<OrderFood> selectOrderByStatus(String status){

        OrderFoodExample orderFoodExample=new OrderFoodExample();
        orderFoodExample.createCriteria().andOrderStateEqualTo(status);
        orderFoodExample.setOrderByClause("order_id DESC");
        List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
        return  orderFoods;
    }

    public List<OrderFood> selectOrder(String status){

        PageHelper.startPage(pageNum , pageSize);
        List<OrderFood> orderFoods = selectOrderByStatus(status);
        PageInfo<OrderFood> personPageInfo = new PageInfo<>(orderFoods);
        List<OrderFood> pageList = personPageInfo.getList();
        return pageList;
    }
    public void setPage(Integer pageNum,Integer pageSize){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
    }
}
