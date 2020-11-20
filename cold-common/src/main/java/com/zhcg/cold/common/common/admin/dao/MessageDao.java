package com.zhcg.cold.common.common.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhcg.cold.common.common.netty.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
}
