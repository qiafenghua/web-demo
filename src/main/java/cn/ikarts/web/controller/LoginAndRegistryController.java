package cn.ikarts.web.controller;

import cn.ikarts.web.bean.User;
import cn.ikarts.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ikart
 * @date 2021年11月24日13:13
 */
@Controller
public class LoginAndRegistryController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping({"/", "/login", "index"})
    public String index(HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user != null){
            return "redirect:/main";
        }
        return "index";
    }

    @PostMapping("/login")
    public String login(User formUser, Model model, HttpSession session) {
        List<User> list = userService.list();
        for (User user : list) {
            if (user.getAccount().equals(formUser.getAccount()) && user.getPwd().equals(formUser.getPwd())) {
                session.setAttribute("loginUser", user);
                return "redirect:/main";
            } else {
                model.addAttribute("msg", "用户名或密码错误,请重新登录!");
            }
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //移除会话session
        session.invalidate();
        //重定向到登录页
        return "redirect:/login";
    }

    @RequestMapping(method = {RequestMethod.POST},name = "/registry")
    public String registry(User formUser, Model model, HttpSession session) {
        //查询用户是存在，存在则返回失败
        User user = userService.selectExist(formUser);
        if (user != null) {
            //用户存在
            model.addAttribute("msg", "该用户已存在，请重新注册!");
        } else {
            //不存在则注册
            userService.save(formUser);
            session.setAttribute("loginUser", formUser);
            model.addAttribute("msg", "注册成功");
            return "redirect:/main";
        }
        return "index";
    }


}
