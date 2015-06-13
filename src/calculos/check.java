/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import lists.ListaSdoble;
import search.binari;
import search.lineal;
import sort.inserSort;
import tree.Arbol_AVL;
import tree.Arbol_RN;
import tree.Arbol_binario;
import tree.Arbol_splay;

/**
 *
 * @author osboxes
 */
public class check implements Constantes{
    private Array _Dato;
    
    public check(Array dato){
        this._Dato=dato;
    }
    
    public long AVL(String pInstruccion){
        long tmp;
        long tmp2;
        Arbol_AVL _AVL=new Arbol_AVL();
        if(pInstruccion.equals(insert)){
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _AVL.insert(_Dato.getDato(i));
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pInstruccion.equals(delete)){
            for(int i=0;i<_Dato.largo();i++){
                _AVL.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _AVL.delete(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            for(int i=0;i<_Dato.largo();i++){
                _AVL.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _AVL.search(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    
    public long binario(String pInstruccion){
        long tmp;
        long tmp2;
        Arbol_binario _binario= new Arbol_binario();
        if(pInstruccion.equals(insert)){
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _binario.insert(_Dato.getDato(i));
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pInstruccion.equals(delete)){
            for(int i=0;i<_Dato.largo();i++){
                _binario.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _binario.delete(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            for(int i=0;i<_Dato.largo();i++){
                _binario.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _binario.find(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    
    public long RN(String pInstruccion){
        long tmp;
        long tmp2;
        Arbol_RN _RN= new Arbol_RN();
        if(pInstruccion.equals(insert)){
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _RN.insert(_Dato.getDato(i));
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pInstruccion.equals(delete)){
            for(int i=0;i<_Dato.largo();i++){
                _RN.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _RN.delete(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            for(int i=0;i<_Dato.largo();i++){
                _RN.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _RN.search(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    
    public long splay(String pInstruccion){
        long tmp;
        long tmp2;
        Arbol_splay _splay= new Arbol_splay();
        if(pInstruccion.equals(insert)){
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _splay.insert(_Dato.getDato(i));
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pInstruccion.equals(delete)){
            for(int i=0;i<_Dato.largo();i++){
                _splay.insert(_Dato.getDato(i));
            }
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _splay.delete(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _splay.insert(_Dato.getDato(i));
            }
            for(int i=0; i<(_Dato.largo()/50);i++){
                _splay.search(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    
    public long listaSDoble(String pInstruccion){
        long tmp;
        long tmp2;
        ListaSdoble _LD= new ListaSdoble();
        if(pInstruccion.equals(insert)){
            tmp=System.nanoTime();
            for(int i=0;i<_Dato.largo();i++){
                _LD.enQueue(_Dato.getDato(i));
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else if(pInstruccion.equals(delete)){
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _LD.deQueue(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        else{
            tmp=System.nanoTime();
            for(int i=0; i<(_Dato.largo()/50);i++){
                _LD.find(_Dato.getRandArray());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
    }
    
    public long search(String pInstruccion){
        long tmp,tmp2;
        int[] datos=_Dato.getArreglo();
        if(pInstruccion.equals(binariS)){
            inserSort ordenar=new inserSort();
            ordenar.insertSort(datos);
            binari buscar= new binari();
            tmp=System.nanoTime();
            for(int i=0; i<(datos.length/50);i++){
                buscar.binari(datos, _Dato.getRandArreglo());
            }
            tmp2=System.nanoTime();
            return tmp2-tmp;
        }
        lineal buscar = new lineal();
        tmp=System.nanoTime();
        for(int i=0; i<(datos.length/50);i++){
            buscar.lineal(datos, _Dato.getRandArreglo());
        }
        tmp2=System.nanoTime();
        return tmp2-tmp;
    }
    
    public static void main(String[] args) {
        Array arreglo =new Array(100, 0);
        check nuevo = new check(arreglo);
        nuevo.splay("se");
    }
}
