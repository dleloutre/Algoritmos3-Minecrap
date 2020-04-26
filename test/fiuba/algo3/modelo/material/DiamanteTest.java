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

public class DiamanteTest {
	
	private static int DURABILIDAD_DIAMANTE=100;
	private static int FUERZA_PICO_FINO_DE_METAL_Y_PIEDRA=20;
	
	@Test
	public void test01SeCreaDiamanteConDurabilidad100() {
		
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		assertEquals(durabilidadDiamante, DURABILIDAD_DIAMANTE);	
	}
	
	@Test
	public void test02SeGolpeaDiamanteConPicoFinoYDurabilidadSeReduce() {
		Material diamante = new Diamante();
		
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		
		int durabilidadDiamante = diamante.getDurabilidad();
		
		picoFino.golpear(diamante);
		
		assertEquals(durabilidadDiamante-FUERZA_PICO_FINO_DE_METAL_Y_PIEDRA, diamante.getDurabilidad());	
	}
	
	@Test
	public void test03DiamanteSeGolpeaConPicoDeMaderaYDurabilidadNoSeReduce() {
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta picoDeMadera = new PicoDeMadera();
		
		picoDeMadera.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test04DiamanteSeGolpeaConPicoDePiedraYDurabilidadNoSeReduce() {
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta picoDePiedra = new PicoDePiedra();
		
		picoDePiedra.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test05DiamanteSeGolpeaConPicoDeMetalYDurabilidadNoSeReduce() {
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta picoDeMetal = new PicoDeMetal();
		
		picoDeMetal.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test06DiamanteSeGolpeaConUnHachaDeMaderaYDurabilidadNoSeReduce() {
	
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta hacha = new HachaDeMadera();
		hacha.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test07DiamanteSeGolpeaConUnHachaDePiedraYDurabilidadNoSeReduce() {
	
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta hacha = new HachaDePiedra();
		hacha.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test08DiamanteSeGolpeaConUnHachaDeMetalYDurabilidadNoSeReduce() {
	
		Material diamante = new Diamante();
		int durabilidadDiamante = diamante.getDurabilidad();
		
		Herramienta hacha = new HachaDeMetal();
		hacha.golpear(diamante);
		
		assertEquals(durabilidadDiamante, diamante.getDurabilidad());
	}
	
	@Test
	public void test09DiamanteSeGolpeaConPicoFino5VecesYSeRompe(){
		Material diamante = new Diamante();
		Herramienta pico = new PicoFinoDeMetalYPiedra();
		for (int i=0; i<5; i++)
			pico.golpear(diamante);
		assertTrue(diamante.estaRoto());
	}
	
	@Test
	public void test09DiamanteSeGolpeaConPicoFino4VecesYNoSeRompe(){
		Material diamante = new Diamante();
		Herramienta pico = new PicoFinoDeMetalYPiedra();
		for (int i=0; i<4; i++)
			pico.golpear(diamante);
		assertFalse(diamante.estaRoto());
	}

}
