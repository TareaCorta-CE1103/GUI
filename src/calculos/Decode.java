/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import sort.RadixSort;
import sort.bubbleSort;
import sort.inserSort;
import sort.mergeSort;
import sort.quickSort;
import sort.selectionSort;

/**
 * clase que decodifica el mensaje enviado por el facade para saber que es lo
 * que se le esta pidiendo o que tiene que calcular, se van a devolver los 
 * tiempos en tipos de datos 'long' que son nano segundos.
 * @author osboxes
 */
public class Decode implements Constantes{
    
    private CalcTime _obtenerTiempos;
    private int _cant, _bitDiference;
    
    /**
     * contructor de la clase, recibe dos datos, el primero es la cantidad de 
     * datos con la que estamos trabajando, la segunda es el bitDiference, que 
     * es lo que nos indica si utilizando el mejor, peor o medio de los casos de 
     * ejecucion.
     * @param cant dato tipo entero, corresponde a la cantidad de datos con que
     * queramos operar.
     * @param bitDiference dato tipo entero, corresponde al tipo de caso que 
     * estamos calculando.
     */
    public Decode(int cant, int bitDiference){
        this._cant=cant;
        this._bitDiference=bitDiference;
        this._obtenerTiempos=new CalcTime(_cant,bitDiference);
    }
    
    /**
     * metodo que recibe el mensaje y lo decodifica, verifica si lo que se va a
     * realizar una insercion, borrado, busqueda u ordenamiento.
     * @param pMetodo dato tipo entero que nos indica que metodo vamos a ejecutar
     * @return retorna un dato tipo 'long', este dato es la cantidad de tiempo
     * que se gasto ejecutando la operacion.
     */
    public long Time(int pMetodo){
        if((pMetodo/diez)==insert)
            return inserts(pMetodo);
        else if((pMetodo/diez)==delete)
            return deletes(pMetodo);
        else if((pMetodo/diez)==search)
            return searchs(pMetodo);
        else
            return sort(pMetodo);
    }
    
    /**
     * metodo para obtener el tiempo para cuando se verifica que la operacion
     * pedida fue una insercion.
     * @param pMetodo dato tipo entero, que concuerda con el tipo de operacion a
     * realizar, ya sea un AVL, binario o cualquier otra cosa a la cual puedan
     * insertarsele datos.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo gastado
     * por el metodo que realizo una insercion.
     */
    private long inserts(int pMetodo){
        if((pMetodo-diez)==AVL)
            return _obtenerTiempos.AVL(pMetodo/diez);
        else if((pMetodo-diez)==BinarioT)
            return _obtenerTiempos.binario(pMetodo/diez);
        else if((pMetodo-diez)==Splay)
            return _obtenerTiempos.splay(pMetodo/diez);
        else if((pMetodo-diez)==R_N)
            return _obtenerTiempos.RN(pMetodo/diez);
        else
            return _obtenerTiempos.listaSDoble(pMetodo/diez);
    }
    
    /**
     * metodo para obtener el tiempo para cuando se verifica que la operacion
     * pedida fue un borrado.
     * @param pMetodo dato tipo entero, concuerda con el metodo que vamos a 
     * realizar, puede ser para un AVL, binario, lista o cualquier otro.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo gastado
     * por el metodo que realizo el borrado.
     */
    private long deletes(int pMetodo){
        if((pMetodo-(dos*diez))==AVL)
            return _obtenerTiempos.AVL(pMetodo/(dos*diez));
        else if((pMetodo-(dos*diez))==BinarioT)
            return _obtenerTiempos.binario(pMetodo/(dos*diez));
        else if((pMetodo-(dos*diez))==Splay)
            return _obtenerTiempos.splay(pMetodo/(dos*diez));
        else if((pMetodo-(dos*diez))==R_N)
            return _obtenerTiempos.RN(pMetodo/(dos*diez));
        else
            return _obtenerTiempos.listaSDoble(pMetodo/(dos*diez));
    }
    
    /**
     * metodo para obtener el tiempo para cuando se verifica que la operacion
     * pedida fue una busqueda.
     * @param pMetodo dato tipo entero, concuerda con el metodo que vamos a 
     * realizar, puede ser para un AVL, binario, lista o cualquier otro.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo gastado
     * por el metodo que realizo una busqueda.
     */
    private long searchs(int pMetodo){
        if((pMetodo-(tres*diez))==AVL)
            return _obtenerTiempos.AVL(pMetodo/(tres*diez));
        else if((pMetodo-(tres*diez))==BinarioT)
            return _obtenerTiempos.binario(pMetodo/(tres*diez));
        else if((pMetodo-(tres*diez))==Splay)
            return _obtenerTiempos.splay(pMetodo/(tres*diez));
        else if((pMetodo-(tres*diez))==R_N)
            return _obtenerTiempos.RN(pMetodo/(tres*diez));
        else if((pMetodo-(tres*diez))==Ldoble)
            return _obtenerTiempos.listaSDoble(pMetodo/(tres*diez));
        else
            return _obtenerTiempos.search(pMetodo/(tres*diez));
    }
    
    /**
     * metodo para obtener el tiempo para cuando se verifica que la operacion
     * pedida fue un ordenamiento sobre arreglos.
     * @param pMetodo dato tipo entero, concuerda con el metodo que vamos a 
     * realizar, puede ser para un burbuja, insertSort, mergeSort o cualquier 
     * otro.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo gastado
     * por el metodo que realizo un ordenamiento.
     */
    private long sort(int pMetodo){
        long tmp,tmp2;
        forArrays _Datos= new forArrays(_cant, _bitDiference);
        int[] arreglo=_Datos.getArreglo();
        if((pMetodo-(cuatro*diez))==burbujaS){
            tmp=System.nanoTime();
            new bubbleSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if((pMetodo-(cuatro*diez))==insertS){
            inserSort metodo= new inserSort();
            tmp=System.nanoTime();
            metodo.insertSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if((pMetodo-(cuatro*diez))==mergeS){
            tmp=System.nanoTime();
            new mergeSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if((pMetodo-(cuatro*diez))==quickS){
            tmp=System.nanoTime();
            new quickSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if((pMetodo-(cuatro*diez))==selecS){
            tmp=System.nanoTime();
            new selectionSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            tmp=System.nanoTime();
            new RadixSort(arreglo,arreglo.length);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
}
