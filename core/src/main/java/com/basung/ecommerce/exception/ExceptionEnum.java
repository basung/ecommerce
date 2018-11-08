package com.basung.ecommerce.exception;

/**
 * Description: 返回状态枚举定义
 * <p>
 * Date: 2018-10-09-上午9:47
 */
public enum ExceptionEnum implements ServiceExceptionEnum {


    /**
     * 成功状态码
     */
    SUCCESS(200, "成功"),

    /**
     * 用户账户错误
     */
    USER_NOT_LOGGED_IN(400, "用户未登录"),
    USER_LOGIN_ERROR(400, "密码错误,请输入正确的用户名和密码!!!"),
    USER_ACCOUNT_FORBIDDEN(400, "账号已被禁用"),
    USER_NOT_EXIST(400, "用户不存在,请输入正确的用户名和密码!!!"),
    USER_HAS_EXISTED(400, "用户已存在"),
    USER_TOKEN_ERROR(403, "Token认证失败, 请重新登录"),

    /**
     * 请求参数错误
     */
    PARAM_IS_INVALID(400, "参数无效"),
    PARAM_IS_BLANK(400, "参数为空"),
    PARAM_TYPE_BIND_ERROR(400, "参数类型错误"),
    PARAM_NOT_COMPLETE(400, "参数缺失"),
    REQUEST_ERROR(400, "请求有错误"),

    /**
     * 权限错误
     */
    PERMISSION_NO_ACCESS(401, "无访问权限"),

    /**
     * 文件上传
     */
    FILE_READING_ERROR(400, "FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400, "FILE_NOT_FOUND!"),

    /**
     * 其他
     */
    SERVER_ERROR(500, "服务端异常");


    ExceptionEnum(int code, String message) {
	  this.code = code;
	  this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
	  return code;
    }

    public void setCode(Integer code) {
	  this.code = code;
    }

    @Override
    public String getMessage() {
	  return message;
    }

    public void setMessage(String message) {
	  this.message = message;
    }

}
