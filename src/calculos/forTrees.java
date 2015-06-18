/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.ArrayList;
import java.util.Random;
import tree.Arbol_AVL;
import tree.Arbol_RN;
import tree.Arbol_binario;
import tree.Arbol_splay;

/**
 * clase para generar los contenedores de datos que vamos a utilizar 
 * especificamente para arboles.
 * @author osboxes
 * @param <dp>
 */
public class forTrees <dp extends Comparable<dp>> implements Constantes{
    private ArrayList _array;
    private Random _rnd = new Random();
    /**
     * _bitDiference sirve para almacenar el dato que contiene el diferenciador
     * de si estamos calculando el peor, mejor o medio caso con el benchmarck;
     * _lenght nos sirve para almacenar el largo de datos que estamos usando.
     */
    private int _bitDiference,_lenght;
    
    /**
     * contructor de la clase, recibe dos datos, uno que es el largo de datos,
     * que estamos calculando y otro para diferenciar que tipo de caso estamos 
     * aplicando.
     * @param pCantidadMaxima dato tipo entero que es la cantidad maxima con la 
     * que se va a estar operando.
     * @param bitDiference dato que nos diferenciara entre lo que sera el mejor,
     * medio y peor caso para los arboles.
     */
    public forTrees(int pCantidadMaxima,int bitDiference){
        _array = new ArrayList();
        this._bitDiference=bitDiference;
        this._lenght=pCantidadMaxima;
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
        return _array.size();
    }
    
    /**
     * metodo para obtener un dato segun el numero con el del ArrayList se pida.
     * @param i dato entero que concuerda con alguna posicion pedidad por el 
     * programa.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getDato(int i){
        return (dp)_array.get(i);
    }
    
    /**
     * metodo para obtener un dato segun lo pedido, usado exclusivamente 
     * para cuando se realizan busquedas o borrados
     * @param avl dato de la clase Arbol_AVL, este es el arbol con el cual 
     * estamos operando.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getAVL(Arbol_AVL avl){
        if(_bitDiference==cero)
            return (dp)avl.getRoot().getDato();
        else if(_bitDiference==uno)
            return (dp)_array.get(_rnd.nextInt(_lenght)+1);
        else
            return (dp)_array.get(cero);
    }
    
    /**
     * metodo para obtener un dato segun lo que se haya pedido como busqueda,
     * si es busqueda o borrado.
     * @param abb dato de la clase Arbol_binario, este es el arbol con el cual 
     * estamos operando.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getBi(Arbol_binario abb){
        if(_bitDiference==cero)
            return (dp)abb.getRoot().getDato();
        else if(_bitDiference==uno)
            return (dp)_array.get(_rnd.nextInt(_lenght)+1);
        else
            return (dp)_array.get(cero);
    }
    
    /**
     * metodo para obtener un dato segun lo que se haya pedido como busqueda,
     * si es busqueda o borrado.
     * @param asp dato de la clase Arbol_splay, este es el arbol con el cual 
     * estamos operando.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getSp(Arbol_splay asp){
        if(_bitDiference==cero)
            return (dp)asp.getRoot().getDato();
        else if(_bitDiference==uno)
            return (dp)_array.get(_rnd.nextInt(_lenght)+1);
        else
            return (dp)_array.get(cero);
    }
    
    /**
     * metodo para obtener un dato segun lo que se haya pedido como busqueda,
     * si es busqueda o borrado.
     * @param arn dato de la clase Arbol_RN, este es el arbol con el cual 
     * estamos operando.
     * @return retonar un dato generico que son los ingresados en la lista.
     */
    public dp getRN(Arbol_RN arn){
        if(_bitDiference==cero)
            return (dp)arn.getRoot().getDato();
        else if(_bitDiference==uno)
            return (dp)_array.get(_rnd.nextInt(_lenght)+1);
        else
            return (dp)_array.get(cero);
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el mejor de los casos.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void better(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(_rnd.nextInt(pCantMax/50)+1);
        }
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el caso normal.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void normal(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(_rnd.nextInt(pCantMax/50)+1);
        }
    }
    
    /**
     * funcion que ingresa los datos en el arreglo para el peor de los casos.
     * @param pCantMax dato tipo entero, recibe el dato de la maxima cantidad
     * de datos con el que debe de crear el ArrayList.
     */
    private void worst(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _array.add(i);
        }
    }
}
