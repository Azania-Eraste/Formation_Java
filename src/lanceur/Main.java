package lanceur;

import java.util.Scanner;
import java.util.Date;

import domaine.Professeur;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        gestionProf(scan);
        
    }

        public static void gestionProf(Scanner scan) {
        while (true) {
            System.out.println("\n*********************************");
            System.out.println("📚 GESTION DES PROFESSEURS");
            System.out.println("*********************************");
            System.out.println("1: Ajouter un professeur");
            System.out.println("2: Supprimer un professeur");
            System.out.println("3: Modifier un professeur");
            System.out.println("4: Lister les professeurs");
            System.out.println("5: Retour au menu principal");
            System.out.print("Votre choix : ");
            
            int choix = scan.nextInt();
            scan.nextLine(); // Évite le problème de buffer

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scan.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scan.nextLine();
                    System.out.print("Ville : ");
                    String ville = scan.nextLine();
                    System.out.print("Vacant (true/false) : ");
                    boolean vacant = scan.nextBoolean();
                    scan.nextLine(); // Évite le problème de buffer

                    Professeur p = new Professeur(Professeur.getNextId(), new Date(), ville, prenom, nom, vacant);
                    p.ajouter();
                    break;
                case 2:
                    Professeur.lister();
                    System.out.print("ID du professeur à supprimer : ");
                    int idSupp = scan.nextInt();
                    scan.nextLine(); 
                
                    // Trouver le professeur dans la liste en utilisant l'ID
                    Professeur professeurASupprimer = null;
                    for (Professeur pf : Professeur.professeurs) {
                        if (pf.getId() == idSupp) {
                            professeurASupprimer = pf;
                            break;
                        }
                    }
                
                    // Si on a trouvé le professeur, on le supprime
                    if (professeurASupprimer != null) {
                        professeurASupprimer.supprimer();
                    } else {
                        System.out.println("❌ Professeur non trouvé avec cet ID.");
                    }
                    break;
                
                case 3:
                    Professeur.lister();
                    System.out.print("ID du professeur à modifier : ");
                    int idModif = scan.nextInt();
                    scan.nextLine();
                    Professeur.modifier(idModif, scan);
                    break;
                case 4:
                    Professeur.lister();
                    break;
                case 5:
                    return; // Retour au menu principal
                default:
                    System.out.println("❌ Choix invalide !");
            }
        }
    }

}