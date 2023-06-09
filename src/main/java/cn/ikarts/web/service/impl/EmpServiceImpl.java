package cn.ikarts.web.service.impl;

import cn.ikarts.web.bean.Employee;
import cn.ikarts.web.mapper.EmpMapper;
import cn.ikarts.web.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ikart
 * @date 2021年11月24日13:27
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Employee> implements EmpService {

}
