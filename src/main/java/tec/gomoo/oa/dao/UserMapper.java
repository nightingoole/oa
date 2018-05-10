package tec.gomoo.oa.dao;

import tec.gomoo.oa.model.User;

import org.apache.ibatis.annotations.Mapper;
import xyz.frt.base.dao.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}