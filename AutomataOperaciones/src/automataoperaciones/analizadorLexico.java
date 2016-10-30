/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automataoperaciones;

import java.util.Scanner;

/**
 *
 * @author Jorge M
 */
public class analizadorLexico {
    Scanner leer = new Scanner(System.in);
    Token t = new Token();
    int j=0;
    public void proceso(String nuevaCadena){
        t.cadena=nuevaCadena;
    }
    public void  scanner(){
        boolean fin=false;
        boolean fin2=false;
        boolean fin3=false, fin4=false;
        
        int x;
        t.setVal("");
        char c=' ';
        
        if(j>=t.cadena.length()){
            c='$';
        }
        else{
            while(t.cadena.charAt(j)==' '){
                j++;
            }
        }
        if(c=='$'){ 
            t.setVal(t.getVal()+c);
        }
        else{
            c=t.cadena.charAt(j);
        }
        if(('A'<=c || 'a'<=c) && (c<='Z' || c<='z') && c!='[' && c!=']'){
            while (j<t.cadena.length() && c!=' ' && c!='[' && c!=']' && (('A'<=c || 'a'<=c) && (c<='Z' || c<='z') || Character.isDigit(c))){
                if(Character.isDigit(c)){
                    x = Character.getNumericValue(c);
                    while(x>=0 && x<=9 && fin2==false){
                        String g2=Integer.toString(x);
                        t.setVal(t.getVal()+g2);
                        j++;
                        if(j<t.cadena.length()){
                            c=t.cadena.charAt(j);
                            x=Character.getNumericValue(c);
                        }
                        else{
                            fin2=true;
                        }
                    }
                }
                else{ 
                    while(((('A'<=c || 'a'<=c) && (c<='Z' || c<='z')) &&  c!='[' && c!=']'&&  fin==false)) {
                        t.setVal(t.getVal()+c);
                        j++;
                        if(j<t.cadena.length()){
                            c=t.cadena.charAt(j);
                        }
                        else{
                            fin=true;
                        }
                    }
                }
            }
            t.tipo="identificador";
        }
        else{
            if(Character.isDigit(c)){
                int y = Character.getNumericValue(t.cadena.charAt(j));
            
                while(0<=y && y<=9 && fin3==false){
                    String g=Integer.toString(y);
                    t.setVal(t.getVal()+g);
                    j++;
                    if(j<t.cadena.length()){
                        c=t.cadena.charAt(j);
                        y = Character.getNumericValue(c);
                    }
                    else{
                        fin3=true;
                    }      
                }
                t.tipo="numero";
            }else{
                if(c==',' || c=='(' || c==')' || c=='=' || c=='*' || c=='/' || c=='-' || c=='+' || c==']' || c=='[' || 
	           c=='<' || c=='>' || c==';'|| c=='!' || c== '¡' || c=='}' || c=='{'){
                    t.setVal(t.getVal()+c);
                    if(j<t.cadena.length()-1){
                        if ((c=='-' && t.cadena.charAt(j+1)=='-') ||
                            (c=='+' && t.cadena.charAt(j+1)=='+') ||
                            (c=='<' && t.cadena.charAt(j+1)=='=') ||
                            (c=='>' && t.cadena.charAt(j+1)=='=') || (c=='!' && t.cadena.charAt(j+1)=='='))
                        {
                         t.setVal(t.getVal()+t.cadena.charAt(j+1));
                         j++;
			}
                    }
                    j++;  
                }
                t.tipo="operador";
            }
        }
    }
}
