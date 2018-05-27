package cn.wolfcode.mapper;

import cn.wolfcode.domain.Message;

public interface MessageMapper {
    void insert(Message entity);
    int deleteByPrimaryKey(Long id);
    Message selectByPrimaryKey(Long id);
}
