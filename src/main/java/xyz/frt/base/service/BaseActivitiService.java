package xyz.frt.base.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import xyz.frt.base.model.BaseEntity;

import java.io.InputStream;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */

public interface BaseActivitiService<T extends BaseEntity> {

    public ProcessDefinition deployProcess(String filePath);

    public ProcessDefinition deployProcess(InputStream in);

    public ProcessInstance startProcessByKey(String key);

}
