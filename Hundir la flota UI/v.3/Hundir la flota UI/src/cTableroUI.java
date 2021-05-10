import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cTableroUI extends JFrame implements ActionListener {

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

    private cTableroCalculos tc = new cTableroCalculos();
    private cDisparosUI dUI = new cDisparosUI();


    private JButton[][] btnOcupados = new JButton[8][8];
    private JButton[] btnPanelBarcos = new JButton[5];

    private JPanel contentPane;
    private JPanel panelBotones;
    private JLabel pantalla;
    private JComboBox menuBarcos;
    private JLabel lblBarcos;
    private JPanel panelBarcos;
    private JPanel panelBotonesBarcos;
    private JPanel panelRdbt;
    private ButtonGroup buttonGroup;
    private JRadioButton rdbtnVertical;
    private JRadioButton rdbtnHorizontal;
    private JButton btnConfirmar;
    private JButton btnComenzarJuego;

    String coordenadas;
    String barcoSeleccionado;
    boolean horizontal;

    boolean confirmarPresionado;

    public static void main(String[] args) {
        //ejecutaInterfaz();
        SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new cTableroUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        boolean posicionValida;

        JButton boton;
        boton = (JButton) evento.getSource();

        confirmarPresionado = false;

        /** Pedir coordenadas*/
        coordenadas = boton.getActionCommand();
        barcoSeleccionado = getBarcoSeleccionado();
        horizontal = getDireccion();
        if(barcoSeleccionado == null){
            setTextoPantalla("Selecciona un barco");
        }else{
            /** Establecer coordenadas */
            tc.setPropiedadesBarco(coordenadas, barcoSeleccionado, horizontal);
            /** Validar coordenadas */
            posicionValida = tc.getPosicionValida();
            if(posicionValida){
                setTextoPantalla("Posicion Valida");
                if(tc.bMemoria != null){
                    tc.quitarBarcoMemoria();
                }
                tc.setPropiedadesMemoria();
                tc.insertarBarco(false);
                pintarBarco();
                confirmarPresionado = true;
            }else{
                setTextoPantalla("El Barco no cabe");
                if(tc.bMemoria != null){
                    tc.quitarBarcoMemoria();
                }
                pintarBarco();
            }
        }
    }

    public void pintarBarco(){

        for (int i = 0; i < tc.ocupados.length; i ++){
            for (int j = 0; j < tc.ocupados[i].length; j++){
                if(tc.ocupados[i][j] == ' '){
                    btnOcupados[i][j].setBackground(azul);
                }else if(tc.ocupados[i][j] == 'o'){
                    btnOcupados[i][j].setBackground(verde);
                }else{
                    btnOcupados[i][j].setBackground(negro);
                }
            }
        }
    }

    public void pintarPanelBarcos(String barcoSeleccionado){

        int grandaria = tc.getGrandaria(barcoSeleccionado);
        for (int i  = 0; i < btnPanelBarcos.length; i++){
            btnPanelBarcos[i].setBackground(azul);
        }
        for (int i = 0; i < grandaria; i++){
            btnPanelBarcos[i].setBackground(rojo);
        }
    }

    public String getBarcoSeleccionado(){

        if(menuBarcos.getSelectedItem() != null){

            barcoSeleccionado = (String) menuBarcos.getSelectedItem();
            return barcoSeleccionado;
        }
        return null;
    }

    public boolean getDireccion(){

        if (rdbtnHorizontal.isSelected()){
            return horizontal = true;
        }
        return horizontal = false;
    }

    public void actionConfirmar(){

        if(confirmarPresionado){
            if(quitarBarcoMenu()){
                tc.quitarPropiedadesBarco();
                tc.insertarBarco(true);
                pintarBarco();
            }
        }else{
            setTextoPantalla("Posicion no Valida");
        }
    }

    public void actionComenzarJuego(){

        if(verificarBarcosInsertados()){
            this.setVisible(false);
            dUI.jugar();
            dUI.tc = this.tc;
        }else{
            setTextoPantalla("Coloca todos los barcos");
        }
    }

    public boolean verificarBarcosInsertados(){

        if(menuBarcos.getSelectedItem() == null && menuBarcos.getItemAt(2) == null){
            return true;
        }else{
            return false;
        }
    }

    public void setTextoPantalla(String texto){

        pantalla.setText(texto);
    }

    public boolean quitarBarcoMenu(){

        if(tc.b.nombre.equals(menuBarcos.getSelectedItem())){
            menuBarcos.removeItem(getBarcoSeleccionado());
            return true;
        }else{
            setTextoPantalla("Selecciona el " + tc.b.nombre);
            return false;
        }
    }

    public void insertarBotones(){

        for (int i = 0; i < btnOcupados.length; i++){
            for(int j = 0; j < btnOcupados[i].length; j++){
                String iString = Integer.toString(i);
                String jString = Integer.toString(j);
                btnOcupados[i][j] = new JButton();
                btnOcupados[i][j].addActionListener(this);
                btnOcupados[i][j].setActionCommand(iString+jString);
                btnOcupados[i][j].setBackground(azul);
                btnOcupados[i][j].setBorder(new LineBorder(Color.lightGray, 1, false));
                panelBotones.add(btnOcupados[i][j]);
            }
        }
    }

    public void insertarBotonesBarcos(){

        for (int i = 0; i < btnPanelBarcos.length; i++){

            String iString = Integer.toString(i);
            btnPanelBarcos[i] = new JButton();
            btnPanelBarcos[i].setActionCommand(iString);
            btnPanelBarcos[i].setBackground(azul);
            btnPanelBarcos[i].setEnabled(false);
            btnPanelBarcos[i].setBorder(new LineBorder(Color.lightGray, 2, false));
            panelBotonesBarcos.add(btnPanelBarcos[i]);
        }
    }

    public cTableroUI() {

        super("Hundir la Flota - Ruben Romera");


        /** Inicializacion de variables */

        //Colores
        azul = new Color(72, 158, 234);
        negro = new Color(40, 44, 52);
        verde = new Color(85, 168, 118);
        rojo = new Color(215, 86, 109);
        morado = new Color(176, 90, 155);
        amarillo = new Color(229, 192, 123);

        //Fuentes
        mono30 = new Font("Liberation Mono", Font.BOLD, 30);
        mono15 = new Font("Liberation Mono", Font.BOLD, 15);
        mono13 = new Font("Liberation Mono", Font.BOLD, 13);

        //Borde
        bordeRedondeado = new LineBorder(verde, 2, true);

        //Titulo del borde
        tituloBorde = new TitledBorder(bordeRedondeado, "Direccion", TitledBorder.CENTER, TitledBorder.TOP, mono15, verde);

        //Combobox de Barcos
        nombreBarcos = new String[]{tc.p.nombre, tc.bb.nombre, tc.s.nombre, tc.c.nombre, tc.l.nombre};
        barcosComboBox = new DefaultComboBoxModel(nombreBarcos);


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

        lblBarcos = new JLabel("Barcos");
        lblBarcos.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarcos.setForeground(verde);
        lblBarcos.setFont(mono30);
        lblBarcos.setBounds(982, 72, 250, 34);
        contentPane.add(lblBarcos);

        menuBarcos = new JComboBox();
        menuBarcos.setModel(barcosComboBox);
        menuBarcos.setSelectedItem(null);
        menuBarcos.setBounds(1022, 130, 182, 24);
        menuBarcos.setBackground(verde);
        menuBarcos.setFocusable(false);
        menuBarcos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pintarPanelBarcos((String) menuBarcos.getSelectedItem());
            }
        });
        contentPane.add(menuBarcos);

        panelRdbt = new JPanel();
        panelRdbt.setBorder(tituloBorde);
        panelRdbt.setBounds(1000, 285, 230, 111);
        panelRdbt.setBackground(negro);
        contentPane.add(panelRdbt);
        panelRdbt.setLayout(new GridLayout(0, 2, 0, 0));

        buttonGroup = new ButtonGroup();

        rdbtnVertical = new JRadioButton("Vertical");
        rdbtnVertical.setFont(mono13);
        rdbtnVertical.setForeground(verde);
        rdbtnVertical.setBackground(negro);
        rdbtnVertical.setFocusable(false);
        buttonGroup.add(rdbtnVertical);
        panelRdbt.add(rdbtnVertical);

        rdbtnHorizontal = new JRadioButton("Horizontal");
        rdbtnHorizontal.setFont(mono13);
        rdbtnHorizontal.setForeground(verde);
        rdbtnHorizontal.setBackground(negro);
        rdbtnVertical.setFocusable(false);
        buttonGroup.add(rdbtnHorizontal);
        panelRdbt.add(rdbtnHorizontal);

        panelBotonesBarcos = new JPanel();
        panelBotonesBarcos.setBackground(Color.lightGray);
        panelBotonesBarcos.setBounds(135, 92, 100, 500);
        panelBotonesBarcos.setBorder(new LineBorder(Color.lightGray, 2));
        panelBotonesBarcos.setLayout(new GridLayout(0,1));
        contentPane.add(panelBotonesBarcos);

        insertarBotonesBarcos();

        panelBarcos = new JPanel();
        panelBarcos.setBackground(azul);
        panelBarcos.setBounds(74, 28, 216, 631);
        panelBarcos.setBorder(new LineBorder(Color.lightGray, 2));
        contentPane.add(panelBarcos);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionConfirmar();
            }
        });
        btnConfirmar.setBackground(verde);
        btnConfirmar.setFocusable(false);
        btnConfirmar.setForeground(negro);
        btnConfirmar.setBounds(1041, 523, 173, 24);
        contentPane.add(btnConfirmar);

        pantalla = new JLabel("¡Bienvenido a Hundir la flota!");
        pantalla.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        pantalla.setForeground(verde);
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);

        btnComenzarJuego = new JButton("¡Comenzar a Jugar!");
        btnComenzarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionComenzarJuego();
            }
        });
        btnComenzarJuego.setBackground(verde);
        btnComenzarJuego.setForeground(negro);
        btnComenzarJuego.setBounds(520, 644, 263, 25);
        contentPane.add(btnComenzarJuego);

        tc.reinicializarTableros();

        this.setVisible(true);

    }
}
