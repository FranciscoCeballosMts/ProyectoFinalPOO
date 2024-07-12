import javax.swing.*;
import java.awt.event.*;

public class InterfazMenu extends JDialog{
    private JPanel contentPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addZapato;
    private JButton addZapatoTrabajo;
    private JButton addZapatoDeporte;
    private JButton mostrarListaZapato;


    public InterfazMenu() {
        setContentPane(contentPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        addZapato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazZapatilla dialog = new InterfazZapatilla();
                dialog.setSize(500,400);
                dialog.setVisible(true);

            }
        });

        addZapatoTrabajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazZapatoTrabajo dialog = new InterfazZapatoTrabajo();
                dialog.setSize(500,400);
                dialog.setVisible(true);

            }
        });

        addZapatoTrabajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazZapatoTrabajo dialog = new InterfazZapatoTrabajo();
                dialog.setSize(500,400);
                dialog.setVisible(true);

            }
        });

        addZapatoDeporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazZapatoDeporte dialog = new InterfazZapatoDeporte();
                dialog.setSize(500,400);
                dialog.setVisible(true);

            }
        });

        mostrarListaZapato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarZapatos dialog = new MostrarZapatos();
                dialog.setSize(500,400);
                dialog.setVisible(true);

            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        InterfazMenu dialog = new InterfazMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
