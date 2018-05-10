package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.ActionMapper;
import tec.gomoo.oa.model.Action;
import tec.gomoo.oa.service.ActionService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class ActionServiceImpl extends BaseServiceImpl<Action> implements ActionService {

    private final ActionMapper actionMapper;

    @Autowired
    public ActionServiceImpl(ActionMapper actionMapper) {
        this.actionMapper = actionMapper;
    }

    @Override
    public BaseMapper<Action> getMapper() {
        return actionMapper;
    }

}
