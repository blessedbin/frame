package com.blessedbin.frame.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by xubin on 2018/10/9.
 *
 * @author 37075
 * @date 2018/10/9
 * @time 16:30
 * @tool intellij idea
 */
public interface SinkSender {

    @Output(Source.OUTPUT)
    MessageChannel output();

}
