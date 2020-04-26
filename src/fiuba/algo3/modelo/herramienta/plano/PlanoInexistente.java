package fiuba.algo3.modelo.herramienta.plano;

public class PlanoInexistente extends PlanoDeHerramienta {
	
	@Override
	public boolean equals(Object otroPlano) {
		return otroPlano instanceof PlanoDeHerramienta;
	}
}
