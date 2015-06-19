/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import sort.Heap;
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
        forArrays _Datos= new forArrays(_cant, _bitDiference);
        int[] arreglo=_Datos.getArreglo();
        if((pMetodo-(cuatro*diez))==burbujaS)
            return bubbuble(arreglo);
        else if((pMetodo-(cuatro*diez))==insertS)
            return insert(arreglo);
        else if((pMetodo-(cuatro*diez))==quickS)
            return quick(arreglo);
        else if((pMetodo-(cuatro*diez))==mergeS)
            return merge(arreglo);
        else if((pMetodo-(cuatro*diez))==raddixS)
            return raddix(arreglo);
        else if((pMetodo-(cuatro*diez))==selecS)
            return selection(arreglo);
        else 
            return heap(arreglo);
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * burbuja y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long bubbuble(int[] array){
        long tmp=0;
        long tmp2=0;
        tmp=System.nanoTime();
        new bubbleSort(array);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * selection sort y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long selection(int[] array){
        long tmp=0;
        long tmp2=0;
        tmp=System.nanoTime();
        new selectionSort(array);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * insert sort y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long insert(int[] array){
        long tmp=0;
        long tmp2=0;
        inserSort metodo= new inserSort();
        tmp=System.nanoTime();
        metodo.insertSort(array);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * merge sort y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long merge(int[] array){
        long tmp=0;
        long tmp2=0;
        tmp=System.nanoTime();
        new mergeSort(array);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * quick sort y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long quick(int[] array){
        long tmp=0;
        long tmp2=0;
        tmp=System.nanoTime();
        new quickSort(array);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * raddix sort y devolvera el tiempo tardado en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long raddix(int[] array){
        long tmp=0;
        long tmp2=0;
        tmp=System.nanoTime();
        new RadixSort(array,array.length);
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    /**
     * metodo para calcular el tiempo de duracion de un ordenamiento tipo 
     * heap sort, el cual es un heap de menores y devolvera el tiempo tardado 
     * en nano segundos.
     * @param array recibe un dato tipo 'int[]' que es el arreglo sobre el cual
     * operaremos.
     * @return devuelve un dato tipo 'long' que es la cantidad de tiempo que 
     * se tardo el metodo de ordenamiento.
     */
    private long heap(int[] array){
        long tmp=0;
        long tmp2=0;
        Heap heap= new Heap();
        for(int i =0; i<array.length;i++){
            tmp=System.nanoTime();
            heap.insert(array[i]);
            tmp2=System.nanoTime();
        }
        return tmp2-tmp;
    }
    /**
     * casos de prueba para los metodos de ordenamiento, todos dan con numeros
     * un tanto extraños pero su intervalo de diferencia en mayoria no es muy 
     * grande. el heap sort es el mas continuo y preciso, inclusive con 
     * todos los datos logro marcar tiempos con un intervalo de diferencia muy
     * poca, se mantiene siempre entre los 220000 nano segundos.
    public static void main(String[] args) {
        long tmp=0;
        for(int i =0; i<1001; i+=100){
            Decode nuevo = new Decode(i, 2);
            //tmp=nuevo.Time(41);//burbuja
            //tmp=nuevo.Time(42);//insert
            //tmp=nuevo.Time(43);//quick
            //tmp=nuevo.Time(44);//merge
            //tmp=nuevo.Time(45);//raddix
            //tmp=nuevo.Time(46);//select
            //tmp=nuevo.Time(47);//heap
            System.out.println(tmp);
        }
    }*/
}
