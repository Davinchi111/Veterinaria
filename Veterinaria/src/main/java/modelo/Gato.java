/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author oscar
 */
public class Gato extends Mascotas implements IMascotas{
    ArrayList <Gato> listag = new ArrayList();
    private boolean libreToxoplasmosis;

    int i=0;
    
    public boolean isLibreToxoplasmosis() {
        return libreToxoplasmosis;
    }

    public void setLibreToxoplasmosis(boolean libreToxoplasmosis) {
        this.libreToxoplasmosis = libreToxoplasmosis;
    }

    public Gato() {
    }

    public Gato(boolean libreToxoplasmosis, String nombre, int edad, String raza, String color) {
        super(nombre, edad, raza, color);
        this.libreToxoplasmosis = libreToxoplasmosis;
    }
    
    public void añadirGato(boolean libreToxoplasmosis, String nombre, int edad, String raza, String color){
        Gato gato=new Gato();
        gato.setColor(color);
        gato.setEdad(edad);
        gato.setLibreToxoplasmosis(libreToxoplasmosis);
        gato.setNombre(nombre);
        gato.setRaza(raza);
        if(!listag.contains(gato)){
            listag.add(listag.size(),gato);
        }    
    }
    
    public void setlist(ArrayList list){
        this.listag=list;
    }
    
    @Override
    public String datos (){
        Gato feli=new Gato();
        boolean conf=feli.isLibreToxoplasmosis();
        String mes;
        if(conf==true){
            mes="libre de toxoplasmosis.";
        }else{
            mes="con toxoplasmosis.";
        }
        return "La mascota se llama "+getNombre()+", es de raza "+getRaza()+ ", es de color " +getColor() + ", tiene "+getEdad()+" años,  \n"+"está "+mes;
    }
    
    public String imprimir(){
        Iterator ite2 = this.listag.iterator();
        String a="";
        while (ite2.hasNext()) {
                i++;
                Object obj2 = ite2.next();
                Gato feli = (Gato) obj2;
                a=a+i+". "+feli.datos()+"<br>";
        }
        return a;
    }
    
    @Override
    public int calcularTotal() {
        int a=this.listag.size();
        return a;
    }
    
    @Override
    public int edades(){
        int edadg =0;
        
        Iterator ite2 = this.listag.iterator();
        
        while (ite2.hasNext()) {
            Object obj2 = ite2.next();
            Gato gato=(Gato)obj2;
            edadg=edadg+gato.getEdad();
        }
        return edadg;
    }
    
}
