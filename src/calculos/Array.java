/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculos;


import java.util.ArrayList;
import java.util.Random;
import sort.mergeSort;

/**
 *
 * @author estadm
 * @param <dp>
 */
public class Array <dp extends Comparable<dp>>{
    
    private ArrayList _array;
    private Random _rnd = new Random();
    private int[] _datos;
    
    public Array(int pCantidadMaxima,int bitDiference){
        _array = new ArrayList();
        _datos=new int[pCantidadMaxima];
        if(bitDiference==0)
            llenarRn(pCantidadMaxima);
        else if (bitDiference==1)
            llenar(pCantidadMaxima);
        else
            worst(pCantidadMaxima);
    }
    
    public int largo (){
        return _array.size();
    }
    
    public dp getDato(int i){
        return (dp)_array.get(i);
    }
    
    public dp getRandArray(){
        return (dp)_array.get(_rnd.nextInt(_array.size()-1));
    }
    
    public int getRandArreglo(){
        return _datos[_rnd.nextInt(_array.size())+1];
    }
    
    public int[] getArreglo(){
        return _datos;
    }
    
    private void llenarRn(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(_rnd.nextInt(pCantMax)+1);
            _datos[i]=_rnd.nextInt(pCantMax)+1;
        }
    }
    
    private void llenar(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(_rnd.nextInt(pCantMax/50)+1);
            _datos[i]=_rnd.nextInt(pCantMax/50)+1;
        }
    }
    
    private void worst(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(i);
            _datos[i]=_rnd.nextInt(pCantMax/50)+1;
            new mergeSort(_datos);
        }
        for(int i = 0; i<_datos.length/2 ; i++){
            int temp=_datos[i];
            _datos[i]=_datos[_datos.length-i-1];
            _datos[_datos.length-i-1]=temp;
        }
    }
}
