public class cTicket {

    //Todas las variables que almacenaran el ticket
    public String nombre;
    public String apellido1;
    public String NIF;
    public String electrodomestico;
    public int eleNumRef;
    public int cantidad;
    public int total;
    public int codigoTicket;
    public String fecha;

    public cTicket(){
    }

    //Salida por pantalla de la informacion del ticket
    public String toString(){
        return """
                nº del ticket ->"""+" "+codigoTicket+"""
                
                fecha de la compra ->"""+" "+fecha+"""
             
                comprador ->"""+" "+nombre+" "+apellido1+", DNI: "+NIF+"""
                                
                Electrodomestico"""+" "+eleNumRef+" ->  "+electrodomestico+", cantidad: "+cantidad+"""
                                
                Precio total ->"""+" "+total+"€\n";
    }
}
