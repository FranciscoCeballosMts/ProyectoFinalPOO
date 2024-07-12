public class Zapatilla extends Zapato {

	private String estilo;

	public Zapatilla(int talla, String material, String marca, int cantidad, int precio, Bodega bodega, String estilo,String nombre) {
		super(talla, material, marca, cantidad, precio, bodega,nombre);
		this.estilo = estilo;
	}

	public String getEstilo() {
		return estilo;
	}

	@Override
	public String toString() {
		return "Zapatilla{" +
				super.toString() + '\''+
				"estilo='" + estilo + '\'' +
				'}';
	}
}
