package util;

import generisano.Car;

import java.util.List;

public class Util {

    public static String getValueSaZnacimaNavoda(String value){
        return "value = \"" + value +"\"";
    }

    public static String dodajZnakeNavoda(String stringIzmedjuZnakaNavoda){
        return "\"" + stringIzmedjuZnakaNavoda + "\"";
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

    public static String napraviCarTabelu(List<Car> cars){
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" >");

        sb.append(" <tr>\n" +
                "        <td> id </td>\n" +
                "        <td> manufacturer </td>\n" +
                "        <td> model </td>\n" +
                "        <td> production year </td>\n" +
                "        <td> horsepower </td>\n" +
                "        <td> type of fuel </td>\n" +
                "        <td> consumption </td>\n" +
                "        <td> price </td>\n" +
                "    </tr>");

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


}
