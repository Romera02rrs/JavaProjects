import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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

    Color azul;
    Color negro;
    Color verde;
    Color rojo;
    Color morado;
    Color amarillo;

    Font mono30;
    Font mono15;
    Font mono13;

    LineBorder bordeRedondeado;

    TitledBorder tituloBorde;

    String[] nombreBarcos;


    DefaultComboBoxModel barcosComboBox;

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
        if(tc.compruebaFin()){
            setTextoPantalla("Fin del juego");
        }
    }

    public void pintar(){

        for (int i = 0; i < tc.disparos.length; i ++){
            for (int j = 0; j < tc.disparos[i].length; j++){
                if(tc.disparos[i][j] == 'X'){
                    btnOcupados[i][j].setBackground(rojo);
                }else if (tc.disparos[i][j] == '-'){
                    btnOcupados[i][j].setBackground(negro);
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
                btnOcupados[i][j].setBackground(azul);
                btnOcupados[i][j].setBorder(new LineBorder(Color.lightGray, 1, false));
                panelBotones.add(btnOcupados[i][j]);
                btnOcupados[i][j].addActionListener(this);
            }
        }
    }

    public void pintaTablero(){

        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j++){
                btnOcupados[i][j].setBackground(azul);
            }
        }
    }

    public cDisparosUI() {

        super("Hundir la Flota - Ruben Romera");


        /** Inicializacion de variables */

        //Colores
        azul = new Color(72, 158, 234);
        negro = new Color(40, 44, 52);
        verde = new Color(85, 168, 118);
        rojo = new Color(223, 74, 75);
        morado = new Color(176, 90, 155);
        amarillo = new Color(229, 192, 123);

        //Fuentes
        mono30 = new Font("Liberation Mono", Font.BOLD, 30);
        mono15 = new Font("Liberation Mono", Font.BOLD, 15);
        mono13 = new Font("Liberation Mono", Font.BOLD, 13);

        //Borde
        bordeRedondeado = new LineBorder(verde, 2, true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(negro);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelBotones = new JPanel();
        panelBotones.setBackground(Color.lightGray);
        panelBotones.setBounds(372, 72, 550, 550);
        panelBotones.setBorder(new LineBorder(negro, 2, false));
        contentPane.add(panelBotones);
        panelBotones.setLayout(new GridLayout(8, 8));

        /** Insertar los botones */
        insertarBotones();

        pantalla = new JLabel("¡Comienza a disparar!");
        pantalla.setFont(mono30);
        pantalla.setForeground(verde);
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);

        pintaTablero();
    }
}
