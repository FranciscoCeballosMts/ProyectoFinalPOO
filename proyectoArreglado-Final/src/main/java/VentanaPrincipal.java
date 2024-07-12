import com.google.cloud.firestore.Firestore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel ventanaPrincipal;//Es un contenedor invisible que organiza los controladoresprivate JPasswordField usuarioContrasena;
    private JButton iniciarButton;
    private JTextField usuarioNombre;
    private JCheckBox verContrasena;
    private JLabel usuario;
    private JLabel contrasena;
    private JPasswordField usuarioContrasena;

    public VentanaPrincipal() {
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioNombre.getText();
                String contrasena = String.valueOf(usuarioContrasena.getPassword());
                if (usuario.equals("Raúl") && contrasena.equals("123qweasdzxc")){
                    JOptionPane.showMessageDialog(null,"Usuario autenticado");
                    InterfazMenu dialog = new InterfazMenu();
                    dialog.setSize(400,400);
                    dialog.setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null,"Error en usuario y contraseña");
                }
            }
        });
        verContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verContrasena.isSelected()){
                    usuarioContrasena.setEchoChar((char) 0);
                } else {
                    usuarioContrasena.setEchoChar('*');
                }
            }
        });
    }

    public JPanel getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
