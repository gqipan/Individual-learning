package org.panpan.PointToPoint;

import org.panpan.util.ActiveMQUtils;

import javax.jms.*;

/**
 * Created by PanPan on 2016-08-21.
 */
public class JMSConsumerPointToPoint_2 {

    public static void main(String[] args) {
        Connection connection = null;
        Session session =null;
        try {
            connection = ActiveMQUtils.getConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //需要使用跟生产者相同名称的队列，
            Destination destination = session.createQueue("MY_STUDY_JMS_FIRST_QUERY");
            MessageConsumer consumer = session.createConsumer(destination);
            //使用监听的方式消费- 注册监听
            ConsumerListenerPointToPoint listener = new ConsumerListenerPointToPoint();
            consumer.setMessageListener(listener);

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
        	//使用监听的方式不能关闭连接
           // ActiveMQUtils.closeSessionAndConnection(connection,session);
        }

    }

}
