/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.Random;

/**
 *
 * @author osboxes
 */
public class forArrays implements Constantes{
    private int[] _datos;
    private Random _rnd = new Random();
    private int _leght, _bitDiference;
    
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
    
    public int largo (){
        return _leght;
    }
    
    public int getDato(){
        if(_bitDiference==cero)
            return _datos[cero];
        else if (_bitDiference==uno)
            return _datos[_rnd.nextInt(_leght-1)+1];
        else
            return _datos[_leght-1];
    }
    
    public int[] getArreglo(){
        return _datos;
    }
    
    private void better(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _datos[i]=i;
        }
    }
    
    private void normal(int pCantMax){
        for (int i=0; i<pCantMax; i++){
            _datos[i]=_rnd.nextInt(pCantMax/50)+1;
        }
    }
    
    private void worst(int pCantMax){
        for (int i=pCantMax; i>0; i--){
            _datos[i]=i;
        }
    }
}
