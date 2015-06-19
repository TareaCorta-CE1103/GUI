/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.ArrayList;
import java.util.Random;

/**
 * clase para crear un arreglo que contendra todos los datos que se van a ir 
 * ingresando en una lista simple doble
 * @author osboxes
 * @param <dp>
 */
public class forList <dp extends Comparable<dp>> implements Constantes{
    private ArrayList _array;
    private Random _rnd = new Random();
    /**
     * _bitDiference sirve para almacenar el dato que contiene el diferenciador
     * de si estamos calculando el peor, mejor o medio caso con el benchmarck;
     * _lenght nos sirve para almacenar el largo de datos que estamos usando.
     */
    private int _bitDiference,_lenght;
    
    /**
     * constructor que inicializa el ArrayList de datos y establece con cual 
     * arreglo se va a estar trabajando.
     * @param pCantidadMaxima dato que representa la cantidad maxima de datos 
     * que va a contener el ArrayList.
     * @param bitDiference dato para diferenciar que tipo de operacion se va a
     * realizar.
     */
    public forList(int pCantidadMaxima,int bitDiference){
        _array = new ArrayList();
        this._bitDiference=bitDiference;
        this._lenght=pCantidadMaxima;
        if(bitDiference==0)
            better(_lenght);
        else if (bitDiference==1)
            normal(_lenght);
        else
            worst(_lenght);
    }
    
    /**
     * metodo que retorna la maxima cantidad de datos que estamos usando.
     * @return retorna un dato tipo entero, que es la cantidad de datos con que
     * se opera.
     */
    public int largo (){
        return _array.size();
    }
    
    /**
     * metodo para obtener un dato segun el numero con el del arreglo se pida.
     * @param i dato entero que concuerda con alguna posicion pedidad por el 
     * programa.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getDato(int i){
        return (dp)_array.get(i);
        
    }
    
    /**
     * metodo para retornar lo que es un dato que concuerda para realizar 
     * busquedas o eliminaciones en la lista segun concuerde con lo establecido
     * por el _bitDiference.
     * @return retorna un dato de valor generico.
     */
    public dp getfind(){
        _array.sort(null);
        if(_bitDiference==cero)
            return (dp)_array.get(cero);
        else if(_bitDiference==uno)
            return (dp)_array.get((_lenght-1)/2);
        return (dp)_array.get(_lenght-1);
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el mejor de los casos.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void better(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(i);
        }
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el caso normal.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void normal(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(_rnd.nextInt(pCantMax/10)+1);
        }
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el peor de los casos.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void worst(int pCantMax){
        for (int i=pCantMax; i>0; i--){
            _array.add(i);
        }
    }
}
