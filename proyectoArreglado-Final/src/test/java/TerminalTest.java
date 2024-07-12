import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TerminalTest {

    private Bodega bodega;
    private Zapato zapato1;
    private Zapato zapato2;
    private Zapato zapato3;
    private Terminal terminal;

    @BeforeEach
    void setUp() {
        List<Zapato> zapatoes=new ArrayList<>();
        zapato1 = new Zapatilla(42, "malla", "Gato", 10, 98780,bodega,"casual","Procasual");
        zapato2 = new ZapatoTrabajo(40, "Cuero", "MAX", 15, 53000,bodega,"Metal","anticlavos","Maxsegurity");
        zapato3 = new ZapatoDeportivo(41, "tela", "LIKE", 5, 49990,bodega,"Fultball","Notlimit");
        bodega=new Bodega(zapatoes,100);
        terminal = new Terminal(bodega);
        terminal.agregarZapato(zapato1,zapato2,zapato3);
    }



    @Test
    void testOrdenarPorTalla() {
        List<Zapato> ordenados = terminal.ordenarPorTalla();
        assertEquals(zapato2, ordenados.get(0));
        assertEquals(zapato3, ordenados.get(1));
        assertEquals(zapato1, ordenados.get(2));
    }

    @Test
    void testOrdenarPorMarca() {
        List<Zapato> ordenados = terminal.ordenarPorMarca();
        assertEquals(zapato2, ordenados.get(0));
        assertEquals(zapato1, ordenados.get(1));
        assertEquals(zapato3, ordenados.get(2));
    }

    @Test
    void testOrdenarPorMaterial() {
        List<Zapato> ordenados = terminal.ordenarPorMaterial();
        assertEquals(zapato1, ordenados.get(0));
        assertEquals(zapato3, ordenados.get(1));
        assertEquals(zapato2, ordenados.get(2));
    }

    @Test
    void testOrdenarPorCantidad() {
        List<Zapato> ordenados = terminal.ordenarPorCantidad();
        assertEquals(zapato3, ordenados.get(0));
        assertEquals(zapato1, ordenados.get(1));
        assertEquals(zapato2, ordenados.get(2));
    }

    @Test
    void testOrdenarPorPrecio() {
        List<Zapato> ordenados = terminal.ordenarPorPrecio();
        assertEquals(zapato2, ordenados.get(0));
        assertEquals(zapato3, ordenados.get(1));
        assertEquals(zapato1, ordenados.get(2));
    }

    @Test
    void testAgregarZapato() {
        Zapato zapato4 = new Zapatilla(39, "Sintético", "Blackday", 8, 70,bodega,"salida","Finality");
        terminal.agregarZapato(zapato4);
        assertTrue(bodega.getZapatos().contains(zapato4));
    }

    @Test
    void testVerInventario() {
        assertDoesNotThrow(() -> terminal.verInventario());
    }

}