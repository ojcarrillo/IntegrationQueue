package com.co.javeriana.epica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.javeriana.epica.model.Factura;
import com.co.javeriana.epica.model.Response;
import com.co.javeriana.epica.queue.QueueManager;


@RestController
@RequestMapping("/REST/service")
public class QueueRESTService {
	
	@Autowired
	private QueueManager qmanager;
	
	@RequestMapping(value="/contabilidad/", method= RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces={MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
	public Response getReserva(@RequestBody Factura factura) {
		return qmanager.sendQueue(factura);
	}

}
