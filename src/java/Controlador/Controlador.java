/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tienda;
import ModeloDAO.TiendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String login="vistas/login.jsp";
    String registro="vistas/registro.jsp";
    String servicios="vistas/servicios.jsp";
    String index="index.jsp";
    
    Tienda tienda=new Tienda();
    TiendaDAO tdao=new TiendaDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String acceso="";
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("ingresar")){
            System.out.println("CONTROLADOR LOGIN");
            int r;
             String correo=request.getParameter("txtEmail");
             String clave=request.getParameter("txtClave");
             
             tienda.setEmail(correo);
             tienda.setClave(clave);
             
             r=tdao.validar(tienda);
             
             if(r!=0){
             
                 acceso=servicios+"/?id="+r;
             }else{
                acceso=index;
             }
        }
        acceso=index;
         RequestDispatcher vista=request.getRequestDispatcher(acceso);
       vista.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acceso="";
       String action=request.getParameter("accion");
       
       if(action.equalsIgnoreCase("registrar")){
       
           String nombre=request.getParameter("txtNombre");
           String lema=request.getParameter("txtLema");
           String descripcion=request.getParameter("txtDescripcion");
           String email=request.getParameter("email");
           String clave=request.getParameter("txtPassword");
           String propietario=request.getParameter("txtPropietario");
           String facebook=request.getParameter("txtFacebook");
           String web=request.getParameter("txtWeb");
           String imagen=request.getParameter("txtImagen");
           
         List<Tienda> list=tdao.listar();
                        Iterator<Tienda>iter=list.iterator();
                        Tienda t=null;
                        int c=0;
                        
                        while(iter.hasNext()){
                            t=iter.next();
                            if(t.getEmail().equalsIgnoreCase(email)){
                                c++;
                            }
                        }
           if(c!=0){
           
               acceso=registro+"?mensaje=error";
           }else{
           
           
           
           
           tienda.setNombre(nombre);
           tienda.setLema(lema);
           tienda.setDescripcion(descripcion);
           tienda.setEmail(email);
           tienda.setClave(clave);
           tienda.setPropietario(propietario);
           tienda.setFacebook(facebook);
           tienda.setWeb(web);
           tienda.setImagen(imagen);
           
           tdao.add(tienda);
           acceso=index+"mensaje=registro";
           }
           
       }
       
       
       RequestDispatcher vista=request.getRequestDispatcher(acceso);
       vista.forward(request, response);
       
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
