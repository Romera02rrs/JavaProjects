import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class cTableroUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    JLabel pantalla;
    JComboBox menuBarcos;
    String barcoSeleccionado;
    JLabel lblBarcos;
    JRadioButton rdbtnVertical = new JRadioButton("Vertical");
    JRadioButton rdbtnHorizontal = new JRadioButton("Horizontal");


    JButton[][] ocupados = new JButton[8][8];

    /**
     * Launch the application.
     */
    public static void ejecutaInterfaz() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cTableroUI frame = new cTableroUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*if(menuBarcos.getSelectedItem().equals("PortaAviones")){
           if(rdbtnHorizontal.isSelected()){
               pantalla.setText("Hola");
               for (int i = 0; i < 5; i++){
                   String a = (String) e.getActionCommand();
                   pantalla.setText(a);
                   //ocupados[][]
               }
           }
        }*/
        JButton a = (JButton) e.getSource();
        a.setBackground(Color.black);
        String nombre = a.getActionCommand();
        String[] pos = nombre.split("(?<=.)");
        String iString = pos[0];
        String jString = pos[1];
        int i = Integer.parseInt(iString);
        int j = Integer.parseInt(jString);
        for (int x = i; x < i+4; x++){
            ocupados[x][j].setBackground(Color.BLUE);
        }
        /*if(e.getSource() == ocupados[2][2]){
            ocupados[2][2].setBackground(Color.red);
        }*/
    }

    /**
     * Create the frame.
     */
    public cTableroUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(372, 72, 550, 550);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < ocupados.length; i++){
            for(int j = 0; j < ocupados[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                ocupados[i][j] = new JButton();
                ocupados[i][j].setActionCommand(iString+jString);
                panel.add(ocupados[i][j]);
                ocupados[i][j].addActionListener(this);
            }
        }

        lblBarcos = new JLabel("Barcos");
        lblBarcos.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarcos.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        lblBarcos.setBounds(982, 72, 250, 34);
        contentPane.add(lblBarcos);

        menuBarcos = new JComboBox();
        menuBarcos.setModel(new DefaultComboBoxModel(new String[] {"PortaAviones", "Buque", "Submarino", "Crucero", "Lancha"}));
        menuBarcos.setSelectedItem(null);
        menuBarcos.setBounds(1022, 130, 182, 24);
        contentPane.add(menuBarcos);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Direccion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panel_1.setBounds(1000, 285, 230, 111);
        contentPane.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        buttonGroup.add(rdbtnVertical);
        panel_1.add(rdbtnVertical);

        buttonGroup.add(rdbtnHorizontal);
        panel_1.add(rdbtnHorizontal);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLUE);
        panel_2.setBounds(74, 28, 216, 631);
        contentPane.add(panel_2);

        /*JButton okBarco = new JButton("Ok");
        okBarco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                colocaBarcos();
            }
        });
        okBarco.setBounds(947, 118, 53, 48);
        contentPane.add(okBarco);*/

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(Color.GREEN);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnConfirmar.setBounds(1041, 523, 173, 24);
        contentPane.add(btnConfirmar);

        pantalla = new JLabel("¡Bienvenido a Hundir la flota!");
        pantalla.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);

        JButton btncomenzarJuego = new JButton("¡Comenzar a Jugar!");
        btncomenzarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                muestraColocaBarcos();
            }
        });
        btncomenzarJuego.setBounds(520, 644, 263, 25);
        contentPane.add(btncomenzarJuego);
    }

    public void muestraColocaBarcos() {

        /*try {
            Thread.sleep(5*500);
        } catch (Exception e) {
            System.out.println(e);
        }*/
        pantalla.setText("Coloca los Barcos");
    }
}