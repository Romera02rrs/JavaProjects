import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cSpiderInterfaz extends JFrame {

    cSpiderCalculos calculo = new cSpiderCalculos();

    private String rutaFondo = "src/Imagenes/SpiderFondo.png";
    private Color transparente = new Color(0,0,0,0);
    private Color translucido = new Color(0,0,0,100);
    private Color rojoPastel = new Color(255, 118, 112, 150);
    private Color azulPastel = new Color(110, 170, 255, 150);

    //LineBorder roundedLineBorder = new LineBorder(translucido, 5, true);

    private JPanel marco;
    private JTextField pantallaOperacion;
    private JTextField pantallaResultado;
    private JTextField pantallaOperacionMemoria;
    private JPanel panelTeclado;
    private JPanel panelBtnBorrar;
    private JButton btn_1_7;
    private JButton btn_2_8;
    private JButton btn_3_9;
    private JButton btn_4_Div;
    private JButton btn_5_4;
    private JButton btn_6_5;
    private JButton btn_7_6;
    private JButton btn_8_Mul;
    private JButton btn_9_1;
    private JButton btn_10_2;
    private JButton btn_11_3;
    private JButton btn_12_Res;
    private JButton btn_13_0;
    private JButton btn_14_Com;
    private JButton btn_15_Igu;
    private JButton btn_16_Sum;
    private JButton btn_Borrar;
    private JPanel panelColorNumeros;
    private JPanel panelColorBorrar;
    private JPanel panelColorPantallaOperacion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cSpiderInterfaz frame = new cSpiderInterfaz();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public cSpiderInterfaz() {

        /** Frame */
        super("SpiderCalculadora");
        setSize(490, 695);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        /** marco */
        marco = new JPanel();
        marco.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(marco);
        marco.setLayout(null);

        /** Pantalla operacion */
        pantallaOperacion = new JTextField();
        //pantallaOperacion.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pantallaOperacion.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 30));
        pantallaOperacion.setOpaque(false);
        pantallaOperacion.setForeground(SystemColor.text);
        pantallaOperacion.setBounds(20, 20, 445, 50);
        marco.add(pantallaOperacion);
        pantallaOperacion.setColumns(10);
        pantallaOperacion.setBackground(Color.WHITE);

        /** Pantalla resultado */
        pantallaResultado = new JTextField();
        //pantallaResultado.setComponentOrientation(ComponentOrientation);
        pantallaResultado.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 30));
        pantallaResultado.setForeground(SystemColor.text);
        pantallaResultado.setOpaque(false);
        pantallaResultado.setBounds(20, 68, 300, 50);
        marco.add(pantallaResultado);
        pantallaResultado.setColumns(10);
        pantallaResultado.setBackground(Color.WHITE);

        //** Operacion en memoria */
        pantallaOperacionMemoria = new JTextField();
        pantallaOperacionMemoria.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 20));
        pantallaOperacionMemoria.setForeground(SystemColor.text);
        pantallaOperacionMemoria.setOpaque(false);
        pantallaOperacionMemoria.setBounds(318, 68, 147, 50);;
        marco.add(pantallaOperacionMemoria);
        pantallaOperacion.setColumns(10);
        pantallaOperacionMemoria.setBackground(Color.WHITE);

        /** Panel teclado */
        panelTeclado = new JPanel();
        panelTeclado.setOpaque(false);
        panelTeclado.setLayout(new GridLayout(0, 4, 0, 0));
        panelTeclado.setBounds(56, 230, 370, 370);
        marco.add(panelTeclado);

        /** Panel Boton Borrar */
        panelBtnBorrar = new JPanel();
        panelBtnBorrar.setOpaque(false);
        panelBtnBorrar.setLayout(new GridLayout());
        panelBtnBorrar.setBounds(341, 145, 85, 85);
        marco.add(panelBtnBorrar);

        /** Boton 7 */
        btn_1_7 = new JButton("7");
        //Listener
        btn_1_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("7");
            }
        });
        btn_1_7.setBorderPainted(false);
        btn_1_7.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_1_7.setForeground(SystemColor.controlHighlight);
        btn_1_7.setOpaque(false);
        btn_1_7.setFocusable(false);
        btn_1_7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btn_1_7.setBackground(azulPastel);
        panelTeclado.add(btn_1_7);

        /** Boton 8 */
        btn_2_8 = new JButton("8");
        //Listener
        btn_2_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("8");
            }
        });
        btn_2_8.setBorderPainted(false);
        btn_2_8.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_2_8.setForeground(SystemColor.controlHighlight);
        btn_2_8.setOpaque(false);
        btn_2_8.setFocusable(false);
        btn_2_8.setBackground(rojoPastel);
        panelTeclado.add(btn_2_8);

        /** Boton 9 */
        btn_3_9 = new JButton("9");
        //Listener
        btn_3_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("9");
            }
        });
        btn_3_9.setBorderPainted(false);
        btn_3_9.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_3_9.setForeground(SystemColor.controlHighlight);
        btn_3_9.setOpaque(false);
        btn_3_9.setFocusable(false);
        btn_3_9.setBackground(azulPastel);
        panelTeclado.add(btn_3_9);

        /** Boton Div */
        btn_4_Div = new JButton("/");
        //Listener
        btn_4_Div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("/");
            }
        });
        btn_4_Div.setBorderPainted(false);
        btn_4_Div.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_4_Div.setForeground(SystemColor.controlHighlight);
        btn_4_Div.setOpaque(false);
        btn_4_Div.setFocusable(false);
        btn_4_Div.setBackground(rojoPastel);
        panelTeclado.add(btn_4_Div);

        /** Boton 4 */
        btn_5_4 = new JButton("4");
        //Listener
        btn_5_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("4");
            }
        });
        btn_5_4.setBorderPainted(false);
        btn_5_4.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_5_4.setForeground(SystemColor.controlHighlight);
        btn_5_4.setOpaque(false);
        btn_5_4.setFocusable(false);
        btn_5_4.setBackground(rojoPastel);
        panelTeclado.add(btn_5_4);

        /** Boton 5 */
        btn_6_5 = new JButton("5");
        //Listener
        btn_6_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("5");
            }
        });
        btn_6_5.setBorderPainted(false);
        btn_6_5.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_6_5.setForeground(SystemColor.controlHighlight);
        btn_6_5.setOpaque(false);
        btn_6_5.setFocusable(false);
        btn_6_5.setBackground(azulPastel);
        panelTeclado.add(btn_6_5);

        /** Boton 6 */
        btn_7_6 = new JButton("6");
        //Listener
        btn_7_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("6");
            }
        });
        btn_7_6.setBorderPainted(false);
        btn_7_6.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_7_6.setForeground(SystemColor.controlHighlight);
        btn_7_6.setOpaque(false);
        btn_7_6.setFocusable(false);
        btn_7_6.setBackground(rojoPastel);
        panelTeclado.add(btn_7_6);

        /** Boton Mul */
        btn_8_Mul = new JButton("X");
        //Listener
        btn_8_Mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("*");
            }
        });
        btn_8_Mul.setBorderPainted(false);
        btn_8_Mul.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_8_Mul.setForeground(SystemColor.controlHighlight);
        btn_8_Mul.setOpaque(false);
        btn_8_Mul.setFocusable(false);
        btn_8_Mul.setBackground(azulPastel);
        panelTeclado.add(btn_8_Mul);

        /** Boton 1 */
        btn_9_1 = new JButton("1");
        //Listener
        btn_9_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("1");
            }
        });
        btn_9_1.setBorderPainted(false);
        btn_9_1.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_9_1.setForeground(SystemColor.controlHighlight);
        btn_9_1.setOpaque(false);
        btn_9_1.setFocusable(false);
        btn_9_1.setBackground(azulPastel);
        panelTeclado.add(btn_9_1);

        /** Boton 2 */
        btn_10_2 = new JButton("2");
        //Listener
        btn_10_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("2");
            }
        });
        btn_10_2.setBorderPainted(false);
        btn_10_2.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_10_2.setForeground(SystemColor.controlHighlight);
        btn_10_2.setOpaque(false);
        btn_10_2.setFocusable(false);
        btn_10_2.setBackground(rojoPastel);
        panelTeclado.add(btn_10_2);

        /** Boton 3 */
        btn_11_3 = new JButton("3");
        //Listener
        btn_11_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("3");
            }
        });
        btn_11_3.setBorderPainted(false);
        btn_11_3.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_11_3.setForeground(SystemColor.controlHighlight);
        btn_11_3.setOpaque(false);
        btn_11_3.setFocusable(false);
        btn_11_3.setBackground(azulPastel);
        panelTeclado.add(btn_11_3);

        /** Boton Res */
        btn_12_Res = new JButton("-");
        //Listener
        btn_12_Res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("-");
            }
        });
        btn_12_Res.setBorderPainted(false);
        btn_12_Res.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_12_Res.setForeground(SystemColor.controlHighlight);
        btn_12_Res.setOpaque(false);
        btn_12_Res.setFocusable(false);
        btn_12_Res.setBackground(rojoPastel);
        panelTeclado.add(btn_12_Res);

        /** Boton 0 */
        btn_13_0 = new JButton("0");
        //Listener
        btn_13_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("0");
            }
        });
        btn_13_0.setBorderPainted(false);
        btn_13_0.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_13_0.setForeground(SystemColor.controlHighlight);
        btn_13_0.setOpaque(false);
        btn_13_0.setFocusable(false);
        btn_13_0.setBackground(rojoPastel);
        panelTeclado.add(btn_13_0);

        /** Boton Coma */
        btn_14_Com = new JButton(",");
        //Listener
        btn_14_Com.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero(",");
            }
        });
        btn_14_Com.setBorderPainted(false);
        btn_14_Com.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_14_Com.setForeground(SystemColor.controlHighlight);
        btn_14_Com.setOpaque(false);
        btn_14_Com.setFocusable(false);
        btn_14_Com.setBackground(azulPastel);
        panelTeclado.add(btn_14_Com);

        /** Boton Igual */
        btn_15_Igu = new JButton("=");
        //Listener
        btn_15_Igu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Llama al metodo para que se prepare la ejecucion del calculo
                prepararOperacion();
            }
        });
        btn_15_Igu.setBorderPainted(false);
        btn_15_Igu.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_15_Igu.setForeground(SystemColor.controlHighlight);
        btn_15_Igu.setOpaque(false);
        btn_15_Igu.setFocusable(false);
        btn_15_Igu.setBackground(azulPastel);
        panelTeclado.add(btn_15_Igu);

        /** Boton Suma */
        btn_16_Sum = new JButton("+");
        //Listener
        btn_16_Sum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("+");
            }
        });
        btn_16_Sum.setBorderPainted(false);
        btn_16_Sum.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_16_Sum.setForeground(SystemColor.controlHighlight);
        btn_16_Sum.setOpaque(false);
        btn_16_Sum.setFocusable(false);
        btn_16_Sum.setBackground(azulPastel);
        panelTeclado.add(btn_16_Sum);

        /** Boton Borrar */
        btn_Borrar = new JButton("C");
        //Listener
        btn_Borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantallaOperacion.setText("");
            }
        });
        btn_Borrar.setBorderPainted(false);
        btn_Borrar.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_Borrar.setForeground(SystemColor.controlHighlight);
        btn_Borrar.setOpaque(false);
        btn_Borrar.setFocusable(false);
        btn_Borrar.setBackground(rojoPastel);
        panelBtnBorrar.add(btn_Borrar);

        /** Panel translucido del teclado */
        panelColorNumeros = new JPanel();
        //panelColorNumeros.setBorder(roundedLineBorder);
        panelColorNumeros.setBounds(56, 230, 370, 370);
        panelColorNumeros.setBackground(translucido);
        marco.add(panelColorNumeros);

        /** Panel translucido del boton borrar */
        panelColorBorrar = new JPanel();
        panelColorBorrar.setBounds(341, 145, 85, 85);
        panelColorBorrar.setBackground(translucido);
        marco.add(panelColorBorrar);

        /** Panel translucido de las pantallas */
        panelColorPantallaOperacion = new JPanel();
        panelColorPantallaOperacion.setBounds(20, 20, 445, 98);
        panelColorPantallaOperacion.setBackground(translucido);
        marco.add(panelColorPantallaOperacion);

        /** Label con la imagen de fondo */
        JLabel Fondo = new JLabel("");
        Fondo.setIcon(new ImageIcon(rutaFondo));
        Fondo.setBounds(0, 0, 494, 671);
        marco.add(Fondo);
    }

    public void InsertaNumero(String numero){

        pantallaOperacion.setText(pantallaOperacion.getText()+numero);
    }

    private void prepararOperacion(){

        //Guarda en un string la opracion escrita por pantalla
        String operacion = pantallaOperacion.getText();
        //restablece la pantalla
        pantallaOperacion.setText("");
        //Establece la operacion en el panel de memoria
        pantallaOperacionMemoria.setText(" " + operacion);
        //Llama al metodo calcula del objeto calculo para que realice la operacion.
        pantallaResultado.setText(calculo.calcula(operacion));
    }
}
