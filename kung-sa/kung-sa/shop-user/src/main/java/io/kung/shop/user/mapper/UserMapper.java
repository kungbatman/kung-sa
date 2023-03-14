package io.kung.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.kung.shop.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Author kung
 * @Date 2023/2/22 16:30
 * @Version 1.0.0
 * @Description 用户Mapper
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
