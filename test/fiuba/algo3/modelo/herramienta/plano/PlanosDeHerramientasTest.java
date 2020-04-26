package fiuba.algo3.modelo.herramienta.plano;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.grilla.celda.EspacioVacio;
import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.PicoDeMadera;
import fiuba.algo3.modelo.herramienta.PicoDeMetal;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PlanosDeHerramientasTest {
	@Test
	public void test01HachaDeMaderaPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = HachaDeMadera.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Madera(), 0, 0);
		grilla.posicionar(new Madera(), 0, 1);
		grilla.posicionar(new Madera(), 1, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test02HachaDePiedraPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = HachaDePiedra.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Piedra(), 0, 0);
		grilla.posicionar(new Piedra(), 0, 1);
		grilla.posicionar(new Piedra(), 1, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test03HachaDeMetalPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = HachaDeMetal.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Metal(), 0, 0);
		grilla.posicionar(new Metal(), 0, 1);
		grilla.posicionar(new Metal(), 1, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test04PicoDeMaderaPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = PicoDeMadera.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Madera(), 0, 0);
		grilla.posicionar(new Madera(), 1, 0);
		grilla.posicionar(new Madera(), 2, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test05PicoDePiedraPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = PicoDePiedra.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Piedra(), 0, 0);
		grilla.posicionar(new Piedra(), 1, 0);
		grilla.posicionar(new Piedra(), 2, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test06PicoDeMetalPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = PicoDeMetal.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Metal(), 0, 0);
		grilla.posicionar(new Metal(), 1, 0);
		grilla.posicionar(new Metal(), 2, 0);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test07PicoFinoDeMetalYPiedraPoseePlanoConItemsCorrectos() {
		PlanoDeHerramienta plano = PicoFinoDeMetalYPiedra.plano();
		
		GrillaDeMateriales grilla = new GrillaDeMateriales();
		
		grilla.posicionar(new Metal(), 0, 0);
		grilla.posicionar(new Metal(), 1, 0);
		grilla.posicionar(new Metal(), 2, 0);
		grilla.posicionar(new Piedra(), 0, 1);
		grilla.posicionar(new Madera(), 1, 1);
		grilla.posicionar(new Madera(), 1, 2);
		
		assertTrue(plano.igualGrilla(grilla));
	}
	
	@Test
	public void test08PlanoDeHachaDeMaderaFabricaUnHachaDeMadera() throws Exception {
		PlanoDeHerramienta plano = HachaDeMadera.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof HachaDeMadera);
	}
	
	@Test
	public void test09PlanoDeHachaDePiedraFabricaUnHachaDePiedra() throws Exception {
		PlanoDeHerramienta plano = HachaDePiedra.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof HachaDePiedra);
	}
	
	@Test
	public void test10PlanoDeHachaDeMetalFabricaUnHachaDeMetal() throws Exception {
		PlanoDeHerramienta plano = HachaDeMetal.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof HachaDeMetal);
	}
	
	@Test
	public void test11PlanoDePicoDeMaderaFabricaUnPicoDeMadera() throws Exception {
		PlanoDeHerramienta plano = PicoDeMadera.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof PicoDeMadera);
	}
	
	@Test
	public void test12PlanoDePicoDePiedraFabricaUnPicoDePiedra() throws Exception {
		PlanoDeHerramienta plano = PicoDePiedra.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof PicoDePiedra);
	}
	
	@Test
	public void test13PlanoDePicoDeMetalFabricaUnPicoDeMetal() throws Exception {
		PlanoDeHerramienta plano = PicoDeMetal.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof PicoDeMetal);
	}
	
	@Test
	public void test14PlanoDePicoFinoDeMetalYPiedraFabricaUnPicoFinoDeMetalYPiedra() throws Exception {
		PlanoDeHerramienta plano = PicoFinoDeMetalYPiedra.plano();
		
		assertTrue(plano.fabricarHerramienta() instanceof PicoFinoDeMetalYPiedra);
	}
	
	@Test
	public void test15BosquejoDeHerramientaSeVaciaCorrectamente() throws Exception {
		BosquejoDeHerramienta bosquejoDeHerramienta = new BosquejoDeHerramienta();
		bosquejoDeHerramienta.posicionar(new Madera(), 1, 1);
		
		bosquejoDeHerramienta.vaciar();
		
		bosquejoDeHerramienta.paraCadaPosicionable((posicionable, posicion) -> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
	}

	@Test
	public void test16BosquejoDeHerramientaRemueveItemsCorrectamente() throws Exception {
		BosquejoDeHerramienta bosquejoDeHerramienta = new BosquejoDeHerramienta();
		bosquejoDeHerramienta.posicionar(new Madera(), 1, 1);
		
		bosquejoDeHerramienta.remover(1, 1);

		bosquejoDeHerramienta.paraCadaPosicionable((posicionable, posicion) -> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
	}
	
}
