import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class InterfazZapatoDeporte extends JDialog {
    private JTextField talla;
    private JTextField material;
    private JTextField marca;
    private JButton ingresarButton;
    private JTextField cantidad;
    private JTextField precio;
    private JTextField tipoDeporte;
    private JTextField nombre;
    private JPanel contentPanel;

    public InterfazZapatoDeporte() {
        setContentPane(contentPanel);
        setModal(true);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarZapatoDeporte();
                } catch (IOException | SQLException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    FirebaseConnection.close();
                }
            }
        });
    }

    public void ingresarZapatoDeporte() throws SQLException, IOException {
        Firestore db = FirebaseConnection.getFirestore();

        try {
            // Supongamos que obtienes estos valores de algún lugar, como una interfaz gráfica.
            int tallaInt = Integer.parseInt(talla.getText());
            String materialStr = material.getText();
            String marcaStr = marca.getText();
            int cantidadInt = Integer.parseInt(cantidad.getText());
            int precioInt = Integer.parseInt(precio.getText());
            String deporteStr = tipoDeporte.getText();
            String nombreStr = nombre.getText();

            Zapato zapato = new ZapatoDeportivo(tallaInt, materialStr, marcaStr, cantidadInt, precioInt, null, deporteStr, nombreStr);

            DocumentReference docRef = db.collection("Zapatos de deporte").document(zapato.getNombre());

            Map<String, Object> data = new HashMap<>();
            data.put("nombre", zapato.getNombre());
            data.put("talla", zapato.getTalla());
            data.put("material", zapato.getMaterial());
            data.put("marca", zapato.getMarca());
            data.put("cantidad", zapato.getCantidad());
            data.put("precio", zapato.getPrecio());
            data.put("tipo de deporte", ((ZapatoDeportivo) zapato).getTipoDeporte());

            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time : " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InterfazZapatoDeporte dialog = new InterfazZapatoDeporte();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
