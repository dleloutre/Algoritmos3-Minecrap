package fiuba.algo3.controlador.eventos;

import java.util.function.BiConsumer;

import fiuba.algo3.modelo.AlmacenamientoLlenoException;
import fiuba.algo3.modelo.Inventario;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistenteException;
import fiuba.algo3.vista.inventario.VistaInventario;

public class ControladorInventario {
	
	private Inventario inventario;
	private VistaInventario vistaInventario;
	
	private static ControladorInventario instance;
	
	private ControladorInventario() {
		this.inventario = ControladorJuego.getInstance().getInventario();
	}
	
	public static ControladorInventario getInstance(){
		if( instance == null ) {
			instance = new ControladorInventario();
		}
		return instance;
	}
	
	
	public VistaInventario getVistaInventario() {
		if(this.vistaInventario == null) {
			this.vistaInventario = new VistaInventario();
		}
		return this.vistaInventario;
	}
	

	public void cambiarVisibilidadVista() {
		vistaInventario.setVisible(!vistaInventario.isVisible());
	}
	
	public void paraCadaPosicionableDelAlmacenamiento(BiConsumer<Posicionable, Posicion> consumer) {
		inventario.paraCadaPosicionableDelAlmacenamiento(consumer);
	}
	
	public void paraCadaPosicionableDelBosquejo(BiConsumer<Posicionable, Posicion> consumer) {
		inventario.paraCadaPosicionableDelBosquejo(consumer);
	}

	public void refrescarVista() {
		getVistaInventario().refrescar();
	}

	public void almacenar(Posicionable posicionable) throws AlmacenamientoLlenoException {
		inventario.almacenar(posicionable);
	}

	public Posicionable removerDeAlmacenamiento(Posicion posicion) {
		return inventario.remover(posicion.getX(), posicion.getY());
	}
	
	public void removerDeAlmacenamiento(Posicionable posicionable){
		this.inventario.remover(posicionable);
	}
	
	public Posicionable removerDeBosquejo(Posicion posicion) {
		return inventario.getBosquejo().remover(posicion.getX(), posicion.getY());
	}
	
	public void almacenarEn(Posicionable posicionable, Posicion posicion) {
		inventario.almacenarEn(posicionable, posicion.getX(), posicion.getY());
	}
	
	public void posicionarEnBosquejo(Posicionable posicionable, Posicion posicion) {
		inventario.getBosquejo().posicionar(posicionable, posicion.getX(), posicion.getY());
		try {
			ControladorJuego.getInstance().validarBosquejoDeHerramienta();
		} catch (PlanoInexistenteException e) {
			System.out.println("Plano Inexistente!");
		}
	}
	
	public Posicionable getHerramientaFabricada() {
		return inventario.getHerramientaFabricada();
	}

	public void removerHerramientaFabricada() {
		inventario.removerHerramientaFabricada();
	}

	public void vaciarBosquejo() {
		inventario.getBosquejo().vaciar();
	}
}
