/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import calculos.Decode;
import calculos.Constantes;
import lists.ListaSimple;
import lists.Nodo;
/**
 * clase facade que comunica las clases que realizan los calculos con la clase 
 * que grafica.
 * @author osboxes
 */
public class facade implements Constantes{
    
    private Decode _betterCien;
    private Decode _normalCien;
    private Decode _worstCien;
    private ListaSimple _mensajes;
    private ListaSimple _better;
    private ListaSimple _normal;
    private ListaSimple _worst;
    
    public facade(){
        _mensajes= new ListaSimple();
        _better= new ListaSimple();
        _normal= new ListaSimple();
        _worst= new ListaSimple();
    }
    
    /**
     * metodo para iniciar el calculo de los datos, recibe un dato que indica 
     * con que cantidad de datos va a operar.
     */
    public void run(){
        Nodo tmp = _mensajes.getHead();
        while(tmp!=null){
            int cantDatos=0;
            for(;cantDatos<Mil+uno;cantDatos+=cien){
                _betterCien=new Decode(cantDatos, cero);
                _normalCien= new Decode(cantDatos, uno);
                _worstCien= new Decode(cantDatos, dos);
                _better.enQueue(_betterCien.Time((int)tmp.getData()));
                _normal.enQueue(_normalCien.Time((int)tmp.getData()));
                _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            }
            for(;cantDatos<cienMil+uno;cantDatos+=Mil){
                _betterCien=new Decode(cantDatos, cero);
                _normalCien= new Decode(cantDatos, uno);
                _worstCien= new Decode(cantDatos, dos);
                _better.enQueue(_betterCien.Time((int)tmp.getData()));
                _normal.enQueue(_normalCien.Time((int)tmp.getData()));
                _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            }
            tmp=tmp.getNext();
        }
    }
    
    /**
     * funcion para establecer los mensajes con los que se va a estar trabajando
     * @param mensajes recibe un dato de la clase ListaSdoble, esta es la lista
     * que contiene todos los mensajes de las operaciones que vamos a realizar.
     */
    public void setMensaje(ListaSimple mensajes){
        this._mensajes=mensajes;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del mejor de los casos.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron mejor rendimiento.
     */
    public ListaSimple getBetter(){
        return _better;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del caso normal.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron un rendimiento medio.
     */
    public ListaSimple getNormal(){
        return _normal;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del caso normal.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron el peor rendimiento.
     */
    public ListaSimple getWorst(){
        return _worst;
    }
}
