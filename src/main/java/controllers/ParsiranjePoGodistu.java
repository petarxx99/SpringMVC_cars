package controllers;

import generisano.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import parsiranje.ParsiranjeXML;

import java.util.List;

@Controller
public class ParsiranjePoGodistu {

    @RequestMapping("/parsirajPoGodiniProizvodnje")
    public ModelAndView prikaziAutomobile(@RequestParam(name="najnizegodiste") String najnizeGodisteString,
                                          @RequestParam(name="najvecegodiste") String najveceGodisteString){
        try {
            int najnizeGodiste = Integer.parseInt(najnizeGodisteString);
            int najveceGodiste = Integer.parseInt(najveceGodisteString);

            ParsiranjeXML parsiranjeXML = new ParsiranjeXML();
            List<Car> cars = parsiranjeXML.parsirajPoGodistu(najnizeGodiste, najveceGodiste);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject(Konstante.CARS_ATRIBUT, cars);
            modelAndView.setViewName("prikazAutomobila");
            return modelAndView;
        } catch(NumberFormatException exception){
            exception.printStackTrace();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("greska", "Niste dobro uneli brojeve");
            modelAndView.setViewName("greska");
            return modelAndView;
        }
    }



}
