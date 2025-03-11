package domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Professeur extends Personne {
    private Boolean vacant;

    // Liste des professeurs
    public static List<Professeur> professeurs = new ArrayList<>();

    // Constructeur
    public Professeur(int id, Date dateNaissance, String ville, String prenom, String nom, Boolean vacant) {
        this.id = id;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.prenom = prenom;
        this.nom = nom;
        this.vacant = vacant;
    }

    @Override
    public void ajouter() {
        professeurs.add(this); // Ajoute l'objet actuel à la liste
        System.out.println("Professeur ajouté : " + this.nom + " " + this.prenom + " | Statut: " + (this.vacant ? "Vacant" : "Occupé"));
    }

    @Override
    public void supprimer() {
        for (Professeur p : professeurs) {
            if (p.id == this.id) { // Vérifie si un professeur avec le même ID existe
                professeurs.remove(p);
                System.out.println("✅ Professeur supprimé : " + this.nom + " " + this.prenom);
                return;
            }
        }
        System.out.println("❌ Erreur : Professeur non trouvé.");
    }

    public static int getNextId() {
        return professeurs.size() + 1;
    }

    public static void lister() {
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur enregistré.");
            return;
        }
        System.out.println("\nListe des professeurs :");
        for (Professeur p : professeurs) {
            System.out.println("ID: " + p.getId() + " | Nom: " + p.getNom() + " | Prénom: " + p.getPrenom() +
                    " | Ville: " + p.getVille() + " | Statut: " + (p.getVacant() ? "Vacant" : "Occupé"));
        }
    }

    public static void modifier(int id, Scanner scan) {
    for (Professeur p : professeurs) {
        if (p.id == id) {
            System.out.print("Nouveau nom : ");
            p.nom = scan.nextLine();
            System.out.print("Nouveau prénom : ");
            p.prenom = scan.nextLine();
            System.out.print("Nouvelle ville : ");
            p.ville = scan.nextLine();
            System.out.print("Vacant (true/false) : ");
            p.vacant = scan.nextBoolean();
            scan.nextLine(); // Évite le problème de buffer
            System.out.println("✅ Professeur modifié !");
            return;
        }
    }
    System.out.println("❌ Professeur introuvable.");
}

    // Getters et Setters
    public Boolean getVacant() {
        return vacant;
    }

    public void setVacant(Boolean vacant) {
        this.vacant = vacant;
    }
}
