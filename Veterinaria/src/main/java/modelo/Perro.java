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
public class Perro extends Mascotas implements IMascotas{
    ArrayList lista = new ArrayList();  
    
    private int nivelEntrenamiento;

    public int getNivelEntrenamiento() {
        return nivelEntrenamiento;
    }

    public void setNivelEntrenamiento(int nivelEntrenamiento) {
        this.nivelEntrenamiento = nivelEntrenamiento;
    }

    public Perro() {
    }
    
    public Perro(int nivelEntrenamiento, String nombre, int edad, String raza, String color) {
        super(nombre, edad, raza, color);
        this.nivelEntrenamiento = nivelEntrenamiento;
    }
    
    public void añadirPerro(int nivelEntrenamiento, String nombre, int edad, String raza, String color){      
        Perro perro=new Perro(nivelEntrenamiento, nombre, edad, raza, color);
        lista.add(perro);
    }
    
    @Override
    public int calcularTotal() {
        int a=lista.size();
        return a;
    }
    
    public String imprimir(){
        int i=0;
        Iterator ite = lista.iterator();
        String xd="";
        while (ite.hasNext()) {
                i++;
                Object obj1 = ite.next();
                Perro perro = (Perro) obj1;
                xd=xd+i+". "+perro.datos()+"<br>";
        }
        return xd;
    }
    
    @Override
    public String datos (){
        return "La mascota se llama "+getNombre()+", es de raza "+getRaza()+ ", es de color " +getColor() + ", tiene "+getEdad()+" años,  \n"+"y tiene un nivel "+getNivelEntrenamiento()+" de entrenamiento.";
    }
    
    @Override
    public int edades(){
        int edadp =0;
        Iterator ite = lista.iterator();
        while (ite.hasNext()) {
            Object obj1 = ite.next();
            Perro perro=(Perro)obj1;
            edadp=edadp+perro.getEdad();
        }
        return edadp;
    }
    
    public void setlist(ArrayList list){
        this.lista=list;
    }

}
