package fiuba.algo3.vista;

import fiuba.algo3.controlador.eventos.ControladorMapa;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.mapa.Orientable;
import fiuba.algo3.vista.posicionable.VistaPosicionableMapa;
import javafx.scene.layout.GridPane;

public class VistaMapa extends GridPane{
	
	
	public VistaMapa() {
		super();
		setPrefSize(800, 400);
		inicializar();
	}
	
	private void inicializar() {
		ControladorMapa.getInstance().paraCadaPosicionable((posicionable, posicion) -> {
			ProveedorDeImagenes proveedor = ProveedorDeImagenes.getInstance();
			VistaPosicionableMapa vistaPosicionable = new VistaPosicionableMapa(posicionable, posicion, 30);
			if (!(posicionable instanceof Jugador)) {
				proveedor.proveerImagen(vistaPosicionable);
			} else {
				proveedor.getImagenJugador(vistaPosicionable, ControladorMapa.getInstance().obtenerOrientacionDe((Orientable) posicionable));
			}
			setConstraints(vistaPosicionable, posicion.getX(), posicion.getY());
			getChildren().addAll(vistaPosicionable);
		});
	}

	public void refrescar() {
		getChildren().clear();
		inicializar();
	}

	
}
