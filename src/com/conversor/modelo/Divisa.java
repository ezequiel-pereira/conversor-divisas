/**
 * 
 */
package com.conversor.modelo;

/**
 * Reporesenta una divisa a convertir
 * 
 * @author ezedev
 *
 */
public class Divisa {
	private String nombre;
	private Double tasaConversion;
	
	public Divisa(String nombre, Double tasaConversion) {
		this.nombre = nombre;
		this.tasaConversion = tasaConversion;
	}
	
	/**
	 * Convierte un valor de una divisa a otra
	 * 
	 * @param valor Valor a convertir
	 * @param divisaDestino 
	 * @return
	 */
	public Double convertir(Double valor, Divisa divisaDestino) {
		Double valorConvertido = valor * divisaDestino.getTasaConversion();
		System.out.println("aaa");
		return valorConvertido;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tasaConversionUsd
	 */
	public Double getTasaConversion() {
		return tasaConversion;
	}

	/**
	 * @param tasaConversionUsd the tasaConversionUsd to set
	 */
	public void setTasaConversion(Double tasaConversionUsd) {
		this.tasaConversion = tasaConversionUsd;
	}
	
	
}
