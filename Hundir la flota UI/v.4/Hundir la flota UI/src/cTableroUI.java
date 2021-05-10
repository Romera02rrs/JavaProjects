import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cTableroUI extends JFrame implements ActionListener {

    Color translucido = new Color(0, 0,0, 100);

    private cTableroCalculos tc = new cTableroCalculos();
    private cDisparosUI dUI = new cDisparosUI();


    private JButton[][] btnOcupados = new JButton[8][8];

    private JPanel contentPane;
    private JPanel panelBotones;
    private JPanel panelBotonesColor;
    private JLabel pantalla;
    private JComboBox menuBarcos;
    private JLabel lblBarcos;
    private JPanel panelBarcos;
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
                if(verificarBarcosInsertados()){
                    setTextoPantalla("boton comenzar juego");
                }
            }
        }
    }

    public void pintarBarco(){

        for (int i = 0; i < tc.ocupados.length; i ++){
            for (int j = 0; j < tc.ocupados[i].length; j++){
                if(tc.ocupados[i][j] == ' '){
                    btnOcupados[i][j].setOpaque(false);
                    btnOcupados[i][j].setBackground(Color.white);
                }else if(tc.ocupados[i][j] == 'o'){
                    btnOcupados[i][j].setOpaque(true);
                    btnOcupados[i][j].setBackground(Color.blue);
                }else{
                    btnOcupados[i][j].setOpaque(true);
                    btnOcupados[i][j].setBackground(Color.BLACK);
                }
            }
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
                btnOcupados[i][j].setBorder(new LineBorder(Color.black, 2, false));
                btnOcupados[i][j].setOpaque(false);
                //btnOcupados[i][j].setFocusable(false);
                btnOcupados[i][j].setBackground(Color.WHITE);
                panelBotones.add(btnOcupados[i][j]);
            }
        }
    }

    public cTableroUI() {

        super("Hundir la Flota - Ruben Romera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setBorder(new LineBorder(Color.black, 3, false));
        panelBotones.setBounds(372, 72, 550, 550);
        panelBotones.setLayout(new GridLayout(8, 8));
        contentPane.add(panelBotones);

        /** Insertar los botones */
        insertarBotones();

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

        panelRdbt = new JPanel();
        panelRdbt.setOpaque(true);
        panelRdbt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Direccion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panelRdbt.setBounds(1000, 285, 230, 111);
        panelRdbt.setBackground(translucido);
        contentPane.add(panelRdbt);
        panelRdbt.setLayout(new GridLayout(0, 2, 0, 0));

        buttonGroup = new ButtonGroup();

        rdbtnVertical = new JRadioButton("Vertical");
        rdbtnVertical.setOpaque(false);
        buttonGroup.add(rdbtnVertical);
        panelRdbt.add(rdbtnVertical);

        rdbtnHorizontal = new JRadioButton("Horizontal");
        rdbtnHorizontal.setOpaque(false);
        buttonGroup.add(rdbtnHorizontal);
        panelRdbt.add(rdbtnHorizontal);

        panelBarcos = new JPanel();
        panelBarcos.setBackground(Color.BLUE);
        panelBarcos.setBounds(74, 28, 216, 631);
        contentPane.add(panelBarcos);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(Color.GREEN);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionConfirmar();
            }
        });
        btnConfirmar.setBounds(1041, 523, 173, 24);
        contentPane.add(btnConfirmar);

        pantalla = new JLabel("¡Bienvenido a Hundir la flota!");
        pantalla.setFont(new Font("Liberation Mono", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(SwingConstants.CENTER);
        pantalla.setBounds(372, 12, 550, 48);
        contentPane.add(pantalla);

        btnComenzarJuego = new JButton("¡Comenzar a Jugar!");
        btnComenzarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionComenzarJuego();
            }
        });
        btnComenzarJuego.setBounds(520, 644, 263, 25);
        contentPane.add(btnComenzarJuego);

        panelBotonesColor = new JPanel();
        panelBotonesColor.setBounds(372, 72, 550, 550);
        panelBotonesColor.setBackground(translucido);
        contentPane.add(panelBotonesColor);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("/media/romera/RRS-USB/shark2.gif"));
        lblNewLabel.setBounds(0, 0, 1264, 681);
        contentPane.add(lblNewLabel);

        tc.reinicializarTableros();

        this.setVisible(true);

    }
}
