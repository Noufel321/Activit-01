package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            // Lecture du fichier de configuration
            Scanner scanner = new Scanner(new File("C:/Users/PC/IdeaProjects/TP01/config.txt"));

            // Lecture et instantiation du DAO
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            // Lecture et instanciation du Metier
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor(IDao.class).newInstance(dao);

            // Affichage du résultat
            System.out.println("RES = " + metier.calcul());

            // Fermeture du scanner
            scanner.close();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }}
