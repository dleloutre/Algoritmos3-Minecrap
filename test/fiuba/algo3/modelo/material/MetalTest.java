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

public class MetalTest {
	
	private static int DURABILIDAD_METAL=50;
	private static int FUERZA_PICO_DE_PIEDRA=4;
	
	@Test
	public void test01SeCreaMetalConDurabilidad50() {
		
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		assertEquals(durabilidadMetal, DURABILIDAD_METAL);	
	}
	
	@Test
	public void test02MetalSeGolpeaConPicoDeMaderaYDurabilidadNoSeReduce() {
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta picoDeMadera = new PicoDeMadera();
		
		picoDeMadera.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	@Test
	public void test03MetalSeGolpeaConPicoDePiedraYDurabilidadSeReduce4() {
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta picoDePiedra = new PicoDePiedra();
		
		picoDePiedra.golpear(metal);
		
		assertEquals(durabilidadMetal-FUERZA_PICO_DE_PIEDRA, metal.getDurabilidad());
	}
	
	@Test
	public void test04MetalSeGolpeaConPicoDeMetalYDurabilidadNoSeReduce() {
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta picoDeMetal = new PicoDeMetal();
		
		picoDeMetal.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	@Test
	public void test05MetalSeGolpeaConPicoFinoYDurabilidadNoSeReduce() {
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		
		picoFino.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	
	@Test
	public void test06MetalSeGolpeaConUnHachaDeMaderaYDurabilidadNoSeReduce() {
	
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta hacha = new HachaDeMadera();
		hacha.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	@Test
	public void test07MetalSeGolpeaConUnHachaDePiedraYDurabilidadNoSeReduce() {
	
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta hacha = new HachaDePiedra();
		hacha.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	@Test
	public void test08MetalSeGolpeaConUnHachaDeMetalYDurabilidadNoSeReduce() {
		Material metal = new Metal();
		int durabilidadMetal = metal.getDurabilidad();
		
		Herramienta hacha = new HachaDeMetal();
		hacha.golpear(metal);
		
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
	
	@Test
	public void test09MetalSeGolpeaConPicoDePiedra13VecesYSeRompe(){
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		for (int i=0; i<13; i++)
			pico.golpear(metal);
		assertTrue(metal.estaRoto());
	}
	
	@Test
	public void test10MetalSeGolpeaConPicoDePiedra12VecesYNoSeRompe(){
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		for (int i=0; i<12; i++)
			pico.golpear(metal);
		assertFalse(metal.estaRoto());
	}

}
