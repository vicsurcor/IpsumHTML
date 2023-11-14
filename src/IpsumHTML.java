import java.io.*;
import java.util.TreeMap;

public class IpsumHTML {

    String recursos = "resources/Lorem";
    BufferedReader fEntrada;
    BufferedWriter fSalida;


    public void limpiar(){

        File dPrincipal = new File("resources/resultado");
        if (dPrincipal.exists())
        {
            File[] parrafos = dPrincipal.listFiles();
            if (parrafos != null) {
                for (int i = 0; i < parrafos.length; i++)
                {
                    File parrafo = parrafos[i];
                    File[] txtArchivos = parrafo.listFiles();
                    if (txtArchivos != null) {
                        for (int f = 0; f < txtArchivos.length; f++)
                        {
                            txtArchivos[f].delete();
                        }
                    }
                    parrafo.delete();
                }
            }
            dPrincipal.delete();
        }
        else
        {

            System.out.println("No se puede borrar");

        }

    }
    public void crearDirectorioPrincipal(){

        File dPrincipal = new File("resources/resultado");
        if (dPrincipal.exists()){


            System.out.println("El directorio ya existe");

        }
        else {

            System.out.println("DirectorioPrincipal creado " + dPrincipal.mkdirs());

        }


    }
    public void crearCarpetaParrafoLineas(){
        int nParrafos = 1;
        int SaltosDeLinea = 0;

        try {
            fEntrada = new BufferedReader(new FileReader(recursos));
            String parrafo = fEntrada.readLine();
            while (parrafo != null)
            {
                if (nParrafos%2 != 0){
                    File file = new File("resources/resultado/parrafo-" + (nParrafos + SaltosDeLinea));
                    file.mkdir();
                    crearArchivoTxT(file,nParrafos);
                }
                else {
                    SaltosDeLinea += -1;
                }
                parrafo = fEntrada.readLine();
                nParrafos++;
            }
            try {
                fEntrada.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
    public void crearArchivoTxT(File file,int nParrafos){
        
        int parrafo = 0;
        try {
            BufferedReader fIn = new BufferedReader(new FileReader(recursos));
            while((nParrafos - 1) != parrafo){
                fIn.readLine();
                parrafo++;
            }
            String[] linea = fIn.readLine().split(" ");




            fIn.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
