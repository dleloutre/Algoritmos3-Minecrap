package fiuba.algo3.controlador.eventos;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.vista.posicionable.VistaPosicionable;
import javafx.event.EventHandler;
import javafx.scene.effect.Lighting;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class ControladorMouseDrag {

	private static ControladorMouseDrag instance;

	private ControladorMouseDrag() {

	}

	public static ControladorMouseDrag getInstance() {
		if (instance == null) {
			instance = new ControladorMouseDrag();
		}
		return instance;
	}

	private Posicionable posicionableArrastrado;

	public void setArrastrable(Posicionable posicionable) {
		this.posicionableArrastrado = posicionable;
	}

	public Posicionable getArrastrable() {
		return this.posicionableArrastrado;
	}

	public void dragPosicionable(VistaPosicionable vistaPosicionable) {
		vistaPosicionable.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {

				if (vistaPosicionable.getId() != "tablero") {
					Dragboard db = vistaPosicionable.startDragAndDrop(TransferMode.MOVE);

					ClipboardContent content = new ClipboardContent();
					content.putImage(vistaPosicionable.getImage());
					db.setContent(content);

					event.consume();
				}
			}
		});

		vistaPosicionable.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getTransferMode() == TransferMode.MOVE) {

				}
				event.consume();
			}
		});
	}

	public void dropInPosicionable(VistaPosicionable vistaPosicionable) {
		vistaPosicionable.setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* the drag-and-drop gesture entered the target */
				/* show to the user that it is an actual gesture target */
				if (event.getGestureSource() != vistaPosicionable && event.getDragboard().hasImage()) {
					Lighting light = new Lighting();
					vistaPosicionable.setEffect(light);
				}
				event.consume();
			}
		});

		vistaPosicionable.setOnDragExited(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* mouse moved away, remove the graphical cues */
				vistaPosicionable.setEffect(null);

				event.consume();
			}
		});

		vistaPosicionable.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* data is dragged over the target */
				/*
				 * accept it only if it is not dragged from the same node and if it has an image
				 */
				if (event.getGestureSource() != vistaPosicionable && event.getDragboard().hasImage()) {
					/* allow for both copying and moving, whatever user chooses */
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			}
		});

		vistaPosicionable.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* data dropped */
				/* if there is a string data on dragboard, read it and use it */
				Dragboard db = event.getDragboard();

				boolean success = false;
				if (db.hasImage() &&  event.getGestureSource() instanceof VistaPosicionable) {
					VistaPosicionable otraVista = (VistaPosicionable) event.getGestureSource();
					vistaPosicionable.intercambiarPosicionesCon(otraVista);
					success = true;
				}
				/*
				 * let the source know whether the string was successfully transferred and used
				 */
				event.setDropCompleted(success);
				event.consume();
				ControladorInventario.getInstance().refrescarVista();
			}
		});

	}




	

}
