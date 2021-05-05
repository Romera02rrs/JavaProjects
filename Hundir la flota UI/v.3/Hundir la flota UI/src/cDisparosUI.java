import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cDisparosUI extends JFrame implements ActionListener{

    private JButton[][] ocupados = new JButton[8][8];

    private JPanel contentPane;
    private JPanel panelBotones;
    private JLabel pantalla;
    private JPanel panelBarcos;

    public void iniciarDisparos(cTableroCalculos tc){

        ejecutaInterfaz();
    }

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

    public void insertarBotones(){

        for (int i = 0; i < ocupados.length; i++){
            for(int j = 0; j < ocupados[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                ocupados[i][j] = new JButton();
                ocupados[i][j].setActionCommand(iString+jString);
                ocupados[i][j].setBackground(Color.WHITE);
                panelBotones.add(ocupados[i][j]);
                ocupados[i][j].addActionListener(this);
            }
        }
    }

    public cDisparosUI() {
        super("Hundir la Flota - Ruben Romera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelBotones = new JPanel();
        panelBotones.setBackground(Color.RED);
        panelBotones.setBounds(372, 72, 550, 550);
        contentPane.add(panelBotones);
        panelBotones.setLayout(new GridLayout(8, 8));

        /** Insertar los botones */
        insertarBotones();

        panelBarcos = new JPanel();
        panelBarcos.setBackground(Color.BLUE);
        panelBarcos.setBounds(74, 28, 216, 631);
        contentPane.add(panelBarcos);

        pantalla = new JLabel("¡Bienvenido a Hundir la flota!");
        pantalla.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
