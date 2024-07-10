import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args)throws IOException, ExecutionException, InterruptedException {

        //iniciar clases
        List<Zapato> zapatos=new ArrayList<>();
        Bodega bodega=new Bodega(zapatos,40);
        Terminal terminal=new Terminal(bodega);

        JFrame frame = new JFrame(); //Es para interactuar cómo en una ventana de Windons
        VentanaPrincipal Ventana = new VentanaPrincipal(bodega); //Se esta creando el objeto una Ventana para poder tener muchas más ventanas
        frame.setContentPane(Ventana.getVentanaPrincipal());//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Es para cuando uno oprime la X de la ventana el programa para
        frame.setSize(300,300); //Es para determinar el tamaño de la ventana
        frame.setVisible(true);//Es para que se nosotros lo podamos ver cuando le damos oprimimos Run

        //inicar base de datos
        InputStream serviceAccount = new FileInputStream("src/main/resources/zapateriabasededatos-firebase-adminsdk-odyen-dd419eb68f.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        String projectId="zapateriabasededatos";
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId(projectId)
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();




        Zapato z1=new Zapatilla(42,"goma","nike",10,50000,bodega,"casual","vapormax");
        Zapato z2=new ZapatoTrabajo(45,"cuero","maxService",5,15000,bodega,"plastico endurecido","zapato de seguridad","VFlex");
        Zapato z3=new ZapatoDeportivo(38,"goma","adidas",4,35000,bodega,"futbol","predator");

        //terminal.agregarZapato(z1,z2,z3); no agregar, ya estan en la base de datos


        //hacer con interfaz, crear zapato


        //guardar en base de datos

        for (Zapato zapato:terminal.getBodega().getZapatos()){
            if (zapato instanceof ZapatoTrabajo){

                DocumentReference docRef = db.collection("Zapatos de Trabajo").document(zapato.getNombre());

                Map<String, Object> data = new HashMap<>();
                data.put("nombre", zapato.getNombre());
                data.put("talla", zapato.getTalla());
                data.put("material", zapato.getMaterial());
                data.put("marca", zapato.getMarca());
                data.put("cantidad", zapato.getCantidad());
                data.put("precio", zapato.getPrecio());
                data.put("material de seguridad",((ZapatoTrabajo) zapato).getSeguridadMaterial());
                data.put("especialidad de seguridad", ((ZapatoTrabajo) zapato).getEspecialidadSeguridad());

                ApiFuture<WriteResult> result = docRef.set(data);

                System.out.println("Update time : " + result.get().getUpdateTime());

            } else if (zapato instanceof Zapatilla) {

                DocumentReference docRef = db.collection("Zapatillas").document(zapato.getNombre());

                Map<String, Object> data = new HashMap<>();
                data.put("nombre", zapato.getNombre());
                data.put("talla", zapato.getTalla());
                data.put("material", zapato.getMaterial());
                data.put("marca", zapato.getMarca());
                data.put("cantidad", zapato.getCantidad());
                data.put("precio", zapato.getPrecio());
                data.put("estilo", ((Zapatilla) zapato).getEstilo());

                ApiFuture<WriteResult> result = docRef.set(data);

                System.out.println("Update time : " + result.get().getUpdateTime());

            } else if (zapato instanceof ZapatoDeportivo) {

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
            }
        }



        //pasar base de datos a bodega

        ApiFuture<QuerySnapshot> query = db.collection("Zapatos de Trabajo").get();

        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {

            int talla= Math.toIntExact(document.getLong("talla"));
            int cantidad= Math.toIntExact(document.getLong("cantidad"));
            int precio= Math.toIntExact(document.getLong("precio"));

            Zapato zapatoTrabajo=new ZapatoTrabajo(talla,document.getString("material"),document.getString("marca"),cantidad,precio,bodega,document.getString("material de seguridad"),document.getString("especialidad de seguridad"),document.getId());
            terminal.agregarZapato(zapatoTrabajo);
        }
        System.out.println("\n");

        ApiFuture<QuerySnapshot> query1 = db.collection("Zapatillas").get();


        QuerySnapshot querySnapshot1 = query1.get();
        List<QueryDocumentSnapshot> documents1 = querySnapshot1.getDocuments();
        for (QueryDocumentSnapshot document : documents1) {

            int talla= Math.toIntExact(document.getLong("talla"));
            int cantidad= Math.toIntExact(document.getLong("cantidad"));
            int precio= Math.toIntExact(document.getLong("precio"));

            Zapato zapatilla=new Zapatilla(talla,document.getString("material"),document.getString("marca"),cantidad,precio,bodega,document.getString("estilo"),document.getId());
            terminal.agregarZapato(zapatilla);
        }

        System.out.println("\n");

        ApiFuture<QuerySnapshot> query2 = db.collection("Zapatos de deporte").get();

        QuerySnapshot querySnapshot2 = query2.get();
        List<QueryDocumentSnapshot> documents2 = querySnapshot2.getDocuments();
        for (QueryDocumentSnapshot document : documents2) {

            int talla= Math.toIntExact(document.getLong("talla"));
            int cantidad= Math.toIntExact(document.getLong("cantidad"));
            int precio= Math.toIntExact(document.getLong("precio"));

            Zapato zapatoDeportivo=new ZapatoDeportivo(talla,document.getString("material"),document.getString("marca"),cantidad,precio,bodega,document.getString("tipo de deporte"),document.getId());
            terminal.agregarZapato(zapatoDeportivo);
        }
        terminal.verInventario();
    }
}
