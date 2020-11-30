<%@ page import="be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Overview Page</title>
</head>
<body>
    <h1>
        Detail Page
    </h1>
    <table>
        <tr>
            <th>
                <%=Gebruiker.VOORNAAM%>
            </th>
            <th>
                <%=Gebruiker.FAMILIENAAM%>
            </th>
            <th>
                <%=Gebruiker.EMAIL%>
            </th>
            <%
                List<Gebruiker> gebruikers = (List<Gebruiker>) request.getAttribute("gebruikers");
                for (Gebruiker gebruiker: gebruikers) {
                    out.print("<tr><td>" + gebruiker.getVoornaam() + "</td><td>" + gebruiker.getFamilienaam() + "</td><td>" + gebruiker.getEmail() + "</td></tr>");
                }
            %>
        </tr>
    </table>
    <p>
        <a href="/">
            Terug
        </a>
         naar index
    </p>
</body>
</html>
