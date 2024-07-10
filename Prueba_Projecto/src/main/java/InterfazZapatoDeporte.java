import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InterfazZapatoDeporte {
    private JTextField talla;
    private JTextField material;
    private JTextField marca;
    private JButton ingresarButton;
    private JTextField cantidad;
    private JTextField precio;
    private JTextField tipoDeporte;
    private JTextField nombre;

    public InterfazZapatoDeporte(Bodega bodega){
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarZapatoDeporte(bodega);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

    }
    public Zapato ingresarZapatoDeporte(Bodega bodega) throws SQLException {
        int tallaInt = Integer.parseInt(talla.getText());
        String materialStr = material.getText();
        String marcaStr = marca.getText();
        int cantidadInt = Integer.parseInt(cantidad.getText());
        int precioInt = Integer.parseInt(precio.getText());
        String tipoDeporteStr = tipoDeporte.getText();
        String nombreStr = nombre.getText();

        Zapato z = new ZapatoDeportivo(tallaInt, materialStr, marcaStr, cantidadInt, precioInt, bodega,tipoDeporteStr, nombreStr);


        return z;
    }



}
