package fiuba.algo3.vista.posicionable;

import fiuba.algo3.controlador.eventos.ControladorJuego;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.material.Material;

public class VistaPosicionableHerramientaEquipada extends VistaPosicionable {

	public VistaPosicionableHerramientaEquipada(Posicionable posicionable, int dimension) {
		super(posicionable, dimension);
	}

	@Override
	public void removerDeVista() { 
		ControladorJuego.getInstance().desequiparJugador();
	}
	
	@Override
	public void intercambiarPosicionesCon(VistaPosicionable otraVista) {
		if(!(otraVista.getPosicionable() instanceof Material) && !(otraVista instanceof VistaPosicionableHerramientaFabricada)) {
			super.intercambiarPosicionesCon(otraVista);
		}
	}

	@Override
	public void insertarEnVista(Posicionable posicionable) { 
		if(posicionable instanceof Herramienta) {
			ControladorJuego.getInstance().equiparJugador((Herramienta) posicionable);
		}
	}



	
}
