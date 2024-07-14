package sprint1_tasca3_exercici1_nivell3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Persona> persones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sortir = false;

        // Llegir persones des d'un fitxer CSV
        llegirPersonesDeCSV("persones.csv");

        while (!sortir) {
            System.out.println("\nMenú:");
            System.out.println("1.- Introduir persona.");
            System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
            System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
            System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
            System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
            System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
            System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
            System.out.println("0.- Sortir.");
            System.out.print("Selecciona una opció: ");
            
            int opcio = scanner.nextInt();
            scanner.nextLine(); // consumeix la nova línia
            
            switch (opcio) {
                case 1:
                    introduirPersona(scanner);
                    break;
                case 2:
                    mostrarPersonesOrdenadesPerNomAZ();
                    break;
                case 3:
                    mostrarPersonesOrdenadesPerNomZA();
                    break;
                case 4:
                    mostrarPersonesOrdenadesPerCognomAZ();
                    break;
                case 5:
                    mostrarPersonesOrdenadesPerCognomZA();
                    break;
                case 6:
                    mostrarPersonesOrdenadesPerDNIAZ();
                    break;
                case 7:
                    mostrarPersonesOrdenadesPerDNIZA();
                    break;
                case 0:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void llegirPersonesDeCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] dades = line.split(",");
                if (dades.length == 3) {
                    persones.add(new Persona(dades[0].trim(), dades[1].trim(), dades[2].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer: " + e.getMessage());
        }
    }

    private static void introduirPersona(Scanner scanner) {
        System.out.print("Introdueix el nom: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el cognom: ");
        String cognom = scanner.nextLine();
        System.out.print("Introdueix el DNI: ");
        String DNI = scanner.nextLine();
        
        persones.add(new Persona(nom, cognom, DNI));
    }

    private static void mostrarPersonesOrdenadesPerNomAZ() {
        persones.sort(Comparator.comparing(Persona::getNom));
        mostrarPersones();
    }

    private static void mostrarPersonesOrdenadesPerNomZA() {
        persones.sort(Comparator.comparing(Persona::getNom).reversed());
        mostrarPersones();
    }

    private static void mostrarPersonesOrdenadesPerCognomAZ() {
        persones.sort(Comparator.comparing(Persona::getCognom));
        mostrarPersones();
    }

    private static void mostrarPersonesOrdenadesPerCognomZA() {
        persones.sort(Comparator.comparing(Persona::getCognom).reversed());
        mostrarPersones();
    }

    private static void mostrarPersonesOrdenadesPerDNIAZ() {
        persones.sort(Comparator.comparing(Persona::getDNI));
        mostrarPersones();
    }

    private static void mostrarPersonesOrdenadesPerDNIZA() {
        persones.sort(Comparator.comparing(Persona::getDNI).reversed());
        mostrarPersones();
    }

    private static void mostrarPersones() {
        System.out.printf("%-15s %-20s %-10s\n", "Nom", "Cognoms", "DNI");
        System.out.println("-----------------------------------------------------------");
        for (Persona p : persones) {
            System.out.println(p);
        }
    }
}
