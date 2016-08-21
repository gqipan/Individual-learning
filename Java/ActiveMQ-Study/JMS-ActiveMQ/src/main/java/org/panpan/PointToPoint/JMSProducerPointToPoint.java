package org.panpan.jms.PointToPoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.panpan.util.ActiveMQUtils;

import javax.jms.*;


/**
 * Created by PanPan on 2016-08-21.
 * 点对点模式的生产消费
 */
public class JMSProducerPointToPoint {


    private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;        //默认的用户名和密码都为 NUll
    private static final String PASS_WORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL; //目的地址： failover://tcp://localhost:61616
    private static final int SEND_NUM = 10;

    public static void main(String[] args) {

        ActiveMQConnectionFactory activeMQConnectionFactory = null;
        Connection connection = null;
        Session session = null;
        try {
            //获取消息工厂
            activeMQConnectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASS_WORD, BROKER_URL);
            //通过工厂创建连接
            connection = activeMQConnectionFactory.createConnection();
            //启动连接
            connection.start();
            // 创建Session 两个参数，
            //  第一个：transacted 表示是否开启事务
            //  第二个：acknowledgeMode：Receive 方式，当客户成功的从receive方法返回的时候，或者从MessageListener.onMessage方法成功返回的时候，会话自动确认客户收到的消息
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建队列，消息队列的目的名
            Destination firstQuery = session.createQueue("MY_STUDY_JMS_FIRST_QUERY");
            //创建生产者
            MessageProducer producer = session.createProducer(firstQuery);
            sendMessage(session, producer);

            //因为开启了事务，所以需要提交
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ActiveMQUtils.closeSessionAndConnection(connection,session);
        }

    }


    public static void sendMessage(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < SEND_NUM; i++) {
            TextMessage message = session.createTextMessage();
            message.setText("ActiveMQ 发送的消息" + (i+1));
            System.out.println("发送消息：" + "ActiveMQ 发送的消息" + (i+1));
            producer.send(message);
        }
    }

}
