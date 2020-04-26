package fiuba.algo3.vista;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.controlador.eventos.ControladorMapa;
import fiuba.algo3.vista.inventario.VistaInventario;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class VistaJuego extends StackPane{
	
	private BarraHud barra;
	private VistaInventario vistaInventario;
	private VistaMapa vistaMapa;
	
	public VistaJuego() {
		super();
		this.vistaMapa = ControladorMapa.getInstance().getVistaMapa();
		this.barra = new BarraHud();
		this.vistaInventario = ControladorInventario.getInstance().getVistaInventario();
		inicializar();
		
	}
	
	private void inicializar() {
		BorderPane pane = new BorderPane();
		
		pane.setTop(vistaMapa);
		pane.setBottom(barra);
	   
		getChildren().add(pane);
		getChildren().add(this.vistaInventario);
		
		StackPane.setAlignment(this.vistaInventario,Pos.CENTER);
		
	}

	public void refrescar() {
		ControladorMapa.getInstance().refrescarVista();
		ControladorInventario.getInstance().refrescarVista();
		this.barra.actualizar();
	}
}
