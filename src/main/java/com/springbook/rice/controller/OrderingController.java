package com.springbook.rice.controller;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderDetailExample;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.OrderFoodExample;
import com.springbook.rice.common.utils.JSONOrderNum;
import com.springbook.rice.common.utils.Session;
import com.springbook.rice.mapper.OrderDetailMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderingController {
    String status="待配送";
    @Autowired
    OrderingService orderingService;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;

    @RequestMapping("/order-list2")
    public String orderList2(Model model,String status,String orderId,String start,String end){
        List<OrderFood> orderFoods = orderingService.selectOrder("待配送");
        model.addAttribute("status","待配送");
        System.out.println("status:"+status);
        if (status!=null){
            System.out.println(status+this.status);
            if (!status.equals(this.status)){
                System.out.println("分页重置");
                orderingService.setPage(1,10);
            }
            this.status=status;
            orderFoods = orderingService.selectOrder(status);

        }

        if (orderId!=null&&!(orderId.equals("")&&start.equals("")&&end.equals(""))){
//            进行筛选
            orderFoods = orderingService.sreach(start, end, orderId,this.status);
//            model.addAttribute("sreach","true");
            orderingService.setPage(1,10);
            model.addAttribute("start",start);
            model.addAttribute("end",end);
            model.addAttribute("orderId",orderId);

        }
        Session.getSession().setAttribute("status",this.status);

        model.addAttribute("status",this.status);
        model.addAttribute("orderFoods",orderFoods);

        return "order-list2";
    }
    @RequestMapping("/getCurrStatus")
    @ResponseBody
    public String getCurrStatus(){
        Object status = Session.getSession().getAttribute("status");
        return status.toString();
    }



    @RequestMapping("/order-list")
    public String orderList(Model model,String status,String orderId,String start,String end){
        if (status==null) {
            status=this.status;
        }
        if (orderId!=null&&!(orderId.equals("")&&start.equals("")&&end.equals(""))){
//            进行筛选
            List<OrderFood> sreach = orderingService.sreach(start, end, orderId,this.status);
            model.addAttribute("orderFoods",sreach);
            model.addAttribute("sreach","sreach");
        }else {
//            进入页面
            List<OrderFood> orderFoods = orderingService.selectOrder(status);
            model.addAttribute("orderFoods",orderFoods);
            this.status=status;
        }
        model.addAttribute("status",status);
        return "order-list";
    }
//    退款
    @RequestMapping("/refund")
    @ResponseBody
    public Boolean refund(String orderId){

        return orderingService.refund(orderId);
    }
    //    完成订单
    @RequestMapping("/completeOrder")
    @ResponseBody
    public Boolean completeOrder(String orderId){
        return orderingService.completeOrder(orderId);
    }
//    订单查询
//    @RequestMapping("/selectOrder")
//    public String selectOrder(){
//        OrderFoodExample orderFoodExample=new OrderFoodExample();
//        orderFoodExample.createCriteria().andOrderTimeBetween("2020年01月19日","2020年01月20日");
//        List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
//      this.selectOrders=orderFoods;
//        return "redirect:/order-list?select=true";
//    }

//    订单详情
    @RequestMapping("/order-detail")
    public String orderDetail(String orderId,Model model){
        System.out.println(orderId);
        OrderFood orderFood = orderFoodMapper.selectByPrimaryKey(orderId);
        OrderDetailExample orderDetailExample=new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(orderDetailExample);
        model.addAttribute("orderFood",orderFood);
        model.addAttribute("orderDetails",orderDetails);
        return "order-detail";
    }
//    分页触发
    @RequestMapping("/pageHelper")
    @ResponseBody
    public void pageHelper(Integer pageNum,Integer pageSize){
        orderingService.setPage(pageNum, pageSize);
    }
//    分页总数
    @RequestMapping("/orderNum")
    @ResponseBody
    public JSONOrderNum orderNum(){
        JSONOrderNum jsonOrderNum=new JSONOrderNum();
        jsonOrderNum.setNum(orderingService.selectOrderByStatus(this.status).size());
        return jsonOrderNum;
    }

//    删除订单
    @RequestMapping("/allDeleteOrder")
    @ResponseBody
    public Integer allDeleteOrder(String[] orderIdList){

        return orderingService.allDelete(orderIdList);
    }

}
