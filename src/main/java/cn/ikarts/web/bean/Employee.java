package cn.ikarts.web.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ikart
 * @date 2021年11月24日13:19
 */
@Data
@ToString
@TableName("emp")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("emp_no")
    private String empNo;
    @TableField("emp_name")
    private String empName;
    private String phone;
    private String job;
    private Double salary;
    @TableField("commission_pct")
    private Double commissionPct;
    private String department;
    private String hiredate;
}
