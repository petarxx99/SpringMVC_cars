<html>
<head>
    <title>Prikaz automobila</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Prikaz automobila</h2>
<%@page contentType="text/html" isELIgnored="false"%>
<%@page import="util.Util"%>
<%@page import="util.CarAdapter"%>
<%@page import="java.util.*"%>
<%@page import="generisano.*"%>
<%@page import="controllers.Konstante"%>


<%
List<Car> cars = (List<Car>) request.getAttribute(Konstante.CARS_ATRIBUT);
out.println("broj automobila koji odgovaraju uslovima = " + cars.size() + "<br>");
if(cars.size() > 0){
    out.println(CarAdapter.getHtmlTabelu(cars));
}
 %>

</body>
</html>
