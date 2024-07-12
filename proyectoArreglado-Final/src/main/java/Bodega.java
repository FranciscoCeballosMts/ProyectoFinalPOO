import java.util.List;

public class Bodega {
	private List<Zapato> zapatos;
	private int capacidadMaxima;
	private int capacidadOcupada;
	private int capacidadRestante;

	public Bodega(List<Zapato> zapatos, int capacidadMaxima) {
		this.zapatos = zapatos;
		this.capacidadMaxima = capacidadMaxima;
		int cont=0;
		for (Zapato zapato:zapatos){
			cont+=zapato.getCantidad();
		}
		capacidadOcupada=cont;
		capacidadRestante=capacidadMaxima-capacidadOcupada;
	}

	public Bodega() {
	}

	public int saberCapacidadRestante() {
		return capacidadRestante;
	}
	public int saberCapacidadOcupada(){
		return capacidadOcupada;
	}

	public List<Zapato> getZapatos() {
		return zapatos;
	}
}