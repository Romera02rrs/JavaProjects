import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class cStock {

    cTienda ti = new cTienda();
    Scanner sc = new Scanner(System.in);

    //Decalracion de las arrays de cada electrodomestico
    public ArrayList<cElectrodomestico> listaEstufa;
    public ArrayList<cElectrodomestico> listaTelevision;
    public ArrayList<cElectrodomestico> listaMicroondas;
    public ArrayList<cElectrodomestico> listaNevera;
    public ArrayList<cElectrodomestico> listaHorno;
    public ArrayList<cElectrodomestico> listaLavadora;
    //Decalracion de la array donde se guardaran todos los electrodomesticos
    public ArrayList<cElectrodomestico> listaElectrodomesticos;

    //Decalracion de los objetos de tipo electrodomestico
    public cEstufa e;
    public cTelevision t;
    public cMicroondas m;
    public cNevera n;
    public cHorno h;
    public cLavadora l;

    public cStock(){

        listaEstufa = new ArrayList<>();
        listaTelevision = new ArrayList<>();
        listaMicroondas = new ArrayList<>();
        listaNevera = new ArrayList<>();
        listaHorno = new ArrayList<>();
        listaLavadora = new ArrayList<>();
        listaElectrodomesticos = new ArrayList<>();
        //Metodo que llama a los ficheros de electrodomesticos y los introduce en sus arrays
        cargaElectrodomesticos();

        e = new cEstufa();
        t = new cTelevision();
        m = new cMicroondas();
        n = new cNevera();
        h = new cHorno();
        l = new cLavadora();

        //Insercion de todos los electrodomesticos en una unica array de electrodomesticos con un identificador
        listaElectrodomesticos.addAll(listaEstufa);
        listaElectrodomesticos.addAll(listaTelevision);
        listaElectrodomesticos.addAll(listaMicroondas);
        listaElectrodomesticos.addAll(listaNevera);
        listaElectrodomesticos.addAll(listaHorno);
        listaElectrodomesticos.addAll(listaLavadora);
    }

    //--------------------------------------------------------------------------------------//

    //Metodo que da de alta un nuevo electrodomestico, le puedes pasar el tipo ya predefinido o
    //si no tiene tipo te pide uno en insertarElectrodomestico(id)
    public void altaElectrodomestico(String id){

        cElectrodomestico ele = ti.insertarElectrodomestico(id);
        altaElectrodomestico(ele);
    }

    //Metodo que edita un electrodomestico creando uno nuevo
    public void editarElectrodomestico(){

        String id;
        int numRef;
        int contador = -1;

        id = dameID();
        numRef = compruebaNumRef(id);
        Iterator<cElectrodomestico> iter;
        iter = listaElectrodomesticos.iterator();
        while (iter.hasNext()){
            cElectrodomestico ele = iter.next();
            contador ++;
            if (ele.numRef == numRef && ele.nombre.equals(id)){
                this.listaElectrodomesticos.set(contador, ti.insertarElectrodomestico(id));
                return;
            }
        }
    }

    //Metodo que devuelve un electrodomestico que se encuentre en la array de electrodomesticos
    public cElectrodomestico dameElectrodomestico(){

        int numRef;
        String id;

        id = dameID();
        ti.mostrarUnElectrodomestico(id);
        numRef = compruebaNumRef(id);
        Iterator<cElectrodomestico> iter;
        iter = listaElectrodomesticos.iterator();
        while (iter.hasNext()){
            cElectrodomestico ele = iter.next();
            if(numRef == ele.numRef && ele.nombre.equals(id)) {
                return ele;
            }
        }
        return null;
    }

    //Metodo que devuelve un identificador de electrodomestico o su tipo
    public String dameID(){

        String opcion;
        do{
            System.out.println("Escoge el ID del electrodomestico");
            System.out.println("Escriba Estufa.txt\"E\" Television.txt\"T\" Microondas.txt\"M\"\n" +
                    "        Nevera.txt\"N\" Horno.txt\"H\" Lavadora.txt\"L\"");
            System.out.print("-> ");
            opcion = sc.next();
        }while (!(opcion.equalsIgnoreCase("E") || opcion.equalsIgnoreCase("T") ||
                  opcion.equalsIgnoreCase("M") || opcion.equalsIgnoreCase("N") ||
                  opcion.equalsIgnoreCase("H") || opcion.equalsIgnoreCase("L")));
                  opcion = opcion.toUpperCase();
        switch (opcion){
            case ("E") -> {
                return "Estufa";
            }
            case ("T") -> {
                return "Television";
            }
            case ("M") -> {
                return "Microondas";
            }
            case ("N") -> {
                return "Nevera";
            }
            case ("H") -> {
                return "Horno";
            }
            case ("L") -> {
                return "Lavadora";
            }
        }
        return null;
    }

    //Metodo que borra un electrodomestico de la array
    public void borrarElectrodomestico() {

        int numRef;
        String id;

        id = dameID();
        numRef = compruebaNumRef(id);
        Iterator<cElectrodomestico> iter;
        iter = listaElectrodomesticos.iterator();
        while (iter.hasNext()){
            cElectrodomestico ele = iter.next();
            if(numRef == ele.numRef && ele.nombre.equals(id)) {
                System.out.println("EXITO");
                this.listaElectrodomesticos.remove(ele);
                return;
            }
        }
    }

    //Este metood verifica que buscas un numero de referencia que exista y devuelve un entero
    public int compruebaNumRef(String id){

        int numREF;
        do{
            System.out.println("Introcuce el numero de referencia del electrodomestico ");
            numREF = sc.nextInt();
            Iterator<cElectrodomestico> iter;
            iter = listaElectrodomesticos.iterator();
            while (iter.hasNext()){
                cElectrodomestico ele = iter.next();
                if (ele.numRef == numREF && ele.nombre.equals(id)){
                    System.out.println("Numero de referencia valido");
                    return numREF;
                }
            }
            System.err.println("numero de referencia no encontrado");
        }while (true);
    }

    //Este metodo comprueba que no exista un el numero de referencia introducido y devuelve un booleano
    public boolean verificaNumRef(String id, int numRef){

        do{
            Iterator<cElectrodomestico> iter;
            iter = listaElectrodomesticos.iterator();
            while (iter.hasNext()){
                cElectrodomestico ele = iter.next();
                if (ele.numRef == numRef && ele.nombre.equals(id)){
                    System.out.println("El numero de referencia ya existe");
                    return false;
                }
            }
            System.out.println("numero de referencia valido");
            return true;
        }while (true);
    }

    //--------------------------------------------------------------------------------------//

    //Metodo que llama a los ficheros de electrodomesticos y los introduce en sus arrays
    public void cargaElectrodomesticos(){

        try{
            File fe = new File("src/Electrodomesticos/Estufa.txt");
            File ft = new File("src/Electrodomesticos/Television.txt");
            File fm = new File("src/Electrodomesticos/Microondas.txt");
            File fn = new File("src/Electrodomesticos/Nevera.txt");
            File fh = new File("src/Electrodomesticos/Horno.txt");
            File fl = new File("src/Electrodomesticos/Lavadora.txt");

            Scanner se = new Scanner(fe);
            Scanner st = new Scanner(ft);
            Scanner sm = new Scanner(fm);
            Scanner sn = new Scanner(fn);
            Scanner sh = new Scanner(fh);
            Scanner sl = new Scanner(fl);
            while (se.hasNextLine()){
                String strLine = se.nextLine();
                cElectrodomestico e = new cEstufa(strLine);
                this.altaEstufa(e);
            }
            while (st.hasNextLine()){
                String strLine = st.nextLine();
                cElectrodomestico e = new cTelevision(strLine);
                this.altaTelevision(e);
            }
            while (sm.hasNextLine()){
                String strLine = sm.nextLine();
                cElectrodomestico e = new cMicroondas(strLine);
                this.altaMicroondas(e);
            }
            while (sn.hasNextLine()){
                String strLine = sn.nextLine();
                cElectrodomestico e = new cNevera(strLine);
                this.altaNevera(e);
            }
            while (sh.hasNextLine()){
                String strLine = sh.nextLine();
                cElectrodomestico e = new cHorno(strLine);
                this.altaHorno(e);
            }
            while (sl.hasNextLine()){
                String strLine = sl.nextLine();
                cElectrodomestico e = new cLavadora(strLine);
                this.altaLavadora(e);
            }
        }catch(FileNotFoundException e){
            System.err.println("Error con la carga de electrodomesticos");
        }
    }

    //Metodo que inserta los electrodomesticos en sus respectivas arrays
    public void altaEstufa(cElectrodomestico e){

        this.listaEstufa.add(e);
    }
    public void altaTelevision(cElectrodomestico e){

        this.listaTelevision.add(e);
    }
    public void altaMicroondas(cElectrodomestico e){

        this.listaMicroondas.add(e);
    }
    public void altaNevera(cElectrodomestico e){

        this.listaNevera.add(e);
    }
    public void altaHorno(cElectrodomestico e){

        this.listaHorno.add(e);
    }
    public void altaLavadora(cElectrodomestico e){

        this.listaLavadora.add(e);
    }

    //Metodo que inserta los electrodomesticos en la array de electrodmesticos
    public void altaElectrodomestico(cElectrodomestico ele){

        this.listaElectrodomesticos.add(ele);
    }

    //Metodo que devuelve la array de electrodomesticos
    public ArrayList<cElectrodomestico> listaElectrodomesticos() {

        return this.listaElectrodomesticos;
    }
}