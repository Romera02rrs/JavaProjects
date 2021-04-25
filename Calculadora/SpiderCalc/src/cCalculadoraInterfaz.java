import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class cSpiderInterfaz extends JFrame {

    private Color transarente = new Color(0,0,0,0);
    private Color translucido = new Color(0,0,0,50);
    private JPanel contentPane;
    private JTextField pantalla;

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public cSpiderInterfaz() {
        setTitle("SpiderCalculadora");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        pantalla = new JTextField();
        pantalla.setBounds(20, 20, 445, 50);
        contentPane.add(pantalla);
        pantalla.setColumns(10);
        pantalla.setBackground(translucido);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setSize(370, 370);
        panel.setLocation(56, 230);
        panel.setBackground(translucido);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
    }
}
