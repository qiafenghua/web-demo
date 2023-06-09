package cn.ikarts.web;

import cn.ikarts.web.service.impl.EmpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebDemoApplicationTests {

    @Autowired
    EmpServiceImpl empService;


    @Test
    void contextLoads() {
//        Employee employee = new Employee();
//        employee.setEmpName("ikart");
//        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
//        wrapper.eq("emp_no","200001");
//        empService.update(employee,wrapper);
    }

    @Test
    void update(){
//        Employee employee = new Employee(999,"22","ikart","123","ss",199999.00,21.1,"ds",null);
//        empService.save(employee);
    }

}
