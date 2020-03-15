package com.springbook.rice.controller;

import com.springbook.rice.common.domain.*;
import com.springbook.rice.common.utils.HttpXmlClient;
import com.springbook.rice.common.utils.JSONBusiness;
import com.springbook.rice.common.utils.JSONMenu;
import com.springbook.rice.mapper.AddressMapper;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.OrderDetailMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.service.CategoryFoodService;
import com.springbook.rice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataInterfaceController {
    Boolean newOder=false;
    Boolean load=false;
    @Autowired
    FoodService foodService;
    @Autowired
    CategoryFoodService categoryFoodService;
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;

//    局部刷新订单
@RequestMapping("/load")
@ResponseBody
public Boolean load(){
    Boolean load;
    load=this.load;
    this.load=false;
    return load;
}

//    新订单提示
@RequestMapping("/orderPrompt")
@ResponseBody
public Boolean orderPrompt(){
    Boolean newOder;
    newOder=this.newOder;
    this.newOder=false;
    return newOder;
}

    @RequestMapping("/MenuInterface")
    @ResponseBody
    public JSONMenu MenuInterface(){
        List<Food> foods = foodService.selectAll();
        JSONMenu jsonMenu =new JSONMenu();
        jsonMenu.setFoods(foods);
        List<CategoryFood> categoryFoods = categoryFoodService.selectAll();
        jsonMenu.setCategoryFoods(categoryFoods);
        return jsonMenu;
    }

    @RequestMapping("/businessInterface")
    @ResponseBody
    public JSONBusiness businessInterface(){
        JSONBusiness jsonBusiness=new JSONBusiness();
        Business business = businessMapper.selectByPrimaryKey(1);
        jsonBusiness.setBusiness(business);
        return jsonBusiness;
    }
    @RequestMapping("/getOpenId")
    @ResponseBody
    public String getOpenId(String code){
//         appid:"wx4738a29d658b52de",
//        secret:"731e8678c44a32e73fd2da08cec97000",
//        js_code:result.code,
//        grant_type:"authorization.code"
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", "wx4738a29d658b52de");
        params.put("secret", "731e8678c44a32e73fd2da08cec97000");
        params.put("js_code",code);
        params.put("grant_type","authorization.code");
        String xml = HttpXmlClient.post("https://api.weixin.qq.com/sns/jscode2session",params);
        System.out.println(xml);
        return xml;
        //        log.info(xml);
    }

//    获取用户地址
     @RequestMapping("/getAddress")
     @ResponseBody
    public List<Address> getAddress(String openid){
         AddressExample addressExample=new AddressExample();
         addressExample.createCriteria().andOpenidEqualTo(openid);
         List<Address> addresses = addressMapper.selectByExample(addressExample);
      return addresses;
    }
    //    更新用户地址
    @RequestMapping("/updateAddress")
    @ResponseBody
    public Boolean updateAddress(Address address){
        int i = addressMapper.updateByPrimaryKeySelective(address);
      return i!=0?true:false;
    }

    //    删除用户地址
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public Boolean deleteAddress(Integer id){
        int i = addressMapper.deleteByPrimaryKey(id);
        return i!=0?true:false;
    }
   // 保存用户地址
    @RequestMapping("/setAddress")
    @ResponseBody
    public Boolean setAddress(Address address){
        System.out.println(address.getId());
            int i = addressMapper.insertSelective(address);
          return i==1?true:false;

    }

   //置换地址到第一个
   @RequestMapping("/changeAddress")
   @ResponseBody
   public Boolean changeAddress(Integer id){
       System.out.println("置换"+id+"到第一个");
       AddressExample addressExample=new AddressExample();
       List<Address> addresses = addressMapper.selectByExample(addressExample);
       if (addresses.size()!=1&&addresses.size()!=0){
              if (addresses.get(0).getId()!=id){
                  System.out.println("地址有两个以上并"+id+"不在第一个");
                 int flag=addresses.get(0).getId();
                 Address address=new Address();
                 address.setId(1);
                 AddressExample addressExample1=new AddressExample();
                 addressExample1.createCriteria().andIdEqualTo(flag);
                  addressMapper.updateByExampleSelective(address,addressExample1);

                  AddressExample addressExample2=new AddressExample();
                  addressExample2.createCriteria().andIdEqualTo(id);
                  address.setId(flag);
                  addressMapper.updateByExampleSelective(address,addressExample2);

                  AddressExample addressExample3=new AddressExample();
                  addressExample3.createCriteria().andIdEqualTo(1);
                  address.setId(id);
                  addressMapper.updateByExampleSelective(address,addressExample3);
           }
       }
              return true;

   }
   @RequestMapping("/createOrder")
   @ResponseBody
   public Boolean createOrder(OrderFood order){
       this.newOder=true;
       this.load=true;
       int i = orderFoodMapper.insertSelective(order);
       return i!=0?true:false;

   }
   @RequestMapping("/createOrderDetail")
   @ResponseBody
   public Integer createOrderDetail(OrderDetail orderDetail){
        return orderDetailMapper.insertSelective(orderDetail);
   }
    @RequestMapping("/orderList")
    @ResponseBody
    public List<OrderFood> orderList(String openid){
        OrderFoodExample orderFoodExample=new OrderFoodExample();
        orderFoodExample.createCriteria().andOpenidEqualTo(openid);
        orderFoodExample.setOrderByClause("order_id DESC");
        return orderFoodMapper.selectByExample(orderFoodExample);
    }
    @RequestMapping("/orderDetail")
    @ResponseBody
    public List<OrderDetail> orderDetail(String orderId){
        OrderDetailExample orderDetailExample=new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        return orderDetailMapper.selectByExample(orderDetailExample);
    }

}
