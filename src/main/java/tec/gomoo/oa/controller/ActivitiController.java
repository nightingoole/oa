package tec.gomoo.oa.controller;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tec.gomoo.oa.config.ActivitiService;
import tec.gomoo.oa.form.OnVocationRequestForm;
import xyz.frt.base.util.AppConst;
import xyz.frt.base.util.BaseUtils;
import xyz.frt.base.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 05-14-2018
 * @description
 */
@RestController
public class ActivitiController {

    private final ActivitiService activitiService;

    @Autowired
    public ActivitiController(ActivitiService activitiService) {
        this.activitiService = activitiService;
    }

    @GetMapping("/processes/{key}")
    public JsonResult startProcess(@PathVariable String key) {
        ProcessInstance instance = activitiService.startProcess(key);
        if (BaseUtils.isNullOrEmpty(instance)) {
            return JsonResult.error("Start process failed");
        }
        return JsonResult.success("Start process [" + instance.getProcessDefinitionId() + "] successful");
    }

    @GetMapping("/tasks/candidate/{group}")
    public JsonResult getTasksByGroup(@PathVariable String group) {
        List<ActivitiService.TaskInfo> infos = activitiService.getTasksByGroup(group);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put(AppConst.KEY_DATA, infos);
        return JsonResult.success("Success", dataMap);
    }

    @GetMapping("/tasks/assignee/{assignee}")
    public JsonResult getTasksByAssignee(String assignee) {
        List<ActivitiService.TaskInfo> infos = activitiService.getTasksByAssignee(assignee);
        if (BaseUtils.isNullOrEmpty(infos)) {
            return JsonResult.warn("Didn't have any record");
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put(AppConst.KEY_DATA, infos);
        return JsonResult.success("Success", dataMap);
    }

    @PatchMapping("/tasks/{taskId}")
    public JsonResult completeTask(@PathVariable String taskId, OnVocationRequestForm form) {
        activitiService.completeTask(taskId, form);
        return JsonResult.success("Completed");
    }

    @PostMapping("/processes")
    public JsonResult deployProcess(HttpServletRequest request, MultipartFile bpmn) {
        if (BaseUtils.isNullOrEmpty(bpmn)) {
            return JsonResult.error("Bpmn file cannot be empty");
        }
        try {
            activitiService.deployProcess(bpmn, request.getServletContext().getRealPath("/processes"));
        } catch (IOException e) {
            return JsonResult.error("Process deploy failed:" + e.getMessage());
        }
        return JsonResult.success("Process deploy successful");
    }

}
