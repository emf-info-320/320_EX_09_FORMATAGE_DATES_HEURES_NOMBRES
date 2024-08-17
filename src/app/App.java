package app;

import java.time.LocalDate;
import java.time.LocalTime;

import services.ServiceFormatageNombre;
import services.ServiceFormatageDateEtHeure;

public class App {
  public static void main(String[] args) throws Exception {

    System.out.println("TEST DU FORMATAGE NOMBRE, DATE ET HEURE");
    System.out.println();

    //Exemple de formatage d'un nombre
    double nombre = 1234567.89;
    String pattern = "#,###.##";
    // Appel de la méthode pour formater le nombre selon le pattern
    String resultat = ServiceFormatageNombre.formaterNombre_frCH(nombre, pattern);    
    // Affichage du résultat formaté (attendu : "1'234'567.89")
    System.out.println("Résultat du formatage du nombre : " + resultat); 
    System.out.println();

    // Test de formatage de la date avec le pattern par défaut et la date actuelle (style court)
    String dateFormateeParDefaut = ServiceFormatageDateEtHeure.formaterDate_frCH(null, null);    
    // Affichage du résultat (la date actuelle formatée selon le style court pour la Suisse romande)
    System.out.println("Date actuelle formatée avec le style court : " + dateFormateeParDefaut);
    System.out.println();

    // Test de formatage de la date avec un pattern personnalisé et la date dans une semaine.
    String patternDate = "dd/MM/yyyy";
    LocalDate dateDansUneSemaine = LocalDate.now().plusWeeks(1);
    String dateFormatee = ServiceFormatageDateEtHeure.formaterDate_frCH(patternDate, dateDansUneSemaine);
    // Affichage du résultat (la date dans une semaine formatée selon le pattern "dd/MM/yyyy")
    System.out.println("Date dans une semaine formatée avec pattern personnalisé : " + dateFormatee);
    System.out.println();

    // Test de formatage de l'heure avec pattern par défaut (style court) et l'heure actuelle
    String heureFormateeParDefaut = ServiceFormatageDateEtHeure.formaterHeure_frCH(null, null);
    // Affichage du résultat (l'heure actuelle formatée selon le style court pour la Suisse romande)
    System.out.println("Heure actuelle formatée avec le style court : " + heureFormateeParDefaut);
    System.out.println();


    // Test de formatage de l'heure avec un pattern personnalisé
    String patternHeure = "hh:mm:ss";
    LocalTime heureMoinsDouzeHeures = LocalTime.now().minusHours(12);
    String heureFormatee = ServiceFormatageDateEtHeure.formaterHeure_frCH(patternHeure, heureMoinsDouzeHeures);
    // Affichage du résultat (l'heure actuelle moins 12 heures formatée selon le pattern "hh:mm:ss")
    System.out.println("Heure moins 12 heures formatée avec pattern personnalisé : " + heureFormatee);
    System.out.println();

    // Test de formatage de la date et heure avec le pattern par défaut (style court)
    String dateEtHeureFormateesParDefaut = ServiceFormatageDateEtHeure.formaterDateEtHeure_frCH(null, null);
    // Affichage du résultat (la date et l'heure actuelles formatées selon le style court pour la Suisse romande)
    System.out.println("Date et heure actuelles formatées avec le style court : " + dateEtHeureFormateesParDefaut);
    System.out.println();
  }
}
