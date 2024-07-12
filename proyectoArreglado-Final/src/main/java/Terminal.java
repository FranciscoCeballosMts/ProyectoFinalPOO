

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Terminal {
	private Bodega bodega;

	public Bodega getBodega() {
		return bodega;
	}

	public Terminal(Bodega bodega) {
		this.bodega = bodega;
	}

	public void verInventario() {
		bodega.getZapatos().stream()
				.forEach(System.out::println);
	}

	public List<Zapato> ordenarPorTalla() {
		return bodega.getZapatos().stream()
				.sorted((z1,z2)->Integer.compare(z1.getTalla(), z2.getTalla()))
				.collect(Collectors.toList());
	}

	public List<Zapato> ordenarPorMarca() {
		return bodega.getZapatos().stream()
				.sorted((z1,z2)->z1.getMarca().compareTo(z2.getMarca()))
				.collect(Collectors.toList());
	}

	public List<Zapato> ordenarPorMaterial() {
		return bodega.getZapatos().stream()
				.sorted((z1,z2)->z1.getMaterial().compareTo(z2.getMaterial()))
				.collect(Collectors.toList());
	}

	public void agregarZapato(Zapato ... zapatos) {
		for (Zapato zapato:zapatos){
			bodega.getZapatos().add(zapato);
		}
	}

	public List<Zapato> ordenarPorCantidad() {
		return bodega.getZapatos().stream()
				.sorted((z1,z2)->Integer.compare(z1.getCantidad(), z2.getCantidad()))
				.collect(Collectors.toList());

	}
	public List<Zapato> ordenarPorPrecio() {
		return bodega.getZapatos().stream()
				.sorted((z1,z2)->Integer.compare(z1.getPrecio(), z2.getPrecio()))
				.collect(Collectors.toList());
	}

}