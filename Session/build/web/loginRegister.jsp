<%-- 
    Document   : loginRegister
    Created on : 24/06/2018, 17:30:14
    Author     : yago
--%>

<%@ include file="header.jsp" %>
    <%
        Object fail1 = session.getAttribute("fail");
        if(fail1 != null){
            String fail = (String) fail1;
    %>
    <span><%=fail%></span>
    <%
        session.setAttribute("fail", null);
        }
        if(request.getParameter("login").equals("login")){
            out.println("<H2 align= \"center\" >Login</H2><br>");
            out.println("<form action=\"/Session/login\" method=\"POST\">");
        }
        if (request.getParameter("login").equals("register")){
            out.println("<H2 align= \"center\" >Register</H2><br>");
            out.println("<form action=\"/Session/register\" method=\"POST\">");
        }
    %>
        <div class="imgcontainer">
            <img src="images.png" alt="Avatar" class="avatar">
        </div>
        <br><label>Username:</label>
        <input type="text" placeholder="Enter Username" name="name" required>
        <br><br><label>Password:</label>
        <input type="password" placeholder="Enter Password" name="password" required>            
        <%
            if(request.getParameter("login").equals("login")){
                out.println("<button type=\"submit\">Login</button>");
                out.println("</form>");
            }
            if (request.getParameter("login").equals("register")){
                out.println("<button type=\"submit\">Register</button>");
                out.println("</form>");
            }
        %>
<%@ include file="footer.html" %>
