package com.wmhxx.run.controller;

import cn.hutool.json.JSONUtil;
import com.plumelog.trace.annotation.Trace;
import com.wmhxx.run.controller.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试PlumeLog
 *
 * @author :WangMengHe
 * @since :2021-10-11 15:02
 **/
@Slf4j
@RestController
public class TestPlumeLogController {


    /**
     * 添加信息
     *
     * @param info 信息
     * @return {@link String}
     */
    @GetMapping("/test/add/info")
    public String addInfo(String info) {
        log.info("输入的参数为：「{}」", info);
        return info;
    }


    /**
     * 添加用户信息
     *
     * @param user 用户信息
     * @return {@link String}
     */
    @PostMapping("/test/add/user")
    public User addInfo(@RequestBody User user) {
        log.info("添加用户信息为：「{}」", user);
        log.info("添加用户信息为:{}", JSONUtil.toJsonStr(user));
        return user;
    }

    @Trace
    @PostMapping("/test/add/error")
    public User error(@RequestBody User user) {
        log.error("错误信息：「你这个名字不美观 ->{}」，", user);
        log.warn("警告⚠️：「出现较丑的名字」");
        return user;
    }
}
