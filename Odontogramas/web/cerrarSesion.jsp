<%
        HttpSession session2 = request.getSession();
        session2.invalidate();
        response.sendRedirect("/Odontogramas/index.jsp");

%>