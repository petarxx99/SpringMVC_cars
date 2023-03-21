<html>
<head>
    <title>Greska</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Greska</h2>
Dogodila se greska.
<%
Object greska = request.getAttribute("greska");
if(greska != null){
    String greskaString = (String) greska;
    if(!greskaString.equals("")){
        out.println("Razlog greske: " + greska);
    }
}
%>

<a href="index.jsp"> Kliknite ovde da biste se vratili na pocetnu stranicu. </a>

</body>
</html>
