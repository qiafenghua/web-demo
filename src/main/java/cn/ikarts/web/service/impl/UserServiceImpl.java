package cn.ikarts.web.service.impl;

import cn.ikarts.web.bean.User;
import cn.ikarts.web.mapper.UserMapper;
import cn.ikarts.web.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ikart
 * @date 2021年11月24日13:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectExist(User user) {
        return this.baseMapper.selectOne(
                new QueryWrapper<User>().eq("account",user.getAccount()));
    }
}
