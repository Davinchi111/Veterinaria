/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Gato;
import modelo.Perro;

/**
 *
 * @author oscar
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList <Gato> kit=new ArrayList();
    ArrayList <Perro> dog=new ArrayList();
    int n=0;
    int z=0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tipo=request.getParameter("tipomasc");
            String accion=request.getParameter("accion"); 
            Gato gatow=new Gato();
            Perro perrow=new Perro();
            Gato morris=new Gato(true, "Morris", 5, "Angora", "Blanco");
            if(n==0){
                kit.add(morris);
                n=1;
            }
            if(z==0){
                Perro firulais = new Perro(1, "Firulais", 10, "Chihuahua", "Negro");
                Perro mike = new Perro(3, "Mike", 5, "Gran danés", "Café");
                dog.add(firulais);
                dog.add(mike);
                z=1;
            }
            
            if(!accion.equals("datos")){
                if(accion.equals("agregar")){               
                    int edad=Integer.parseInt(request.getParameter("edad"));               
                    String raza=request.getParameter("raza");
                    String nombre=request.getParameter("nombre");
                    String color=request.getParameter("color");
                    if(tipo.equals("Gato")) {   
                        boolean conf=true;
                        String toxo=request.getParameter("toxo");
                        if(toxo.equals("no"))conf=false;
                        Gato gato=new Gato(conf, nombre, edad, raza, color);
                        gatow.añadirGato(conf, nombre, edad, raza, color);   
                        kit.add(gato);                          
                    }
                    if(tipo.equals("Perro")) {        
                        int nivel=Integer.parseInt(request.getParameter("nivel"));
                        Perro perro=new Perro(nivel, nombre, edad, raza, color);
                        perrow.añadirPerro(nivel, nombre, edad, raza, color);
                        dog.add(perro); 
                    }
                    request.getRequestDispatcher("index.html").forward(request, response);
                }else{
                    int x=Integer.parseInt(request.getParameter("ind"));
                    x=x-1;
                    if(tipo.equals("Gato")) {   
                        kit.remove(x);
                    }
                    if(tipo.equals("Perro")) {        
                        dog.remove(x);
                    }
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
                
            }
            perrow.setlist(dog);
            gatow.setlist(kit);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos</title>"); 
            out.println("<link href=\"micss.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"box1\">Animales adentro: " + (perrow.calcularTotal()+gatow.calcularTotal())+"</div>");  
            out.println("<div id=\"box2\">");
            out.println("<br><p>Perros: </p>");
            out.println("<p>"+perrow.imprimir()+"</p>");
            out.println("<p>Total de perros: "+perrow.calcularTotal()+"</p>");
            out.println("<p>Gatos: </p>");
            out.println("<p>"+gatow.imprimir()+"</p>");
            out.println("</body>");
            out.println("</html>");    
            out.println("<p>Total de gatos: "+gatow.calcularTotal()+"</p>");
            out.println("<p>Promedio de edades: "+(Double.valueOf(perrow.edades()+gatow.edades())/Double.valueOf(gatow.calcularTotal()+perrow.calcularTotal()))+"</p>"); 
            out.println("</div>");
            out.println("<form action=\"index.html\" method=\"POST\"> ");
            out.println("<button type=\"submit\" value=\"volver\">Volver</button>");
            out.println("</form>");
            
 
        }
        
    }
}
