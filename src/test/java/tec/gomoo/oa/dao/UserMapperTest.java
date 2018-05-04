package tec.gomoo.oa.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tec.gomoo.oa.OaApplicationTests;
import tec.gomoo.oa.model.User;

import static org.junit.Assert.*;

public class UserMapperTest extends OaApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user == null ? "null" : user.toString());
    }

}