package net.maxwellclass.online.xdclass.exception;

import net.maxwellclass.online.xdclass.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 异常处理器
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 20:59
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        logger.error("[系统异常]{}", e.getMessage());

        if (e instanceof MAXException) {
            MAXException maxException = (MAXException) e;
            return JsonData.buildError(maxException.getCode(), maxException.getMsg());
        } else {
            return JsonData.buildError("全局异常，未知错误");
        }

    }
}