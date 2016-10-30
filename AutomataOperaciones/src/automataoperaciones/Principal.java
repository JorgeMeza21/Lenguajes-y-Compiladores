/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automataoperaciones;
import java.io.*;
/**
 *
 * @author Jorge M
 */
public class Principal {
    Lista lista = new Lista();
    String linea;
    public void almacenarLineas() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("compila.txt");
        BufferedReader br = new BufferedReader(fr);
        while((linea=br.readLine())!=null){
            if(linea.charAt(0)=='S' && linea.charAt(1)=='t' && linea.charAt(2)=='r' && linea.charAt(3)=='u' && linea.charAt(4)=='c' && linea.charAt(5)=='t'){
                String auxiliar=linea;
                while(!linea.equals("};")){
                    linea=br.readLine();
                    auxiliar=auxiliar.concat(linea);
                }
                lista.insertarAlFinal(auxiliar);
            }
            else{
                lista.insertarAlFinal(linea);
            }
        }
    }
    
    public void lineaRegistro(){
        
    }
    public String reconocimientoGeneral(){
        boolean zz = true;
        Nodo aux=lista.cab;
        String auxOpera="";
        String auxDecla="";
        String auxVector="";
        String auxStruct="";
        String z="reconoce";
        while(aux!=null){
            automatas auto1 = new automatas();
            automatas auto2 = new automatas();
            automatas auto3 = new automatas();
            automatas auto4 = new automatas();
            auxStruct=auto4.reconocimientoEstructuras(aux.info);
            auxOpera=auto1.reconocimientoOperaciones(aux.info);
            if(zz=true){
                auto2.nombreStruct=auto4.nombreStruct;
                System.out.println(auto2.nombreStruct);
                zz=false;
            }
            auxDecla=auto2.reconocimientoDeclaraciones(aux.info);
            auxVector=auto3.reconocimientoVector(aux.info);
            
            if(auxOpera.equals("reconoce") || auxDecla.equals("reconoce") || auxVector.equals("reconoce") || auxStruct.equals("reconoce")){
                aux=aux.enlace;
            }
            else{
                z="error";
                break;
            }
        }
        return z;
    }
    public static void main(String[] args) throws IOException {
     //   automataOperaciones a = new automataOperaciones();
     //   System.out.println(a.reconocimiento());
        Principal p = new Principal();
        p.almacenarLineas();
        System.out.println(p.reconocimientoGeneral());
    }
    
}
