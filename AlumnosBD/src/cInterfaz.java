import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class cInterfaz extends JFrame {

    private cAlumnos a = new cAlumnos();
    private cResultados r = new cResultados();

    private int NIA;

    private DefaultListModel<cAlumnos> dlmAlumnos;
    private DefaultTableModel dtmAlumnos;

    private DefaultListModel<cResultados> dlmResultados;
    private DefaultTableModel dtmResultados;

    private ArrayList<cAlumnos> listaAlumnos;
    private ArrayList<cResultados> resultados;

    private JPanel contentPane;
    private JList lista;
    private JTable tabla;
    private JLabel lblAlumnos;
    private JLabel lblResultados;
    private JButton limpiar;
    private JButton mostrarTodo;

    private Font titulos;
    private Font texto;

    private LineBorder borde;

    private Color azul;
    private Color negro;
    private Color verde;
    private Color rojo;
    private Color morado;
    private Color amarillo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cInterfaz frame = new cInterfaz();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void cargarAlumnos() throws SQLException {

        listaAlumnos = a.cargarAlumnos();

    }

    private void cargarResultados() {

        try {
            resultados = r.calculaResultados(NIA, false);
        }catch (SQLException sql){
            System.out.println(ERROR);
        }
        insertarResultados();
        insertarTablaResultados();
    }

    private void insertarAlumnos() {

        Iterator<cAlumnos> iter;
        iter = listaAlumnos.iterator();
        while (iter.hasNext()) {
            cAlumnos a = iter.next();
            dlmAlumnos.addElement(a);
        }
    }

    private void insertarResultados(){

        Iterator<cResultados> iter;
        iter = resultados.iterator();
        while (iter.hasNext()) {
            cResultados r = iter.next();
            dlmResultados.addElement(r);
        }
    }

    private void insertarTablaAlumnos(int index) {

        dtmAlumnos.setRowCount(0);

        cAlumnos a = listaAlumnos.get(index);

        Object[] fila = new Object[3];
        fila[0] = a.nombre;
        fila[1] = a.apellido;
        fila[2] = a.NIA;

        dtmAlumnos.addRow(fila);

        NIA = a.NIA;
    }

    private void insertarTablaResultados(){

        dtmResultados.setRowCount(0);

        int contador = resultados.size();

        do {

            cResultados r = resultados.get(contador-1);

            contador --;

            Object[] fila2 = new Object[4];
            fila2[0] = r.NIA;
            fila2[1] = r.apellido;
            fila2[2] = r.abreviatura;
            fila2[3] = r.nota;

            dtmResultados.addRow(fila2);
        }while (contador != 0);

    }

    private void cargarTablaAlumnos(){

        dtmAlumnos.addColumn("Nombre");
        dtmAlumnos.addColumn("Apellidos");
        dtmAlumnos.addColumn("Telefono");
    }

    private void cargarTablaResultados(){

        dtmResultados.addColumn("NIA");
        dtmResultados.addColumn("Apellido");
        dtmResultados.addColumn("Abreviatura");
        dtmResultados.addColumn("Nota");
    }

    private void borrarTablaResultados(){

        dtmResultados.setRowCount(0);
    }

    private void mostrarTodo(){


        try {
            resultados = r.calculaResultados(0, true);
        }catch (SQLException sql){
            System.out.println(ERROR);
        }
        insertarResultados();
        insertarTablaResultados();
    }


    /**
     * Create the frame.
     */
    private cInterfaz() throws SQLException {

        super("Alumnos - Notas");

        dlmAlumnos = new DefaultListModel();
        dtmAlumnos = new DefaultTableModel();

        dlmResultados = new DefaultListModel();
        dtmResultados = new DefaultTableModel();

        cargarAlumnos();
        insertarAlumnos();

        cargarTablaAlumnos();
        cargarTablaResultados();

        /** Colores */
        azul = new Color(72, 158, 234);
        negro = new Color(40, 44, 52);
        verde = new Color(85, 168, 118);
        rojo = new Color(215, 86, 109);
        morado = new Color(176, 90, 155);
        amarillo = new Color(229, 192, 123);

        /** Fuentes */
        titulos = new Font("Liberation Mono", Font.BOLD, 30);
        texto = new Font("Arial", Font.BOLD, 15);

        /** Bordes */

        borde = new LineBorder(Color.black, 2, false);


        /** Content Pane */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(negro);
        setContentPane(contentPane);

        /** Lista */
        lista = new JList(dlmAlumnos);
        lista.setBounds(100, 100, 300, 500);
        lista.setBackground(Color.lightGray);
        lista.setFont(texto);
        lista.setBorder(borde);
        lista.setBackground(amarillo);
        lista.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarTablaAlumnos(lista.getSelectedIndex());
                cargarResultados();
            }
        });
        contentPane.add(lista);

        /** Tabla */
        tabla = new JTable(dtmResultados);
        tabla.setBounds(450, 100, 700, 500);
        tabla.setBackground(Color.lightGray);
        tabla.setFont(texto);
        tabla.setBorder(borde);
        tabla.setBackground(amarillo);
        tabla.enable(false);
        contentPane.add(tabla);

        /** Label Alumnos */
        lblAlumnos = new JLabel("Alumos");
        lblAlumnos.setBounds(200, 40, 300, 50);
        lblAlumnos.setFont(titulos);
        lblAlumnos.setForeground(Color.lightGray);
        contentPane.add(lblAlumnos);

        /** Label Resultados */
        lblResultados = new JLabel("Resultados");
        lblResultados.setBounds(700, 40, 300, 50);
        lblResultados.setFont(titulos);
        lblResultados.setForeground(Color.lightGray);
        contentPane.add(lblResultados);

        /** Boton Borrar */
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(600, 620, 100, 50);
        limpiar.setFocusable(false);
        limpiar.setBackground(amarillo);
        limpiar.setBorder(borde);
        limpiar.setForeground(negro);
        limpiar.setFont(texto);
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarTablaResultados();
            }
        });
        contentPane.add(limpiar);

        /** Boton Mostrar Todo */
        mostrarTodo = new JButton("Todo");
        mostrarTodo.setBounds(850, 620, 100, 50);
        mostrarTodo.setFocusable(false);
        mostrarTodo.setFont(texto);
        mostrarTodo.setBackground(amarillo);
        mostrarTodo.setBorder(borde);
        mostrarTodo.setForeground(negro);
        mostrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodo();
            }
        });
        contentPane.add(mostrarTodo);
    }
}
