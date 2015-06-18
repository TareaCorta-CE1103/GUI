/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import calculos.Decode;
import calculos.Constantes;
import lists.ListaSdoble;
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
    private ListaSdoble _mensajes;
    private ListaSdoble _better;
    private ListaSdoble _normal;
    private ListaSdoble _worst;
    
    public facade(){
        _mensajes= new ListaSdoble();
        _better= new ListaSdoble();
        _normal= new ListaSdoble();
        _worst= new ListaSdoble();
    }
    
    /**
     * funcion para establecer los mensajes con los que se va a estar trabajando
     * @param mensajes recibe un dato de la clase ListaSdoble, esta es la lista
     * que contiene todos los mensajes de las operaciones que vamos a realizar.
     */
    public void setMensaje(ListaSdoble mensajes){
        this._mensajes=mensajes;
    }
    
    /**
     * metodo para iniciar el calculo de los datos, recibe un dato que indica 
     * con que cantidad de datos va a operar.
     */
    public void run(){
        Nodo tmp = _mensajes.getHead();
        while(tmp!=null){
            for(int cantDatos=100;cantDatos<Mil+uno;cantDatos+=cien){
                _betterCien=new Decode(cantDatos, cero);
                _normalCien= new Decode(cantDatos, uno);
                _worstCien= new Decode(cantDatos, dos);
                _better.enQueue(_betterCien.Time((int)tmp.getData()));
                _normal.enQueue(_normalCien.Time((int)tmp.getData()));
                _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            }
            for(int cantDatos=2000;cantDatos<cienMil+uno;cantDatos+=Mil){
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
     * metodo para obtener los mensajes con los que se estan operando.
     * @return retorna un dato de la clase 'ListaSdoble', esta lista contiene
     * todos los metodos con los que se esta operando.
     */
    public ListaSdoble getMensajes(){
        return _mensajes;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del mejor de los casos.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron mejor rendimiento.
     */
    public ListaSdoble getBetter(){
        return _better;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del caso normal.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron un rendimiento medio.
     */
    public ListaSdoble getNormal(){
        return _normal;
    }
    
    /**
     * metodo para obtener la lista de los tiempos del caso normal.
     * @return retorna un dato de la clase 'ListaSdoble', contiene los datos de
     * que segun, los metodos, tubieron el peor rendimiento.
     */
    public ListaSdoble getWorst(){
        return _worst;
    }
}
