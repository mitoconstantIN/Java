import java.util.Scanner;

public class XSi0 {
    private static final int DIMENSIUNE = 3; // Dimensiunea tablei (3x3)

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char GOL = '-';

    private char[][] tabla = new char[DIMENSIUNE][DIMENSIUNE];
    private char jucatorCurent = X;

    private Scanner scanner = new Scanner(System.in);

    public XSi0() {
        initTabla();
        afisareTabla();
        while (!jocTerminat()) {
            mutare();
            afisareTabla();
            schimbaJucator();
        }
        afisareRezultat();
        scanner.close();
    }

    private void initTabla() {
        for (int i = 0; i < DIMENSIUNE; i++) {
            for (int j = 0; j < DIMENSIUNE; j++) {
                tabla[i][j] = GOL;
            }
        }
    }

    private void afisareTabla() {
        System.out.println("  0 1 2");
        for (int i = 0; i < DIMENSIUNE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < DIMENSIUNE; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void mutare() {
        System.out.println("Jucatorul " + jucatorCurent + " muta.");
        System.out.print("Rand: ");
        int rand = scanner.nextInt();
        System.out.print("Coloana: ");
        int coloana = scanner.nextInt();
        if (tabla[rand][coloana] == GOL) {
            tabla[rand][coloana] = jucatorCurent;
        } else {
            System.out.println("Mutare invalida. Incercati din nou.");
            mutare();
        }
    }

    private void schimbaJucator() {
        jucatorCurent = (jucatorCurent == X) ? O : X;
    }

    private boolean jocTerminat() {
        return castigator(X) || castigator(O) || tablaPlina();
    }

    private boolean castigator(char jucator) {
        for (int i = 0; i < DIMENSIUNE; i++) {
            if (tabla[i][0] == jucator && tabla[i][1] == jucator && tabla[i][2] == jucator) return true; // verificare linii
            if (tabla[0][i] == jucator && tabla[1][i] == jucator && tabla[2][i] == jucator) return true; // verificare coloane
        }
        if (tabla[0][0] == jucator && tabla[1][1] == jucator && tabla[2][2] == jucator) return true; // verificare diagonala principala
        if (tabla[0][2] == jucator && tabla[1][1] == jucator && tabla[2][0] == jucator) return true; // verificare diagonala secundara
        return false;
    }

    private boolean tablaPlina() {
        for (int i = 0; i < DIMENSIUNE; i++) {
            for (int j = 0; j < DIMENSIUNE; j++) {
                if (tabla[i][j] == GOL) return false;
            }
        }
        return true;
    }

    private void afisareRezultat() {
        if (castigator(X)) {
            System.out.println("Jucatorul X a castigat!");
        } else if (castigator(O)) {
            System.out.println("Jucatorul O a castigat!");
        } else {
            System.out.println("Jocul s-a terminat in egalitate!");
        }
    }

    public static void main(String[] args) {
        new XSi0();
    }
}
