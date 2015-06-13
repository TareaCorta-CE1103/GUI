/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import calculos.getTime;
import calculos.Constantes;
import lists.ListaSdoble;
import lists.Nodo;
/**
 *
 * @author osboxes
 */
public class facade implements Constantes{
    
    private getTime _RandCien;
    private getTime _RandMil;
    private getTime _RandCienMil;
    private getTime _normalCien;
    private getTime _normalMil;
    private getTime _normalCienMil;
    private getTime _worstCien;
    private getTime _worstMil;
    private getTime _worstCienMil;
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
        _RandCien=new getTime(cien, cero);
        _RandMil=new getTime(Mil, cero);
        _RandCienMil=new getTime(cienMil, cero);
        _normalCien= new getTime(cien, uno);
        _normalMil= new getTime(Mil, uno);
        _normalCienMil= new getTime(cienMil, uno);
        _worstCien= new getTime(cien, dos);
        _worstMil= new getTime(Mil, dos);
        _worstCienMil= new getTime(cienMil, dos);
    }
    
    public void setMensaje(String mens){
        this._mensaje=mens;
        _mensajes= new ListaSdoble();
        int x=cero;
        int y=cuatro;
        while(y<=_mensaje.length()){
            if(_mensajes.find(_mensaje.substring(x,y))!=null){}
            else
                _mensajes.enQueue(_mensaje.substring(x,y));
            x=y;
            y=y+cuatro;
        }
    }
    
    public void run(){
        Nodo tmp = _mensajes.getHead();
        while(tmp!=null){
            _rand.enQueue(_RandCien.Time((String)tmp.getData()));
            _rand.enQueue(_RandMil.Time((String)tmp.getData()));
            _rand.enQueue(_RandCienMil.Time((String)tmp.getData()));
            _normal.enQueue(_normalCien.Time((String)tmp.getData()));
            _normal.enQueue(_normalMil.Time((String)tmp.getData()));
            _normal.enQueue(_normalCienMil.Time((String)tmp.getData()));
            _worst.enQueue(_worstCien.Time((String)tmp.getData()));
            _worst.enQueue(_worstMil.Time((String)tmp.getData()));
            _worst.enQueue(_worstCienMil.Time((String)tmp.getData()));
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
        nuevo.setMensaje("inAV");
        nuevo.run();
        nuevo.getRand().print();
    }
}
