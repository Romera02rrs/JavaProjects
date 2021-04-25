import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;

public class cCompra {

    Scanner sc = new Scanner(System.in);

    //Declaracion de la array de objetos donde se guadaran los tickets
    private ArrayList<cTicket> items;

    String fecha;
    int total;
    int cantidad;

    public cCompra(){

        items = new ArrayList<>();
    }

    //Metodo que crea una nueva compra
    public void nuevaCompra(cCliente comprador, cElectrodomestico ele){

        //Metodo que guarda en un String la fecha del sistema en el formato que le pida
        fecha = fechaActual();
        //Metodo que guarda en cantidad la cantidad de electrodomesticos comprados
        cantidad = dameCantidad(ele);
        //Metodo que calcula el precio de todos los electrodomesticos comprados
        total = dameTotal(ele, cantidad);
        //Metodos que crean el ticket y lo añaden a la array de tickets
        nuevoTicket(crearTicket(comprador, ele, cantidad, total, fecha));
    }

    //Metodo que me devuelve la fecha del sistema en el formato escogido
    public static String fechaActual(){

        Date fecha = new Date();
        SimpleDateFormat estableceFecha = new SimpleDateFormat("hh:mm - dd/MM/YYYY");

        return estableceFecha.format(fecha);
    }

    //Metodo que crea el ticket con la informacion que le pases por los parametros
    public cTicket crearTicket(cCliente comprador, cElectrodomestico ele,
                               int cantidad, int total, String fecha){

        cTicket ticket = new cTicket();

        ticket.nombre = comprador.nombre;
        ticket.apellido1 = comprador.apellido1;
        ticket.NIF = comprador.NIF;
        ticket.electrodomestico = ele.nombre;
        ticket.eleNumRef = ele.numRef;
        ticket.cantidad = cantidad;
        ticket.total = total;
        ticket.codigoTicket = dameCodigoTicket();
        ticket.fecha = fecha;
        return ticket;
    }

    //Devuelve un entero
    public int dameCantidad(cElectrodomestico ele){

        System.out.println("Introduce la cantidad de "+ele.nombre+": ");
        return cantidad = sc.nextInt();
    }

    //Devuelve el precio del electrodomestico por la cantidad
    public int dameTotal(cElectrodomestico ele, int cantidad){

        return ele.PVP * cantidad;
    }

    //Devuelve la array de tickets
    public ArrayList<cTicket> listaTickets() {

        return this.items;
    }

    //Inserta el objjeto de tipo ticket a la arraylist de tickets
    public void nuevoTicket(cTicket ticket){

        items.add(ticket);
    }

    //Metodo que calcula el codigo del ticket sumandole uno a el numero del ticket anerior
    public int dameCodigoTicket(){

        int codigoTicket = 0;
        Iterator<cTicket> iter;
        iter = this.items.iterator();
        while (iter.hasNext()){
            cTicket t = iter.next();
            codigoTicket = t.codigoTicket;
        }
        codigoTicket = codigoTicket +1;
        return codigoTicket;
    }
}


