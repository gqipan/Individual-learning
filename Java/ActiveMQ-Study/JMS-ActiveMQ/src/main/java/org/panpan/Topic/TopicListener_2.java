package org.panpan.Topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by PanPan on 2016-08-21.
 */
public class TopicListener_2 implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("订阅者二收到的消息："+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
