package utils;

public final class StringUtils {

    //INSTANCE ALINSIN İSTEMİYORUZ.
    private StringUtils(){};

    //DOĞRUDAN CLASS ÜZERİNDEN ULAŞACAĞIZ.
    public static String normalize(String input){
        if(input == null)
            return null;

        return input.trim().replaceAll("\\s+"," ").toLowerCase();
    }

}
