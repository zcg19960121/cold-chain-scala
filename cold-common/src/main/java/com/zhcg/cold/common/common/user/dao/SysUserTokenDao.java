package com.zhcg.cold.common.common.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhcg.cold.common.common.user.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 *
 *
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);

    void deleteByToken(String token);
}
