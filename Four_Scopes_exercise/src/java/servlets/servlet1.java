/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanluis
 */
public class servlet1 extends HttpServlet {
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        counterClass counterPage, counterRequest, counterSession, counterApplication;
        
        //manage the creation/use of the these 4 counters
        //each one with the corresponding scope
        
        // Page Scope
        counterPage = new counterClass();
        // Request Scope
        counterRequest = (counterClass) ((request.getAttribute("counterRequest")!=null) ? 
                            request.getAttribute("counterRequest") : new counterClass());
        // Session Scope
        HttpSession session = request.getSession();
        counterSession = (counterClass) ((session.getAttribute("counterSession") != null)?
                             session.getAttribute("counterSession") : new counterClass());
        // Application Scope
        ServletContext App = getServletContext();
        counterApplication = (counterClass) ((App.getAttribute("counterApplication") != null) ?
                              App.getAttribute("counterApplication") : new counterClass());
        
        counterPage.counter++;
        counterRequest.counter++;
        counterSession.counter++;
        counterApplication.counter++;
        
        // We store the value in the Request, Session and Application scope
        request.setAttribute("counterRequest", counterRequest);
        request.getSession().setAttribute("counterSession", counterSession);
        getServletContext().setAttribute("counterApplication", counterApplication);
        
        
        
        
        
        if(counterSession.counter==3){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/servlet2");
            rd.forward(request,response);
        }
        
        else{
        
            try {
                /*
                * TODO output your page here. You may use following sample code.
                */
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet servlet1</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Page scope counter value: " + counterPage.counter + "</h1>");
                out.println("<h1>Request scope counter value: " + counterRequest.counter + "</h1>");
                out.println("<h1>Session scope counter value: " + counterSession.counter + "</h1>");
                out.println("<h1>Application scope counter value: " + counterApplication.counter + "</h1>");
                out.println("</body>");
                out.println("</html>");
            } finally {            
                out.close();
            }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
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
