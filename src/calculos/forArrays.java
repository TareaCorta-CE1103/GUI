/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.Random;

/**
 *  clase para crear los arreglos que se van a utilizar para los calculos de 
 * tiempo.
 * @author osboxes
 */
public class forArrays implements Constantes{
    private int[] _datos;
    private Random _rnd = new Random();
    /**
     * _bitDiference sirve para almacenar el dato que contiene el diferenciador
     * de si estamos calculando el peor, mejor o medio caso con el benchmarck;
     * _lenght nos sirve para almacenar el largo de datos que estamos usando.
     */
    private int _leght, _bitDiference;
    
    /**
     * constructor que inicializa el Arreglo de datos y establece con cual 
     * arreglo se va a estar trabajando.
     * @param pCantidadMaxima dato que representa la cantidad maxima de datos 
     * que va a contener el ArrayList.
     * @param bitDiference dato para diferenciar que tipo de operacion se va a
     * realizar, 'cero' para el mejor de los casos, 'uno' para el caso promedio
     * y 'dos' para el peor de los casos.
     */
    public forArrays(int pCantidadMaxima,int bitDiference){
        _datos=new int[pCantidadMaxima];
        this._leght=pCantidadMaxima;
        this._bitDiference=bitDiference;
        if(bitDiference==cero)
            better(pCantidadMaxima);
        else if (bitDiference==uno)
            normal(pCantidadMaxima);
        else
            worst(pCantidadMaxima);
    }
    
    /**
     * metodo que retorna la maxima cantidad de datos que estamos usando.
     * @return retorna un dato tipo entero, que es la cantidad de datos con que
     * se opera.
     */
    public int largo (){
        return _leght;
    }
    
    /**
     * metodo que nos retorna un dato para un busqueda binaria y distingue entre
     * el mejor, peor o medio de los casos segun el bitDiference ingresado en 
     * el constructor.
     * @return retorna un dato tipo entero que es el dato con el que se 
     * realizara una busqueda.
     */
    public int binari(){
        if(_bitDiference==cero)
            return _datos[(_leght-1)/2];
        else if (_bitDiference==uno)
            return _datos[(_leght-1)/4];
        else
            return _datos[_leght-1];
    }
    
    /**
     * metodo que nos retorna un dato para un busqueda lineal y distingue entre
     * el mejor, peor o medio de los casos segun el bitDiference ingresado en 
     * el constructor.
     * @return retorna un dato tipo entero que es el dato con el que se 
     * realizara una busqueda.
     */
    public int lineal(){
        if(_bitDiference==cero)
            return _datos[cero];
        else if (_bitDiference==uno)
            return _datos[(_leght-1)/2];
        else
            return _datos[_leght-1];
    }
    
    /**
     * metodo que retorna un arreglo que es el que vamos a utilizar para todas 
     * las operaciones relizadas, ya sea para busquedas u ordenamientos.
     * @return retorna una 'int[]' que es el arreglo que se utilizara durante
     * toda la operacion.
     */
    public int[] getArreglo(){
        return _datos;
    }
    
    /**
     * metodo que recibe un dato que le indicara la cantidad con la que tendra 
     * que realizar un arreglo, este metodo creara un arreglo para el mejor de 
     * los casos.
     * @param pCantMax dato tipo entero, es la cantidad de datos con la que 
     * se quiere crear un arreglo.
     */
    private void better(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _datos[i]=i;
        }
    }
    
    /**
     * metodo que recibe un dato que le indicara la cantidad con la que tendra 
     * que realizar un arreglo, este metodo creara un arreglo para el caso 
     * normal o promedio.
     * @param pCantMax dato tipo entero, es la cantidad de datos con la que 
     * se quiere crear un arreglo.
     */
    private void normal(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _datos[i]=_rnd.nextInt(pCantMax)+1;
        }
    }
    
    /**
     * metodo que recibe un dato que le indicara la cantidad con la que tendra 
     * que realizar un arreglo, este metodo creara un arreglo para el peor de 
     * los casos.
     * @param pCantMax dato tipo entero, es la cantidad de datos con la que 
     * se quiere crear un arreglo.
     */
    private void worst(int pCantMax){
        int x=0;
        for (int i=pCantMax-1; i>0; i--,x++){
            _datos[x]=i;
        }
    }
}
