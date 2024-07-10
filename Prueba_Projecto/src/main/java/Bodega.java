import java.util.List;

public class Bodega {
	private List<Zapato> zapatos;
	private int capacidadMaxima;
	private int capacidadOcupada;
	private int capacidadRestante;

	public Bodega(List<Zapato> zapatos, int capacidadMaxima) {
		this.zapatos = zapatos;
		this.capacidadMaxima = capacidadMaxima;
	}



	public void saberCapacidadRestante() {
		// TODO - implement Bodega.saberCapacidadRestante
		throw new UnsupportedOperationException();
	}

	public List<Zapato> getZapatos() {
		return zapatos;
	}
}