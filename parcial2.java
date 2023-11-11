import java.util.Scanner;
import java.util.ArrayList;

public class parcial2 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ArrayList<String> dna = new ArrayList<>();

        int counter = 0;

        while (counter < 6) {
            System.out.println("Ingrese el ADN para saber si o no mutante: ");
            String chain_mutante = leer.nextLine();
            if (largoCaracter(chain_mutante)) {
                if (caracterValido(chain_mutante)) {
                    dna.add(chain_mutante);
                    counter++;
                } else {
                    System.out.println("Caracteres invalidos");
                    continue;
                }
            } else {
                System.out.println("Largo de la cadena invalido");
                continue;
            }
        }
        boolean result = is_mutant(dna);
        System.out.println(result);
        if (result){
            System.out.println("El humano es mutante");
        }else{
            System.out.println("El humano no es mutante");
        }

    }

    public static boolean largoCaracter(String chain_mutante) {
        if (chain_mutante.length() == 6) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean caracterValido(String chain_mutante) {
        for (int i = 0; i < 6; i++) {
            if (chain_mutante.charAt(i) != 'a' && chain_mutante.charAt(i) != 'g' && chain_mutante.charAt(i) != 'c' && chain_mutante.charAt(i) != 't') {
                return false;
            }
        }
        return true;
    }

    public static boolean is_mutant(ArrayList<String> dna) {
        int filas = dna.size();
        int columnas = dna.get(0).length();
        int contador_mut = 0;
        /*Verificacion horizontal para ver si hay mutantes o no*/
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (dna.get(i).charAt(j) == dna.get(i).charAt(j + 1) && dna.get(i).charAt(j) == dna.get(i).charAt(j + 2) && dna.get(i).charAt(j) == dna.get(i).charAt(j + 3)) {
                    contador_mut++;
                }
            }
        }
        /*Verificacion vertical para ver si hay mutantes o no*/
        for (int i = 0; i < filas - 3; i++) {
            for (int j = 0; j < columnas; j++) {
                char aux = dna.get(i).charAt(j);

                if (aux != dna.get(i + 1).charAt(j) || aux != dna.get(i + 2).charAt(j) || aux != dna.get(i + 3).charAt(j)) {
                    continue;
                }
                contador_mut++;
            }
        }
        /*Verificacion en diagonales para ver si hay mutantes o no*/
        for (int i = 0; i < filas-3; i++){
            for (int j = 0; j<columnas;j++){
                char aux = dna.get(i).charAt(j);
                if (j < dna.size() - 3 && aux != dna.get(i + 1).charAt(j + 1) && aux != dna.get(i + 2).charAt(j + 2) && aux != dna.get(i + 3).charAt(j + 3)) {
                    continue;
                }
                /*derecha a izquierda*/
                if (j >= 3 && aux != dna.get(i + 1).charAt(j - 1) && aux != dna.get(i + 2).charAt(j - 2) && aux != dna.get(i + 3).charAt(j - 3)) {
                    continue;
                }
            }
        }

        System.out.println(contador_mut);
        return contador_mut>=2;
    }
}
