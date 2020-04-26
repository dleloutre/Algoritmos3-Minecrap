package fiuba.algo3.vista;


import fiuba.algo3.controlador.eventos.ControladorJuego;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.vista.boton.BotonInventario;
import fiuba.algo3.vista.posicionable.VistaPosicionable;
import fiuba.algo3.vista.posicionable.VistaPosicionableHerramientaEquipada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarraHud extends HBox {
	
	private Image fondo;
	
	public BarraHud() {
		
		this.fondo = new Image("FondoMarron.jpg");
		setMinHeight(70);
		setAlignment(Pos.CENTER);
		
		setBackground(new Background(new BackgroundImage(fondo,BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		//setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		setPadding(new Insets(10,10,10,10));
		centerShapeProperty();
		initialize();
	}

	public void initialize() {
		getChildren().clear();
		
		//parent.setPadding(new Insets(20,20,20,20));
		//parent.centerShapeProperty();
		
		Label jugadorEtiqueta = new Label("Jugador: ");
		jugadorEtiqueta.setStyle("-fx-text-fill: lightgreen;"+
				"-fx-font-family: Tahoma;"+
			    "-fx-font-size: 24;");
		jugadorEtiqueta.setAlignment(Pos.CENTER_LEFT);
		//jugadorEtiqueta.setFont(Font.font("Helvetica", 25));
		getChildren().addAll(jugadorEtiqueta);
		
		Text nombreJugador = new Text();
		nombreJugador.setText(ControladorJuego.getInstance().getNombreJugador());		
		//nombreJugador.setFont(Font.font("Helvetica", 25));
		nombreJugador.setFill(Color.LIGHTGREY);
		nombreJugador.setStyle("-fx-font-family: Helvetica;"+"-fx-font-size: 24;");
		setMargin(nombreJugador, new Insets(0,60,0,0));
		getChildren().addAll(nombreJugador);

		//BotonInventario buttonInventario = BotonInventario.getInstance();
		//buttonInventario.setAlignment(Pos.CENTER_RIGHT);
		//buttonInventario.setOnAction(event -> buttonInventario.cambiarVistaInventario());
		
		//BotonTablero buttonConstruccion = BotonTablero.getInstance();
		//buttonConstruccion.setOnAction(event -> buttonConstruccion.cambiarVistaTablero());
		
		VBox layoutHerramientaEquipada = new VBox();
		layoutHerramientaEquipada.setAlignment(Pos.CENTER);
		setMargin(layoutHerramientaEquipada, new Insets(0,0,0,60));
		
		Text description = new Text("Herramienta equipada");
		description.setFill(Color.LIGHTGREEN);
		description.setStyle("-fx-font-family: Helvetica;"+"-fx-font-size: 14;");
		layoutHerramientaEquipada.getChildren().add(description);
		
		HBox.setMargin(description, new Insets(10,10,10,10));
		
		Posicionable herramientaActual = ControladorJuego.getInstance().getHerramienta();
		
		VistaPosicionable vistaPosicionable = new VistaPosicionableHerramientaEquipada(herramientaActual, 30);
		ProveedorDeImagenes.getInstance().proveerImagen(vistaPosicionable);
		layoutHerramientaEquipada.getChildren().add(vistaPosicionable);
		
		
		
		if (ControladorJuego.getInstance().jugadorEstaEquipado()) {
			int durabilidadHerramienta = ControladorJuego.getInstance().getDurabilidadHerramienta();
			Label durabilidadHerramientaEtiqueta = new Label("Durabilidad: " + durabilidadHerramienta);
			durabilidadHerramientaEtiqueta.setStyle("-fx-text-fill: lightgreen;"+
					"-fx-font-family: Helvetica;"+
					"-fx-font-size: 14;");
			durabilidadHerramientaEtiqueta.setAlignment(Pos.CENTER_RIGHT);
			layoutHerramientaEquipada.getChildren().add(durabilidadHerramientaEtiqueta);
		}
		
		getChildren().add(layoutHerramientaEquipada);
	}
	
	public void actualizar(){
		initialize();
	}
	
	
}
