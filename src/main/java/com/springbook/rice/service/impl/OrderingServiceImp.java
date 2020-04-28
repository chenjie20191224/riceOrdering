package com.springbook.rice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbook.rice.common.domain.Food;
import com.springbook.rice.common.domain.OrderDetailExample;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.OrderFoodExample;
import com.springbook.rice.mapper.OrderDetailMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderingService")
public class OrderingServiceImp implements OrderingService {
    Integer pageNum=1;
    Integer pageSize=10;
    String startCurr=null;
    String endCurr=null;
    List<OrderFood> sreachResult=null;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
//退款
    public Boolean refund(String orderId){
        OrderFood orderFood=new OrderFood();
        orderFood.setOrderState("已取消");
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
               orderFoodExample.createCriteria().andOrderTimeBetween(start,start+" 23:59").andOrderStateEqualTo(status);
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
               orderFoodExample.createCriteria().andOrderTimeBetween(end,end+" 23:59").andOrderStateEqualTo(status);
           }else {
               orderFoodExample.createCriteria().andOrderTimeBetween(start,end);
           }
       }
       orderFoodExample.setOrderByClause("order_id DESC");
       List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
       this.sreachResult=orderFoods;
       if (this.endCurr==null){
           this.startCurr=start;
           this.endCurr=end;
       }
       System.out.println("Curr"+start+end+"new"+this.startCurr+this.endCurr);
       if (!this.endCurr.equals(end)||!this.startCurr.equals(start)){
           setPage(1,10);
           System.out.println("分页重置");
           this.startCurr=start;
           this.endCurr=end;
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
        if (status.equals("待配送")){
            orderFoodExample.setOrderByClause("order_id ASC");
        }else {
            orderFoodExample.setOrderByClause("order_id DESC");
        }
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

    //   删除订单
    public  Integer allDelete(String[] orderIdList){
        int delete=0;
        OrderDetailExample orderDetailExample;
        for (int i=0;i<orderIdList.length;i++){
            System.out.println("删除"+orderIdList[i]);
            if (orderFoodMapper.deleteByPrimaryKey(orderIdList[i])>=1){
                orderDetailExample=new OrderDetailExample();
                orderDetailExample.createCriteria().andOrderIdEqualTo(orderIdList[i]);
                orderDetailMapper.deleteByExample(orderDetailExample);
                delete++;
            }
        }
        return delete;
    }
}
