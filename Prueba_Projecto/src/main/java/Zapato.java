public abstract class  Zapato {

	private int talla;
	private String material;
	private String marca;
	private int cantidad;
	private int precio;
	private Bodega bodega;
	private String nombre;

	public Zapato(int talla, String material, String marca, int cantidad, int precio, Bodega bodega,String nombre) {
		this.talla = talla;
		this.material = material;
		this.marca = marca;
		this.cantidad = cantidad;
		this.precio = precio;
		this.bodega = bodega;
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTalla() {
		return talla;
	}

	public String getMaterial() {
		return material;
	}

	public String getMarca() {
		return marca;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return
				"talla=" + talla +
				", material='" + material + '\'' +
				", marca='" + marca + '\'' +
				", cantidad=" + cantidad +
				", precio=" + precio +
				", nombre='" + nombre + '\'';
	}
}