package com.zhang.rep.controller;

import com.zhang.rep.entity.Material;
import com.zhang.rep.service.IMaterialService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController extends BaseController {

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("getMaterials")
    public JsonResult<List<Material>> getMaterials(@Param("mid") String mid,
                                                   @Param("label") String label,
                                                   @Param("name") String name,
                                                   Integer pageNo) {
        List<Material> materials = materialService.getMaterials(mid, label, name,pageNo);

        return new JsonResult<>(ok, materials);
    }

    @RequestMapping("addMaterial")
    public JsonResult<Void> addMaterial(Material material, HttpSession httpSession) {
        materialService.addMaterial(material, (Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("changeMaterial")
    public JsonResult<Void> changeMaterial(@Param("mid") String mid,
                                           @Param("purchase") BigDecimal purchase,
                                           @Param("materialStatus") Integer materialStatus,
                                           @Param("storageTemperature") Integer storageTemperature,
                                           @Param("storageMode") Integer storageMode,
                                           @Param("ifFlammable") Integer ifFlammable,
                                           @Param("ifPoisonous") Integer ifPoisonous,
                                           HttpSession httpSession) {

        materialService.changeMaterial(mid, purchase, materialStatus, storageTemperature, storageMode, ifFlammable,
                ifPoisonous,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("deleteMaterial")
    public JsonResult<Void> deleteMaterial(List<String> mids, HttpSession httpSession) {

        materialService.deleteMaterial(mids, (Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }
}
