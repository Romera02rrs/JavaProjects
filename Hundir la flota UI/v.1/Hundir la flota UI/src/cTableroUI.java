import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class cTableroUI extends JFrame implements ActionListener {

    cTablero t = new cTablero();

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    JLabel pantalla;
    JComboBox menuBarcos;
    JLabel lblBarcos;
    JRadioButton rdbtnVertical = new JRadioButton("Vertical");
    JRadioButton rdbtnHorizontal = new JRadioButton("Horizontal");

    int iMemoria = -1;
    int jMemoria = -1;
    int granadriaMemoria = -1;
    boolean horizontalMemoria = false;

    cBarcos barcoEnTablero;

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

    /*public String getCoordenadas(String coordenadas){

        return coordenadas;
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton a = (JButton) e.getSource();
        String coordenadas = a.getActionCommand();
        //getCoordenadas(coordenadas);
        prepararBarco(coordenadas);
    }

    public void prepararBarco(String coordenadas){

        boolean horizontal = false;
        boolean valido = false;
        if(menuBarcos.getSelectedItem() != null){
            String barco = (String) menuBarcos.getSelectedItem();
            cBarcos b = t.getBarco(barco);
            barcoEnTablero = b;
            if (rdbtnHorizontal.isSelected()){
                horizontal = true;
            }
            b.direccion = horizontal;
            String[] pos = coordenadas.split("(?<=.)");
            String iString = pos[0];
            String jString = pos[1];
            int i = Integer.parseInt(iString);
            int j = Integer.parseInt(jString);
            b.fila = i;
            b.columna = j;
            valido = validaOpcion(b);
            if(valido){
                if(iMemoria != -1){
                    if(horizontalMemoria == true){
                        for (int k = jMemoria; k < jMemoria+granadriaMemoria; k++){
                            ocupados[iMemoria][k].setBackground(Color.white);
                        }
                    }else{
                        for (int k = iMemoria; k < iMemoria+granadriaMemoria; k++){
                            ocupados[k][jMemoria].setBackground(Color.white);
                        }
                    }
                }
                if(horizontal == true){
                    for (int x = j; x < j+b.GRANDARIA; x++){
                        ocupados[i][x].setBackground(Color.BLUE);
                    }
                }else{
                    for (int x = i; x < i+b.GRANDARIA; x++){
                        ocupados[x][j].setBackground(Color.BLUE);
                    }
                }
                iMemoria = i;
                jMemoria = j;
                granadriaMemoria = b.GRANDARIA;
                horizontalMemoria = horizontal;
                pantalla.setText("cabe");
            }else{
                pantalla.setText("no cabe");
            }
        }
    }

    public boolean validaOpcion(cBarcos b) {

        boolean opcionValida = false;
        if (b.direccion == false) { //Direccion true es igual a VERTICAL
            //Compreuba que el barco no se salga por abajo
            if ((b.fila + b.GRANDARIA) > 8) {
                pantalla.setText("Error, el barco no cabe verticalmente");
                return opcionValida = false;
            } else {
                //Comprueba que no hayan barcos ya colocados
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila+i][b.columna].equals(Color.WHITE)){
                        pantalla.setText("Error, ya hay un barco en esa posicion");
                        return opcionValida = false;
                    }
                }
                return opcionValida = true;
            }
        } else {
            //Compreuba que el barco no se salga por la derecha
            if ((b.columna + b.GRANDARIA) > 8) {
                pantalla.setText("Error, el barco no cabe horizontalmente");
                return opcionValida = false;
            } else {
                //Comprueba que no hayan barcos ya colocados
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila][b.columna+i].equals(Color.white)) {
                        pantalla.setText("Error, ya hay un barco en esa posicion");
                        return opcionValida = false;
                    }
                }
                return opcionValida = true;
            }
        }

    }

    /**
     * Create the frame.
     */
    public cTableroUI() {
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

        for (int i = 0; i < ocupados.length; i++){
            for(int j = 0; j < ocupados[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                ocupados[i][j] = new JButton();
                ocupados[i][j].setActionCommand(iString+jString);
                ocupados[i][j].setBackground(Color.WHITE);
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
        menuBarcos.setModel(new DefaultComboBoxModel(new String[] {"PortaAviones", "Buque", "Submarino", "Crucero", "Lancha"})); //t.p.nombre
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

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(Color.GREEN);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String barco = (String) menuBarcos.getSelectedItem();
                cBarcos b = t.getBarco(barco);
                colocarBarco(b);
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

        if(menuBarcos.getSelectedItem() == null && menuBarcos.getItemAt(2) == null){
            cDisparosUI.posiciones(ocupados);
        }else {
            pantalla.setText("Coloca todos los barcos");
        }
    }

    public void  colocarBarco(cBarcos b){

        boolean valido = false;
        if(barcoEnTablero.nombre.equals(menuBarcos.getSelectedItem())){
            for (int i = 0; i < ocupados.length; i ++){
                for (int j = 0; j < ocupados[i].length; j++){
                    if(Color.BLUE == ocupados[i][j].getBackground()){
                        ocupados[i][j].setBackground(Color.BLACK);
                        valido = true;
                    }
                }
            }
        }else{
            pantalla.setText("Selecciona "+b.nombre);
        }
        if(valido){
            menuBarcos.removeItem(menuBarcos.getSelectedItem());
            iMemoria = -1;
            jMemoria = -1;
            granadriaMemoria = -1;
            horizontalMemoria = false;
        }
    }
}