package com.wilche.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoweiquan
 * @date 2021/3/22
 */
@RestController
@Api(value = "hello 测试", tags = {"曹威权Hello_World"})
public class HelloWorldController {

    @ApiOperation(value = "name 测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header"),
    })
    @PostMapping(value = "/getName")
    public Object getName(String name, @RequestHeader(value = "token", required = false) String token) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("name", name);
        map.put("token", token);
        map.put("message", "hello world");
        return map;
    }
}
