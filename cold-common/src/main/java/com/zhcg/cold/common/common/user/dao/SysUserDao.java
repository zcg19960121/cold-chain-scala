package com.zhcg.cold.common.common.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhcg.cold.common.common.user.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 *
 *
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);
}
