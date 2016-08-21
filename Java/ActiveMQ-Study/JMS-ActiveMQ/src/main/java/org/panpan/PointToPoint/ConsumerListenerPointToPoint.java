package org.panpan.PointToPoint;

import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by PanPan on 2016-08-21.
 */
@Slf4j
public class ConsumerListenerPointToPoint implements MessageListener {


    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("收到的消息：" + textMessage.getText());
            System.out.println("收到的消息：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
