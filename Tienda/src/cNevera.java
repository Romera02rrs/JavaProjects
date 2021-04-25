public class cNevera extends cElectrodomestico {

    public cNevera(){

    }

    public cNevera(String str){

        if(!str.isEmpty()){
            String[] info = str.split(";");
            numRef = Integer.parseInt(info[0]);
            nombre = info[1];
            marca = info[2];
            modelo = info[3];
            EE = info[4];
            cantidad = Integer.parseInt(info[5]);
            PVP = Integer.parseInt(info[6]);;
            alturaM = Integer.parseInt(info[7]);
            anchuraM = Integer.parseInt(info[8]);
            longitudM = Integer.parseInt(info[9]);
            congelador = info[10];
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
                "Altura en Metros -> " + alturaM + "\n" +
                "Anchura en Metros -> " + anchuraM + "\n" +
                "Longitud en metros -> "+ longitudM + "\n" +
                "Congelador -> " + congelador + "\n\n";
    }
}
