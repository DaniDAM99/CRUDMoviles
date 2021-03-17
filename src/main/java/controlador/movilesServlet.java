/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Moviles;
import modelo.MovilesCRUD;

public class movilesServlet extends HttpServlet {

    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

        String op = request.getParameter("op");

        if (op.equalsIgnoreCase("listar")) {
            List<Moviles> moviles = MovilesCRUD.getMoviles();
            request.setAttribute("moviles", moviles);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }

        if (op.equalsIgnoreCase("insert1")) {
            request.getRequestDispatcher("insertar.jsp").forward(request, response);
        }

        if (op.equalsIgnoreCase("insert2")) {
            Moviles m = new Moviles();
            m.setMarca(request.getParameter("marca"));
            m.setModelo(request.getParameter("modelo"));
            m.setColor(request.getParameter("color"));
            m.setPrecio(new BigDecimal(request.getParameter("precio")));
            MovilesCRUD.insertarMovil(m);
            out.println("<p>movil insertado correctamente</p>");
            out.println("<a href='movilesServlet?op=listar'>Listado</a>");
        }

        if (op.equalsIgnoreCase("borrar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (MovilesCRUD.borrarMovil(id) > 0) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        if (op.equals("update1")) {
            id = Integer.parseInt(request.getParameter("id"));
            Moviles movil = MovilesCRUD.getMovil(id);
            request.setAttribute("movil", movil);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }

        if (op.equals("update2")) {
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String color = request.getParameter("color");
            String precio = request.getParameter("precio");
            Moviles movil = new Moviles(id, marca, modelo, color, new BigDecimal(precio));
            int filas = MovilesCRUD.actualizarMovil(movil);
            out.println("<p>movil actualizado correctamente</p>");
            out.println("<a href='movilesServlet?op=listar'>Listado</a>");
        }

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
        processRequest(request, response);
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
