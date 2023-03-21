package parsiranje;

import generisano.Car;
import generisano.Cars;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

// mvn jaxb2:xjc
// mvn package tomee:run

public class ParsiranjeXML {
    private String paketSaKlasama = "generisano";
    private String xmlFajl = "C:\\Users\\Vladan\\Desktop\\JavaProgrami\\kursXML\\assignment\\SpringXML\\cars.xml";
    private String schemaFajl = "C:\\Users\\Vladan\\Desktop\\JavaProgrami\\kursXML\\assignment\\SpringXML\\src\\main\\xsd\\cars.xsd";

    public ParsiranjeXML(){}
    public ParsiranjeXML(String paketSaKlasama, String xmlFajl, String schemaFajl){
        this.paketSaKlasama = paketSaKlasama;
        this.xmlFajl = xmlFajl;
        this.schemaFajl = schemaFajl;
    }



    public List<Car> parsirajPoPotrosnjiItipuGoriva(String tipGoriva, double minimalnaPotrosnja, double maksimalnaPotrosnja){
        return parsirajPoTipuGoriva(tipGoriva).stream().filter(car ->
                        car.getConsumption().getValue() >= minimalnaPotrosnja &&
                        car.getConsumption().getValue() <= maksimalnaPotrosnja)
                .collect(Collectors.toList());
    }


    public List<Car> parsirajPoTipuGoriva(String tipGoriva){
        return unmarshalCar(schemaFajl, xmlFajl, paketSaKlasama).stream()
                .filter(car -> daLiJeIstiTipGoriva(car, tipGoriva))
                .collect(Collectors.toList());
    }

    private static boolean daLiJeIstiTipGoriva(Car car, String tipGoriva){
        if(car.getConsumption().getType() == null) return false;

        return car.getConsumption().getType().value().toLowerCase().equals(tipGoriva.toLowerCase());
    }

    public static List<Car> parsirajPoPotrosnji(List<Car> cars, double minimalnaPotrosnja, double maksimalnaPotrosnja){
        return cars.stream().filter(car ->
                        car.getConsumption().getValue() >= minimalnaPotrosnja &&
                                car.getConsumption().getValue() <= maksimalnaPotrosnja)
                .collect(Collectors.toList());
    }

    public List<Car> parsirajPoNazivuProizvodjaca(String nazivProizvodjaca){
        return unmarshalCar(schemaFajl, xmlFajl, paketSaKlasama).stream()
                .filter(car -> car.getManufacturer().equals(nazivProizvodjaca))
                .collect(Collectors.toList());
    }


    public List<Car> parsirajPoGodistu(int najnizeGodiste, int najveceGodiste){
        return unmarshalCar(schemaFajl, xmlFajl, paketSaKlasama).stream().filter(car ->
                                car.getProductionYear() >= najnizeGodiste &&
                                car.getProductionYear() <= najveceGodiste)
                .collect(Collectors.toList());
    }

    private List<Car> unmarshalCar(String schemaFajl, String xmlFajl, String paketSaKlasama){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(paketSaKlasama);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(schemaFajl));
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new XmlValidationEventHandler());

            Cars cars = (Cars) unmarshaller.unmarshal(new File(xmlFajl));
            return cars.getCar();
        } catch (JAXBException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
