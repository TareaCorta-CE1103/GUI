package graficacion;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import facade.facade;
import lists.Nodo;
import calculos.Constantes;
import lists.ListaSimple;

/**
 * clase que se utiliza para graficar los datos que se obtienen apartir del 
 * facade, estos datos se agarrar y se ponen en los 
 * @author luis
 */
public class Grafico implements Constantes{
    
    private facade _facade;
    private ListaSimple _mensajes;
    private ListaSimple _better;
    private ListaSimple _normal;
    private ListaSimple _worst;
    
    /**
     * contructor de la clase, recibe una lista enlazada que es la que contiene
     * los datos de los mensajes que pedimos, inicializa el facade, realiza los 
     * calculos de los datos y empieza a ingresarlos a la grafica.
     * @param pMensaje dato que pertenece a la clase 'ListaSdoble', este dato
     * es el que contiene los mensajes que vamos a usar para realizar los 
     * calculos.
     */
    public Grafico(ListaSimple pMensaje) {
        this._mensajes=pMensaje;
        _facade=new facade();
        
        //establecemos los mensajes de los metodos que queremos ejecutar.
        _facade.setMensaje(_mensajes);
        
        //ejecutamos los metodos y el facade realiza solo los calculos.
        _facade.run();
        
        //obtenemos las listas de los tiempos.
        _normal=_facade.getNormal();
        _better=_facade.getBetter();
        _worst=_facade.getWorst();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //obtenemos los nodos que conectados a las listas de mensajes y tiempos.
        Nodo tmp=_mensajes.getHead();
        Nodo mejor= _better.getHead();
        Nodo normal=_normal.getHead();
        Nodo peor=_worst.getHead();
        while(tmp!=null){
            int lenght=0;
            for (int cantDatos = 0; cantDatos<(dos*diez);cantDatos++){
                
                //llamda a metodo que establece las lineas
                setLines(dataset,getMetodo((int)tmp.getData()), lenght,
                        mejor, normal, peor);
                mejor=mejor.getNext();
                normal=normal.getNext();
                peor=peor.getNext();
                //sumatoria del contador que va a llevar la cantidad de datos
                //que hemos ingresado para realizar el benchmark.
                if(lenght<Mil)
                    lenght+=cien;
                else if(lenght==Mil)
                    lenght+=Mil;
                else if(lenght>Mil &&lenght<cienMil+1)
                    lenght+=Mil;
            }
            tmp=tmp.getNext();
        }
        //establecimiento de atributos a la grafica.
        JFreeChart Grafico = ChartFactory.createLineChart(
                "Eficiencia del algoritmo",
                "Cantidad de elementos",
                "Tiempo de ejecución",dataset,PlotOrientation.VERTICAL,true,
                false,false);
        //Se muestra el grafico
        ChartFrame fr = new ChartFrame("Gráfico", Grafico);
        fr.pack();
        fr.setVisible(true);
    }
    
    /**
     * metodo que decodifica el mensaje del metodo que vamos a realizar los 
     * calculos y devuelve su nombre en un string.
     * @param pMetodo dato tipo entero, que es el mensaje codificado.
     * @return dato tipo String que es el nombre del metodo.
     */
    private String getMetodo(int pMetodo){
        if(pMetodo/diez==insert)
            return getInsertMetodo(pMetodo-diez);
        else if(pMetodo/diez==delete)
            return getDeleMetodo(pMetodo-(dos*diez));
        else if(pMetodo/diez==search)
            return getSerchMetodo(pMetodo-(tres*diez));
        else
            return getSortMetodo(pMetodo-(cuatro*diez));
    }
    
    /**
     * metodo que decodifica lo que reciba del mensaje y lo envia diciendo cual
     * es el metodo que se quiso calcular para un insercion.
     * @param pMetodo dato tipo entero, que es el mensaje codificado.
     * @return dato tipo String que es el nombre del metodo.
     */
    private String getInsertMetodo(int pMetodo){
        if(pMetodo==AVL)
            return "insertar AVL";
        else if(pMetodo==BinarioT)
            return "insertar binario";
        else if(pMetodo==Splay)
            return "insertar splay";
        else if(pMetodo==R_N)
            return "insertar R&N";
        else
            return "insertar lista";
    }
    
    /**
     * metodo que decodifica lo que reciba del mensaje y lo envia diciendo cual
     * es el metodo que se quiso calcular para un borrado.
     * @param pMetodo dato tipo entero, que es el mensaje codificado.
     * @return dato tipo String que es el nombre del metodo.
     */
    private String getDeleMetodo(int pMetodo){
        if(pMetodo==AVL)
            return "borrar AVL";
        else if(pMetodo==BinarioT)
            return "borrar binario";
        else if(pMetodo==Splay)
            return "borrar splay";
        else if(pMetodo==R_N)
            return "borrar R&N";
        else
            return "borrar lista";
    }
    
    /**
     * metodo que decodifica lo que reciba del mensaje y lo envia diciendo cual
     * es el metodo que se quiso calcular para un busqueda.
     * @param pMetodo dato tipo entero, que es el mensaje codificado.
     * @return dato tipo String que es el nombre del metodo.
     */
    private String getSerchMetodo(int pMetodo){
        if(pMetodo==binariS)
            return "busqueda binaria";
        else if(pMetodo==lineal)
            return "busqueda lineal";
        else if(pMetodo==AVL)
            return "buscar AVL";
        else if(pMetodo==BinarioT)
            return "buscar binario";
        else if(pMetodo==Splay)
            return "buscar splay";
        else if(pMetodo==R_N)
            return "buscar R&N";
        else
            return "buscar lista";
    }
    
    /**
     * metodo que decodifica lo que reciba del mensaje y lo envia diciendo cual
     * es el metodo que se quiso calcular para un ordenamiento.
     * @param pMetodo dato tipo entero, que es el mensaje codificado.
     * @return dato tipo String que es el nombre del metodo.
     */
    private String getSortMetodo(int pMetodo){
        if(pMetodo==burbujaS)
            return "Burbuja";
        else if(pMetodo==insertS)
            return "Insert";
        else if(pMetodo==selecS)
            return "Selection";
        else if(pMetodo==mergeS)
            return "Merge";
        else if(pMetodo==quickS)
            return "Quick";
        else if(pMetodo==quickS)
            return "Raddix";
        else 
            return "Heap";
    }
    
    /**
     * metodo que ejecuta el establecimiento de lineas en la grafica, segun los
     * datos que este recibiendo.
     * @param pDataset dato de la biblioteca DefaultCategoryDataset, esta es la 
     * grafica en donde se van a poner las lineas.
     * @param pMetodo dato tipo String, es el nombre del metodo que calculamos
     * @param pLenghtDatos dato tipo entero, es el dato que nos indica la maxima
     * cantidad de datos que estamos usando.
     * @param pBetter dato de la clase Nodo, este el nodo que contiene el dato 
     * del mejor rendimiento de tiempo.
     * @param pNorm dato de la clase Nodo, este es el nodo que contiene el dato
     * del rendimiento medio.
     * @param pWorst dato de la clase Nodo, este es el nodo que contiene el dato
     * del peor rendimiento, encomparacion a los demas tiempos.
     */
    private void setLines(DefaultCategoryDataset pDataset,String pMetodo, 
             int pLenghtDatos,Nodo pBetter, Nodo pNorm, Nodo pWorst){
        pDataset.addValue((long)pBetter.getData(), "Mejor caso de: "+pMetodo,
                "" + pLenghtDatos);
        pDataset.addValue((long)pWorst.getData(), "Peor caso de: "+pMetodo,
                "" + pLenghtDatos);
        pDataset.addValue((long)pNorm.getData(), "Caso promedio de: "+pMetodo,
                "" + pLenghtDatos);
    }
    
    /**casos de prueba,ordenamientos, inserciones y busquedas quedan listas
     * pero los borrados de los arboles siguen si funcionar, no se porque, 
     * quisiera saberlo, ya quiero que termine el semestre :'''(
     **
    public static void main(String[] args) {
        ListaSimple lista= new ListaSimple();
        //lista.enQueue(42);
        lista.enQueue(41);
        //lista.enQueue(43);
        //lista.enQueue(44);
        //lista.enQueue(45);
        //lista.enQueue(46);
        //lista.enQueue(47);
        Grafico nuevo= new Grafico(lista);
    }*/
}
 

