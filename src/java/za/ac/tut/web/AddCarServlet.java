/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.jboss.classfilewriter.util.ByteArrayDataOutputStream;
import za.ac.tut.bl.CarsFacadeLocal;
import za.ac.tut.entity.Cars;

/**
 *
 * @author karab
 */
@MultipartConfig
public class AddCarServlet extends HttpServlet {

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB CarsFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Part part = request.getPart("file");
        byte[] img_source = new byte[0];
        if(part.getContentType()!=null){
            InputStream input=part.getInputStream();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int byte_integer = 0;
            while((byte_integer=input.read(buffer))!=-1)
            {
                baos.write(buffer,0,byte_integer);
            }
            img_source=baos.toByteArray();
        }
        Cars car = new Cars();
        car.setName(name);
        car.setImage_source(img_source);
        
        cfl.create(car);
        request.setAttribute("name", name);
        request.setAttribute("img_source", img_source);
        RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
        rd.forward(request, response);
        
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
