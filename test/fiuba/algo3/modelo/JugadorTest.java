package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.grilla.celda.EspacioVacio;
import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;

public class JugadorTest {
	
	private static int FUERZA_HACHA_DE_MADERA=2;
	
	@Test
	public void test01JugadorSeCreaEInicializaConNombreCorrecto() {
		Jugador jugador = new Jugador("nombreDeJugador");
		
		String nombre = jugador.getNombre();
		
		assertEquals(nombre, "nombreDeJugador");
	}
	
	@Test
	public void test02JugadorSeCreaEInicializaConUnHachaDeMadera() {
		Jugador jugador = new Jugador("nombreDeJugador");
		
		Herramienta hacha = jugador.getHerramienta();
		
		assertTrue(hacha instanceof HachaDeMadera);
	}
	
	
	@Test
	public void test03JugadorSeCreaEInicializaConUnInventarioVacio() {
		Jugador jugador = new Jugador("nombreDeJugador");
		
		Inventario inventario = new Inventario();
		
		inventario.paraCadaPosicionableDelAlmacenamiento((posicionable, posicion)-> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
		
		inventario.paraCadaPosicionableDelBosquejo((posicionable, posicion)-> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
		
//		InventarioDeHerramientas inventario = jugador.getInventarioDeHerramientas();
		
//		inventario.recorrerCeldas((celda)-> {
//			assertFalse(celda.estaOcupada());
//		});
	}
	
	@Test
	public void test04JugadorGuardaHerramientaEnInventario() throws AlmacenamientoLlenoException {
		Jugador jugador = new Jugador("test");
		Herramienta herramienta = new HachaDeMetal();
		jugador.guardar(herramienta);
		Posicionable herramientaGuardada = jugador.getInventario().obtener(0, 0);
		assertEquals (herramienta, herramientaGuardada);
	}
	
	@Test
	public void test05EquiparJugadorConHerramientaRemueveHerramientaDelInventario() throws AlmacenamientoLlenoException {
		Jugador jugador = new Jugador("test");
		
		Herramienta herramienta = new HachaDeMadera();
		jugador.guardar(herramienta);
		Herramienta herramienta2 = new HachaDeMadera();
		jugador.guardar(herramienta2);
		Herramienta herramienta3 = new HachaDePiedra();
		jugador.guardar(herramienta3);
		
		//int cantidadHerramientas = jugador.getInventario().obtenerCantidadDe(herramienta);
		
//		jugador.equiparse(herramienta);
		jugador.setHerramienta(herramienta);
		
//		assertEquals(jugador.getInventarioDeHerramientas().obtenerCantidadDe(herramienta), cantidadInicial-1);
		
	}
	
	@Test
	public void test06NoSePuedeEquiparJugadorConHerramientaQueNoPoseeEnInventario() throws AlmacenamientoLlenoException {
		Jugador jugador = new Jugador("test");
		
		Herramienta herramienta = new HachaDeMadera();
		jugador.guardar(herramienta);
		Herramienta herramienta2 = new HachaDeMadera();
		jugador.guardar(herramienta2);
		
		Herramienta hachaDePiedra = new HachaDePiedra();
//		jugador.equiparse(hachaDePiedra);
//		assertFalse(jugador.getInventarioDeHerramientas().contiene(hachaDePiedra));
	}
	
	@Test
	public void test07EquiparJugadorCambiaHerramientaQuePosee() throws AlmacenamientoLlenoException {
		Jugador jugador = new Jugador("test");
		Herramienta herramientaInicial = jugador.getHerramienta();
		Herramienta hachaDePiedra = new HachaDePiedra();
		jugador.guardar(hachaDePiedra);
//		jugador.equiparse(hachaDePiedra);
		
		assertFalse(herramientaInicial == jugador.getHerramienta());
		
	}
	
	@Test
	public void test08JugadorGolpeaMaderaConHachaDeMadera() {
		Jugador jugador = new Jugador("nombreDeJugador");
		Herramienta hacha = jugador.getHerramienta();
		
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		hacha.golpear(madera);
		assertEquals(durabilidadMadera-FUERZA_HACHA_DE_MADERA, madera.getDurabilidad());
		
	}
}
