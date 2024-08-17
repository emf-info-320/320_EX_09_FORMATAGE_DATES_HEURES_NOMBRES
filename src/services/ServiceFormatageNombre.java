package services;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Cette classe contient une méthode statique afin de faciliter le formatage
 * des nombres, indépendamment de la compatibilité des JRE.
 */
public class ServiceFormatageNombre {

    public ServiceFormatageNombre() {
    }

    /**
     * Méthode statique formatant un nombre en tenant compte des symboles de la
     * locale fr_CH
     * et du pattern passé en paramètre. Le symbole de groupement des milliers et le
     * séparateur
     * décimal sont gérés correctement indépendamment de la version de la JRE.
     * 
     * Cette méthode utilise un apostrophe ('') comme symbole de groupement des
     * milliers
     * et un point ('.') comme séparateur décimal, conformément aux conventions de
     * la Suisse romande.
     *
     * @param nombreAFormatter le nombre à formater
     * @param pattern          le pattern utilisé pour le formatage, par exemple
     *                         "#,###.##"
     * @return le nombre formaté en tant que chaîne de caractères
     */
    public static String formaterNombre_frCH(double nombreAFormatter, String pattern) {
        return "";
    }

}
