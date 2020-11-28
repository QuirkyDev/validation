<%@ page import="be.thomasmore.graduaten.voorbeeld.validation.entity.Gebruiker" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Page</title>
</head>
<body>
    <h1>
        Form Page
    </h1>
    <%
        HashMap<String, String> values = (HashMap<String, String>) request.getAttribute("values");
        HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    %>
    <form action="/process-form" method="post">
        <p>
            <label for="<%=Gebruiker.VOORNAAM%>"><%=Gebruiker.VOORNAAM%></label>
            <input type="text" id="<%=Gebruiker.VOORNAAM%>" name="<%=Gebruiker.VOORNAAM%>" value="<%=values.get(Gebruiker.VOORNAAM)%>">
            <%
                if (errors.containsKey(Gebruiker.VOORNAAM)) {
                    out.print("<span style='color: red;'>" + errors.get(Gebruiker.VOORNAAM) + "</span>");
                }
            %>
        </p>
        <p>
            <label for="<%=Gebruiker.FAMILIENAAM%>"><%=Gebruiker.FAMILIENAAM%></label>
            <input type="text" id="<%=Gebruiker.FAMILIENAAM%>" name="<%=Gebruiker.FAMILIENAAM%>" value="<%=values.get(Gebruiker.FAMILIENAAM)%>">
            <%
                if (errors.containsKey(Gebruiker.FAMILIENAAM)) {
                    out.print("<span style='color: red;'>" + errors.get(Gebruiker.FAMILIENAAM) + "</span>");
                }
            %>
        </p>
        <p>
            <label for="<%=Gebruiker.EMAIL%>"><%=Gebruiker.EMAIL%></label>
            <input type="text" id="<%=Gebruiker.EMAIL%>" name="<%=Gebruiker.EMAIL%>" value="<%=values.get(Gebruiker.EMAIL)%>">
            <%
                if (errors.containsKey(Gebruiker.EMAIL)) {
                    out.print("<span style='color: red;'>" + errors.get(Gebruiker.EMAIL) + "</span>");
                }
            %>
        </p>
        <p>
            <input type="submit" value="Voeg gebruiker toe">
        </p>
    </form>
</body>
</html>
