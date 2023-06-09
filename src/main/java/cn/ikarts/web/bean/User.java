package cn.ikarts.web.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author shenhuan
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.NONE)
    private Integer id;
    private String account;
    private String pwd;
    @TableField(exist = false)
    private String rePwd;
}
