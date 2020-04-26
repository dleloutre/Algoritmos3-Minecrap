package fiuba.algo3.modelo.grilla.celda;

import fiuba.algo3.modelo.grilla.Posicionable;

public class EstadoCeldaOcupada extends EstadoCelda{
	
	private Posicionable posicionable;
	
	public EstadoCeldaOcupada(Celda celda, Posicionable posicionable) {
		super(celda);
		this.posicionable = posicionable;
	}
	
	@Override
	public boolean estaOcupada() {
		return true;
	}

	@Override
	public Posicionable getPosicionable() {
		return posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		
	}

	@Override
	public boolean moverContenidoDe(Celda otraCelda) {
		return false;
	}

}
