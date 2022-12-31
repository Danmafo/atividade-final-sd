package br.com.atividade.questa1a;

import br.com.atividade.model.Veiculo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutorVeiculo {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "fila_veiculos";
    public static void envia(String msg) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(subject);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage(msg + subject + " em " + new Date().toLocaleString());

        XStream xstream = new XStream(new StaxDriver());

        Veiculo v1 = new Veiculo("Daniel Fonseca", "Fiat Uno", 2017, 30000.00);
        Veiculo v2 = new Veiculo("Agenor Moreira", "Chevrolet Cruze", 2020, 80000.00);
        Veiculo v3 = new Veiculo("Sarah Berdine", "Ford KA", 2017, 50000.00);

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(v1);
        veiculos.add(v2);
        veiculos.add(v3);

        for (Veiculo v : veiculos) {
            message = session.createTextMessage(xstream.toXML(v));
            producer.send(message);
        }

        System.out.println("Mensagem enviada!");
        connection.close();
    }

    public static void main(String[] args) throws JMSException {
        String msg = "HELLO WORLD!   \n msg enviada para a fila " ;
        if (args != null && args.length>0 ) {
            msg = args[0] + "  \n FILA = ";    	}
        envia(msg);
    }

}
