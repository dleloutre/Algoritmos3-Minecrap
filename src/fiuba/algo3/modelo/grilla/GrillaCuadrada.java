package fiuba.algo3.modelo.grilla;

import java.util.Map;

public class GrillaCuadrada extends Grilla {

	private int tamanio;

	public GrillaCuadrada(int tamanio) {
		super(tamanio, tamanio);
		this.tamanio = tamanio;
	}
	
	public GrillaCuadrada(int tamanio, Map<Posicion, Posicionable> posicionablesIniciales ) {
		super(tamanio, tamanio, posicionablesIniciales);
		this.tamanio = tamanio;
	}

	public int getTamanio() {
		return tamanio;
	}
}
