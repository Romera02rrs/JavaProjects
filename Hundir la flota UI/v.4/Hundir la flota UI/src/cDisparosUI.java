import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cDisparosUI extends JFrame implements ActionListener{

    public cTableroCalculos tc;
    private JButton[][] btnOcupados = new JButton[8][8];

    private JPanel contentPane;
    private JPanel panelBotones;
    private JLabel pantalla;
    private JPanel panelBarcos;

    String coordenadas;

    public void jugar(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        String barco;

        JButton boton;
        boton = (JButton) evento.getSource();

        coordenadas = boton.getActionCommand();
        barco = tc.disparo(coordenadas);
        if(barco != null){
            pintar();
            setTextoPantalla(barco);
        }else{
            setTextoPantalla("Ya has disparado ahi");
        }
    }

    public void pintar(){

        for (int i = 0; i < tc.disparos.length; i ++){
            for (int j = 0; j < tc.disparos[i].length; j++){
                if(tc.disparos[i][j] == 'X'){
                    btnOcupados[i][j].setBackground(Color.red);
                }else if (tc.disparos[i][j] == '-'){
                    btnOcupados[i][j].setBackground(Color.blue);
                }
            }
        }
    }

    public void setTextoPantalla(String texto){

        pantalla.setText(texto);
    }

    public void insertarBotones(){

        for (int i = 0; i < btnOcupados.length; i++){
            for(int j = 0; j < btnOcupados[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                btnOcupados[i][j] = new JButton();
                btnOcupados[i][j].setActionCommand(iString+jString);
                btnOcupados[i][j].setBackground(Color.WHITE);
                panelBotones.add(btnOcupados[i][j]);
                btnOcupados[i][j].addActionListener(this);
            }
        }
    }

    public void pintaTablero(){

        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j++){
                btnOcupados[i][j].setBackground(Color.gray);
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

        pintaTablero();
    }
}
