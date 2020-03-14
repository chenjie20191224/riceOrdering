package com.springbook.rice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbook.rice.common.domain.Food;
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

        if (status.equals("所有订单")){
            status=null;
        }
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
           if (status!=null){
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end).andOrderStateEqualTo(status);
           }else {
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end);
           }


       }
       if (!start.equals("")&&end.equals("")){
           System.out.println("start:"+start);
           String[] split = start.split("-");
           start=split[0]+"年"+split[1]+"月"+split[2]+"日";
           System.out.println(start+start+" 23:59");
           if (status!=null){
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end).andOrderStateEqualTo(status);
           }else {
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end);
           }

       }
       if (start.equals("")&&!end.equals("")){
           System.out.println("end:"+end);
           String[] split = end.split("-",3);
           for (String s : split) {
               System.out.println(s);
           }
           end=split[0]+"年"+split[1]+"月"+split[2]+"日";
           System.out.println(end+end+" 23:59");
           if (status!=null){
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end).andOrderStateEqualTo(status);
           }else {
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end);
           }
       }
       orderFoodExample.setOrderByClause("order_id DESC");
       List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
       this.sreachResult=orderFoods;
       for (OrderFood orderFood : orderFoods) {
           System.out.println(orderFood.getOrderId());
       }
       PageHelper.startPage(pageNum , pageSize);
       List<OrderFood> orderFoods2 = orderFoodMapper.selectByExample(orderFoodExample);
       PageInfo<OrderFood> personPageInfo = new PageInfo<>(orderFoods2);
       List<OrderFood> pageList = personPageInfo.getList();
       return pageList;
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
        if (this.sreachResult!=null){
            List<OrderFood> list=this.sreachResult;
            this.sreachResult=null;
            return list;
        }
        OrderFoodExample orderFoodExample=new OrderFoodExample();
        if(!status.equals("所有订单")){
            orderFoodExample.createCriteria().andOrderStateEqualTo(status);
        }
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
