/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yago
 */
@WebServlet(urlPatterns = {"/Session", "/login", "/index", "/loginRegister", "/register"})
public class Session extends HttpServlet {
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
        String path = request.getRequestURI().substring(request.getContextPath().length());
        
        HttpSession sessao = request.getSession();
        
        
        if(request.getMethod().equalsIgnoreCase("POST")){
            switch (path){
            case "/login":
                Cookie cookie1 = null;
                for(Cookie cookie: request.getCookies()){
                    if(cookie.getName().equals(request.getParameter("name")) && cookie.getValue().equals(request.getParameter("password"))) {
                        cookie1 = cookie;
                    }
                }
                if(cookie1==null){
                    sessao.setAttribute("fail", "You aren't registered!");
                    response.sendRedirect("/Session/loginRegister?login=register");
                } else {
                    sessao.setAttribute("time", System.currentTimeMillis());
                    response.sendRedirect("/Session/index");
                }
                break;
            case "/register":
                response.setContentType("text/html;charset=UTF-8");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                sessao.setAttribute("name", request.getParameter("name"));
                Cookie cookie2 = null;
                for(Cookie cookie: request.getCookies()){
                    if(cookie.getName().equals(request.getParameter("name"))) {
                        cookie2 = cookie;
                    }
                }
                if (cookie2 == null){
                    cookie2 = new Cookie(name, password);
                    response.addCookie(cookie2);
                    response.sendRedirect("/Session/index");
                } else {
                    sessao.setAttribute("fail", "You already registered!");
                    response.sendRedirect("/Session/loginRegister?login=register");
                }
                break;
            }
        } else {
            switch (path){
            case "/index":
                Long seconds = (Long) sessao.getAttribute("time");
                long time = 0;
                if (seconds != null){
                    time = seconds;
                }
                if (System.currentTimeMillis() - time > 30000){
                    time = 0;
                    sessao.setAttribute("time", time);
                }
                response.setContentType("text/html;charset=UTF-8");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/loginRegister":
                response.setContentType("text/html;charset=UTF-8");
                request.getRequestDispatcher("/loginRegister.jsp").forward(request, response);
                break;
            }
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