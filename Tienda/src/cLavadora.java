import java.util.Arrays;

public class cLavadora extends cElectrodomestico {

    String arrayProgramas[] = new String[7];

    public cLavadora(){
        //setProgramas();
    }

    public cLavadora(String str){

        if(!str.isEmpty()){
            String[] info = str.split(";");
            numRef = Integer.parseInt(info[0]);
            nombre = info[1];
            marca = info[2];
            modelo = info[3];
            EE = info[4];
            cantidad = Integer.parseInt(info[5]);
            PVP = Integer.parseInt(info[6]);
            potenciaW = Integer.parseInt(info[7]);
            programas = Integer.parseInt(info[8]);
        }
    }

    public String toString(cElectrodomestico c){
        return "Numero de referencia -> " + numRef + "\n" +
                "Tipo -> " + nombre + "\n" +
                "Marca -> " + marca + "\n" +
                "Modelo -> " + modelo + "\n" +
                "Eficiencia Energetica -> " + EE + "\n" +
                "Cantidad -> " + cantidad + "\n" +
                "Precio de benta al publico -> " + PVP + "\n" +
                "Potencia -> " + potenciaW + "\n" +
                "Programas -> " + programas + "\n\n";
    }

    private void setProgramas(){
        arrayProgramas [0] = "Prelavado";
        arrayProgramas [1] = "Delicado";
        arrayProgramas [2] = "Lana";
        arrayProgramas [3] = "Algodón";
        arrayProgramas [4] = "Sintéticos";
        arrayProgramas [5] = "Ropa oscura";
        arrayProgramas [6] = "Rápido";
    }
}
