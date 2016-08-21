package org.panpan.PointToPoint;

import org.panpan.util.ActiveMQUtils;

import javax.jms.*;
import javax.xml.soap.Text;

/**
 * Created by PanPan on 2016-08-21.
 */
public class JMSConsumerPointToPoint {

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
            while (true) {
                //每间隔1秒接受一次消息
                TextMessage message = (TextMessage) consumer.receive(1000);
                if (message == null) {
                    break;
                }
                String messageText = message.getText();
                System.out.println("收到的消息：" + messageText);
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            ActiveMQUtils.closeSessionAndConnection(connection,session);
        }

    }

}
