package org.panpan.Topic;

import org.panpan.util.ActiveMQUtils;

import javax.jms.*;

/**
 * Created by PanPan on 2016-08-21.
 *
 * 发布/订阅模式，改模式需要订阅者那边先订阅才能在发布者发布之后收到消息
 *
 */
public class JMSProducerTopic {

    public static void main(String[] args) {
        Connection connection = null;
        Session session = null;
        try {
            connection = ActiveMQUtils.getConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("MY_STUDY_JMS_FIRST_TOPIC");
            MessageProducer producer = session.createProducer(topic);
            sendTopicMessage(session,producer);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            ActiveMQUtils.closeSessionAndConnection(connection,session);
        }

    }

    public static void sendTopicMessage(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < 1000; i++) {
            TextMessage message = session.createTextMessage();
            message.setText("ActiveMQ Topic发送的消息" + (i+1));
            System.out.println("发送消息：" + "ActiveMQ Topic发送的消息" + (i+1));
            producer.send(message);
        }
    }

}
