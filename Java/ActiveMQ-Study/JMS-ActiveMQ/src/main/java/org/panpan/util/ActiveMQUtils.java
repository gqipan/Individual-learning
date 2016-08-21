package org.panpan.util;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * Created by PanPan on 2016-08-21.
 */
public class ActiveMQUtils {


    public static Connection getConnection() {
        Connection connection = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                    ActiveMQConnection.DEFAULT_PASSWORD,
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            return connection;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeSessionAndConnection(Connection connection, Session session) {
        try {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
