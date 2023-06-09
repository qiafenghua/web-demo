package cn.ikarts.web.controller;

import cn.ikarts.web.bean.Employee;
import cn.ikarts.web.bean.User;
import cn.ikarts.web.service.impl.EmpServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ikart
 * @date 2021年11月24日13:23
 */
@Slf4j
@Controller
public class MainController {

    @Autowired
    EmpServiceImpl empService;

    @GetMapping("/main")
    public String main(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                       HttpSession session,
                       Model model) {
        Page<Employee> page = new Page<>(pn, 10);
        Page<Employee> employeePage = empService.page(page);
        User user = (User) session.getAttribute("loginUser");
        model.addAttribute("employees", employeePage);
        model.addAttribute("user", user);
        return "pages/main";
    }


    @GetMapping("/deleteEmp/{id}")
    public String delEmp(@PathVariable(value = "id", required = false) Integer id,
                         @RequestParam("pn") Integer pn,
                         RedirectAttributes redirectAttributes) {
        empService.removeById(id);
        redirectAttributes.addAttribute("pn", pn);
        return "redirect:/main";
    }

    @ResponseBody
    @PostMapping("/updateEmp")
    public boolean updateEmp(Employee employee) {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("emp_no", employee.getEmpNo());
        log.info("请求updateEmp--");
        System.out.println(employee.toString());
        return empService.update(employee, wrapper);
    }

    @ResponseBody
    @PostMapping("/addEmp")
    public boolean addEmp(Employee employee) {
        if (employee.getHiredate() == "") {
            employee.setHiredate(null);
        }
        return empService.save(employee);
    }

    @PostMapping("/findEmpByCondition")
    public String findEmpByCondition(@RequestParam(value = "empNo", required = false) String empNo,
                                     @RequestParam(value = "empName", required = false) String empName,
                                     @RequestParam(value = "department", required = false) String department,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                     HttpSession session,
                                     Model model) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("emp_no", empNo);
        wrapper.like("emp_name", empName);
        wrapper.like("department", department);

        Page<Employee> page = new Page<>(pn, 10);
        Page<Employee> employeePage = empService.page(page, wrapper);
        List<Employee> records = employeePage.getRecords();
        model.addAttribute("employees", employeePage);
        User user = (User) session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "pages/main";
    }


}
