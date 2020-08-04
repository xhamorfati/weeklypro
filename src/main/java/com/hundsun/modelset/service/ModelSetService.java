package com.hundsun.modelset.service;

import com.hundsun.modelset.bean.JsonResult;
import com.hundsun.modelset.bean.PageJson;
import com.hundsun.modelset.bean.ModelSetBean;
import com.hundsun.modelset.mapper.ModelSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)

public class ModelSetService {
    @Autowired
    private ModelSetMapper ModelMapper;

    /* public Result setModelInfo(ModelSetBean modelinfo) {
         Result result = new Result();
         result.setSuccess(false);
         result.setDetail(null);
         try {
             ModelSetBean existModle = ModelMapper.findModelByUser(modelinfo.getUser_id());
             if(existModle != null){
                 //如果用户名已存在
                 result.setMsg("修改模板");
                 result.setSuccess(true);
                 result.setDetail(modelinfo);
             }else{
                 ModelMapper.setModelInfo(modelinfo);
                 //System.out.println(user.getId());
                 result.setMsg("");
                 result.setSuccess(true);
                 result.setDetail(modelinfo);
             }
         } catch (Exception e) {
             result.setMsg(e.getMessage());
             e.printStackTrace();
         }
         return result;
     }*/
    public PageJson<ModelSetBean> getModelInfo(String user_id,boolean flag) {
        PageJson<ModelSetBean> page = new PageJson<>();
        try {
            List<ModelSetBean> modelist;
            if(flag){
                modelist = ModelMapper.findModelByAll();
            }else{
                modelist = ModelMapper.findModelByUser(user_id);
            }
            if (modelist != null) {
                page.setCode(0);
                page.setMsg("用户:"+user_id+":数据已返回");
                page.setCount(modelist.size());
                page.setData(modelist);
            } else {
                page.setCode(0);
                page.setMsg("用户:"+user_id+":没有查到数据");
                page.setCount(modelist.size());
                page.setData(modelist);
            }
        } catch (Exception e) {
            page.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return page;
    }

    public ModelSetBean findModelByid(Long model_id) {
        ModelSetBean model = new ModelSetBean();
        try {
            model = ModelMapper.findModelByid(model_id);
            if (model != null) {
                return model;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public JsonResult saveModel(String user_id, ModelSetBean modelsave,boolean flag) {
        if (modelsave == null) {
            return JsonResult.fail("传入数据为空");
        }
        if (!(flag || user_id.equals(modelsave.getUser_id()))) {
            //System.out.print(modelsave.getUser_id());
            return JsonResult.fail("用户" + user_id + "没有权限设置" + modelsave.getUser_id() + "的模板");
        }

        if (modelsave.getModel_id() != null && modelsave.getModel_id() > 0) {
            ModelMapper.updateModel(modelsave);
        } else {
            try {
                ModelMapper.insertModel(modelsave);
            } catch (Exception e) {
                e.printStackTrace();
                return JsonResult.fail(e.getMessage() + modelsave.getTopical());
            }
        }
        return JsonResult.ok();
    }

    public JsonResult delModel(Long model_id) {
        try {
            ModelMapper.delModel(model_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
}
