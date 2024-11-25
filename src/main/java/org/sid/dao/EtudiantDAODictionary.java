package org.sid.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EtudiantDAODictionary implements IDao{
    private Map<String, Etudiant> etudiants = new java.util.HashMap<>();
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        etudiants.put(etudiant.getId(), etudiant);
        return etudiant;
    }
    @Override
    public List<Etudiant> getAllEtudiants() {
        System.out.printf("Etudiants from DAODictionary: %s\n", etudiants);
        return new ArrayList<>(etudiants.values());
    }
    @Override
    public Etudiant updateEtudiant(String id, Etudiant updatedEtudiant) {
        // Ensure the ID remains the same by fetching the current record with the given id
        Etudiant existingEtudiant = etudiants.get(id);
        if (existingEtudiant != null) {
            // Update other fields but keep the same ID
            existingEtudiant.setNom(updatedEtudiant.getNom());
            existingEtudiant.setPrenom(updatedEtudiant.getPrenom());
            existingEtudiant.setEmail(updatedEtudiant.getEmail());
            // No need to change the id
            return existingEtudiant;
        }
        return null;
    }


}