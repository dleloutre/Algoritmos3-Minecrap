package fiuba.algo3.modelo.juego.inicializacion;

import java.util.HashMap;

import fiuba.algo3.modelo.FabricadorDeHerramientas;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.mapa.Mapa;

public abstract class CriterioDeInicializacion {
	
	public abstract Mapa inicializarMapa(Jugador jugador);
	public abstract Jugador inicializarJugador(String nombre);
	public abstract FabricadorDeHerramientas inicializarFabricadorDeHerramientas();
	protected abstract HashMap<Posicion, Posicionable> inicializarMateriales();
	
}
