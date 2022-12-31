package br.com.atividade.questa1a;

import br.com.atividade.model.Veiculo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumidorVeiculo {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String subject = "fila_veiculos";

    public static void consumir() throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(subject);

        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive(15000);

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Recebi da Fila a msg = '" + textMessage.getText() + "'");
            if (textMessage.getText().toLowerCase().contains("xml")) {
                consomeObjeto(textMessage);
            }
        } else {
            System.out.println("** SEM MENSAGENS **  ");
        }

        consumer.close();
        session.close();
        connection.close();
    }

    private static void consomeObjeto(TextMessage msg) throws JMSException {
        TextMessage tmsg = (TextMessage)msg;

        XStream xstream = new XStream(new StaxDriver());

        xstream.addPermission(AnyTypePermission.ANY);

        Veiculo veiculo = (Veiculo) xstream.fromXML(tmsg.getText());

        System.out.println(veiculo);
    }

    public static void main(String[] args) throws JMSException {
        while (true)  consumir();
    }

}
