package tec.gomoo.oa.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tec.gomoo.oa.OaApplicationTests;
import tec.gomoo.oa.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest extends OaApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user == null ? "null" : user.toString());
    }

    @Test
    public void insertSelective() {
        User user = new User();
        user.setUsername("nightingale");
        user.setPassword("199798");
        user.setPhone("1897288714");
        user.setEmail("997855021@qq.com");
        user.setCreateUser("admin");
        user.setCreateUserId(1);
        userMapper.insertSelective(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        User user = new User();
        user.setId(5);
        user.setEmail("phw.nightingale@gmail.com");
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Test
    public void deleteByPrimaryKey() {
        User user = new User();
        user.setId(6);
        userMapper.deleteByPrimaryKey(user.getId());
    }

    @Test
    public void selectByConditions() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "phw");
        List<User> users = userMapper.selectByConditions(map);
        System.out.println(users);
    }

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}