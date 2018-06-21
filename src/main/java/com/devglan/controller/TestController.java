package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@PublicApiController
public class TestController {


    /***
     * // without auth
     * http://localhost:8080/token/test
     *
     * //
     *
     *
     * ***/
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String dfregister() throws AuthenticationException {
System.out.print("/test");
        return "test ss";
    }

}
