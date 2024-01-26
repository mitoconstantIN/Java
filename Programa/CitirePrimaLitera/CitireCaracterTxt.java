import java.io.*;

public class CitireCaracterTxt {
    public static void main(String[] args) {
        // Verificare dacă a fost furnizată o cale către director
        if (args.length != 1) {
            System.out.println("Utilizare: java CitireCaracterTxt <cale_catre_director>");
            return;
        }

        String directorPath = args[0];
        File director = new File(directorPath);

        // Verificare dacă calea indică către un director existent
        if (!director.exists() || !director.isDirectory()) {
            System.out.println("Calea specificată nu este un director valid.");
            return;
        }

        // Listare fișiere .txt în director și citire primul caracter din fiecare
        File[] fisiereTxt = director.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String numeFisier) {
                return numeFisier.toLowerCase().endsWith(".txt");
            }
        });

        if (fisiereTxt != null) {
            for (File fisier : fisiereTxt) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fisier))) {
                    int caracter = reader.read(); // Citire primul caracter din fișier
                    if (caracter != -1) {
                        System.out.println("Primul caracter din " + fisier.getName() + ": " + (char) caracter);
                    } else {
                        System.out.println("Fișierul " + fisier.getName() + " este gol.");
                    }
                } catch (IOException e) {
                    System.out.println("Eroare la citirea fișierului " + fisier.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("Nu s-au găsit fișiere .txt în directorul specificat.");
        }
    }
}
