package controllers;

import generisano.Car;
import generisano.TipGoriva;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import parsiranje.ParsiranjeXML;

import java.util.List;

@Controller
public class ParsiranjePoGorivu {

    @RequestMapping("/parsirajPoTipuGoriva")
    public ModelAndView getMessage(@RequestParam("gorivo") String gorivo){
        ModelAndView modelAndView = new ModelAndView();

        switch(gorivo){
            case "fuel", "hybrid":{
                modelAndView.addObject("tipGoriva", gorivo);
                modelAndView.setViewName("izaberitePotrosnju");
                break;
            }

            case "electric":{
                ParsiranjeXML parsiranjeXML = new ParsiranjeXML();
                List<Car> cars = parsiranjeXML.parsirajPoTipuGoriva("electric");
                modelAndView.addObject(Konstante.CARS_ATRIBUT, cars);
                modelAndView.setViewName("prikazAutomobila");
                break;
            }
            default:
                modelAndView.setViewName("greska");
        }

        return modelAndView;
    }

    @RequestMapping("/parsirajPoPotrosnjiITipuGoriva")
    public ModelAndView parsirajPoPotrosnji(@RequestParam("minimalnapotrosnja") String minimalnaPotrosnjaString,
                                            @RequestParam("maksimalnapotrosnja") String maksimalnaPotrosnjaString,
                                            @RequestParam("izabranoGorivo") String izabranoGorivo){
        try {
            double minimalnaPotrosnja = Double.parseDouble(minimalnaPotrosnjaString);
            double maksimalnaPotrosnja = Double.parseDouble(maksimalnaPotrosnjaString);

            ParsiranjeXML parsiranjeXML = new ParsiranjeXML();
            List<Car> cars = parsiranjeXML.parsirajPoPotrosnjiItipuGoriva(izabranoGorivo, minimalnaPotrosnja, maksimalnaPotrosnja);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject(Konstante.CARS_ATRIBUT, cars);
            modelAndView.setViewName("prikazAutomobila");
            return modelAndView;
        } catch(NumberFormatException exception){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("greska", "Niste dobro uneli brojeve za potrosnju.");
            modelAndView.setViewName("greska");
            return modelAndView;
        }
    }
}
