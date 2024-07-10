import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InterfazZapatoTrabajo {
    private JTextField talla;
    private JTextField material;
    private JTextField marca;
    private JTextField cantidad;
    private JTextField precio;
    private JTextField materialSeguridad;
    private JTextField especialidad;
    private JButton ingresarButton;
    private JTextField nombre;
    public InterfazZapatoTrabajo(Bodega bodega){
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarZapatoTrabajo(bodega);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

    }
    public Zapato ingresarZapatoTrabajo(Bodega bodega) throws SQLException {
        int tallaInt = Integer.parseInt(talla.getText());
        String materialStr = material.getText();
        String marcaStr = marca.getText();
        int cantidadInt = Integer.parseInt(cantidad.getText());
        int precioInt = Integer.parseInt(precio.getText());
        String materialSeguridaStr = materialSeguridad.getText();
        String especialidaStr = especialidad.getText();
        String nombreStr = nombre.getText();

        Zapato z = new ZapatoTrabajo(tallaInt, materialStr, marcaStr, cantidadInt, precioInt, bodega,materialSeguridaStr,especialidaStr, nombreStr);


        return z;
    }
}
