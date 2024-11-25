package org.sid.presentation;

import org.sid.dao.Etudiant;
import org.sid.dao.IDao;
import org.sid.metier.IMetier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationInstanciationDyn {
    public static void main(String[] args) {
        try {
            // Step 1: Read class names from config file
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();    // First line: DAO class
            String metierClassName = scanner.nextLine(); // Second line: Metier class

            // Step 2: Load DAO class dynamically
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            // Step 3: Load Metier class dynamically
            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            // Step 4: Inject DAO into Metier using reflection
            Method m = cMetier.getMethod("setEtudiantDAO", IDao.class); // Inject DAO into Metier
            m.invoke(metier, dao);

            // Step 5: Add data
            dao.addEtudiant(new Etudiant("1", "John", "Doe", "em@gmail.com"));
            dao.addEtudiant(new Etudiant("2", "Jane", "Smith", "sm@gmail.com"));
            System.out.println("Résultat : " + metier.getAllEtudiants());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
