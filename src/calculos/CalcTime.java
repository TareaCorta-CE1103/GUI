/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import lists.ListaSdoble;
import search.binari;
import search.lineal;
import tree.Arbol_AVL;
import tree.Arbol_RN;
import tree.Arbol_binario;
import tree.Arbol_splay;

/**
 * clase para calcular los tiempos de ejecucion de cada uno de los metodos 
 * implementados,el devolvera un unidad de tiempo expresada en un dato tipo
 * "long".
 * @author osboxes
 */
public class CalcTime implements Constantes{
    private int _bitDiference;
    private int _length;
    
    /**
     * contructor de la clase, recibe la cantidad total de datos con los que se
     * van a operar y el tipo de operacion que se quiere realizar,puede ser un 
     * mejor, peor o medio de todos los casos para los metodos.
     * @param CantMax dato tipo entero que recibe la cantidad total con la que
     * vamos a trabajar.
     * @param bitDiference dato tipo entero, recibe un 'cero' si se quiere calcular
     * el mejor de los casos, un 'uno' para el caso medio y uno dos para el peor
     * de los casos.
     */
    public CalcTime(int CantMax,int bitDiference){
        this._bitDiference=bitDiference;
        this._length=CantMax;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado en un arbol AVL 
     * segun la cantidad de datos, puede realizar borrados, inserciones y 
     * busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'uno' para insercion, un 'dos' para borrado y un 
     * 'tres' para busqueda.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long AVL(int pInstruccion){
        long tmp=0;
        long tmp2=0;
        forTrees _Dato=new forTrees(_length, _bitDiference);
        Arbol_AVL _AVL=new Arbol_AVL();
        if(pInstruccion==insert){
            for(int i=0;i<_Dato.largo();i++){
                int dato= (int)_Dato.getDato(i);
                tmp=System.nanoTime();
                _AVL.insert(dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        for(int i=0;i<_Dato.largo();i++){
            _AVL.insert((int)_Dato.getDato(i));
        }
        if(pInstruccion==delete){
            for(int i=0; i<(_Dato.largo()-1);i++){
                int dato= (int)_Dato.getAVLDel(_AVL);
                tmp=System.nanoTime();
                _AVL.delete(dato);
                tmp2=System.nanoTime();
            }
        }
        else{
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getAVL(_AVL);
                tmp=System.nanoTime();
                _AVL.search(dato);
                tmp2=System.nanoTime();
            }
        }
        return tmp2-tmp;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado en un arbol binario
     * segun la cantidad de datos, puede realizar borrados, inserciones y 
     * busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'uno' para insercion, un 'dos' para borrado y un 
     * 'tres' para busqueda.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long binario(int pInstruccion){
        long tmp=0;
        long tmp2=0;
        forTrees _Dato=new forTrees(_length, _bitDiference);
        Arbol_binario _binario= new Arbol_binario();
        if(pInstruccion==insert){
            for(int i=0;i<_Dato.largo();i++){
                int dato= (int)_Dato.getDato(i);
                tmp=System.nanoTime();
                _binario.insert(dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        for(int i=0;i<_Dato.largo();i++){
            _binario.insert(_Dato.getDato(i));
        }
        if(pInstruccion==delete){
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getBiDel(_binario);
                tmp=System.nanoTime();
                _binario.delete(dato);
                tmp2=System.nanoTime();
            }
        }
        else{
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getBi(_binario);
                tmp=System.nanoTime();
                _binario.find(dato);
                tmp2=System.nanoTime();
            }
        }
        return tmp2-tmp;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado en un arbol rojo y 
     * negro segun la cantidad de datos, puede realizar borrados, inserciones y 
     * busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'uno' para insercion, un 'dos' para borrado y un 
     * 'tres' para busqueda.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long RN(int pInstruccion){
        long tmp=0;
        long tmp2=0;
        forTrees _Dato=new forTrees(_length, _bitDiference);
        Arbol_RN _RN= new Arbol_RN();
        if(pInstruccion==insert){
            for(int i=0;i<_Dato.largo();i++){
                int dato= (int)_Dato.getDato(i);
                tmp=System.nanoTime();
                _RN.insert(dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        for(int i=0;i<_Dato.largo();i++){
            _RN.insert(_Dato.getDato(i));
        }
        if(pInstruccion==delete){
            for(int i=0; i<(_Dato.largo()/50);i++){
                int dato= (int)_Dato.getRNDel(_RN);
                tmp=System.nanoTime();
                _RN.delete(dato);
                tmp2=System.nanoTime();
            }
        }
        else{
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getRN(_RN);
                tmp=System.nanoTime();
                _RN.search(dato);
                tmp2=System.nanoTime();
            }
        }
        return tmp2-tmp;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado en un arbol splay
     * segun la cantidad de datos, puede realizar borrados, inserciones y 
     * busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'uno' para insercion, un 'dos' para borrado y un 
     * 'tres' para busqueda.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long splay(int pInstruccion){
        long tmp=0;
        long tmp2=0;
        forTrees _Dato=new forTrees(_length, _bitDiference);
        Arbol_splay _splay= new Arbol_splay();
        if(pInstruccion==insert){
            for(int i=0;i<_Dato.largo();i++){
                int dato= (int)_Dato.getDato(i);
                tmp=System.nanoTime();
                _splay.insert(dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        for(int i=0;i<_Dato.largo();i++){
            _splay.insert(_Dato.getDato(i));
        }
        if(pInstruccion==delete){
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getSpDel(_splay);
                tmp=System.nanoTime();
                _splay.delete(dato);
                tmp2=System.nanoTime();
            }
        }
        else{
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getSp(_splay);
                tmp=System.nanoTime();
                _splay.search(dato);
                tmp2=System.nanoTime();
            }
        }
        return tmp2-tmp;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado en una lista enlazada
     * segun la cantidad de datos, puede realizar borrados, inserciones y 
     * busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'uno' para insercion, un 'dos' para borrado y un 
     * 'tres' para busqueda.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long listaSDoble(int pInstruccion){
        long tmp=0;
        long tmp2=0;
        forList _Dato=new forList(_length, _bitDiference);
        ListaSdoble _LD= new ListaSdoble();
        if(pInstruccion==insert){
            for(int i=0;i<_Dato.largo();i++){
                int dato= (int)_Dato.getDato(i);
                tmp=System.nanoTime();
                _LD.insert(dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        for(int i=0;i<_Dato.largo();i++){
            _LD.insert(_Dato.getDato(i));
        }
        if(pInstruccion==delete){
            for(int i=0; i<(_Dato.largo());i++){
                int dato= (int)_Dato.getfind();
                tmp=System.nanoTime();
                _LD.deQueue(dato);
                tmp2=System.nanoTime();
            }
        }
        else{
            for(int i=0; i<(_Dato.largo());i++){
                int dato=(int)_Dato.getfind();
                tmp=System.nanoTime();
                _LD.find(dato);
                tmp2=System.nanoTime();
            }
        }
        return tmp2-tmp;
    }
    
    /**
     * metodo para obtener el tiempo de operacion realizado por metodos de 
     * busquedas aplicados en un arreglo segun la cantidad de datos, puede 
     * realizar borrados, inserciones y busquedas.
     * @param pInstruccion recibe un dato tipo entero que concuerda con la 
     * operacion pedida, un 'seis' para binaria o un 'siete' para un lineal.
     * @return retorna un dato tipo 'long' que es la cantidad de tiempo tardado 
     * en nanosegundos por el programa.
     */
    public long search(int pInstruccion){
        long tmp=0,tmp2=0;
        forArrays _Datos= new forArrays(_length, _bitDiference);
        int[] datos=_Datos.getArreglo();
        if(pInstruccion==binariS){
            binari buscar= new binari();
            for(int i=0; i<(datos.length);i++){
                int dato=_Datos.binari();
                tmp=System.nanoTime();
                buscar.binari(datos,dato);
                tmp2=System.nanoTime();
            }
            return tmp2-tmp;
        }
        lineal buscar = new lineal();
        for(int i=0; i<(datos.length);i++){
            int dato=_Datos.lineal();
            tmp=System.nanoTime();
            buscar.lineal(datos,dato);
            tmp2=System.nanoTime();
        }
        return tmp2-tmp;
    }
    
    /**
     * casos de prueba, para el segundo espacio en la instancia de la 
     * clase CalcTime no poner un cero y descomentar alguno de los 
     * tiempos para arboles que digan que no funcionan para el mejor de los casos
     * por que se cae.**
    public static void main(String[] args) {
        long tmp=0;
        for(int i =0;i<1001;i+=100){
            CalcTime nuevo = new CalcTime(i,0);
            //tmp=nuevo.listaSDoble(1);
            //tmp=nuevo.listaSDoble(2);
            //tmp=nuevo.listaSDoble(3);
            //tmp=nuevo.AVL(1);
            //tmp=nuevo.AVL(2);//**---no funciona para el mejor de los casos---
            //tmp=nuevo.AVL(3);
            //tmp=nuevo.splay(1);
            //tmp=nuevo.splay(2);//**---no funciona para el mejor y medio caso---
            //tmp=nuevo.splay(3);
            //tmp=nuevo.binario(1);
            //tmp=nuevo.binario(2);
            //tmp=nuevo.binario(3);
            //tmp=nuevo.RN(1);
            //tmp=nuevo.RN(3);
            //tmp=nuevo.search(6);
            //tmp=nuevo.search(7);
            System.out.println(tmp);
        }
    }*/
}
