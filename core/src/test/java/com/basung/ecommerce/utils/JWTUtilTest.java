package com.basung.ecommerce.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.basung.ecommerce.utils.JWTUtil.*;
import static org.junit.Assert.*;

/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-10-08-下午9:21
 */
public class JWTUtilTest {

    private final static Logger logger = LoggerFactory.getLogger(JWTUtilTest.class);

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Mzg5Nzg1MjEsInVzZXJuYW1lIjoiYWRtaW44ODgifQ.Ah_foRzQUizWeOtC5JOeujhoQspbObsb1wyrSFVDh9s";
    String userName = "admin";

    @Test
    public void createTokenTest() {

	  String newToken = createToken(userName);
	  logger.info(" newToken === {} ", newToken);

    }

    @Test
    public void verifyTest() {

	  Boolean isLogin = verify(token, "admin888");
	  logger.info(" isLogin === {} ", isLogin);

    }

    @Test
    public void getUsernameTest() {

	  String userName = getUserId(token);
	  logger.info(" userName === {} ", userName);

    }

    @Test
    public void getExpiresAtTest() {

	  String time =  getExpiresAt(token);
	  logger.info(" time === {} ", time);

    }
}