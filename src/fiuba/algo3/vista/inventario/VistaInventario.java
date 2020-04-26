package fiuba.algo3.vista.inventario;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.controlador.eventos.ControladorMouseDrag;
import fiuba.algo3.vista.ProveedorDeImagenes;
import fiuba.algo3.vista.posicionable.VistaPosicionableAlmacen;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaInventario extends VBox{
	
	private GridPane seccionAlmacen;
	
	public VistaInventario() {
		this.seccionAlmacen = new GridPane();
		setMaxWidth(200);
		setMaxHeight(400);
		setVisible(false);
		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(6), Insets.EMPTY)));
		//String style = "-fx-background: rgb(225, 228, 203);";
		//setStyle(style);
		inicializar();
	}

	private ControladorInventario controlador() {
		return ControladorInventario.getInstance();
	}
	
	private ProveedorDeImagenes proveedorDeImagenes() {
		return ProveedorDeImagenes.getInstance();
	}
	
	public void inicializar() {
		
		controlador().paraCadaPosicionableDelAlmacenamiento((posicionable, posicion) -> {
			VistaPosicionableAlmacen vistaPosicionable = new VistaPosicionableAlmacen(posicionable, posicion, 30); 
			proveedorDeImagenes().proveerImagen(vistaPosicionable);
			
			ControladorMouseDrag.getInstance().dragPosicionable(vistaPosicionable);
			ControladorMouseDrag.getInstance().dropInPosicionable(vistaPosicionable);
			
			GridPane.setConstraints(vistaPosicionable, posicion.getX(), posicion.getY());
			seccionAlmacen.getChildren().addAll(vistaPosicionable);
		});
		
		Label tituloInventario = new Label("Inventario");
		tituloInventario.setFont(new Font("Verdana", 30));
		//tituloInventario.setStyle("-fx-text-fill: #6495ed");
		tituloInventario.setStyle("-fx-text-fill: #1BD22E; -fx-stroke-color: #823818; -fx-stroke-width: 2");
		getChildren().add(tituloInventario);
		VBox.setMargin(tituloInventario, new Insets(10,10,0,10));
		
		Label tituloFabricacion= new Label("Fabricacion");
		tituloFabricacion.setFont(new Font("Verdana", 15));
		getChildren().add(tituloFabricacion);
		VBox.setMargin(tituloFabricacion, new Insets(10,10,0,10));
		
		VistaSeccionFabricacionInventario seccionFabricacion = new VistaSeccionFabricacionInventario();
		getChildren().add(seccionFabricacion);
		VBox.setMargin(seccionFabricacion, new Insets(10,10,10,10));
		
		Label tituloHerramientaEquipada = new Label ("Herramienta equipada");
		tituloHerramientaEquipada.setFont(new Font("Verdana", 15));
		getChildren().add(tituloHerramientaEquipada);
		VBox.setMargin(tituloHerramientaEquipada, new Insets(10,10,10,10));
		
		VistaHerramientaEquipada herramientaEquipada = new VistaHerramientaEquipada();
		ImageView seccionHerramientaEquipada = herramientaEquipada.getVistaHerramientaEquipada();
		getChildren().add(seccionHerramientaEquipada);
		VBox.setMargin(seccionHerramientaEquipada, new Insets(10,10,10,50));
		
		Label tituloAlmacenamiento = new Label("Almacenamiento");
		tituloAlmacenamiento.setFont(new Font("Verdana", 15));
		getChildren().add(tituloAlmacenamiento);
		VBox.setMargin(tituloAlmacenamiento, new Insets(10,10,0,10));
		
		getChildren().add(seccionAlmacen);
		VBox.setMargin(seccionAlmacen, new Insets(10));
		
	}

	public void refrescar() {
		getChildren().clear();
		seccionAlmacen.getChildren().clear();
		inicializar();
	}
	
	
}
