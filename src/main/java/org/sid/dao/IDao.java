package org.sid.dao;

import java.util.List;

public interface IDao {
    Etudiant addEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(String id, Etudiant etudiant);
}
