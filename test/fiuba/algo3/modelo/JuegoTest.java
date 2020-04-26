package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.grilla.celda.CeldaVaciaException;
import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.inicializacion.CriterioDeInicializacionRandom;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class JuegoTest {
	
	static String NOMBRE_JUGADOR = "test";
	static int TAMANIO_MAPA = 20;
    static int POSICION_X_JUGADOR = 10;
	static int POSICION_Y_JUGADOR = 10;
	private static int FUERZA_HACHA_DE_MADERA=2;

	@Test
	public void test01JuegoSeIniciaConMapaDe20x20() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		assertEquals(juego.getTamanioMapa(), TAMANIO_MAPA);
	}
	
	@Test 
	public void test02JuegoSeIniciaConJugadorInicializado() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Jugador jugador = juego.getJugador();
		
		String nombre = jugador.getNombre();
		Herramienta hacha = jugador.getHerramienta();
		
		assertEquals(nombre, "test");
		assertTrue(hacha instanceof HachaDeMadera);
	}
	
	@Test
	public void test03JuegoSeIniciaConMaterialesDistribuidos() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		boolean madera = false;
		boolean metal = false;
		boolean piedra = false;
		boolean diamante = false;
		for (int i = 0; i < TAMANIO_MAPA; i ++){
			for (int j=0; j < TAMANIO_MAPA; j++){
				Posicionable elemento = mapa.obtener(i, j);
				if (elemento instanceof Madera){
					madera = true;
				}
				if (elemento instanceof Piedra){
					piedra = true;
				}
				if (elemento instanceof Metal){
					metal = true;
				}
				if (elemento instanceof Diamante){
					diamante = true;
				}
			}
			
		}
		assertTrue(madera);
		assertTrue(diamante);
		assertTrue(metal);
		assertTrue(piedra);
	}
	
	@Test 
	public void test04JuegoSeIniciaConJugadorEnPosicion() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();		
		
		Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR);
		assertTrue (jugador instanceof Jugador);
	}
	
	
	@Test
	public void test05JugadorAvanzaHaciaArriba() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		if(!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR-1)){
			juego.avanzarJugadorHaciaArriba();
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR-1);
			assertTrue (jugador instanceof Jugador); //prueba que en esa posicion hay un Jugador y no otra cosa posicionable
		}
		else {
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR-1);
			assertFalse (jugador instanceof Jugador);
		}
		
	}
	
	@Test
	public void test06JugadorAvanzaHaciaAbajo() throws Exception{

		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
			juego.avanzarJugadorHaciaAbajo();
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR+1);
			assertTrue (jugador instanceof Jugador);
		}
		else {
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR+1);
			assertFalse (jugador instanceof Jugador);
		}
	}
	
	@Test
	public void test14JugadorAvanzaHaciaAbajoYLaPosicionAnteriorQuedaVacia() throws CeldaVaciaException{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
			juego.avanzarJugadorHaciaAbajo();
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR);
			assertFalse (jugador instanceof Jugador);
		}
		else {
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR);
			assertTrue (jugador instanceof Jugador);
		}
	}
	
	@Test
	public void test07JugadorAvanzaHaciaLaDerecha() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
			juego.avanzarJugadorHaciaLaDerecha();
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR+1, POSICION_Y_JUGADOR);
			assertTrue (jugador instanceof Jugador);
		}
		else {
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR+1, POSICION_Y_JUGADOR);
			assertFalse (jugador instanceof Jugador);
		}
	}
	
	@Test
	public void test08JugadorAvanzaHaciaLaIzquierda() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
			juego.avanzarJugadorHaciaLaIzquierda();
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR-1, POSICION_Y_JUGADOR);
			assertTrue (jugador instanceof Jugador);
		}
		else {
			Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR-1, POSICION_Y_JUGADOR);
			assertFalse (jugador instanceof Jugador);
		}
	}
	
	@Test
	public void test09JugadorAvanzaVariasVecesHaciaArriba() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		for(int i=0; i<10; i++) {
			if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
				juego.avanzarJugadorHaciaArriba();
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, 0);
				assertTrue (jugador instanceof Jugador);
			}
			else {
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, 0);
				assertFalse (jugador instanceof Jugador);
			}
		}
	}
	
	@Test
	public void test10JugadorAvanzaVariasVecesHaciaAbajo() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		for(int i=0; i<9; i++) {
			if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
				juego.avanzarJugadorHaciaAbajo();
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR+9);
				assertTrue (jugador instanceof Jugador);
			}
			else {
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR+9);
				assertFalse (jugador instanceof Jugador);
			}
		}
	}
	
	@Test
	public void test11JugadorAvanzaVariasVecesHaciaLaIzquierda() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		for(int i=0; i<10; i++) {
			if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
				juego.avanzarJugadorHaciaLaIzquierda();
				Posicionable jugador = mapa.obtener(0, POSICION_Y_JUGADOR);
				assertTrue (jugador instanceof Jugador);
			}
			else {
				Posicionable jugador = mapa.obtener(0, POSICION_Y_JUGADOR);
				assertFalse (jugador instanceof Jugador);
			}
		}
	}
	
	@Test
	public void test12JugadorAvanzaVariasVecesHaciaLaDerecha() throws Exception{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		for(int i=0; i<9; i++) {
			if (!mapa.estaOcupada(POSICION_X_JUGADOR, POSICION_Y_JUGADOR)){
				juego.avanzarJugadorHaciaLaDerecha();
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR+9, POSICION_Y_JUGADOR);
				assertTrue (jugador instanceof Jugador);
			}
			else {
				Posicionable jugador = mapa.obtener(POSICION_X_JUGADOR+9, POSICION_Y_JUGADOR);
				assertFalse (jugador instanceof Jugador);
			}
		}
	}
	
	@Test
	public void test13JugadorGolpeaMaderaConHachaDeMadera() throws CeldaVaciaException,AlmacenamientoLlenoException{
		Juego juego = new Juego(NOMBRE_JUGADOR, new CriterioDeInicializacionRandom());
		Mapa mapa = juego.getMapa();
		
		Jugador jugador = juego.getJugador();
		Herramienta herramienta = jugador.getHerramienta();
		Posicionable posicionable1 = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR-1);
		Posicionable posicionable2 = mapa.obtener(POSICION_X_JUGADOR, POSICION_Y_JUGADOR+1);
		Posicionable posicionable3 = mapa.obtener(POSICION_X_JUGADOR-1, POSICION_Y_JUGADOR);
		Posicionable posicionable4 = mapa.obtener(POSICION_X_JUGADOR+1, POSICION_Y_JUGADOR);
		
		if(posicionable1.getClass() == Madera.class) {
			Madera m = (Madera) posicionable1;
			int durabilidadMadera = m.getDurabilidad();
			int durabilidadHacha = herramienta.getDurabilidad();
			herramienta.golpear(m);
			assertEquals(durabilidadMadera-FUERZA_HACHA_DE_MADERA, m.getDurabilidad());
			assertEquals (durabilidadHacha-FUERZA_HACHA_DE_MADERA, herramienta.getDurabilidad());
		}
		else if(posicionable2.getClass() == Madera.class) {
			Madera m = (Madera) posicionable2;
			int durabilidad = m.getDurabilidad();
			herramienta.golpear(m);
			assertEquals(durabilidad-FUERZA_HACHA_DE_MADERA, m.getDurabilidad());
		}
		else if(posicionable3.getClass() == Madera.class) {
			Madera m = (Madera) posicionable3;
			int durabilidad = m.getDurabilidad();
			herramienta.golpear(m);
			assertEquals(durabilidad-FUERZA_HACHA_DE_MADERA, m.getDurabilidad());
		}
		else if(posicionable4.getClass() == Madera.class) {
			Madera m = (Madera) posicionable4;
			int durabilidad = m.getDurabilidad();
			herramienta.golpear(m);
			assertEquals(durabilidad-FUERZA_HACHA_DE_MADERA, m.getDurabilidad());
		}
		
	}
	
	@Test
	public void test13JugadorConstruyeHerramienta() {
		
	}
	
	
}
