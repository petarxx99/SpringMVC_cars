
Type
http://localhost:8080/SpringXML/
into web browser
Replace SpringXML with the name of the project.

In parsiranje.ParsiranjeXML the paths to cars.xml and cars.xsd are absolute and they are hard coded.

After clicking ctrl twice run anything option appears. Type:
mvn jaxb2:xjc to generate java classes from xml
mvn package tomee:run to run the project
