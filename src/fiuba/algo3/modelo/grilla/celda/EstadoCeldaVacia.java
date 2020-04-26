package fiuba.algo3.modelo.grilla.celda;

import fiuba.algo3.modelo.grilla.Posicionable;

public class EstadoCeldaVacia extends EstadoCelda{

	public EstadoCeldaVacia(Celda celda) {
		super(celda);
	}

	@Override
	public boolean estaOcupada() {
		return false;
	}

	@Override
	public Posicionable getPosicionable(){
		return new EspacioVacio();
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.celda.setEstadoCelda(new EstadoCeldaOcupada(this.celda, posicionable));
	}
	
	@Override
	public boolean moverContenidoDe(Celda otraCelda) {
		Posicionable posicionable = otraCelda.vaciar();
		setPosicionable(posicionable);
		return true;
	}
}
