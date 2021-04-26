import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class cSpiderCalculos {

    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByName("JavaScript");

    cSpiderCalculos(){
    }

    String calcula(String operacion){

        try {
            String resultado = se.eval(operacion).toString();
            return resultado;
        } catch (Exception eve) {
            return "Syntax ERROR";
        }
    }
}
