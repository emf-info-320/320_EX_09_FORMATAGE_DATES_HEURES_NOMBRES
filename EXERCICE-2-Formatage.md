# Exercice 2 Formatage

## Objectifs

Appliquer le principe d'encapsulation et d'abstraction de la POO.

Utiliser les classes des package java.utils et java.time découvertes dans la théorie pour résoudre un problème d'une situation professionnelle.

## Contexte et donnée
Dans une équipe de développeurs internationale, vous êtes amené sans cesse à formater des nombres et des dates.
Chacun utilise les fonctions Java de base de manière un peu différente, et le code est difficile à maintenir. De plus, les pertes de fonctionnalités des nouveaux JDK concernant la reconnaissance du séparateur des milliers pour certaines locales, par exemple, sont problématiques.

Vous êtes donc chargé de créer des classes de service qui fourniront des méthodes pour le formatage des nombres et des dates.
Soyez attentif aux méthodes publiques et privées proposées, afin de séparer les responsabilités et d'éviter la duplication de code. Pour l'instant, les méthodes publiques ne proposent qu'un formatage avec la locale fr_CH, mais ce service pourrait supporter d'autres locales dans le futur.


## Réalisation & Durée
1. Prenez connaissance et lisez soigneusement le code déjà fourni..
2. Le main() et son code vous sont fournis.
3. Le main() utilise les méthodes de vos services `ServiceFormatageNombre` et `ServiceFormatageDateEtHeure` . Le résultat obtenu est à chaque fois affiché sur la console afin de vérifier son bon fonctionnement.
4. Votre travail consiste à implémenter les méthodes actuellement vides de ces services.
5. Lisez attentivement la javadoc fournie, elle contient toutes les indications sur le fonctionnement souhaité de ces méthodes !

Durée : 90'

## Résultat à obtenir (avec bien sûr votre heure et date actuelles)


TEST DU FORMATAGE NOMBRE, DATE ET HEURE

Résultat du formatage du nombre : 1'234'567.89

Date actuelle formatée avec le style court : 17.08.24

Date dans une semaine formatée avec pattern personnalisé : 24/08/2024

Heure actuelle formatée avec le style court : 13:57

Heure moins 12 heures formatée avec pattern personnalisé : 01:57:58

Date et heure actuelles formatées avec le style court : 17.08.24 13:57

