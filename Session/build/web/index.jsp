<%-- 
    Document   : index
    Created on : 24/06/2018, 16:31:29
    Author     : yago
--%>

<%@ include file="header.jsp" %>
        <%
            Long seconds = (Long) session.getAttribute("time");
            if (seconds != null && seconds != 0){
                long time = (System.currentTimeMillis() - seconds) / 1000;
        %>
        
        <%
            String name = (String) session.getAttribute("name");
        %>
        
        <span><%=name%> is login for <%=time%> seconds</span>
        
        <%
            } else {
            out.println("<h3>You aren't logged in!<br>Please, choose one of the options below: </h3>");
        %>
            Login <a href="/Session/loginRegister?login=login"> here</a><br>
            Register <a href="/Session/loginRegister?login=register"> here</a>
        <%
            }
        %>
    <%@ include file="footer.html" %> 