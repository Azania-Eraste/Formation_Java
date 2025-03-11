package domaine;

import java.util.Date;
import java.util.Calendar;

public abstract class Personne {
    protected int id;
    protected Date dateNaissance;
    protected String ville;
    protected String prenom;
    protected String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int obtenirAge() {
        if (dateNaissance == null) {
            return -1;
        }
        Calendar dateNaiss = Calendar.getInstance();
        dateNaiss.setTime(dateNaissance);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateNaiss.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dateNaiss.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public static void lister(){};
    public abstract void supprimer();
    public abstract void ajouter(); // Méthode abstraite que les classes filles doivent implémenter
}
