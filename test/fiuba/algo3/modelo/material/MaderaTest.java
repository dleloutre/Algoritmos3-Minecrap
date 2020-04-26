package fiuba.algo3.modelo.material;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.herramienta.PicoDeMadera;
import fiuba.algo3.modelo.herramienta.PicoDeMetal;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;

public class MaderaTest {
	
	private static int DURABILIDAD_MADERA=10;
	private static int FUERZA_HACHA_DE_MADERA=2;
	private static int FUERZA_HACHA_DE_PIEDRA=5;
	private static int FUERZA_HACHA_DE_METAL=10;
	
	@Test
	public void test01SeCreaMaderaConDurabilidad10() {
		
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		assertEquals(durabilidadMadera, DURABILIDAD_MADERA);	
	}
	
	@Test
	public void test02MaderaSeGolpeaConHachaDeMaderaYDurabilidadSeReduce2() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta hacha = new HachaDeMadera();
		
		hacha.golpear(madera);
		assertEquals(durabilidadMadera-FUERZA_HACHA_DE_MADERA, madera.getDurabilidad());
	}
	
	@Test
	public void test03MaderaSeGolpeaConHachaDePiedraYDurabilidadSeReduce5() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta hacha = new HachaDePiedra();
		
		hacha.golpear(madera);
		assertEquals(durabilidadMadera-FUERZA_HACHA_DE_PIEDRA, madera.getDurabilidad());
	}
	
	
	@Test
	public void test04MaderaSeGolpeaConHachaDeMetalYDurabilidadSeReduce10() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta hacha = new HachaDeMetal();
		
		hacha.golpear(madera);
		assertEquals(durabilidadMadera-FUERZA_HACHA_DE_METAL, madera.getDurabilidad());	
	}
	
	@Test
	public void test05MaderaSeGolpeaConPicoDeMaderaYDurabilidadNoSeReduce() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta pico = new PicoDeMadera();
		
		pico.golpear(madera);
		assertEquals(durabilidadMadera, madera.getDurabilidad());
	}
	
	@Test
	public void test06MaderaSeGolpeaConPicoDePiedraYDurabilidadNoSeReduce() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta pico = new PicoDePiedra();
		
		pico.golpear(madera);
		assertEquals(durabilidadMadera, madera.getDurabilidad());
	}
	
	@Test
	public void test07MaderaSeGolpeaConPicoDeMetalYDurabilidadNoSeReduce() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta pico = new PicoDeMetal();
		
		pico.golpear(madera);
		assertEquals(durabilidadMadera, madera.getDurabilidad());
	}
	
	@Test
	public void test08MaderaSeGolpeaConPicoFinoYDurabilidadNoSeReduce() {
		Material madera = new Madera();
		int durabilidadMadera = madera.getDurabilidad();
		
		Herramienta pico = new PicoFinoDeMetalYPiedra();
		
		pico.golpear(madera);
		assertEquals(durabilidadMadera, madera.getDurabilidad());
	}

	@Test 
	public void test09MaderaSeGolpeaConHachaDeMadera5VecesYSeRompe(){
		Material madera = new Madera();		
		Herramienta hacha = new HachaDeMadera();
		for(int i=0;i<5;i++)
			hacha.golpear(madera);
		
		assertTrue(madera.estaRoto());
	}
	
	@Test 
	public void test10MaderaSeGolpeaConHachaDePiedra2VecesYSeRompe(){
		Material madera = new Madera();		
		Herramienta hacha = new HachaDePiedra();		
		hacha.golpear(madera);
		hacha.golpear(madera);
		
		assertTrue(madera.estaRoto());
	}
	
	@Test 
	public void test11MaderaSeGolpeaConHachaDeMetal1VezYSeRompe(){
		Material madera = new Madera();		
		Herramienta hacha = new HachaDeMetal();		
		hacha.golpear(madera);
		
		assertTrue(madera.estaRoto());
	}
	
	@Test
	public void test12MaderaSeGolpeaConHachaDeMadera4VecesYSeReduceDurabilidadEn8(){
		Material madera = new Madera();	
		int durabilidadInicial = madera.getDurabilidad();
		Herramienta hacha = new HachaDeMadera();	
		for (int i=0; i<4; i++)
			hacha.golpear(madera);
		
		assertEquals(madera.getDurabilidad(), durabilidadInicial - (4*FUERZA_HACHA_DE_MADERA));
	}
	
	@Test 
	public void test13MaderaSeGolpeaConHachaDeMadera4VecesYNoSeRompe(){
		Material madera = new Madera();		
		Herramienta hacha = new HachaDeMadera();
		for(int i=0;i<4;i++)
			hacha.golpear(madera);
		
		assertFalse(madera.estaRoto());
	}
	
	@Test 
	public void test14MaderaSeGolpeaConHachaDePiedra1VeaYNoSeRompe(){
		Material madera = new Madera();		
		Herramienta hacha = new HachaDePiedra();		
		hacha.golpear(madera);
		
		assertFalse(madera.estaRoto());
	}
	
}
