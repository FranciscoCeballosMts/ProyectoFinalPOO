import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FirebaseConnection {
    private static Firestore db = null;

    public static Firestore getFirestore() throws IOException {
        if (db == null) {
            InputStream serviceAccount = new FileInputStream("src/main/resources/zapateriabasededatos-firebase-adminsdk-odyen-dd419eb68f.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            String projectId = "zapateriabasededatos";
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .setProjectId(projectId)
                    .build();
            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        }
        return db;
    }

    public static void close() {
        if (db != null) {
            db = null;
            FirebaseApp.getInstance().delete();
        }
    }
}
