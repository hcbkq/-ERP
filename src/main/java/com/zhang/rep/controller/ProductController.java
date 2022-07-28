package com.zhang.rep.controller;

import com.zhang.rep.entity.Product;
import com.zhang.rep.service.IProductService;
import com.zhang.rep.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping("addProduct")
    public JsonResult<Void> addProduct(Product product, HttpSession httpSession){
        Integer uid = getuidFormSession(httpSession);
        String username = getUsernameFromSession(httpSession);
        productService.addProduct(product,uid,username);

        return new JsonResult<>(ok);
    }
    @RequestMapping("getProducts")
    public JsonResult<List<Product>> getProducts(@Param("pid") Integer pid,
                                                 @Param("productId") String productId,
                                                 @Param("productName") String productName,
                                                 @Param("workingProcedure") String workingProcedure,
                                                 @Param("haltTheSales") Integer haltTheSales,
                                                 Integer pageNo){

        List<Product> products = productService.getProducts(pid, productId, productName, workingProcedure, haltTheSales,pageNo);
        return new JsonResult<>(ok,products);

    }

    @RequestMapping("changeProduct")
    public JsonResult<Void> changeProduct(@Param("productId") String productId,
                                          @RequestParam("file") MultipartFile file,
                                          @Param("productName") String productName,
                                          @Param("productType") String productType,
                                          @Param("company") String company,
                                          @Param("workingProcedure") String workingProcedure,
                                          @Param("lowestSelling") BigDecimal lowestSelling,
                                          @Param("recentPurchase") BigDecimal recentPurchase,
                                          @Param("recentBid") BigDecimal recentBid,
                                          @Param("specifyCost") BigDecimal specifyCost,
                                          @Param("specifySales") BigDecimal specifySales,
                                          @Param("minimumStock") Integer minimumStock,
                                          @Param("maximumStock") Integer maximumStock,
                                          @Param("rawMaterial") String rawMaterial,
                                          @Param("remarks") String remarks,
                                          @Param("haltTheSales") String haltTheSales,
                                          HttpSession httpSession){
        String avatar = null;
        String address = "product";
        if (file != null){
            avatar = getAvatar(file, address);
        }

        productService.changeProduct(productId,avatar,productName,productType,company,workingProcedure,lowestSelling,recentPurchase,
                recentBid,specifyCost,specifySales,minimumStock,maximumStock,rawMaterial,remarks,haltTheSales,
                getuidFormSession(httpSession),getUsernameFromSession(httpSession));

        return new JsonResult<>(ok);
    }
    @RequestMapping("deleteProduct")
    public JsonResult<Void> deleteProduct(List<String> productId,HttpSession httpSession){

        productService.deleteProduct(productId,getuidFormSession(httpSession),getUsernameFromSession(httpSession));

        return new JsonResult<>(ok);
    }

}
