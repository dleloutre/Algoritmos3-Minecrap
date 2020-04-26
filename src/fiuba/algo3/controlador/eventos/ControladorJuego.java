package fiuba.algo3.controlador.eventos;

import fiuba.algo3.modelo.AlmacenamientoLlenoException;
import fiuba.algo3.modelo.Inventario;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.SinHerramientaEquipadaException;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistenteException;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.inicializacion.CriterioDeInicializacionRandom;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.vista.VistaJuego;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorJuego {
	
	public static final double WIDTH = 600;
	public static final double HEIGHT = 670;
	
	private static ControladorJuego instance;
	private Juego juego;
	private VistaJuego vistaJuego;
	
	private ControladorJuego() {
		this.juego = new Juego("test", new CriterioDeInicializacionRandom());
	}
	
	public static ControladorJuego getInstance(){
		if( instance == null ) {
			instance = new ControladorJuego();
		}
		return instance;
	}
	
	public EventHandler<KeyEvent> manejadorDeEventosDeTeclas(){
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				try {
					if (keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP) {
						juego.avanzarJugadorHaciaArriba();			
					} else if (keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN) {
						juego.avanzarJugadorHaciaAbajo();
			        } else if (keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT) {
			        	juego.avanzarJugadorHaciaLaIzquierda();
			        } else if (keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT) {
			        	juego.avanzarJugadorHaciaLaDerecha();
			        } else if (keyEvent.getCode() == KeyCode.E ) {
			        	juego.hacerAlJugadorGolpearAlFrente();
			        } else if (keyEvent.getCode() == KeyCode.I ) {
			        	ControladorInventario.getInstance().cambiarVisibilidadVista();
			        }
				} catch (AlmacenamientoLlenoException e) {
					System.out.println("Inventario Lleno!");
				} catch (SinHerramientaEquipadaException e) {
					System.out.println("Sin Herramienta Equipada!");
				}
				vistaJuego.refrescar();
			}
			
		};
	}
	
	public Herramienta getHerramienta() {
		return this.juego.getJugador().getHerramienta();
	}
	
	public int getDurabilidadHerramienta() {
		return this.juego.getJugador().getHerramienta().getDurabilidad();
	}
	
	public String getNombreJugador() {
		return this.juego.getJugador().getNombre();
	}
	
	public Jugador getJugador(){
		return this.getJugador();
	}

	public void refrescarVista() {
		vistaJuego.refrescar();
	}

	public Inventario getInventario() {
		return this.juego.getJugador().getInventario();
	}

	public Parent getVistaJuego() {
		if (this.vistaJuego == null) {
			this.vistaJuego = new VistaJuego();
		}
		return this.vistaJuego;
	}

	public Mapa getMapa() {
		return this.juego.getMapa();
	}

	public void setNombreJugador(String nombreElegido) {
		this.juego.getJugador().setName(nombreElegido);
	}
	
	public Scene crearSceneConVista() {
		Scene scene = new Scene(getVistaJuego(), WIDTH, HEIGHT);
		scene.setOnKeyPressed(manejadorDeEventosDeTeclas());
		return scene;
	}

	public void validarBosquejoDeHerramienta() throws PlanoInexistenteException {
		this.juego.fabricarHerramienta();
	}
	
	public void equiparJugador (Herramienta unaHerramienta){
		this.juego.equiparJugadorCon(unaHerramienta);
		ControladorJuego.getInstance().refrescarVista();
	}
	
	public void desequiparJugador (){
		this.juego.getJugador().setHerramienta(null);
		ControladorJuego.getInstance().refrescarVista();
	}

	public boolean jugadorEstaEquipado() {
		return this.juego.getJugador().getHerramienta() != null;
	}
	

}
