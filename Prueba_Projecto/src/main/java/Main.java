import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //Es para interactuar cómo en una ventana de Windons
        VentanaPrincipal Ventana = new VentanaPrincipal(); //Se esta creando el objeto una Ventana para poder tener muchas más ventanas
        frame.setContentPane(Ventana.getVentanaPrincipal());//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Es para cuando uno oprime la X de la ventana el programa para
        frame.setSize(300,300); //Es para determinar el tamaño de la ventana
        frame.setVisible(true);//Es para que se nosotros lo podamos ver cuando le damos oprimimos Run
    }
}
