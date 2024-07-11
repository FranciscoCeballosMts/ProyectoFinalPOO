import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InterfazZapatilla {
    private JTextField talla;
    private JTextField material;
    private JTextField marca;
    private JTextField cantidad;
    private JTextField precio;
    private JButton ingresarButton;
    private JTextField estilo;
    private JTextField nombre;
    public InterfazZapatilla(Bodega bodega){
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarZapatilla(bodega);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

    }
    public Zapato ingresarZapatilla(Bodega bodega) throws SQLException {
        int tallaInt = Integer.parseInt(talla.getText());
        String materialStr = material.getText();
        String marcaStr = marca.getText();
        int cantidadInt = Integer.parseInt(cantidad.getText());
        int precioInt = Integer.parseInt(precio.getText());
        String estiloStr = estilo.getText();
        String nombreStr = nombre.getText();

        Zapato z = new Zapatilla(tallaInt, materialStr, marcaStr, cantidadInt, precioInt, bodega, estiloStr, nombreStr);


        return z;
    }
}
