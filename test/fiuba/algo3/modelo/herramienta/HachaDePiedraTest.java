package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class HachaDePiedraTest {
	
	private static int DURABILIDAD_HACHA_DE_PIEDRA=200;
	private static int FUERZA_HACHA_DE_PIEDRA=5;
	
	@Test 
	public void test01SeCreaHachaDePiedraConDurabilidad200() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidad = hachaDePiedra.getDurabilidad();
		assertEquals(durabilidad, DURABILIDAD_HACHA_DE_PIEDRA);
	};
	
	@Test
	public void test02SeCreaHachaDePiedraConFuerza5() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int fuerza = hachaDePiedra.getFuerza();		
		assertEquals (fuerza, FUERZA_HACHA_DE_PIEDRA);
	};
	
	
	@Test
	public void test03UsarHachaDePiedraUnaVezReduceDurabilidadEn5Unidades() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		hachaDePiedra.desgastar();
		assertEquals (durabilidadInicial-FUERZA_HACHA_DE_PIEDRA, hachaDePiedra.getDurabilidad());
	};
	
	
	@Test
	public void test04UsarHachaDePiedra10VecesReduceDurabilidadEn50Unidades() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		
		for (int i=0; i<10; i++) {
			hachaDePiedra.desgastar();
		}
			
		assertEquals (durabilidadInicial-(FUERZA_HACHA_DE_PIEDRA*10), hachaDePiedra.getDurabilidad());
	}
	
	@Test
	public void test05UsarHachaDePiedraContraMaderaReduceSuDurabilidad(){
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		Material madera = new Madera();
		hachaDePiedra.golpear(madera);
		assertEquals (hachaDePiedra.getDurabilidad(), durabilidadInicial-FUERZA_HACHA_DE_PIEDRA);
	}
	
	@Test
	public void test06UsarHachaDePiedraContraPiedraNoReduceSuDurabilidad() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		Material piedra = new Piedra();
		hachaDePiedra.golpear(piedra);
		assertEquals (hachaDePiedra.getDurabilidad(), durabilidadInicial);
	}
	
	@Test 
	public void test07UsarHachaDePiedraContraMetalNoReduceSuDurabilidad() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		Material metal = new Metal();
		hachaDePiedra.golpear(metal);
		assertEquals (hachaDePiedra.getDurabilidad(), durabilidadInicial);
	}
	
	@Test
	public void test08UsarHachaDePiedraContraDiamanteNoReduceSuDurabilidad() {
		Herramienta hachaDePiedra = new HachaDePiedra();
		int durabilidadInicial = hachaDePiedra.getDurabilidad();
		Material diamante = new Diamante();
		hachaDePiedra.golpear(diamante);
		assertEquals (hachaDePiedra.getDurabilidad(), durabilidadInicial);
	}


}
