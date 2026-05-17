# Lab 04 - Liste des taches Android

Application Android simple en Java pour pratiquer :

- la creation d'une interface XML avec `EditText`, `Spinner`, `Button` et `ListView`
- l'ajout dynamique d'elements dans une liste avec `ArrayAdapter`
- la navigation vers un deuxieme ecran avec `Intent`
- la recuperation des donnees envoyees avec les extras
- la suppression d'un element avec un appui long

## Fonctionnalites

- Affiche trois taches d'exemple au demarrage.
- Permet d'ajouter une nouvelle tache avec un titre, une description et une priorite.
- Met a jour le compteur de taches.
- Ouvre un ecran detail quand on touche une tache.
- Supprime une tache avec un appui long.
- Le bouton `Vider` efface seulement les champs de saisie.

## Structure principale

- `MainActivity.java` : gere le formulaire, la liste, l'ajout et la suppression.
- `Screen2Activity.java` : affiche les details de la tache selectionnee.
- `activity_main.xml` : interface de saisie et `ListView`.
- `activity_screen2.xml` : interface de l'ecran detail.

## Test manuel

1. Ouvrir le dossier `Lab04` dans Android Studio.
2. Laisser Gradle synchroniser le projet.
3. Lancer l'application sur un emulateur ou un telephone Android.
4. Verifier que trois taches d'exemple sont affichees.
5. Saisir un titre, une description, choisir une priorite, puis cliquer sur `Ajouter`.
6. Verifier que la nouvelle tache apparait dans la liste et que le compteur augmente.
7. Toucher une tache pour ouvrir l'ecran detail.
8. Cliquer sur `Retour` pour revenir a la liste.
9. Faire un appui long sur une tache et verifier qu'elle est supprimee.
10. Cliquer sur `Ajouter` sans titre et verifier le message d'erreur.

## Commande de verification

Depuis le dossier `Lab04` :

```powershell
.\gradlew.bat assembleDebug
```
