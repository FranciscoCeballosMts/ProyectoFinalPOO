import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MostrarZapatos extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public MostrarZapatos() {
        setTitle("Mostrar Zapatos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tipo");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Talla");
        tableModel.addColumn("Material");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Estilo/Seguridad/Deporte");

        // Crear la tabla
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Leer los datos de la base de datos y mostrarlos en la tabla
        try {
            cargarDatos();
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cargarDatos() throws IOException, ExecutionException, InterruptedException {
        Firestore db = FirebaseConnection.getFirestore();

        cargarZapatillas(db);
        cargarZapatosTrabajo(db);
        cargarZapatosDeporte(db);

        FirebaseConnection.close();
    }

    private void cargarZapatillas(Firestore db) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Zapatillas").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            String nombre = document.getString("nombre");
            long talla = document.getLong("talla");
            String material = document.getString("material");
            String marca = document.getString("marca");
            long cantidad = document.getLong("cantidad");
            long precio = document.getLong("precio");
            String estilo = document.getString("estilo");

            // Agregar los datos a la tabla
            tableModel.addRow(new Object[]{"Zapatilla", nombre, talla, material, marca, cantidad, precio, estilo});
        }
    }

    private void cargarZapatosTrabajo(Firestore db) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Zapatos de Trabajo").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            String nombre = document.getString("nombre");
            long talla = document.getLong("talla");
            String material = document.getString("material");
            String marca = document.getString("marca");
            long cantidad = document.getLong("cantidad");
            long precio = document.getLong("precio");
            String seguridadMaterial = document.getString("material de seguridad");
            String especialidadSeguridad = document.getString("especialidad de seguridad");

            // Agregar los datos a la tabla
            tableModel.addRow(new Object[]{"Zapato de Trabajo", nombre, talla, material, marca, cantidad, precio, seguridadMaterial + " / " + especialidadSeguridad});
        }
    }

    private void cargarZapatosDeporte(Firestore db) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Zapatos de deporte").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            String nombre = document.getString("nombre");
            long talla = document.getLong("talla");
            String material = document.getString("material");
            String marca = document.getString("marca");
            long cantidad = document.getLong("cantidad");
            long precio = document.getLong("precio");
            String deporte = document.getString("deporte");

            // Agregar los datos a la tabla
            tableModel.addRow(new Object[]{"Zapato de Deporte", nombre, talla, material, marca, cantidad, precio, deporte});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MostrarZapatos frame = new MostrarZapatos();
            frame.setVisible(true);
        });
    }
}

