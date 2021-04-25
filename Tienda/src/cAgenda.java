import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class cAgenda {

    Scanner sc = new Scanner(System.in);
    cTienda ti = new cTienda();

    //Declaracion de la array que almacenara todos los objetos de tipo cliente
    private ArrayList<cCliente> listaCliente;

    public cAgenda(){

        listaCliente = new ArrayList<>();
        cargaClientes();
    }

    //Metodo que añade un cliente a la lista de clientes
    public void nuevoCliente(cCliente c){

        this.listaCliente.add(c);
    }



    //Metodo que comprueba que el NIF introducido exista
    public String pedirNIF(){

        String NIF;
        do{
            System.out.print("Introduce el NIF del cliente: ");
            NIF = sc.next();
            Iterator<cCliente> iter;
            iter = this.listaCliente.iterator();
            while (iter.hasNext()){
                cCliente c = (cCliente) iter.next();
                if (c.NIF.equalsIgnoreCase(NIF)){
                    return NIF;
                }
            }
            System.err.println("El NIF introducido no existe");
        }while(true);
    }

    //Metodo que devuelve un cliente
    public cCliente dameCliente(){

        String NIF;
        NIF = pedirNIF();
        Iterator<cCliente> iter;
        iter = this.listaCliente.iterator();
        while (iter.hasNext()){
            cCliente c = (cCliente) iter.next();
            if (c.NIF.equalsIgnoreCase(NIF)){
                return c;
            }
        }
        return null;
    }

    //Metodo que sustituyea la posicion del un objeto de la array de clientes por un objeto nuevo que crees.
    public void editarClientes(){

        int contador = -1;
        String NIF;
        NIF = pedirNIF();
        Iterator<cCliente> iter;
        iter = this.listaCliente.iterator();
        while (iter.hasNext()){
            contador ++;
            cCliente c = (cCliente) iter.next();
            if (c.NIF.equalsIgnoreCase(NIF)){
                this.listaCliente.set(contador, ti.pedirCliente());
                return;
            }
        }
    }

    //Metodo que borra el cliente de la array buscandolo por su NIF
    public void borrarCliente(){

       String NIF;
       NIF = pedirNIF();
       Iterator<cCliente> iter;
       iter = this.listaCliente.iterator();
       while (iter.hasNext()){
           cCliente c = (cCliente) iter.next();
           if (c.NIF.equalsIgnoreCase(NIF)){
               this.listaCliente.remove(c);
               System.out.println("Cliente borrado con Exito");
               return;
           }
       }
    }

    //Metodo que da de alta un nuevo cliente
    public void altaCliente(){

        cCliente c = ti.pedirCliente();
        nuevoCliente(c);
    }

    //Metodo que carga desde el fichero Clientes.txt los clientes a la array de clientes
    public void cargaClientes(){

        try{
            File f = new File("src/Clientes.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                String strLine = s.nextLine();
                cCliente c = new cCliente(strLine);
                this.nuevoCliente(c);
            }
        }catch(FileNotFoundException e){
            System.out.println("no se encuentra al cliente");
        }
    }

    //Metodo que a devuelve la lista de clientes
    public ArrayList<cCliente> listaClientes(){

        return this.listaCliente;
    }
}