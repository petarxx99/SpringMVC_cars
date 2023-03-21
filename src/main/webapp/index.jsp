<html>
<head>
    <title>Prva strana</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Prva strana</h2>

<form action="parsiranjePoNazivuProizvodjaca" method="GET">
    <label>Parsirajte automobile po nazivu proizvodjaca. </label>
    <label for="nazivproizvodjaca"> Unesite naziv proizvodjaca: </label>
    <input type="text" name="nazivproizvodjaca">
    <input type="submit" value="Pogledajte automobile">
    <br>
</form>

<form action="parsirajPoGodiniProizvodnje" method="GET">
    <label>Parsirajte automobile po godini proizvodnje </label>
    <label for="najnizegodiste">Upisite najnize godiste </label>
    <input type="text" name="najnizegodiste">
    <input type="text" name="najvecegodiste">
    <input type="submit" value="Pogledajte automobile">
    <br>
</form>

<form action="parsirajPoTipuGoriva" method="GET">
    <label>Parsirajte automobile po tipu goriva.</label>
    <br>
    <label> Electric </label>
    <input type="radio" name="gorivo" id="electric" value="electric">

    <br>
    <label> Hybrid </label>
    <input type="radio" name="gorivo" id="hybrid" value="hybrid">

    <br>
    <label> Fuel </label>
    <input type="radio" name="gorivo" id="fuel" value="fuel">

    <input type="submit" value="Dovrsite pretragu po gorivu">
    <br>
</form>

</body>
</html>
