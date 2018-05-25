package com.co.javeriana.epica.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private String respuesta;
	private String estado;
	private Date fechaReserva;
	
	
	public Response(String respuesta, String estado, Date fechaReserva) {
		
		this.respuesta = respuesta;
		this.estado = estado;
		this.fechaReserva = fechaReserva;
	}
	
	public Response() {		
		this.respuesta = "";
		this.estado = "";
		this.fechaReserva = new Date();
	}


	public String getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaReserva() {
		return fechaReserva;
	}


	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
}
