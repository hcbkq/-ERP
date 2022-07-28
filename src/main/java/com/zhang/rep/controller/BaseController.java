package com.zhang.rep.controller;

import com.zhang.rep.controller.ex.*;
import com.zhang.rep.entity.hp.PageInformation;
import com.zhang.rep.service.ex.*;
import com.zhang.rep.service.ex.Consumption.DeleteConsumptionException;
import com.zhang.rep.service.ex.Consumption.InsertConsumptionException;
import com.zhang.rep.service.ex.Consumption.SelectConsumptionException;
import com.zhang.rep.service.ex.Consumption.UpdateConsumptionException;
import com.zhang.rep.service.ex.ManufacturingMaterials.DeleteManufacturingMaterialsException;
import com.zhang.rep.service.ex.ManufacturingMaterials.InsertManufacturingMaterialsException;
import com.zhang.rep.service.ex.ManufacturingMaterials.SelectManufacturingMaterialsException;
import com.zhang.rep.service.ex.ManufacturingMaterials.UpdateManufacturingMaterialsException;
import com.zhang.rep.service.ex.account.*;
import com.zhang.rep.service.ex.incomeAndExpenditure.DeleteIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.InsertIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.NotIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.UpdateIncomeAndExpenditureException;
import com.zhang.rep.service.ex.production.DeleteProductionException;
import com.zhang.rep.service.ex.production.InsertProductionException;
import com.zhang.rep.service.ex.production.SelectProductionException;
import com.zhang.rep.service.ex.production.UpdateProductionException;
import com.zhang.rep.service.ex.warehousing.InAndOutException;
import com.zhang.rep.util.JsonResult;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseController {

    /**
     * 操作成功的状态码
     */
    public static final int ok = 200;

    /**
     * 头像文件大小的上限值(10MB)
     */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /**
     * 允许上传的头像的文件类型
     */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    public static final int PAGING_SIZE = 8;

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    //自动将异常对象传递给此方法的参数列表上
    //当项目产生了异常，被统一拦截到此方法中，这个方法此实就充当的是请求处理，方法的返回值直接给到前端
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
        } else if (e instanceof InsertException) {
            result.setState(4003);
        } else if (e instanceof CustomerCountLimitException) {
            result.setState(4004);
        } else if (e instanceof CustomerNotExistenceException) {
            result.setState(4005);
        } else if (e instanceof DeleteCustomerException) {
            result.setState(4006);
        } else if (e instanceof DeleteOrderException) {
            result.setState(4007);
        } else if (e instanceof ListCustomerNotException) {
            result.setState(4008);
        } else if (e instanceof OrderCountLimitException) {
            result.setState(4009);
        } else if (e instanceof UpdateException) {
            result.setState(5000);
        } else if (e instanceof UpdateNotesDocumentException) {
            result.setState(5001);
        } else if (e instanceof UpdateContractException) {
            result.setState(5002);
        } else if (e instanceof CustomerUpdateIFOrderException) {
            result.setState(5003);
        } else if (e instanceof CustomerUpdateException) {
            result.setState(5004);
        } else if (e instanceof CustomerUpdateAvatarException) {
            result.setState(5005);
        } else if (e instanceof ListContractNotException) {
            result.setState(5006);
        } else if (e instanceof AddMaterialException) {
            result.setState(5007);
        } else if (e instanceof UpdateMaterialException) {
            result.setState(5008);
        } else if (e instanceof AddProductException) {
            result.setState(5009);
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileStateException) {
            result.setState(6002);
        } else if (e instanceof FileTypeException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        } else if (e instanceof UpdateProductException) {
            result.setState(6005);
        } else if (e instanceof InsertWarehouseException) {
            result.setState(6006);
        } else if (e instanceof UpdateWarehouseException) {
            result.setState(6007);
        } else if (e instanceof SelectWarehouseException) {
            result.setState(6008);
        } else if (e instanceof DeleteWarehouseException) {
            result.setState(6009);
        } else if (e instanceof InsertAccountException) {
            result.setState(6010);
        } else if (e instanceof DeleteAccountException) {
            result.setState(6011);
        } else if (e instanceof UpdateAccountException) {
            result.setState(6012);
        } else if (e instanceof InsertIncomeAndExpenditureException) {
            result.setState(6013);
        } else if (e instanceof UpdateIncomeAndExpenditureException) {
            result.setState(6014);
        } else if (e instanceof DeleteIncomeAndExpenditureException) {
            result.setState(6015);
        } else if (e instanceof SelectAccountException) {
            result.setState(6016);
        } else if (e instanceof LackOfMoneyException) {
            result.setState(9000);
        } else if (e instanceof InAndOutException) {
            result.setState(9001);
        } else if (e instanceof InventoryShortageException) {
            result.setState(9002);
        } else if (e instanceof DeleteManufacturingMaterialsException) {
            result.setState(9003);
        } else if (e instanceof InsertManufacturingMaterialsException) {
            result.setState(9004);
        } else if (e instanceof SelectManufacturingMaterialsException) {
            result.setState(9005);
        } else if (e instanceof UpdateManufacturingMaterialsException) {
            result.setState(9006);
        } else if (e instanceof InsertProductionException) {
            result.setState(9007);
        } else if (e instanceof SelectProductionException) {
            result.setState(9008);
        } else if (e instanceof UpdateProductionException) {
            result.setState(9009);
        } else if (e instanceof DeleteProductionException) {
            result.setState(9010);
        } else if (e instanceof WarehouseInsufficientGoodsException) {
            result.setState(9011);
        } else if (e instanceof InsertConsumptionException) {
            result.setState(9012);
        } else if (e instanceof SelectConsumptionException) {
            result.setState(9013);
        } else if (e instanceof UpdateConsumptionException) {
            result.setState(9014);
        } else if (e instanceof DeleteConsumptionException) {
            result.setState(9015);
        } else if (e instanceof NotIncomeAndExpenditureException){
            result.setState(9014);
        } else if (e instanceof SelectProductException){
            result.setState(9015);
        }

        return result;
    }

    /**
     * 获取session对像中的uid
     *
     * @param session session对象
     * @return 当前登录用户的uid的值
     */
    protected final Integer getuidFormSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前用户登录的username
     *
     * @param session session对象
     * @return 当前登录用户的用户名
     * <p>
     * 在实现类中重写父类中的toString(),不是句柄信息的输出
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    protected final String getAvatar(@RequestParam("file") MultipartFile file, String address) {

        if (file.isEmpty()) {
            throw new FileEmptyException("上传的头像不允许为空");
        }

        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("不允许上传超过" + AVATAR_MAX_SIZE / 1024 + "kg的图片文件");
        }

        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)) {
            throw new FileTypeException("不支持使用该类型的文件");
        }

        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String parent = jarF.getParentFile().toString() + "/classes/static/images/" + address + "/";

        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        int beginIndex = originalFilename.lastIndexOf(".");

        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        File dest = new File(dir, filename);  //是一个空文件
        // 执行保存头像文件
        try {
            file.transferTo(dest);  //将file中的文件写入dest中
        } catch (IllegalStateException e) {
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }

        return "images/" + address + "/" + filename;
    }


    /**
     *
     * @param pageNo 页面
     * @param count 总数据行数
     * @return 关于页面信息的对象
     */
    protected final PageInformation TotalPages(Integer pageNo, Integer count) {

        PageInformation pageInformation = new PageInformation();

        if (pageNo == null) {
            pageNo = 1;
        }

        Integer pageCount = count % PAGING_SIZE == 0 ? count / PAGING_SIZE : count / PAGING_SIZE + 1;
        if (pageNo > pageCount || pageNo < 1){
            pageNo=1;
        }

        pageNo = (pageNo - 1) * PAGING_SIZE;
        pageInformation.setLibraryPageNo(pageNo);
        pageInformation.setDisplayPageNo(pageNo/PAGING_SIZE+1);
        pageInformation.setPageCount(pageCount);
        return pageInformation;
    }

}
