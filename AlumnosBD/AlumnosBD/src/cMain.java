/*
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class cMain {

    public ArrayList<cAlumnos> listaAlumnos;

    public static cInterfaz interfaz;

    static {
        try {
            interfaz = new cInterfaz();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void hola(String[] args) throws SQLException {
        cMain main = new cMain();
        interfaz.iniciarInterfaz();
        main.cargarAlumnos();
        main.listarAlumnos();
    }

    public cMain(){

        listaAlumnos = new ArrayList<>();
    }

    public void cargarAlumnos() throws SQLException {

        cAlumnos a = new cAlumnos();
        listaAlumnos = a.cargarAlumnos();

    }

    public void listarAlumnos() {

        Iterator<cAlumnos> iter;
        iter = listaAlumnos.iterator();
        while (iter.hasNext()) {
            cAlumnos a = iter.next();
            System.out.println(a.toString(a));
        }
    }
}
*/
