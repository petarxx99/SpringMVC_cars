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
public class ParsiranjePoNazivuProizvodjaca {

    @GetMapping("/parsiranjePoNazivuProizvodjaca")
    public ModelAndView getMessage(@RequestParam("nazivproizvodjaca") String nazivProizvodjaca){
        ParsiranjeXML parsiranjeXMl = new ParsiranjeXML();
        List<Car> cars = parsiranjeXMl.parsirajPoNazivuProizvodjaca(nazivProizvodjaca);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(Konstante.CARS_ATRIBUT, cars);
        modelAndView.setViewName("prikazAutomobila");
        return modelAndView;
    }

}
