package org.sid.presentation;


import org.sid.dao.Etudiant;
import org.sid.metier.EtudiantManager;

public class Presentation {
    public static void main(String[] args) {
        EtudiantManager manager = new EtudiantManager();

        // Ajouter des étudiants
        manager.addEtudiant(new Etudiant("1", "John", "Doe", "john.doe@gmail.com"));
        manager.addEtudiant(new Etudiant("2", "Jane", "Smith", "jane.smith@gmail.com"));
        manager.addEtudiant(new Etudiant("3", "Alice", "Brown", "alice.brown@gmail.com"));
        manager.addEtudiant(new Etudiant("4", "Bob", "White", "bob.white@gmail.com"));

        // Afficher tous les étudiants
        for (Etudiant etudiant : manager.getAllEtudiants()) {
            System.out.println("ID: " + etudiant.getId() + ", Nom: " + etudiant.getNom() +
                    ", Prénom: " + etudiant.getPrenom() + ", Email: " + etudiant.getEmail());
        }
    }
}
