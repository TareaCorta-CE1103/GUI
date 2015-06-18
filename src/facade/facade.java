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
 *
 * @author osboxes
 */
public class facade implements Constantes{
    
    private Decode _RandCien;
    private Decode _normalCien;
    private Decode _worstCien;
    private String _mensaje;
    private ListaSdoble _mensajes;
    private ListaSdoble _rand;
    private ListaSdoble _normal;
    private ListaSdoble _worst;
    
    public facade(){
        _mensajes= new ListaSdoble();
        _normal= new ListaSdoble();
        _rand= new ListaSdoble();
        _worst= new ListaSdoble();
        _RandCien=new Decode(cien, cero);
        _normalCien= new Decode(cien, uno);
        _worstCien= new Decode(cien, dos);
    }
    
    public void setMensaje(ListaSdoble mensajes){
        this._mensajes=mensajes;
    }
    
    public void run(){
        Nodo tmp = _mensajes.getHead();
        while(tmp!=null){
            _rand.enQueue(_RandCien.Time((int)tmp.getData()));
            _rand.enQueue(_RandCien.Time((int)tmp.getData()));
            _rand.enQueue(_RandCien.Time((int)tmp.getData()));
            _normal.enQueue(_normalCien.Time((int)tmp.getData()));
            _normal.enQueue(_normalCien.Time((int)tmp.getData()));
            _normal.enQueue(_normalCien.Time((int)tmp.getData()));
            _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            _worst.enQueue(_worstCien.Time((int)tmp.getData()));
            tmp=tmp.getNext();
        }
    }
    
    public ListaSdoble getMensajes(){
        return _mensajes;
    }
    
    public ListaSdoble getRand(){
        return _rand;
    }
    
    public ListaSdoble getNormal(){
        return _normal;
    }
    
    public ListaSdoble getWorst(){
        return _worst;
    }
    
    public static void main(String[] args) {
        facade nuevo = new facade();
        //nuevo.setMensaje("inAV");
        //nuevo.run();
        //nuevo.getRand().print();
    }
}
