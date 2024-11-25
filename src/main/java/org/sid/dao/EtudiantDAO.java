package org.sid.dao;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO implements IDao{
    private List<Etudiant> etudiants = new java.util.ArrayList<>();
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        return etudiant;
    }
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiants;
    }

    @Override
    public Etudiant updateEtudiant(String id, Etudiant updatedEtudiant) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId().equals(id)) {
                // Only update the other fields, not the id
                etudiant.setNom(updatedEtudiant.getNom());
                etudiant.setPrenom(updatedEtudiant.getPrenom());
                etudiant.setEmail(updatedEtudiant.getEmail());
                // Keep the id unchanged
                return etudiant;
            }
        }
        return null;
    }
}

