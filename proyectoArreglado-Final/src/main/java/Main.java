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
        VentanaPrincipal Ventana = new VentanaPrincipal(); //Se esta creando el objeto una Ventana para poder tener muchas más ventanas
        frame.setContentPane(Ventana.getVentanaPrincipal());//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Es para cuando uno oprime la X de la ventana el programa para
        frame.setSize(300,300); //Es para determinar el tamaño de la ventana
        frame.setVisible(true);//Es para que se nosotros lo podamos ver cuando le damos oprimimos Run


    }
}
