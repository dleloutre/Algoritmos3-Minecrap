package fiuba.algo3.vista.inventario;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.controlador.eventos.ControladorMouseDrag;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.vista.ProveedorDeImagenes;
import fiuba.algo3.vista.posicionable.VistaPosicionableBosquejo;
import fiuba.algo3.vista.posicionable.VistaPosicionableHerramientaFabricada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class VistaSeccionFabricacionInventario extends HBox {
	
	private GridPane seccionBosquejo;
	
	public VistaSeccionFabricacionInventario( ) {
		this.seccionBosquejo = new GridPane();
		setAlignment(Pos.CENTER_LEFT);
		inicializar();
	}
	
	private ControladorInventario controlador() {
		return ControladorInventario.getInstance();
	}
	
	private ProveedorDeImagenes proveedorDeImagenes() {
		return ProveedorDeImagenes.getInstance();
	}
	
	private void inicializar() {
		controlador().paraCadaPosicionableDelBosquejo((posicionable, posicion) -> {
			VistaPosicionableBosquejo vistaPosicionable = new VistaPosicionableBosquejo(posicionable, posicion, 50);
			proveedorDeImagenes().proveerImagen(vistaPosicionable);
			
			ControladorMouseDrag.getInstance().dragPosicionable(vistaPosicionable);
			ControladorMouseDrag.getInstance().dropInPosicionable(vistaPosicionable);
			
			
			GridPane.setConstraints(vistaPosicionable, posicion.getX(), posicion.getY());
			seccionBosquejo.getChildren().addAll(vistaPosicionable);
		});
		
		
		
		getChildren().add(seccionBosquejo);
		HBox.setMargin(seccionBosquejo, new Insets(15));
		
		ImageView flecha = proveedorDeImagenes().getImagen("flecha", 80);
		getChildren().add(flecha);
		HBox.setMargin(seccionBosquejo, new Insets(30));
		
		Posicionable herramientaFabricada = ControladorInventario.getInstance().getHerramientaFabricada();
		VistaPosicionableHerramientaFabricada vistaHerramientaFabricada = new VistaPosicionableHerramientaFabricada(herramientaFabricada, 50);
		ControladorMouseDrag.getInstance().dragPosicionable(vistaHerramientaFabricada);
		proveedorDeImagenes().proveerImagen(vistaHerramientaFabricada);
		getChildren().add(vistaHerramientaFabricada);
		HBox.setMargin(vistaHerramientaFabricada, new Insets(30));
	}
	
	
}
