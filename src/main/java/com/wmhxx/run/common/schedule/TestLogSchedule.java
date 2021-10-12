package com.wmhxx.run.common.schedule;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author :WangMengHe
 * @since :2021-10-11 15:06
 **/
@Slf4j
@Component
@EnableScheduling
public class TestLogSchedule {


    /**
     * 每分钟打印消息
     */
    @Scheduled(cron = "0/15 * * * * ? ")
    public void testPrintInfo() {
        log.info("=========================开始执行定时任务 「每分钟打印乱七八糟的消息」=========================");
        log.info("获取时间：「{}」随机数：「{}」", DateUtil.date(), RandomUtil.randomNumbers(12));
        log.info("=========================定时任务执行完成=========================");
    }

}
