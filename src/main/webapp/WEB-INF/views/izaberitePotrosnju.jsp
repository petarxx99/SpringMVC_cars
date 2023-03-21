<html>
<head>
    <title>Izaberite potrosnju</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Izaberite potrosnju</h2>
<%@page contentType="text/html" isELIgnored="false"%>
<%@page import="util.Util"%>
<%@page import="java.util.*"%>
<%@page import="generisano.*"%>
<%@page import="controllers.Konstante"%>

<form action="parsirajPoPotrosnjiITipuGoriva" method="GET">
    <label for="minimalnapotrosnja">Upisite minimalnuPotrosnju </label>
    <input type="text" name="minimalnapotrosnja">
    <br>

    <label for="maksimalnapotrosnja">Upisite maksimalnapotrosnja </label>
    <input type="text" name="maksimalnapotrosnja">

    <% String izabranoGorivo = (String) request.getAttribute("tipGoriva"); %>
    <input type="hidden" name="izabranoGorivo" <%= Util.getValueSaZnacimaNavoda(izabranoGorivo)%> >
    <input type="submit" value="Prikazite automobile">
</form>
</body>
</html>
