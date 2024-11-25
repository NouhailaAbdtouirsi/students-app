package org.sid.metier;

import org.sid.dao.Etudiant;
import org.sid.dao.EtudiantDAO;
import org.sid.dao.IDao;

import java.util.List;

public class EtudiantManager implements IMetier{
    public IDao etudiantDAO;

    public void setEtudiantDAO(IDao etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    // Ajouter un étudiant avec vérification
    public Etudiant addEtudiant(Etudiant etudiant) {
        for (Etudiant e : etudiantDAO.getAllEtudiants()) {
            if (e.getEmail().equals(etudiant.getEmail())) {
                throw new IllegalArgumentException("Email déjà utilisé !");
            }
        }
        return etudiantDAO.addEtudiant(etudiant);
    }

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.getAllEtudiants();
    }
}
