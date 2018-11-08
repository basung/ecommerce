package com.basung.ecommerce.AOP;

import com.basung.ecommerce.common.controller.ResponseUtils;
import com.basung.ecommerce.exception.ExceptionEnum;
import com.basung.ecommerce.exception.GlobalException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * controller 增强器
 * <p>
 * Date: 2018-10-09-上午10:25
 */

@Controller
@RestControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param
     */
//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
//    }

    /**
     * 全局异常捕捉处理
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public void errorHandler(Exception e, HttpServletResponse response) throws Exception {
	  logger.error("error message === {} ", e.getMessage());
	  ResponseUtils.writeErrorResult(response, 400, e.getMessage());
    }

    //spring 处理异常的接口
    @ExceptionHandler(ApplicationException.class)
    public void handlerException(Exception e, HttpServletResponse response) throws Exception {
	  logger.error("控制器增强处理异常");
	  ResponseUtils.writeErrorResult(response, 400, e.getMessage());
    }


    /**
     * 拦截业务异常
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public void ServiceError(GlobalException error, HttpServletResponse response) throws Exception {
	  ResponseUtils.writeErrorResult(response, error);
    }

    /**
     * 用户未登录异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unAuth(AuthenticationException error, HttpServletResponse response) throws Exception {
	  logger.info("AuthenticationException error === {} ", error);
	  ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_NOT_LOGGED_IN.getCode(), error.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public void notFount(RuntimeException e, HttpServletResponse response) throws Exception {
	  ResponseUtils.writeErrorResult(response, ExceptionEnum.SERVER_ERROR.getCode(), e.getMessage());
    }

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public void groupException(ShiroException error, HttpServletResponse response) throws Exception {
	  logger.info("ShiroException error === {} ", error.getMessage());
	  ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_TOKEN_ERROR.getCode(), ExceptionEnum.USER_TOKEN_ERROR.getMessage());
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorizedException(ShiroException error, HttpServletResponse response) throws Exception {
	  logger.info("unauthorizedException error === {} ", error.getMessage());
	  ResponseUtils.writeErrorResult(response, 401, error.getMessage());
    }
//
//    // 捕捉其他所有异常
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public void groupException(HttpServletRequest request, Throwable ex, HttpServletResponse response) throws Exception {
//        ResponseUtils.writeErrorResult(response, getStatus(request).value(), "错误请求",  ex.getMessage());
//    }
//
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }


}
