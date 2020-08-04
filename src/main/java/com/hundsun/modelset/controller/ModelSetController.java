package com.hundsun.modelset.controller;

import com.hundsun.login.bean.CommonReturnType;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.login.service.model.UserModel;
import com.hundsun.modelset.bean.ModelSetBean;
import com.hundsun.modelset.service.ModelSetService;
import com.hundsun.modelset.bean.JsonResult;
import com.hundsun.modelset.bean.PageJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/modelinfo")
public class ModelSetController {

    @Autowired
    private ModelSetService ModelSetService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @GetMapping(value = "/index")
    public String modelist() {
        return "modelset/modelinfo";
    }

    @GetMapping(value = "/mymodeinfo")
    @ResponseBody
    public PageJson<ModelSetBean> getmodelist() {
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if("admin".equals(current_userVo.getReserve1())){
            return ModelSetService.getModelInfo(current_userVo.getDomainId(),true);
        }else{
            return ModelSetService.getModelInfo(current_userVo.getDomainId(),false);
        }
    }

    /*
        @GetMapping(value = "/{model_id}")
        @ResponseBody
        public PageJson<ModelSetBean> edtmodelist(@PathVariable("model_id") String model_id){
            return ModelSetService.getModelInfo(model_id);
        }
    */
    //  public Result getmodelist(@PathVariable("user_id") String user_id){
    @GetMapping("/modelset")
    public String form(@RequestParam(required = false) Long model_id, @RequestParam(required = false) String user_id, ModelMap map) {
        ModelSetBean model = new ModelSetBean();
        if (model_id != null && model_id != 0L) {
            model = ModelSetService.findModelByid(model_id);
        } else if (user_id != null) {
            model.setUser_id(user_id);
            model.setModel_id(0L);
        }
        map.put("model", model);
        return "modelset/modelset";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(ModelSetBean modelsave) {
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if("admin".equals(current_userVo.getReserve1())){
            return ModelSetService.saveModel(current_userVo.getDomainId(),modelsave,true);
        }else{
            return ModelSetService.saveModel(current_userVo.getDomainId(),modelsave,false);
        }
    }

    @DeleteMapping("/del/{model_id}")
    @ResponseBody
    public JsonResult del(@PathVariable("model_id") Long model_id) {
            return ModelSetService.delModel(model_id);
    }
}
