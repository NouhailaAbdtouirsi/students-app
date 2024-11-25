package org.sid.metier;

import org.sid.dao.Etudiant;

import java.util.List;

public interface IMetier {
    Etudiant addEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
}
