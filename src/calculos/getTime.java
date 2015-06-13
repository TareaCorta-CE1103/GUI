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
 *
 * @author osboxes
 */
public class getTime implements Constantes{
    
    private Array _Dato;
    private check _obtenerTiempos;
    private int _cant;
    
    public getTime(int cant, int bitDiference){
        this._cant=cant;
        this._Dato= new Array(_cant, bitDiference);
        this._obtenerTiempos=new check(_Dato);
    }
    
    public long Time(String pMetodo){
        if(pMetodo.substring(cero,dos).equals(insert))
            return inserts(pMetodo);
        else if(pMetodo.substring(cero,dos).equals(delete))
            return deletes(pMetodo);
        else if(pMetodo.substring(cero,dos).equals(search))
            return searchs(pMetodo);
        else
            return sort(pMetodo);
    }
    
    private long inserts(String pMetodo){
        if(pMetodo.substring(dos,cuatro).equals(AVL))
            return _obtenerTiempos.AVL(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(BinarioT))
            return _obtenerTiempos.binario(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(Splay))
            return _obtenerTiempos.splay(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(R_N))
            return _obtenerTiempos.RN(pMetodo.substring(cero,dos));
        else
            return _obtenerTiempos.listaSDoble(pMetodo.substring(cero,dos));
    }
    
    private long deletes(String pMetodo){
        if(pMetodo.substring(dos,cuatro).equals(AVL))
            return _obtenerTiempos.AVL(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(BinarioT))
            return _obtenerTiempos.binario(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(Splay))
            return _obtenerTiempos.splay(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(R_N))
            return _obtenerTiempos.RN(pMetodo.substring(cero,dos));
        else
            return _obtenerTiempos.listaSDoble(pMetodo.substring(cero,dos));
    }
    
    private long searchs(String pMetodo){
        if(pMetodo.substring(dos,cuatro).equals(AVL))
            return _obtenerTiempos.AVL(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(BinarioT))
            return _obtenerTiempos.binario(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(Splay))
            return _obtenerTiempos.splay(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(R_N))
            return _obtenerTiempos.RN(pMetodo.substring(cero,dos));
        else if(pMetodo.substring(dos,cuatro).equals(Ldoble))
            return _obtenerTiempos.listaSDoble(pMetodo.substring(cero,dos));
        else
            return _obtenerTiempos.search(pMetodo.substring(cero,dos));
    }
    
    private long sort(String pMetodo){
        long tmp,tmp2;
        int [] arreglo= _Dato.getArreglo();
        if(pMetodo.substring(dos,cuatro).equals(burbujaS)){
            tmp=System.nanoTime();
            bubbleSort metodo= new bubbleSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pMetodo.substring(dos,cuatro).equals(insertS)){
            inserSort metodo= new inserSort();
            tmp=System.nanoTime();
            metodo.insertSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pMetodo.substring(dos,cuatro).equals(mergeS)){
            tmp=System.nanoTime();
            mergeSort metodo= new mergeSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pMetodo.substring(dos,cuatro).equals(quickS)){
            tmp=System.nanoTime();
            quickSort metodo= new quickSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pMetodo.substring(dos,cuatro).equals(selecS)){
            tmp=System.nanoTime();
            selectionSort metodo= new selectionSort(arreglo);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            //aqui se supone que va el raddix pero la biblioteca no lo importa
            tmp=System.nanoTime();
            RadixSort burbuja= new RadixSort(arreglo,arreglo.length);
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    //
}
