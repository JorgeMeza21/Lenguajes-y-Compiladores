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
public class automatas {
    analizadorLexico lex = new analizadorLexico();
    String nombreStruct = "";
    public String reconocimientoOperaciones(String lineaAux){
        lex.proceso(lineaAux);
        int q=0;
        while(q!=100 && q!=-1){
            lex.scanner();
            switch(q){
               case 0 : if("identificador".equals(lex.t.getTipo()) || "numero".equals(lex.t.getTipo())){
                            q=1;
                        }
                        else{
                            if("++".equals(lex.t.getVal())){
                                q=2;
                            }
                            else{
                                q=-1;
                            }
                        }
                        break;
               case 1 : if("=".equals(lex.t.getVal())){
                            q=2;
                        }
                        else{
                            if("++".equals(lex.t.getVal())){
                                q=3;
                            }
                            else{
                                q=-1;
                            }
                        }
                        break;
               case 2 : if("identificador".equals(lex.t.getTipo()) || "numero".equals(lex.t.getTipo())){
                            q=3;
                            
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 3 : if(";".equals(lex.t.getVal())){
                            q=4;
                        }
                        else{
                            if("operador".equals(lex.t.getTipo())){
                                q=2;
                            }else{
                                q=-1;
                            }
                        }
                        break;
               case 4 : if("$".equals(lex.t.getVal())){
                            q=100;
                        }else{
                            q=-1;
                            
                        }
            }
        }
        if(q==100){
            return "reconoce";
        }
        else{
            return "error";
        }
    }
    public String reconocimientoDeclaraciones(String lineaAux){
     //   System.out.println(nombreStruct);
        lex.proceso(lineaAux);
        int q=0;
        while(q!=100 && q!=-1){
            lex.scanner();
            switch(q){
                case 0 : if("int".equals(lex.t.getVal())||"float".equals(lex.t.getVal())||"char".equals(lex.t.getVal())||"void".equals(lex.t.getVal()) || nombreStruct.equals(lex.t.getVal()) ){
                            q=1;
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 1 : if("identificador".equals(lex.t.getTipo())){
                            q=2;
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 2 : if(";".equals(lex.t.getVal())){
                            q=4;
                        }
                        else{
                            if("=".equals(lex.t.getVal())){
                                q=3;
                            }
                            else{
                                if(",".equals(lex.t.getVal())){
                                    q=1;
                                }
                                else{
                                    q=-1;
                                }
                            }
                        }
                        break;
               case 3 : if("numero".equals(lex.t.getTipo())){
                            q=2;
                        }
                        else{
                            q=-1;
                        }
                        break;
                case 4 : if("$".equals(lex.t.getVal())){
                            q=100;
                            
                        }
                        else{
                            q=-1;
                        }
                        break;
            }           
        }
        if(q==100){
            return "reconoce";
        }
        else{
            return "error";
        }
    }
    public String reconocimientoVector(String lineaAux){
        lex.proceso(lineaAux);
        int q=0;
        while(q!=100 && q!=-1){
            lex.scanner();
            switch(q){
               case 0 : if("int".equals(lex.t.getVal())||"float".equals(lex.t.getVal())||"char".equals(lex.t.getVal())||"void".equals(lex.t.getVal())){
                            q=1;
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 1 : if("identificador".equals(lex.t.getTipo())){
                            q=2;
                        }
                        else{
                            q=-1;
                        }
                        break;
                case 2 : if("[".equals(lex.t.getVal()) ){
                            q=3;
                        }
                        else{
                            q=-1;
                        }
                        break;
                case 3 : if("numero".equals(lex.t.getTipo())){
                            q=4;
                        }
                        else{
                                q=-1;
                        }
                        break;
               case 4 : if("]".equals(lex.t.getVal())){
                            q=5;
                        }else{
                            q=-1;
                        }
                        break;
               case 5 : if("=".equals(lex.t.getVal())){
                            q=6;
                        }else{
                            if(";".equals(lex.t.getVal())){
                                q=10;
                            }
                            else{
                                q=-1;
                            }
                        }
                        break;
               case 6 : if("{".equals(lex.t.getVal())){
                            q=7;
                        }else{
                            q=-1;
                        }
                        break;
               case 7 : if("numero".equals(lex.t.getTipo())){
                            q=8;
                        }else{
                            q=-1;
                        }
                        break;
               case 8 : if(",".equals(lex.t.getVal())){
                            q=7;
                        }else{
                            if("}".equals(lex.t.getVal())){
                                q=9;
                            }else{
                                q=-1;
                            }
                        }
                        break;
               case 9 : if(";".equals(lex.t.getVal())){
                            q=10;
                        }else{
                            q=-1;
                        }
                        break;
               case 10: if("$".equals(lex.t.getVal())){
                            q=100;
                        }else{
                            q=-1;
                        }
            }
                        
        }       
        if(q==100){
            return "reconoce";
        }
        else{
            return "error";
        }
    }
    
    public String reconocimientoEstructuras(String lineaAux){
        lex.proceso(lineaAux);
        int q=0;
        while(q!=100 && q!=-1){
            lex.scanner();
            switch(q){
                case 0 : if("Struct".equals(lex.t.getVal())){
                            q=1;
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 1 : if("identificador".equals(lex.t.getTipo())){
                            q=2;
                            nombreStruct=lex.t.getVal();
                            //System.out.println(nombreStruct);
                        }
                        else{
                            q=-1;
                        }
                        break;
               case 2 : if("{".equals(lex.t.getVal())){
                            q=3;
                        }else
                            q=-1;
                        break;
               case 3 : if("}".equals(lex.t.getVal())){
                            q=4;
                        }
                        else{
                            if("int".equals(lex.t.getVal())||"float".equals(lex.t.getVal())||"char".equals(lex.t.getVal()) || "identificador".equals(lex.t.getTipo())){
                                q=6;
                            }
                            else{
                                q=-1;
                            }
                        }
                        break;         
                case 4 : if(";".equals(lex.t.getVal())){
                            q=5;
                        }
                        else{
                            q=-1;
                        }
                        break;
                case 5 : if("$".equals(lex.t.getVal())){
                            q=100;
                        }
                        else{
                            q=-1;
                        }
                        break;
                case 6 : if("identificador".equals(lex.t.getTipo())){
                            q=7;
                        }else
                            q=-1;
                        break;
                case 7 : if(";".equals(lex.t.getVal())){
                            q=3;
                        }else
                            q=-1;
            }
           
        }
        if(q==100){
            return "reconoce";
        }
        else{
            return "error";
        }
    }
}
