package fiuba.algo3.vista.inventario;

import fiuba.algo3.controlador.eventos.ControladorJuego;
import fiuba.algo3.controlador.eventos.ControladorMouseDrag;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.vista.ProveedorDeImagenes;
import fiuba.algo3.vista.posicionable.VistaPosicionableHerramientaEquipada;
import javafx.scene.image.ImageView;

public class VistaHerramientaEquipada extends ImageView {
	
	private VistaPosicionableHerramientaEquipada herramientaEquipada;
	
	public VistaHerramientaEquipada(){
		Posicionable herramientaActual = ControladorJuego.getInstance().getHerramienta();
		
		this.herramientaEquipada = new VistaPosicionableHerramientaEquipada(herramientaActual, 50);
		ProveedorDeImagenes.getInstance().proveerImagen(herramientaEquipada);
		
		ControladorMouseDrag.getInstance().dragPosicionable(herramientaEquipada);
		ControladorMouseDrag.getInstance().dropInPosicionable(herramientaEquipada);
		
	}
	
	public ImageView getVistaHerramientaEquipada(){
		return this.herramientaEquipada;
	}
	
	
}
