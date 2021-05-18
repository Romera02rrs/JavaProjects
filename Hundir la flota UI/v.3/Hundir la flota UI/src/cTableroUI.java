import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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

    DefaultComboBoxModel barcosComboBox;

    String[] nombreBarcos;

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
    private JLabel infoBotones;
    private JButton btnConfirmar;
    private JLabel infoConfirmar;
    private JButton btnComenzarJuego;
    private JButton btnInfo;

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

    /** Metodo que es llamado cada vez que se presiona un boton del tablero
     * y se encarga de llamar a todos los metodos necesarios para colocar y
     * validar posiciones de los barcos*/
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
            if(verificarBarcosInsertados()){
                setTextoPantalla("Presione ¡Comenzar a Jugar!");
            }else{
                setTextoPantalla("Selecciona un barco");
            }
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

    /** Pinta el tablero de los barcos con distintos colores dependiendo
     * de la matriz de los barcos */
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

    /** Pinta el panel de guia con la grandaria del barco */
    public void pintarPanelBarcos(String barcoSeleccionado){

        if(barcoSeleccionado == null){
            for (int i  = 0; i < btnPanelBarcos.length; i++){
                btnPanelBarcos[i].setBackground(azul);
            }
        }else{
            int grandaria = tc.getGrandaria(barcoSeleccionado);
            for (int i  = 0; i < btnPanelBarcos.length; i++){
                btnPanelBarcos[i].setBackground(azul);
            }
            for (int i = 0; i < grandaria; i++){
                btnPanelBarcos[i].setBackground(rojo);
            }
        }
    }

    /** Devuelve el nombre del barco seleccionado en el menu */
    public String getBarcoSeleccionado(){

        if(menuBarcos.getSelectedItem() != null){

            barcoSeleccionado = (String) menuBarcos.getSelectedItem();
            return barcoSeleccionado;
        }
        return null;
    }

    /** Recoge el valor de la direccion dependiendo de los radiobutton */
    public boolean getDireccion(){

        if (rdbtnHorizontal.isSelected()){
            return horizontal = true;
        }
        return horizontal = false;
    }

    /** Coloca los barocs y una vez colocados elimina toda
     * la interfaz que no es necesaria */
    public void actionConfirmar(){

        if(confirmarPresionado){
            if(quitarBarcoMenu()){
                tc.quitarPropiedadesBarco();
                tc.insertarBarco(true);
                pintarBarco();
            }
            if(verificarBarcosInsertados()){
                setTextoPantalla("Presione ¡Comenzar a Jugar!");
                btnConfirmar.setVisible(false);
                menuBarcos.setVisible(false);
                panelRdbt.setVisible(false);
                lblBarcos.setVisible(false);
                infoBotones.setVisible(false);
                infoConfirmar.setVisible(false);
            }
        }else{
            setTextoPantalla("Posicion no Valida");
        }
    }

    /** Llama a la clase disparos y comienza la segunda parte del juego
     * si los barcos han sido todos colocados */
    public void actionComenzarJuego(){

        if(verificarBarcosInsertados()){
            this.setVisible(false);
            dUI.jugar();
            dUI.tc = this.tc;
        }else{
            setTextoPantalla("Coloca todos los barcos");
        }
    }

    /** Verifica si quedan barcos por seleccionar */
    public boolean verificarBarcosInsertados(){

        if(menuBarcos.getSelectedItem() == null && menuBarcos.getItemAt(2) == null){
            return true;
        }else{
            return false;
        }
    }

    /** Muestra en la pantalla principal el texto que le pases */
    public void setTextoPantalla(String texto){

        pantalla.setText(texto);
    }

    /** Metodo que elimina el barco del menu si el barco colocado en el tablero
     * es el mismo que se quiere quitar */
    public boolean quitarBarcoMenu(){

        if(tc.b.nombre.equals(menuBarcos.getSelectedItem())){
            menuBarcos.removeItem(getBarcoSeleccionado());
            return true;
        }else{
            setTextoPantalla("Selecciona el " + tc.b.nombre);
            return false;
        }
    }

    /** Inserta todos los botones a la matriz y les establece las propiedades necesarias */
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

    /** Metodo que cambia la direccion presionando la tecla R */
    public void cambiarDireccion(){

        rdbtnHorizontal.getInputMap(rdbtnHorizontal.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "rdbtnHorizontal");
        rdbtnHorizontal.getInputMap(rdbtnHorizontal.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(MouseEvent.BUTTON3, 0), "rdbtnHorizontal");
        rdbtnHorizontal.getActionMap().put("rdbtnHorizontal", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(rdbtnHorizontal.isSelected()){
                    rdbtnVertical.setSelected(true);
                }else{
                    rdbtnHorizontal.setSelected(true);
                }

            }
        });
    }

    public cTableroUI() {

        super("Hundir la Flota - Ruben Romera");

        /** Inicializacion de variables */

        /** Colores */
        azul = new Color(72, 158, 234);
        negro = new Color(40, 44, 52);
        verde = new Color(85, 168, 118);
        rojo = new Color(215, 86, 109);
        morado = new Color(176, 90, 155);
        amarillo = new Color(229, 192, 123);

        /** Fuentes */
        mono30 = new Font("Liberation Mono", Font.BOLD, 30);
        mono15 = new Font("Liberation Mono", Font.BOLD, 15);
        mono13 = new Font("Liberation Mono", Font.BOLD, 13);

        /** Bordes */
        bordeRedondeado = new LineBorder(verde, 2, true);

        /** Texto del borde */
        tituloBorde = new TitledBorder(bordeRedondeado, "Direccion", TitledBorder.CENTER, TitledBorder.TOP, mono15, verde);

        /** Texto del menu de los barcos */
        nombreBarcos = new String[]{tc.p.nombre, tc.bb.nombre, tc.s.nombre, tc.c.nombre, tc.l.nombre};
        barcosComboBox = new DefaultComboBoxModel(nombreBarcos);

        /** Panel principal */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(negro);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /** Panel que contiene los botones */
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.lightGray);
        panelBotones.setBounds(372, 72, 550, 550);
        panelBotones.setBorder(new LineBorder(negro, 2, false));
        contentPane.add(panelBotones);
        panelBotones.setLayout(new GridLayout(8, 8));

        /** Insertar los botones */
        insertarBotones();

        /** Label que dice "Barcos" */
        lblBarcos = new JLabel("Barcos");
        lblBarcos.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarcos.setForeground(verde);
        lblBarcos.setFont(mono30);
        lblBarcos.setBounds(975, 72, 250, 34);
        contentPane.add(lblBarcos);

        /** Menu de los barcos */
        menuBarcos = new JComboBox();
        menuBarcos.setModel(barcosComboBox);
        menuBarcos.setSelectedItem(null);
        menuBarcos.setBounds(1010, 130, 182, 24);
        menuBarcos.setBackground(verde);
        menuBarcos.setFocusable(false);
        menuBarcos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                pintarPanelBarcos((String) menuBarcos.getSelectedItem());
            }
        });
        contentPane.add(menuBarcos);

        /** Panel que contiene los botones de direccion */
        panelRdbt = new JPanel();
        panelRdbt.setBorder(tituloBorde);
        panelRdbt.setBounds(990, 285, 230, 111);
        panelRdbt.setBackground(negro);
        contentPane.add(panelRdbt);
        panelRdbt.setLayout(new GridLayout(0, 2, 0, 0));

        /** Grupo de bos botones */
        buttonGroup = new ButtonGroup();

        /** Boton vertical */
        rdbtnVertical = new JRadioButton("Vertical");
        rdbtnVertical.setFont(mono13);
        rdbtnVertical.setForeground(verde);
        rdbtnVertical.setBackground(negro);
        rdbtnVertical.setFocusable(false);
        buttonGroup.add(rdbtnVertical);
        panelRdbt.add(rdbtnVertical);

        /** Boton horizontal */
        rdbtnHorizontal = new JRadioButton("Horizontal");
        rdbtnHorizontal.setFont(mono13);
        rdbtnHorizontal.setForeground(verde);
        rdbtnHorizontal.setBackground(negro);
        rdbtnVertical.setFocusable(false);
        buttonGroup.add(rdbtnHorizontal);
        panelRdbt.add(rdbtnHorizontal);

        /** Llama al metodo para poder usar el teclado para cambiar la direccion */
        cambiarDireccion();

        /** Label de informacion para cambiar la direccion de los barcos */
        infoBotones = new JLabel("Presione la tecla \"R\"");
        infoBotones.setBounds(1020, 365, 300, 111);
        infoBotones.setFont(mono13);
        infoBotones.setForeground(verde);
        contentPane.add(infoBotones);

        /** Insertar los botones */
        panelBotonesBarcos = new JPanel();
        panelBotonesBarcos.setBackground(Color.lightGray);
        panelBotonesBarcos.setBounds(135, 92, 100, 500);
        panelBotonesBarcos.setBorder(new LineBorder(Color.lightGray, 2));
        panelBotonesBarcos.setLayout(new GridLayout(0,1));
        contentPane.add(panelBotonesBarcos);

        /** Insertar los botones del panel de los barcos
         *  para saber la grandaria */
        insertarBotonesBarcos();

        /** Panel donde se puede ver la grandaria de los barcos */
        panelBarcos = new JPanel();
        panelBarcos.setBackground(azul);
        panelBarcos.setBounds(74, 28, 216, 631);
        panelBarcos.setBorder(new LineBorder(Color.lightGray, 2));
        contentPane.add(panelBarcos);

        /** Boton confirmar
         * con deteccion de la tecla ENTER */
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionConfirmar();
            }
        });
        btnConfirmar.getInputMap(btnConfirmar.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Confirmar");
        btnConfirmar.getActionMap().put("Confirmar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                actionConfirmar();
            }
        });
        btnConfirmar.setBackground(verde);
        btnConfirmar.setFocusable(false);
        btnConfirmar.setForeground(negro);
        btnConfirmar.setFont(mono15);
        btnConfirmar.setBounds(1020, 523, 173, 24);
        contentPane.add(btnConfirmar);

        /** Label de informacion para colocar los barcos con el teclado */
        infoConfirmar = new JLabel("Presione \"Intro\"");
        infoConfirmar.setBounds(1045, 550, 400, 50);
        infoConfirmar.setFont(mono13);
        infoConfirmar.setForeground(verde);
        contentPane.add(infoConfirmar);

        /** Pantalla que va mostrando las indicaciones
         * e intrucciones del juego */
        pantalla = new JLabel("¡Bienvenido a Hundir la flota!");
        pantalla.setFont(mono30);
        pantalla.setForeground(verde);
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);

        /** Boton que muestra la infromacion del juego */
        btnInfo = new JButton("?");
        btnInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "*** COLOCACION DE BARCOS *** \n/\\/\\/\\" +
                        "/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\n" +
                        "1. Selecciona el Barco en el menu. \n" +
                        "2. Escoge la direccion o presione la tecla \"R\".\n" +
                        "3. Coloca el barco en la posicion deseada. \n" +
                        "4. Presione el boton confirmar o la tecla \"Intro\".\n\n" +
                        "Los barcos deben tener una separacion de una casilla.          " +
                        "\n\n /---------------------------------------------------------------------------\\\n\n" +
                        "*** DISPAROS *** \n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\n " +
                        "Indique la posicion a disparar.");

            }
        });
        btnInfo.setFocusable(false);
        btnInfo.setBackground(verde);
        btnInfo.setForeground(negro);
        btnInfo.setBounds(1200, 25, 50, 50);
        contentPane.add(btnInfo);

        /** Boton que llama a los disparos
         * cuando los barcos esten todos colocados */
        btnComenzarJuego = new JButton("¡Comenzar a Jugar!");
        btnComenzarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionComenzarJuego();
            }
        });
        btnComenzarJuego.setFocusable(false);
        btnComenzarJuego.setBackground(verde);
        btnComenzarJuego.setForeground(negro);
        btnComenzarJuego.setFont(mono15);
        btnComenzarJuego.setBounds(520, 644, 263, 25);
        contentPane.add(btnComenzarJuego);

        /** Los valores de la array de caaracteres
         * de la clase cTableroCalculos se llenan
         * de espacios en blanco ' ' */
        tc.reinicializarTableros();

        this.setVisible(true);
    }
}
