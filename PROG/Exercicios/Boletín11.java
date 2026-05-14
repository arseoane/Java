import java.util.Scanner;
import java.util.Random;

public class Boletín11 {

    public static void main(String[] args) {
        
        // Ejercicio 1
        int[] numeros = new int[6];
        Random rand = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(50) + 1;
        }
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // Ejercicio 2
        int[] notas = new int[30];
        int aprobados = 0;
        int suspensos = 0;
        int sumaNotas = 0;
        int notaMasAlta = 0;

        for (int i = 0; i < notas.length; i++) {
            notas[i] = rand.nextInt(11); 
            if (notas[i] >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }
            sumaNotas += notas[i];
            if (notas[i] > notaMasAlta) {
                notaMasAlta = notas[i];
            }
        }
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Suspensos: " + suspensos);
        System.out.println("Nota media: " + ((double) sumaNotas / notas.length));
        System.out.println("Nota mas alta: " + notaMasAlta);

        // Ejercicio 3
        String[] nombres = new String[30];
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = "Alumno " + (i + 1);
        }

        System.out.println("Nota del alumno " + nombres[0] + ": " + notas[0]);

        System.out.println("Alumnos aprobados:");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 5) {
                System.out.println(nombres[i]);
            }
        }

        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - i - 1; j++) {
                if (notas[j] > notas[j + 1]) {
                    int tempNota = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = tempNota;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;
                }
            }
        }

        System.out.println("Lista ordenada de menor a mayor:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println(nombres[i] + ": " + notas[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de un alumno (Ej: Alumno 5): ");
        String nombreBuscado = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Nota: " + notas[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Alumno no encontrado.");
        }

        // Ejercicio 4
        System.out.print("Introduce el numero del DNI: ");
        int dni = scanner.nextInt();
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = dni % 23;
        System.out.println("Letra del NIF: " + letrasDNI[resto]);
        
        scanner.close();
    }

    // Ejercicio 5
    public static <T> int buscarElemento(T[] matriz, T valor) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] != null && matriz[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    // Ejercicio 6
    public static <T extends Comparable<T>> int busquedaBinaria(T[] matriz, T valor) {
        int inicio = 0;
        int fin = matriz.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = matriz[medio].compareTo(valor);
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    // Ejercicio 7
    public static int[] copiarMatriz(int[] matriz) {
        int[] copia = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            copia[i] = matriz[i];
        }
        return copia;
    }

    // Ejercicio 8
    public static int[] obtenerPares(int[] vector) {
        int contador = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                contador++;
            }
        }
        int[] pares = new int[contador];
        int indice = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                pares[indice] = vector[i];
                indice++;
            }
        }
        return pares;
    }

    // Ejercicio 9
    public static int[] eliminarRepetidos(int[] taboa) {
        int[] temporal = new int[taboa.length];
        int contador = 0;
        for (int i = 0; i < taboa.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < contador; j++) {
                if (taboa[i] == temporal[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                temporal[contador] = taboa[i];
                contador++;
            }
        }
        int[] resultado = new int[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = temporal[i];
        }
        return resultado;
    }

    // Ejercicio 10
    public static int[] borrarElementoDesordenado(int[] taboa, int valor) {
        int posicion = -1;
        for (int i = 0; i < taboa.length; i++) {
            if (taboa[i] == valor) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            return taboa;
        }
        int[] nuevaTaboa = new int[taboa.length - 1];
        int indice = 0;
        for (int i = 0; i < taboa.length; i++) {
            if (i != posicion) {
                nuevaTaboa[indice] = taboa[i];
                indice++;
            }
        }
        return nuevaTaboa;
    }

    public static int[] borrarElementoOrdenado(int[] taboa, int valor) {
        int inicio = 0;
        int fin = taboa.length - 1;
        int posicion = -1;
        
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (taboa[medio] == valor) {
                posicion = medio;
                break;
            } else if (taboa[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        
        if (posicion == -1) {
            return taboa;
        }
        
        int[] nuevaTaboa = new int[taboa.length - 1];
        int indice = 0;
        for (int i = 0; i < taboa.length; i++) {
            if (i != posicion) {
                nuevaTaboa[indice] = taboa[i];
                indice++;
            }
        }
        return nuevaTaboa;
    }
}
