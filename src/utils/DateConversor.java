package utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateConversor {

    public static Date parse(String date) {
        DateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return pattern.parse(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão: " + e.getMessage());
            return null;
        }
    }

    public static String format(Date date) {
        DateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
        return pattern.format(date);
    }

}
