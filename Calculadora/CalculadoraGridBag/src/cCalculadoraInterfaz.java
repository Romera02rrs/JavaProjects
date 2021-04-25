import javax.swing.*;
import java.awt.*;

public class cCalculadoraInterfaz extends JFrame {

    public static void main(String[] args) {
        new cCalculadoraInterfaz();
    }

    public cCalculadoraInterfaz(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        //super("Calculator");
        getContentPane().setLayout(new GridBagLayout());
        contentPane.setSize(500,500);
        contentPane.setVisible(true);

        JButton pantalla = new JButton("Calcula");
        getContentPane().add(pantalla);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        getContentPane().add(pantalla, constraints);

        JButton boton1 = new JButton ("Boton 1");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (boton1, constraints);

        JButton boton2 = new JButton ("Boton 2");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (boton2, constraints);

        JButton boton3 = new JButton ("Boton 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (boton3, constraints);

        JButton boton4 = new JButton ("Boton 4");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (boton4, constraints);

        JTextField campoTexto = new JTextField ("Campo texto");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (campoTexto, constraints);
    }
}
