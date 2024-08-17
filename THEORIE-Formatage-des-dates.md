# Théorie formatage des dates

Le principe est le même que pour le formatage des nombres, avec un processus de conversion qui cette fois repose sur la classe
**SimpleDateFormat** du package **java.text**.


<img src="doc/img/TH_date_1.png" alt="processus date" />


L'équivalent en code:

## Formatage simple avec la Locale par défaut :
```java

//Début du processus et définition d'une date.
Date date = new Date(); // Renvoie la date et heure actuelle

//Préparation de notre outil de transformation en utilisant un des constructeur de SimpleDateFormat,
//avec en paramètre le format désiré.
//L'objet retourné de type SimpleDateFormat va nous permettre d'effectuer la transformation de notre date
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//Transformation et récupération du résultat
String laDateMiseEnForme = sdf.format(date);

//Affichage du résultat par exemple: "2024-05-30
System.out.println(laDateMiseEnForme); 

```

## Les patterns utilisables

| Pattern              | Explication                                                            | Exemple d'entrée | Exemple de sortie   |
|----------------------|------------------------------------------------------------------------|------------------|---------------------|
| `yyyy-MM-dd`         | Année avec quatre chiffres, mois sur deux chiffres, jour sur deux chiffres | 2024-06-25       | 2024-06-25          |
| `EEE, MMM d, ''yy`   | Jour de la semaine abrégé, mois abrégé, jour du mois sans zéro initial, année sur deux chiffres | Sam, juin 8, '24  | Sat, Jun 8, '24     |
| `h:mm a`             | Heure sur 12 heures, minutes sur deux chiffres, AM/PM                  | 5:30 PM          | 5:30 PM             |
| `HH:mm:ss`           | Heure sur 24 heures, minutes sur deux chiffres, secondes sur deux chiffres | 17:30:00         | 17:30:00            |
| `hh 'o''clock' a, z` | Heure sur 12 heures, texte 'o'clock', AM/PM, timezone                  | 5 o'clock PM, EST| 5 o'clock PM, EST   |
| `yyyy.MM.dd G 'at' HH:mm:ss z` | Année avec quatre chiffres, mois sur deux chiffres, jour sur deux chiffres, ère, heure sur 24 heures, minutes, secondes, timezone | 2024.06.08 AD at 17:30:00 PST | 2024.06.08 AD at 17:30:00 PST |
| `EEEE, MMMM d, yyyy` | Jour de la semaine complet, mois complet, jour du mois sans zéro initial, année avec quatre chiffres | Samedi, Juin 8, 2024 | Saturday, June 8, 2024 |

### Légende :
- `y` : Année.
- `M` : Mois.
- `d` : Jour.
- `H` : Heure de la journée (0-23).
- `h` : Heure en format AM/PM (1-12).
- `m` : Minutes.
- `s` : Secondes.
- `S` : Millisecondes.
- `E` : Jour de la semaine abrégé
- `EEEE` : Jour de la semaine dans la langue locale
- `M` : Mois en nombre
- `MMMM` : Mois dans la langue locale
- `D` : Jour de l'année.
- `F` : Jour de la semaine dans le mois.
- `w` : Semaine de l'année.
- `W` : Semaine du mois.
- `a` : AM/PM.
- `z` : Fuseau horaire général.


## Formatage avancé, avec utilisation de DateFormatSymbols et des Locales

Comme vous l'avez remarqué dans le tableau ci-dessus, les symboles de la Locale par défaut sont utilisés pour formater les dates et heures. En réalité, cela impacte principalement le nom du jour, du mois, et le numéro de jour de la semaine. 

Dans certaines situations, il peut être nécessaire de changer la Locale par défaut et également de changer certains symboles de la Locale utilisée.

Pour cela, SimpleDateFormat propose un constructeur qui demande en paramètre le pattern et un jeu de symboles. Ce jeu de symboles s'obtient avec une instance de DateFormatSymbols, dont le constructeur lui-même accepte soit aucun argument (c'est la Locale par défaut qui sera utilisée), soit un argument de type Locale.

```java
// Définition d'une Locale spécifique (par exemple, la Suisse romande)
Locale locale = new Locale.Builder().setLanguage("fr").setRegion("CH").build();
        
// Instantiation de DateFormatSymbols en fonction de cette locale
DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);

// Personnalisation de jeu de symboles obtenu avec les instructions suivantes:
String[] newWeekdays = {
  "", "Le dimanche", "Le lundi", "Le mardi", "Le mercredi", "Le jeudi", "Le vendredi", "Le samedi"
};
  
dateFormatSymbols.setWeekdays(newWeekdays);
   
// Création d'une date à formater (date actuelle)
Date date = new Date();

// Instantiation de SimpleDateFormat, avec un pattern et le jeu de symboles customizé
SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy", dateFormatSymbols);
// Formatage de la date selon le pattern et les symbols personnalisés
String formattedDate = sdf.format(date);

// Affichage du résultat formaté : par exemple Le samedi, juin 08, 2024
System.out.println("Date formatée (Suisse personnalisé): " + formattedDate);
```


## Pour aller plus loin, le package `java.time``

Le package java.time offre des avantages par rapport aux package java.text et java.util car il utilise des objets immuables (objet dont l'état ne peux pas être modifié après sa création) et thread-safe.

| Caractéristique                          | `java.time`                              | `java.util` et `java.text`                |
|------------------------------------------|------------------------------------------|------------------------------------------|
| Immutabilité                             | Oui                                      | Non                                      |
| Gestion des fuseaux horaires             | Intégrée et facile                       | Complexe et sujet à erreurs              |
| API fluide                               | Oui                                      | Non                                      |
| Support des types temporels spécifiques  | Oui (LocalDate, LocalTime, etc.)         | Non (utilise principalement `Date` et `Calendar`) |
| Sécurité thread                          | Oui                                      | Non                                      |
| Parsing et formatage                     | `DateTimeFormatter`                      | `SimpleDateFormat` et `DateFormat`       |
| Gestion des périodes et des durées       | `Period`, `Duration`                     | Complexe, doit être implémentée manuellement |
| Compatibilité avec les API modernes      | Oui                                      | Non                                      |


### DateTimeFormatter, LocalDate et LocalDateTime

Voici les ressources
- [DateTimeFormatter](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html)
- [LocalDate](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html)
- [LocalDateTime](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDateTime.html)

Et un exemple

```java

LocalDate date = LocalDate.now()
                          .plusDays(5)
                          .minusMonths(1)
                          .withYear(2025);

// Création d'un formateur de date avec le style court et la locale par défaut
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());                                   

// Formatage de la date
String formattedDate = date.format(formatter);

// Affichage de la date formatée: affichera 13.05.25, selon les paramètres d'environnement du format régional (LOCALE)
System.out.println(formattedDate);

// Mais vous pouvez également utiliser la méthode DateTimeFormatter.ofPattern("dd/MM/yyyy") qui permet d'appliquer le format désiré en utilisant des patterns. 

```


<img src="doc/img/TH_date_2.png" alt="réglage Région" />



