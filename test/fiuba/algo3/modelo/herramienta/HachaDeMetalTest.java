package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class HachaDeMetalTest {
	
	private static int DURABILIDAD_HACHA_DE_METAL=400;
	private static int FUERZA_HACHA_DE_METAL=10;
	private static int DESGASTE_HACHA_DE_METAL=(FUERZA_HACHA_DE_METAL/2);
	
	@Test 
	public void test01SeCreaHachaDeMetalConDurabilidad400() {
		Herramienta hachaDeMetal = new HachaDeMetal();		
		int durabilidad = hachaDeMetal.getDurabilidad();
		assertEquals(durabilidad, DURABILIDAD_HACHA_DE_METAL);
	};
	
	
	@Test
	public void test02SeCreaHachaDeMetalConFuerza10() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int fuerza = hachaDeMetal.getFuerza();		
		assertEquals (fuerza, FUERZA_HACHA_DE_METAL);
	}
	
	@Test
	public void test03UsarHachaDeMetalUnaVezReduceDurabilidadEn5Unidades() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		hachaDeMetal.desgastar();
		assertEquals (durabilidadInicial-DESGASTE_HACHA_DE_METAL, hachaDeMetal.getDurabilidad());
	}

	
	@Test
	public void test04UsarHachaDeMetal10VecesReduceDurabilidadEn50Unidades() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		
		for (int i=0; i<10; i++) {
			hachaDeMetal.desgastar();
		}
		
		assertEquals (durabilidadInicial-(DESGASTE_HACHA_DE_METAL*10), hachaDeMetal.getDurabilidad());
	}
	
	@Test
	public void test05UsarHachaDeMetalContraMaderaReduceSuDurabilidad() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		Material madera = new Madera();
		hachaDeMetal.golpear(madera);
		assertEquals (hachaDeMetal.getDurabilidad(), durabilidadInicial-DESGASTE_HACHA_DE_METAL);
	}
	
	
	@Test
	public void test06UsarHachaDeMetalContraPiedraNoReduceSuDurabilidad() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		Material piedra = new Piedra();
		hachaDeMetal.golpear(piedra);
		assertEquals (hachaDeMetal.getDurabilidad(), durabilidadInicial);
	}
	
	@Test 
	public void test07UsarHachaDeMetalContraMetalNoReduceSuDurabilidad() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		Material metal = new Metal();
		hachaDeMetal.golpear(metal);
		assertEquals (hachaDeMetal.getDurabilidad(), durabilidadInicial);
	}
	
	@Test
	public void test08UsarHachaDeMetalContraDiamanteNoReduceSuDurabilidad() {
		Herramienta hachaDeMetal = new HachaDeMetal();
		int durabilidadInicial = hachaDeMetal.getDurabilidad();
		Material diamante = new Diamante();
		hachaDeMetal.golpear(diamante);
		assertEquals (hachaDeMetal.getDurabilidad(), durabilidadInicial);
	}


}