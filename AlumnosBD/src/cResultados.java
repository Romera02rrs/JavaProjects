import sun.font.CreatedFontTracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class cResultados {

    public String apellido, abreviatura;
    public int NIA, nota;

    public ArrayList<cResultados> calculaResultados(int NIA, boolean todos) throws SQLException {

        ArrayList<cResultados> resultados;
        resultados = new ArrayList<>();

        String strQuery;

        cConectaBD con = new cConectaBD();
        if(todos == true){

            strQuery = "SELECT ALUMNOS.NIA, ALUMNOS.apellido, ASIGNATURAS.abreviatura, RESULTADOS.nota " +
                    "FROM ALUMNOS " +
                    "INNER JOIN RESULTADOS ON ALUMNOS.NIA = RESULTADOS.ALUMNOS_NIA " +
                    "INNER JOIN ASIGNATURAS ON ASIGNATURAS.codigo = RESULTADOS.ASIGNATURAS_codigo";
        }else{
             strQuery = "SELECT ALUMNOS.NIA, ALUMNOS.apellido, ASIGNATURAS.abreviatura, RESULTADOS.nota " +
                    "FROM ALUMNOS " +
                    "INNER JOIN RESULTADOS ON ALUMNOS.NIA = RESULTADOS.ALUMNOS_NIA " +
                    "INNER JOIN ASIGNATURAS ON ASIGNATURAS.codigo = RESULTADOS.ASIGNATURAS_codigo " +
                    "WHERE ALUMNOS.NIA = " + NIA;
        }
        ResultSet rs = con.ExecutarSQL(strQuery);

        while(rs.next()) {
            cResultados r = new cResultados();
            r.NIA = rs.getInt("nia");
            r.apellido = rs.getString("apellido");
            r.abreviatura = rs.getString("abreviatura");
            r.nota = rs.getInt("nota");
            resultados.add(r);
        }
        return resultados;
    }

    public String toString() {
        return this.NIA + ", " + this.apellido + ", " + this.abreviatura + ", " + this.nota;
    }
}
