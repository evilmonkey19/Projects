package web;

import entity.Incidencies;
import other.Incidencia;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.IncidenciesModel;

/**
 *
 * @author evilmonkey19
 */
public class generacio extends HttpServlet {
    private int id =0;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        id++;
        
        Incidencies incidencia = new Incidencies();
        incidencia.setCentre(request.getParameter("centre"));
        incidencia.setCausa(request.getParameter("causa"));
        incidencia.setRelevancia(request.getParameter("relevancia"));

        ServletContext context = getServletContext();
        IncidenciesModel model = (IncidenciesModel) context.getAttribute("IncidenciesModel");
        boolean created = model.createIncidencia(incidencia);
        
        request.setAttribute("Incidencia", incidencia);
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/generacio.jsp");
        rd.forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
