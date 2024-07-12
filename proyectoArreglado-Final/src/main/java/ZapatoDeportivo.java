public class ZapatoDeportivo extends Zapato {
	private String tipoDeporte;

	public ZapatoDeportivo(int talla, String material, String marca, int cantidad, int precio, Bodega bodega, String tipoDeporte,String nombre) {
		super(talla, material, marca, cantidad, precio, bodega,nombre);
		this.tipoDeporte = tipoDeporte;
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	@Override
	public String toString() {
		return "ZapatoDeportivo{" +
				super.toString() + '\''+
				"tipoDeporte='" + tipoDeporte + '\'' +
				'}';
	}
}