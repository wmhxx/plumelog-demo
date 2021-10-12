package com.wmhxx.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :WangMengHe
 * @since :2021-10-11 14:50
 **/
@Slf4j
@ComponentScan({"com.plumelog", "com.wmhxx.**"})
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        log.info("启动成功");
    }
}
