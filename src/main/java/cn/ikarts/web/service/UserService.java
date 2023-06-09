package cn.ikarts.web.service;

import cn.ikarts.web.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ikart
 * @date 2021年11月24日13:25
 */
public interface UserService extends IService<User> {
    User selectExist(User user);
}
