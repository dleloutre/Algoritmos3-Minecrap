package fiuba.algo3.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.orientacion.Orientacion;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionAbajo;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionArriba;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionDerecha;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionIzquierda;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;

public class MapaTest {

	static int TAMANIO_INICIAL = 20;
	static int X = 1;
	static int Y = 1;
	static String NOMBRE_JUGADOR = "test";
	
	@Test
	public void test01SePuedeOcuparCeldaConUnJugador() throws Exception {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		Jugador unJugador = new Jugador(NOMBRE_JUGADOR);
		
		mapa.posicionar(unJugador, X, Y);
		
		assertTrue(mapa.estaOcupada(X, Y));
	}
	
	@Test
	public void test02SePuedeOcuparCeldaConMadera() throws Exception {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		Material material = new Madera();
		
		mapa.posicionar(material, X, Y);
		
		assertTrue(mapa.estaOcupada(X, Y));
	}
	
	@Test
	public void test03MapaDevuelveContenidoJugadorDeUnaCeldaConJugador() throws Exception {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		Jugador unJugador = new Jugador(NOMBRE_JUGADOR);
		
		mapa.posicionar(unJugador, X, Y);
		
		assertTrue(mapa.obtener(X, Y) instanceof Jugador);
	}

	@Test
	public void test04MapaDevuelveContenidoMaterialDeUnaCeldaConMadera() throws Exception {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		Material material = new Madera();
		
		mapa.posicionar(material, X, Y);
		
		assertTrue(mapa.obtener(X, Y) instanceof Material);
	}

	
	@Test
	public void test05MapaSeInstanciaConTodasLasCeldasVacias() {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		
		for(int x = 0; x < TAMANIO_INICIAL; x++)
			for(int y = 0; y < TAMANIO_INICIAL; y++)
				assertFalse(mapa.estaOcupada(x, y));
	}
	
	@Test
	public void test06LuegoDePosicionarCeldaEstaOcupada() {
		Mapa mapa = new Mapa(TAMANIO_INICIAL);
		Jugador jugador = new Jugador(NOMBRE_JUGADOR);
		
		mapa.posicionar(jugador, X, Y);
		
		assertTrue(mapa.estaOcupada(X, Y));
	}
	
	@Test 
	public void test07MoverOrientableHaciaArribaLoPosicionaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaArriba(jugador);
		
		assertTrue (mapa.obtenerPosicion(jugador).equals(new Posicion(5, 4)));
	}
	
	@Test 
	public void test08MoverOrientableHaciaAbajoLoPosicionaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaAbajo(jugador);
		
		assertTrue (mapa.obtenerPosicion(jugador).equals(new Posicion(5, 6)));
	}
	
	
	
	@Test 
	public void test09MoverOrientableHaciaIzquierdaLoPosicionaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaLaIzquierda(jugador);
		
		assertTrue (mapa.obtenerPosicion(jugador).equals(new Posicion(4, 5)));
	}
	
	
	
	@Test 
	public void test10MoverOrientableHaciaDerechaLoPosicionaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaLaDerecha(jugador);
		
		assertTrue (mapa.obtenerPosicion(jugador).equals(new Posicion(6, 5)));
	}
	
	
	@Test 
	public void test11MoverOrientableHaciaArribaLoOrientaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaArriba(jugador);
		
		Orientacion orientacion = mapa.obtenerOrientacionDe(jugador);
		assertTrue (orientacion instanceof OrientacionArriba);
	}
	
	@Test 
	public void test12MoverOrientableHaciaAbajoLoOrientaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaAbajo(jugador);
		
		Orientacion orientacion = mapa.obtenerOrientacionDe(jugador);
		assertTrue (orientacion instanceof OrientacionAbajo);
	}
	
	@Test 
	public void test13MoverOrientableHaciaIzquierdaLoOrientaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaLaIzquierda(jugador);
		
		Orientacion orientacion = mapa.obtenerOrientacionDe(jugador);
		assertTrue (orientacion instanceof OrientacionIzquierda);
	}
	
	@Test 
	public void test14MoverOrientableHaciaDerechaLoOrientaCorrectamente() throws Exception {
		Mapa mapa = new Mapa(10);
		Jugador jugador = new Jugador("test");
		mapa.posicionar(jugador, 5, 5);

		mapa.moverYOrientarHaciaLaDerecha(jugador);
		
		Orientacion orientacion = mapa.obtenerOrientacionDe(jugador);
		assertTrue (orientacion instanceof OrientacionDerecha);
	}
}
