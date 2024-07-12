public class ZapatoTrabajo extends Zapato {

	private String seguridadMaterial;
	private String especialidadSeguridad;

	public ZapatoTrabajo(int talla, String material, String marca, int cantidad, int precio, Bodega bodega, String seguridadMaterial, String especialidadSeguridad,String nombre) {
		super(talla, material, marca, cantidad, precio, bodega,nombre);
		this.seguridadMaterial = seguridadMaterial;
		this.especialidadSeguridad = especialidadSeguridad;
	}

	public String getEspecialidadSeguridad() {
		return especialidadSeguridad;
	}

	public String getSeguridadMaterial() {
		return seguridadMaterial;
	}

	@Override
	public String toString() {
		return "ZapatoTrabajo{" +
				super.toString() + '\''+
				"seguridadMaterial='" + seguridadMaterial + '\'' +
				", especialidadSeguridad='" + especialidadSeguridad + '\'' +
				'}';
	}
}