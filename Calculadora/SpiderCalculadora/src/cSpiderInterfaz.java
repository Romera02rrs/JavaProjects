import java.awt.*;
import javax.script.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class cSpiderInterfaz extends JFrame {

    cSpiderCalculos calculos = new cSpiderCalculos();

    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByName("JavaScript");

    private Color transparente = new Color(0,0,0,0);
    private Color translucido = new Color(0,0,0,100);
    private Color rojoPastel = new Color(255, 118, 112, 150);
    private Color azulPastel = new Color(110, 170, 255, 150);

    //LineBorder roundedLineBorder = new LineBorder(translucido, 5, true);

    private JPanel contentPane;
    private JTextField pantalla;
    private JPanel panelTeclado;
    private JPanel panelBtnIgual;
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
    private JButton btn_15_Bor;
    private JButton btn_16_Sum;
    private JButton btn_Igual;
    private JPanel panelColorNumeros;
    private JPanel panelColorIgual;
    private JPanel panelColorPantalla;

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
        setTitle("SpiderCalculadora");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /** Pantalla */
        pantalla = new JTextField();
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pantalla.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 30));
        pantalla.setForeground(SystemColor.text);
        pantalla.setOpaque(false);
        pantalla.setBounds(20, 20, 445, 50);
        contentPane.add(pantalla);
        pantalla.setColumns(10);
        pantalla.setBackground(Color.WHITE);

        /** Panel teclado */
        panelTeclado = new JPanel();
        panelTeclado.setOpaque(false);
        panelTeclado.setLayout(new GridLayout(0, 4, 0, 0));
        panelTeclado.setBounds(56, 230, 370, 370);
        contentPane.add(panelTeclado);

        /** Panel Boton Igual */
        panelBtnIgual = new JPanel();
        panelBtnIgual.setOpaque(false);
        panelBtnIgual.setLayout(new GridLayout());
        panelBtnIgual.setBounds(341, 145, 85, 85);
        contentPane.add(panelBtnIgual);

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
                InsertaNumero("X");
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

        /** Boton Borrar */
        btn_15_Bor = new JButton("C");
        //Listener
        btn_15_Bor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("");
            }
        });
        btn_15_Bor.setBorderPainted(false);
        btn_15_Bor.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_15_Bor.setForeground(SystemColor.controlHighlight);
        btn_15_Bor.setOpaque(false);
        btn_15_Bor.setFocusable(false);
        btn_15_Bor.setBackground(rojoPastel);
        panelTeclado.add(btn_15_Bor);

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

        /** Boton Igual */
        btn_Igual = new JButton("=");
        //Listener
        btn_Igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertaNumero("=");
                try {
                    String resultado = se.eval(pantalla.getText()).toString();
                    System.out.println(resultado);
                }catch (Exception exc){
                    pantalla.setText("Syntax ERROR");
                }
            }
        });
        btn_Igual.setBorderPainted(false);
        btn_Igual.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 60));
        btn_Igual.setForeground(SystemColor.controlHighlight);
        btn_Igual.setOpaque(false);
        btn_Igual.setFocusable(false);
        btn_Igual.setBackground(azulPastel);
        panelBtnIgual.add(btn_Igual);

        /** Panel translucido del teclado */
        panelColorNumeros = new JPanel();
        //panelColorNumeros.setBorder(roundedLineBorder);
        panelColorNumeros.setBounds(56, 230, 370, 370);
        panelColorNumeros.setBackground(translucido);
        contentPane.add(panelColorNumeros);

        /** Panel translucido del Igual */
        panelColorIgual = new JPanel();
        panelColorIgual.setBounds(341, 145, 85, 85);
        panelColorIgual.setBackground(translucido);
        contentPane.add(panelColorIgual);

        /** Panel translucido de la pantalla */
        panelColorPantalla = new JPanel();
        panelColorPantalla.setBounds(20, 20, 445, 50);
        panelColorPantalla.setBackground(translucido);
        contentPane.add(panelColorPantalla);

        /** Label con la imagen de fondo */
        JLabel Fondo = new JLabel("");
        Fondo.setIcon(new ImageIcon("src\\imagenes\\SpiderFondo.png"));
        Fondo.setBounds(0, 0, 494, 671);
        contentPane.add(Fondo);
    }

    public void InsertaNumero(String numero){

        pantalla.setText(pantalla.getText()+numero);
    }
}
