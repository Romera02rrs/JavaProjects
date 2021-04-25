import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;

public class cInterfazCalculadora{

    private cCalculadora calc = new cCalculadora();
    private JFrame frame;
    private JPanel panelSuperior, panelInferior;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btSum, btRes, btMul, btDiv, btIgual, btPunto;
    private JTextField pantalla;

    public static void main(String [] args){
        cInterfazCalculadora IC = new cInterfazCalculadora();
        IC.aplicar();
    }

    public cInterfazCalculadora(){
        construyePanelSuperior();
        construyePanelInferior();
        construyeVentana();
    }

    public void construyePanelSuperior(){
        panelSuperior = new JPanel ();
        panelSuperior.setLayout(new FlowLayout());
        pantalla = new JTextField(25);
        panelSuperior.setBackground(Color.RED);
        panelSuperior.add(pantalla);
    }

    public void construyePanelInferior(){
        panelInferior= new JPanel();
        panelInferior.setLayout(new GridLayout(5,4,8,8));
        panelInferior.setBackground(Color.BLACK);
        bt1=new JButton("1");
        //.setMargin();
        /*bt1.setBackground(Color.RED);
        bt1.setBorderPainted(false);*/
        bt2=new JButton("2");
        bt3=new JButton("3");
        bt4=new JButton("4");
        bt5=new JButton("5");
        bt6=new JButton("6");
        bt7=new JButton("7");
        bt8=new JButton("8");
        bt9=new JButton("9");
        bt0=new JButton("0");
        btSum=new JButton("+");
        btRes=new JButton("-");
        btDiv=new JButton("/");
        btMul=new JButton("x");
        btIgual=new JButton("=");
        btPunto=new JButton(".");
        panelInferior.add(bt7);
        panelInferior.add(bt8);
        panelInferior.add(bt9);
        panelInferior.add(btSum);
        panelInferior.add(bt4);
        panelInferior.add(bt5);
        panelInferior.add(bt6);
        panelInferior.add(btRes);
        panelInferior.add(bt1);
        panelInferior.add(bt2);
        panelInferior.add(bt3);
        panelInferior.add(btMul);
        panelInferior.add(bt0);
        panelInferior.add(btPunto);
        panelInferior.add(btIgual);
        panelInferior.add(btDiv);
    }

    public void construyeVentana(){
        frame =new JFrame("Calculadora ");
        frame.setBounds(500,500,500,500);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.setSize(370, 580);
        frame.add(panelSuperior);
        frame.add(panelInferior);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void aplicar(){

        String resultadoTxt;
        resultadoTxt = calc.calcula("100+1000");

        pantalla.setText(resultadoTxt);
    }
}
