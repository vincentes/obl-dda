<%
    String msg = request.getParameter("msg");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Mozo</title>
    </head>
    <body>
        <h1>Login Mozo</h1>
        <h1>
            <form method="post" action="login">
                Usuario:<input type="text" name="usuario"><br><br>
                Password:<input type="password" name="pass"><br><br>
                <input type="submit" value="Login">
            </form>
           <br>
            <%
                if(msg!=null) out.println("Error:" + msg);
            %>
        </h1>
    </body>
</html>
