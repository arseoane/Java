import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Boletin13 {
    public static <T> T[] Ejercicio1(T[] primeira, T[] segunda){
        T[] resultado = Arrays.copyOf(primeira, primeira.length + segunda.length);

        System.arraycopy(segunda, 0, resultado, primeira.length, segunda.length);

        return resultado;

    }

    public static void Ejercicio2() {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            numeros.add(rand.nextInt(10) + 1);
        }

        System.out.println("Antes de eliminar:");
        System.out.println(numeros);

        numeros.removeIf(n -> n == 5 || n == 7);

        System.out.println("Después de eliminar:");
        System.out.println(numeros);
    }

    public static void Ejercicio3() {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            numeros.add(rand.nextInt(10) + 1);
        }

        System.out.println("Antes de eliminar:");
        System.out.println(numeros);

        numeros.removeIf(n -> n == 5 || n == 7);

        System.out.println("Después de eliminar:");
        System.out.println(numeros);
    }

    public static void main(String[] args) {
        Integer[] primera = new Integer[10];
        Integer[] segunda = new Integer[10];

        Ejercicio1(primera, segunda);

    }

}
