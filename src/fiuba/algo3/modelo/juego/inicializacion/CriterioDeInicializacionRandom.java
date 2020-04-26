package fiuba.algo3.modelo.juego.inicializacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.modelo.FabricadorDeHerramientas;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.PicoDeMadera;
import fiuba.algo3.modelo.herramienta.PicoDeMetal;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class CriterioDeInicializacionRandom extends CriterioDeInicializacion {
	private static int TAMANIO_MAPA = 20;
	private static int POSICION_JUGADOR = 10;
	private static int CANTIDAD_INICIAL_MADERA_Y_PIEDRA = 20;
	private static int CANTIDAD_INICIAL_METAL = 10;
	private static int CANTIDAD_INICIAL_DIAMANTE = 1;

	
	@Override
	public Mapa inicializarMapa(Jugador jugador) {
		HashMap<Posicion, Posicionable> posicionables = inicializarMateriales();
		
		posicionables.put(new Posicion(POSICION_JUGADOR, POSICION_JUGADOR), jugador);
		
		return new Mapa(TAMANIO_MAPA, posicionables);
	}

	@Override
	protected HashMap<Posicion, Posicionable> inicializarMateriales(){
		HashMap<Posicion, Posicionable> posicionesPosicionables = new HashMap<Posicion, Posicionable>();
		
		Random random = new Random();
		for (int i=0; i<CANTIDAD_INICIAL_MADERA_Y_PIEDRA; i++){
			posicionesPosicionables.put(new Posicion(random.nextInt(TAMANIO_MAPA), random.nextInt(TAMANIO_MAPA)), new Madera());
			posicionesPosicionables.put(new Posicion(random.nextInt(TAMANIO_MAPA), random.nextInt(TAMANIO_MAPA)), new Piedra());
		}
		for (int i=0; i<CANTIDAD_INICIAL_METAL; i++){
	    	posicionesPosicionables.put(new Posicion(random.nextInt(TAMANIO_MAPA), random.nextInt(TAMANIO_MAPA)), new Metal());
		}
	    	
	    for (int i=0; i<CANTIDAD_INICIAL_DIAMANTE; i++){
	    	posicionesPosicionables.put(new Posicion(random.nextInt(TAMANIO_MAPA), random.nextInt(TAMANIO_MAPA)), new Diamante());
	    }
	    
	    return posicionesPosicionables;
	}

	@Override
	public Jugador inicializarJugador(String nombre){
		ArrayList<Posicionable> posicionablesIniciales = new ArrayList<Posicionable>();
		
		Jugador jugador = new Jugador(nombre, posicionablesIniciales);
		
		return jugador;
	}

	@Override
	public FabricadorDeHerramientas inicializarFabricadorDeHerramientas() {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		
		planos.add(PicoDeMadera.plano());
		planos.add(PicoDeMetal.plano());
		planos.add(PicoDePiedra.plano());
		planos.add(PicoFinoDeMetalYPiedra.plano());
		planos.add(HachaDeMadera.plano());
		planos.add(HachaDePiedra.plano());
		planos.add(HachaDeMetal.plano());
		
		return new FabricadorDeHerramientas(planos);
	}

}
