package fiuba.algo3.controlador.eventos;

import java.util.function.BiConsumer;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Orientable;
import fiuba.algo3.modelo.mapa.orientacion.Orientacion;
import fiuba.algo3.vista.VistaMapa;

public class ControladorMapa {
	
	private Mapa mapa;
	private VistaMapa vistaMapa;
	private static ControladorMapa instance;
	
	private ControladorMapa () {
		this.mapa = ControladorJuego.getInstance().getMapa();
	}
	
	public static ControladorMapa getInstance() {
		if( instance == null ) {
			instance = new ControladorMapa();
		}
		
		return instance;
	}
	
	public VistaMapa getVistaMapa() {
		if (this.vistaMapa == null) {
			this.vistaMapa = new VistaMapa();
		}
		return vistaMapa;
	}

	public void paraCadaPosicionable(BiConsumer<Posicionable, Posicion> consumer) {
		mapa.paraCadaPosicionable(consumer);
	}
	
	public Orientacion obtenerOrientacionDe(Orientable orientable) {
		return mapa.obtenerOrientacionDe(orientable);
	}

	public void refrescarVista() {
		getVistaMapa().refrescar();
	}
	
	
}
