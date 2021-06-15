
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class cAlumnos {

    public int NIA;
    public String nombre;
    public String apellido;
    private String correo;
    private int telefono;

    public cAlumnos() {

    }

    public static ArrayList<cAlumnos> cargarAlumnos() throws SQLException {

        ArrayList<cAlumnos> alumnosBD;
        alumnosBD = new ArrayList<>();

        cConectaBD con = new cConectaBD();
        String strQuery = "SELECT * FROM ALUMNOS";
        ResultSet rs = con.ExecutarSQL(strQuery);

        while(rs.next()) {
            cAlumnos a = new cAlumnos();
            a.NIA = rs.getInt("nia");
            a.nombre = rs.getString("Nombre");
            a.apellido = rs.getString("apellido");
            a.correo = rs.getString("Correo");
            a.telefono = rs.getInt("Telefono");
            alumnosBD.add(a);
        }
        return alumnosBD;
    }

    public String toString() {
        return this.NIA + ", " + this.apellido + ", " + this.nombre;
    }
}
