package org.panpan.Topic;

import org.panpan.util.ActiveMQUtils;

import javax.jms.*;

/**
 * Created by PanPan on 2016-08-21.
 */
public class JMSConsumerTopic_1 {

    public static void main(String[] args) {
        Connection connection = null;
        Session session =null;
        try {
            connection = ActiveMQUtils.getConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //需要使用跟生产者相同名称的队列，
            Topic topic = session.createTopic("MY_STUDY_JMS_FIRST_TOPIC");
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(new TopicListener_1());

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
           // ActiveMQUtils.closeSessionAndConnection(connection,session);
        }
    }



}
