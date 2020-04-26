package fiuba.algo3.modelo.juego;

import fiuba.algo3.controlador.eventos.ControladorFinDelJuego;
import fiuba.algo3.modelo.AlmacenamientoLlenoException;
import fiuba.algo3.modelo.FabricadorDeHerramientas;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.SinHerramientaEquipadaException;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.herramienta.plano.BosquejoDeHerramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistenteException;
import fiuba.algo3.modelo.juego.inicializacion.CriterioDeInicializacion;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Golpeable;

public class Juego {
	
    private Mapa mapa;
    private Jugador jugador;
    private FabricadorDeHerramientas fabricadorDeHerramientas;
    
    public Juego(String nombreJugador, CriterioDeInicializacion criterio){
    	this.jugador = criterio.inicializarJugador(nombreJugador);
    	this.mapa = criterio.inicializarMapa(this.jugador);
    	this.fabricadorDeHerramientas = criterio.inicializarFabricadorDeHerramientas();
    }
    
    public Jugador getJugador(){
    	return this.jugador;
    }
    
    public Mapa getMapa(){
    	return this.mapa;
    }
    
    public void avanzarJugadorHaciaArriba(){
    	mapa.moverYOrientarHaciaArriba(this.jugador);
	}
    
    public void avanzarJugadorHaciaAbajo(){
    	mapa.moverYOrientarHaciaAbajo(this.jugador);
    	
	}
    
    public void avanzarJugadorHaciaLaDerecha(){
    	mapa.moverYOrientarHaciaLaDerecha(this.jugador);
    	
	}
    
    public void avanzarJugadorHaciaLaIzquierda(){
    	mapa.moverYOrientarHaciaLaIzquierda(this.jugador);
	}
    
    public void hacerAlJugadorGolpearAlFrente() throws AlmacenamientoLlenoException, SinHerramientaEquipadaException {
    	Golpeable golpeable = (Golpeable) mapa.obtenerPosicionableAlFrenteDe(this.jugador);
    	Herramienta herramienta = this.jugador.getHerramienta();
    	if (herramienta == null)
    		throw new SinHerramientaEquipadaException();
    	
    	herramienta.golpear(golpeable);
    	
    	if (herramienta.estaRota()){
    		this.jugador.setHerramienta(null);
    	}
    	
    	if(golpeable.estaRoto()) {
    		if (golpeable instanceof Diamante){
    			ControladorFinDelJuego.getInstance().cambiarSceneConVista();
    		}
    		mapa.remover(golpeable);
    		jugador.getInventario().almacenar(golpeable);
    		
    	}
    	
    }
    
    public void fabricarHerramienta() throws PlanoInexistenteException {
    	this.jugador.getInventario().removerHerramientaFabricada();
    	BosquejoDeHerramienta bosquejo = this.jugador.getInventario().getBosquejo();
    	Herramienta herramienta = fabricadorDeHerramientas.fabricarHerramientaEnBaseA(bosquejo);
    	this.jugador.getInventario().setHerramientaFabricada(herramienta);
    }

	public int getTamanioMapa() {
		return this.mapa.getTamanio();
	}

	
//	public void equiparJugadorCon (Herramienta unaHerramienta) throws AlmacenamientoLlenoException {
//		Herramienta herramientaActual = jugador.getHerramienta();
//		jugador.guardar(herramientaActual);
		//jugador.equiparse(unaHerramienta);
//	}
	public void equiparJugadorCon (Herramienta unaHerramienta){
		this.jugador.setHerramienta(unaHerramienta);
	}
	
	
	
    
}
