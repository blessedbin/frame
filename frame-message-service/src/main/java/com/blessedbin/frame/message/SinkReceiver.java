package com.blessedbin.frame.message;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by xubin on 2018/10/9.
 *
 * @author 37075
 * @date 2018/10/9
 * @time 15:57
 * @tool intellij idea
 */
@EnableBinding({Sink.class,SinkSender.class})
@Log4j2
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        log.info("Reveived:{}",payload);
    }

}
