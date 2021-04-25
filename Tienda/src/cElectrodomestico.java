public class cElectrodomestico {

    //Variables que comparten todos los electrodomesticos
    protected int numRef;
    protected String nombre;
    protected String marca;
    protected String modelo;
    protected String EE;
    protected int cantidad;
    protected int PVP;

    //Estufa - Mictroondas - Horno - Lavadora
    protected int potenciaW;

    //Television
    protected String definicion;
    public int pulgadas;

    //Microondas - Horno
    protected int volumenLitros;

    //Nevera
    protected int alturaM;
    protected int anchuraM;
    protected int longitudM;
    protected String congelador;

    //Lavadora
    protected int programas;

    public cElectrodomestico(){
    }

    public String toString(cElectrodomestico c){
        return "Numero de referencia -> " + numRef + "\n" +
               "Tipo -> " + nombre + "\n" +
               "Marca -> " + marca + "\n" +
               "Modelo -> " + modelo + "\n" +
               "Eficiencia Energetica -> " + EE + "\n" +
               "Cantidad -> " + cantidad + "\n" +
               "Precio de benta al publico -> "+ PVP + "\n\n";
    }
}
