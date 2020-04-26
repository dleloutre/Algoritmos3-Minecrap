package fiuba.algo3.modelo.mapa.orientacion;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Orientable;

public abstract class Orientacion {
	
	public Posicion calcularPosicionAlFrenteDe(Orientable orientable, Mapa mapa) {
		Posicion posicion = mapa.obtenerPosicion(orientable);
		return new Posicion(posicion.getX() + incrementoX(), posicion.getY() + incrementoY());
	}
	
	public abstract int incrementoX();
	public abstract int incrementoY();
}
