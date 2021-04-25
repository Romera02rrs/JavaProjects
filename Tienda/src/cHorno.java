public class cHorno extends cElectrodomestico {

    public int potenciaW;
    public double volumenLitros;

    public cHorno(){

    }

    public cHorno(String str){

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
            volumenLitros = Integer.parseInt(info[8]);
        }
    }

    public String toString(cElectrodomestico c){
        return "Numero de referencia -> " + numRef + "\n" +
                "Tipo -> " + nombre + "\n" +
                "Marca -> " + marca + "\n" +
                "Modelo -> " + modelo + "\n" +
                "Eficiencia Energetica -> " + EE + "\n" +
                "Cantidad -> " + cantidad + "\n" +
                "Precio de benta al publico -> "+ PVP + "\n" +
                "Potencia -> " + potenciaW + "\n" +
                "Volumen litros -> " + volumenLitros + "\n\n";
    }
}
