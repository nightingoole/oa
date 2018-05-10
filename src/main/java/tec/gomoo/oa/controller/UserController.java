package tec.gomoo.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tec.gomoo.oa.model.User;
import tec.gomoo.oa.service.UserService;
import xyz.frt.base.controller.BaseController;
import xyz.frt.base.service.BaseService;
import xyz.frt.base.util.JsonResult;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@RestController
public class UserController extends BaseController<User> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BaseService<User> getService() {
        return userService;
    }

    @GetMapping("/users")
    public JsonResult findUsers() {
        return findItems();
    }

    @GetMapping("/users/{id}")
    public JsonResult findUsers(@PathVariable Integer id) {
        return findItemByPrimaryKey(id);
    }

}
