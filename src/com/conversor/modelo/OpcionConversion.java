/**
 * 
 */
package com.conversor.modelo;

/**
 * @author ezequiel
 *
 */
public class OpcionConversion {
	private Divisa divisaOrigen;
	private Divisa divisaDestino;
	
	public OpcionConversion(Divisa divisaOrigen, Divisa divisaDestino) {
		this.divisaOrigen = divisaOrigen;
		this.divisaDestino = divisaDestino;
	}
	
	@Override
	public String toString() {
		return "De " + divisaOrigen.getNombre() + " a " + divisaDestino.getNombre();
	}

	/**
	 * @return the divisaOrigen
	 */
	public Divisa getDivisaOrigen() {
		return divisaOrigen;
	}

	/**
	 * @return the divisaDestino
	 */
	public Divisa getDivisaDestino() {
		return divisaDestino;
	}
	
	
}
