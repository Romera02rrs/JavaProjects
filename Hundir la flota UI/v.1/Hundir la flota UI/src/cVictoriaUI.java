import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class cVictoriaUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void ejecutaInterfaz(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cVictoriaUI frame = new cVictoriaUI();
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
    public cVictoriaUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("/home/romera/Escriptori/Downloads/youwin.jpg"));
        label.setBounds(0, -152, 1278, 692);
        contentPane.add(label);
    }
}
