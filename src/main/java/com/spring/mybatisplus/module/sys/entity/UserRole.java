package com.spring.mybatisplus.module.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XuZhenkui
 * @since 2019-10-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
