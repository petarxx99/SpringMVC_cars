package util;

import generisano.Car;

import java.util.List;

public class CarAdapter {
    public final Car car;

    public CarAdapter(Car car){
        this.car = car;
    }

    public static String getHtmlTabelu(List<Car> cars){
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" >");

        sb.append(napraviRedTabele(new Object[]{
                "id", "manufacturer", "model", "production year", "horsepower", "type of fuel",
                "consumption", "price"
        }));

        for(Car car : cars){
            sb.append(napraviRedTabele(new Object[]{
                            car.getId(),
                            car.getManufacturer(),
                            car.getModel(),
                            car.getProductionYear(),
                            car.getHorsepower(),
                            car.getConsumption().getType(),
                            car.getConsumption().getValue(),
                            car.getPrice()
                    }
            ));
        }
        sb.append("</table>");
        return sb.toString();
    }

    public static String napraviRedTabele(Object[] vrednostiKolona){
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");

        for(Object o : vrednostiKolona){
            sb.append("<td> " + o + " </td>");
        }
        sb.append("</tr>");

        return sb.toString();
    }

}
