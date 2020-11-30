<%@ page import="be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker" %>
<%@ page import="be.thomasmore.graduaten.voorbeeld.validation.model.GebruikerError" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Form Page</title>
</head>
<body>
    <h1>
        Form Page
    </h1>
    <%
        Gebruiker gebruiker = (Gebruiker) request.getAttribute(Gebruiker.NAME);
        GebruikerError gebruikerError = (GebruikerError) request.getAttribute(GebruikerError.NAME);
    %>
    <form action="process-form" method="post">
        <p>
            <label for="<%=Gebruiker.VOORNAAM%>"><%=Gebruiker.VOORNAAM%></label>
            <input type="text" id="<%=Gebruiker.VOORNAAM%>" name="<%=Gebruiker.VOORNAAM%>" value="<%=gebruiker.getVoornaam()%>">
            <%
                if (gebruikerError.voornaam != null) {
                    out.print("<span style='color: red;'>" + gebruikerError.voornaam + "</span>");
                }
            %>
        </p>
        <p>
            <label for="<%=Gebruiker.FAMILIENAAM%>"><%=Gebruiker.FAMILIENAAM%></label>
            <input type="text" id="<%=Gebruiker.FAMILIENAAM%>" name="<%=Gebruiker.FAMILIENAAM%>" value="<%=gebruiker.getFamilienaam()%>">
            <%
                if (gebruikerError.familienaam != null) {
                    out.print("<span style='color: red;'>" + gebruikerError.familienaam + "</span>");
                }
            %>
        </p>
        <p>
            <label for="<%=Gebruiker.EMAIL%>"><%=Gebruiker.EMAIL%></label>
            <input type="text" id="<%=Gebruiker.EMAIL%>" name="<%=Gebruiker.EMAIL%>" value="<%=gebruiker.getEmail()%>">
            <%
                if (gebruikerError.email != null) {
                    out.print("<span style='color: red;'>" + gebruikerError.email + "</span>");
                }
            %>
        </p>
        <p>
            <input type="submit" value="Voeg gebruiker toe">
        </p>
    </form>
</body>
</html>
