/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automataoperaciones;

/**
 *
 * @author Jorge M
 */
public class Lista {
    Nodo cab;
    public Lista(){
        cab=null;
    }
    public void insertarAlFinal(String nuevo){
        Nodo tem = new Nodo();
        tem.info=nuevo;
        if(cab==null){
            cab=tem;
           
        }
        else{
            Nodo aux=cab;
            while(aux.enlace!=null){
                aux=aux.enlace;
            }
            aux.enlace=tem;
        }
    }
}
