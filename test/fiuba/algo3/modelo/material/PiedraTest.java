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

public class PiedraTest {
	
	private static int DURABILIDAD_PIEDRA=30;
	private static int FUERZA_PICO_DE_MADERA=2;
	private static int FUERZA_PICO_DE_PIEDRA=4;
	private static int FUERZA_PICO_DE_METAL=12;

	@Test
	public void test01SeCreaPiedraConDurabilidad30() {
		
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		assertEquals(durabilidadPiedra, DURABILIDAD_PIEDRA);	
	}
	
	@Test
	public void test02PiedraSeGolpeaConUnHachaDeMaderaYDurabilidadNoSeReduce() {
	
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta hacha = new HachaDeMadera();
		hacha.golpear(piedra);
		
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
	}
	
	@Test
	public void test03PiedraSeGolpeaConUnHachaDePiedraYDurabilidadNoSeReduce() {
	
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta hacha = new HachaDePiedra();
		hacha.golpear(piedra);
		
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
	}
	
	@Test
	public void test04PiedraSeGolpeaConUnHachaDeMetalYDurabilidadNoSeReduce() {
	
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta hacha = new HachaDeMetal();
		hacha.golpear(piedra);
		
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
	}
	
	@Test
	public void test05PiedraSeGolpeaConPicoDeMaderaYDurabilidadSeReduce2() {
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta pico = new PicoDeMadera();
		
		pico.golpear(piedra);
		assertEquals(durabilidadPiedra-FUERZA_PICO_DE_MADERA, piedra.getDurabilidad());
	}
	
	@Test
	public void test06PiedraSeGolpeaConPicoDePiedraYDurabilidadSeReduce4() {
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta pico = new PicoDePiedra();
		
		pico.golpear(piedra);
		assertEquals(durabilidadPiedra-FUERZA_PICO_DE_PIEDRA, piedra.getDurabilidad());
	}
	
	@Test
	public void test07PiedraSeGolpeaConPicoDeMetalYDurabilidadSeReduce12() {
		Material piedra = new Piedra();
		int durabilidadPiedra = piedra.getDurabilidad();
		
		Herramienta pico = new PicoDeMetal();
		
		pico.golpear(piedra);
		assertEquals(durabilidadPiedra-FUERZA_PICO_DE_METAL, piedra.getDurabilidad());
	}

	@Test
	public void test08PiedraSeGolpeaConPicoDeMadera15VecesYSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMadera();
		for (int i=0;i<15;i++)
			pico.golpear(piedra);
		assertTrue(piedra.estaRoto());
	}
	
	@Test
	public void test09PiedraSeGolpeaConPicoDePiedra8VecesYSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		for (int i=0;i<8;i++)
			pico.golpear(piedra);
		assertTrue(piedra.estaRoto());
	}
	
	@Test
	public void test10PiedraSeGolpeaConPicoDeMetal3VecesYSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMetal();
		for (int i=0;i<3;i++)
			pico.golpear(piedra);
		assertTrue(piedra.estaRoto());
	}
	
	@Test
	public void test11PiedraSeGolpeaConPicoFinoYSuDurabilidadNoSeReduce(){
		Material piedra = new Piedra();
		int durabilidadInicial = piedra.getDurabilidad();
		Herramienta pico = new PicoFinoDeMetalYPiedra();
		pico.golpear(piedra);
		assertEquals(piedra.getDurabilidad(),durabilidadInicial);
	}
	
	@Test
	public void test12PiedraSeGolpeaConPicoDeMadera14VecesYNoSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMadera();
		for (int i=0;i<14;i++)
			pico.golpear(piedra);
		assertFalse(piedra.estaRoto());
	}
	
	@Test
	public void test13PiedraSeGolpeaConPicoDePiedra7VecesYNoSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		for (int i=0;i<7;i++)
			pico.golpear(piedra);
		assertFalse(piedra.estaRoto());
	}
	
	@Test
	public void test14PiedraSeGolpeaConPicoDeMetal2VecesYNoSeRompe(){
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMetal();
		for (int i=0;i<2;i++)
			pico.golpear(piedra);
		assertFalse(piedra.estaRoto());
	}
	
	
	
}