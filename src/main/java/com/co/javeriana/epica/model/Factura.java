package com.co.javeriana.epica.model;

import java.io.Serializable;

public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String numero;
	private String nombre;
	private String documento;	
	private String fecha;
	private String fechaVencimiento;
	private String estado;	
	private Double valor;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Factura() {
		super();
	}
	public Factura(String tipo, String numero, String nombre, String documento, String fecha, String fechaVencimiento,
			String estado, Double valor) {
		super();
		this.tipo = tipo;
		this.numero = numero;
		this.nombre = nombre;
		this.documento = documento;
		this.fecha = fecha;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
		this.valor = valor;
	}

}
