package com.springbook.rice.controller;

import com.springbook.rice.common.domain.Admin;
import com.springbook.rice.common.domain.AdminExample;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.common.utils.Session;
import com.springbook.rice.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/")
    public String index() {
        if (Session.getCurrent() != null) {
            Admin current = Session.getCurrent();
            //在session中找到管理员并核对密码正确，则返回首页
            AdminExample adminExample=new AdminExample();
            adminExample.createCriteria().andAdminEqualTo(current.getAdmin());
            List<Admin> admins = adminMapper.selectByExample(adminExample);
            if (admins.size() != 0 & admins.get(0).getPassword().equals(current.getPassword())) {
                return "index";
            }
        }
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(Admin admin) {

        JSONResult Login = new JSONResult();
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andAdminEqualTo(admin.getAdmin());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        //用户存在，
        if (admins.size() != 0 & admins.get(0).getPassword().equals(admin.getPassword())) {
            Session.setCurrent(admin);
            Login.setSuccess(true);
            return Login;
        }else {
            Login.setMsg("管理员名或密码错误");
        }
        return Login;
    }
//注销
    @RequestMapping("/logout")
    public String logout() {
        Session.clearSession();
//         return "redirect:/itemEdit.action?itemId=" +
//        return "forward:/itemEdit.action";
        return "redirect:/";
    }
    //管理员添加页面 admin-add
    @RequestMapping("/admin-add")
    public String admin_add() {
        return "admin-add";
    }
    //管理员修改密码页面 admin-edit
    @RequestMapping("/admin-edit")
    public String admin_edit() {
        return "admin-edit";
    }

//    修改密码
    @RequestMapping("/adminEdit")
    @ResponseBody
    public JSONResult adminEdit(String password,String newPassword,String rePassword) {
        Admin current = Session.getCurrent();
        System.out.println(current.getPassword());
        JSONResult jsonResult=new JSONResult();
//        旧密码是否正确
        if (password.equals(current.getPassword())){
//            两次输入的新密码是否一致
            if (newPassword.equals(rePassword)){
//                新旧密码是否一样
                if(!password.equals(newPassword)){
                    jsonResult.setSuccess(true);
                    AdminExample adminExample=new AdminExample();
                    adminExample.createCriteria().andAdminEqualTo(current.getAdmin());
                    Admin admin=new Admin();
                    admin.setPassword(newPassword);
                    adminMapper.updateByExampleSelective(admin,adminExample);
                }else {
                    jsonResult.setSuccess(false);
                    jsonResult.setMsg("新密码不能和原密码一样！");
                }


            }else {
                jsonResult.setSuccess(false);
                jsonResult.setMsg("两次密码不一致！");
            }
        }else {
            jsonResult.setSuccess(false);
            jsonResult.setMsg("旧密码不正确！");

        }

        return jsonResult;
    }



    //显示用户名
    @RequestMapping("/getAdmin")
    @ResponseBody
    public String getAdmin() {
        return Session.getCurrent().getAdmin();
    }

}