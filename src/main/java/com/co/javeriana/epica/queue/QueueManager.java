package com.co.javeriana.epica.queue;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.co.javeriana.epica.model.Factura;
import com.co.javeriana.epica.model.Response;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

@Component
public class QueueManager {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final static String QUEUE_NAME = "mq_movctas";
	private final static String HOST = "35.203.21.5";

	public Response sendQueue(Factura factura) {
		Response res = new Response();
		StringBuilder msg = new StringBuilder();
		msg.append(factura.getTipo());
		msg.append(StringUtils.leftPad(factura.getNumero(), 12, "0"));
		msg.append(factura.getFecha().replaceAll("-", ""));
		msg.append(StringUtils.leftPad(factura.getDocumento(), 15, "0"));
		msg.append(StringUtils.rightPad(factura.getNombre(), 70, " "));
		msg.append("p");
		msg.append(StringUtils.leftPad("", 5, "0"));
		msg.append(StringUtils.leftPad("", 17, "0"));
		msg.append(Utils.getImpuestos());
		Double valorIva = Utils.getValorIVA(factura.getValor());
		msg.append(StringUtils.leftPad(String.valueOf(valorIva), 17, "0"));
		msg.append(StringUtils.leftPad(String.valueOf(factura.getValor()), 17, "0"));
		msg.append(factura.getEstado());
		try{
			sendMsgQueue(msg.toString());
			res.setEstado("1");
			res.setRespuesta("FACTURA PUBLICADA EN LA COLA");
		}catch(Exception e){
			res.setEstado("0");
			res.setRespuesta("NO SE PUDO PUBLICAR EN LA COLA");
		}
		return res;
	}

	public void sendMsgQueue(String message) throws Exception {		  
		/* configura la conexion al servidor de colas */
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("b2c_client");
		factory.setPassword("SuperPassword000");
		factory.setHost(HOST);
		factory.setPort(5672);
		/* abre la conexion */
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	    /* publica el mensaje en la cola */
	    channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
	    log.error(" [x] Sent '" + message + "'");
	    /* cierra la conexion al servidor de colas */
	    channel.close();
	    connection.close();
	  }
}
