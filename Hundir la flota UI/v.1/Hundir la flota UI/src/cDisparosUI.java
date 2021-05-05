import java.awt.*;

import javax.naming.event.ObjectChangeListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cDisparosUI extends JFrame implements ActionListener {

    cTablero t = new cTablero();
    cTableroUI tui = new cTableroUI();
    cVictoriaUI vui = new cVictoriaUI();

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    JLabel pantalla;

    JButton[][] disparos = new JButton[8][8];
    static JButton[][] ocupados = new JButton [8][8];

    int barcosTocados = 0;


    public static void ejecutaInterfaz() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cDisparosUI frame = new cDisparosUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void posiciones(JButton[][] ocupados2){


        ocupados = ocupados2;
        ejecutaInterfaz();
    }

    public void disparo(String coordenadas){



        String[] pos = coordenadas.split("(?<=.)");
        String iString = pos[0];
        String jString = pos[1];
        int i = Integer.parseInt(iString);
        int j = Integer.parseInt(jString);
        if(Color.BLACK == ocupados[i][j].getBackground()){
            disparos[i][j].setBackground(Color.RED);
            barcosTocados ++;
        }else{
            disparos[i][j].setBackground(Color.GRAY);
        }
        if (barcosTocados == 15){
            pantalla.setText("FIN DEL JUEGO");
            vui.ejecutaInterfaz();
            //System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton a = (JButton) e.getSource();
        String coordenadas = a.getActionCommand();
        disparo(coordenadas);
    }

    public cDisparosUI() {
        super("Hundir la Flota - Ruben Romera");
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

        for (int i = 0; i < disparos.length; i++){
            for(int j = 0; j < disparos[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                disparos[i][j] = new JButton();
                disparos[i][j].setActionCommand(iString+jString);
                disparos[i][j].setBackground(Color.WHITE);
                panel.add(disparos[i][j]);
                disparos[i][j].addActionListener(this);
            }
        }

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLUE);
        panel_2.setBounds(74, 28, 216, 631);
        contentPane.add(panel_2);

        pantalla = new JLabel("¡Comienza a disparar!");
        pantalla.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);
    }
}
