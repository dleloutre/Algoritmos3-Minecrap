package fiuba.algo3.modelo.grilla.celda;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;

public class Celda {
	
	private EstadoCelda estadoCelda;
	private Posicion posicion;
	
	public Celda(int x, int y){
		this.estadoCelda = new EstadoCeldaVacia(this);
		this.posicion = new Posicion(x, y);
	}
	
	public Posicionable getPosicionable() {
		return this.estadoCelda.getPosicionable();
	}
	
	public void setPosicionable(Posicionable posicionable) {
		this.estadoCelda.setPosicionable(posicionable);
	}

	public void setEstadoCelda(EstadoCelda estadoCelda) {
		this.estadoCelda = estadoCelda;
	}

	public Boolean estaOcupada() {
		return this.estadoCelda.estaOcupada();
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public boolean moverContenidoDe(Celda otraCelda) {
		return this.estadoCelda.moverContenidoDe(otraCelda);
	}
	
	public Boolean contiene(Posicionable posicionable) {
		return posicionable == this.estadoCelda.getPosicionable();
	}

	public Posicionable vaciar() {
		Posicionable posicionable = this.estadoCelda.getPosicionable();
		setEstadoCelda(new EstadoCeldaVacia(this));
		return posicionable;
	}
	
	@Override
	public boolean equals(Object obj) {
		Celda otraCelda = (Celda) obj;
		
		return this.getPosicionable().getClass() == otraCelda.getPosicionable().getClass();
	}

}
