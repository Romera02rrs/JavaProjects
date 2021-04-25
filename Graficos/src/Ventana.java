import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ventana extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 691, 498);
        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(12, 12, 70, 15);
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(12, 39, 70, 15);
        contentPane.add(lblApellido);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(12, 66, 70, 15);
        contentPane.add(lblUsuario);

        JLabel lblClave = new JLabel("Clave");
        lblClave.setBounds(12, 93, 70, 15);
        contentPane.add(lblClave);

        textField = new JTextField();
        textField.setBounds(100, 10, 114, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(100, 37, 114, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(100, 64, 114, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBounds(12, 120, 204, 160);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setBounds(82, 12, 35, 15);
        panel.add(lblEdad);

        JRadioButton radioButton = new JRadioButton("0 - 15");
        buttonGroup.add(radioButton);
        radioButton.setBounds(8, 35, 149, 23);
        panel.add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("16 - 30");
        buttonGroup.add(radioButton_1);
        radioButton_1.setBounds(8, 62, 149, 23);
        panel.add(radioButton_1);

        JRadioButton radioButton_2 = new JRadioButton("31 - 45");
        buttonGroup.add(radioButton_2);
        radioButton_2.setBounds(8, 89, 149, 23);
        panel.add(radioButton_2);

        JRadioButton radioButton_3 = new JRadioButton("46 +");
        buttonGroup.add(radioButton_3);
        radioButton_3.setBounds(8, 116, 149, 23);
        panel.add(radioButton_3);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBounds(265, 120, 204, 160);
        contentPane.add(panel_1);

        JLabel lblGustos = new JLabel("Gustos");
        lblGustos.setBounds(75, 12, 59, 15);
        panel_1.add(lblGustos);

        JCheckBox chckbxDeportes = new JCheckBox("Deportes");
        chckbxDeportes.setBounds(8, 35, 129, 23);
        panel_1.add(chckbxDeportes);

        JCheckBox chckbxCocina = new JCheckBox("Cocina");
        chckbxCocina.setBounds(8, 62, 129, 23);
        panel_1.add(chckbxCocina);

        JCheckBox chckbxAprendizaje = new JCheckBox("Aprendizaje");
        chckbxAprendizaje.setBounds(8, 89, 129, 23);
        panel_1.add(chckbxAprendizaje);

        JCheckBox chckbxDocencia = new JCheckBox("Docencia");
        chckbxDocencia.setBounds(8, 116, 129, 23);
        panel_1.add(chckbxDocencia);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Informatico/a", "Obrero/a", "Cocinero/a", "Sectretario/a", "Dependiente/a"}));
        comboBox.setBounds(100, 292, 369, 24);
        contentPane.add(comboBox);

        JLabel lblProfesion = new JLabel("Profesion");
        lblProfesion.setBounds(12, 297, 70, 15);
        contentPane.add(lblProfesion);

        JLabel lblObservaciones = new JLabel("Observaciones");
        lblObservaciones.setBounds(12, 328, 120, 15);
        contentPane.add(lblObservaciones);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(135, 328, 256, 118);
        contentPane.add(textArea);

        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contentPane,"Registro completado");
            }
        });
        btnOk.setBounds(430, 417, 112, 25);
        contentPane.add(btnOk);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnCancelar.setBounds(554, 417, 112, 25);
        contentPane.add(btnCancelar);

        JLabel lblHbu = new JLabel("HBU");
        lblHbu.setFont(new Font("Liberation Sans", Font.BOLD, 35));
        lblHbu.setBounds(534, 39, 86, 42);
        contentPane.add(lblHbu);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 89, 114, 19);
        contentPane.add(passwordField);

        JLabel lblSeries = new JLabel("Series");
        lblSeries.setFont(new Font("Nimbus Mono PS", Font.BOLD, 20));
        lblSeries.setBounds(534, 92, 105, 24);
        contentPane.add(lblSeries);
    }
}

