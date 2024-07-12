import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BodegaTest {
    private Bodega bodega=new Bodega();
    @BeforeEach
    void setUp() {
        List<Zapato> zapatos=new ArrayList<>();
        Bodega bodega=new Bodega(zapatos,10);
        Zapato z1=new Zapatilla(42,"goma","nike",9,50000,bodega,"casual","vapormax");
        bodega.getZapatos().add(z1);
    }

    @Test
    void saberCapacidadRestante() {
        assertEquals(1,bodega.saberCapacidadRestante());
    }
    @Test
    void saberCapacidadOcupada() {
        assertEquals(9,bodega.saberCapacidadOcupada());
    }

}