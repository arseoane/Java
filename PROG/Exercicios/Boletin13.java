import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Boletin13 {

    public static <T> T[] Ejercicio1(T[] primeira, T[] segunda) {
        T[] resultado = Arrays.copyOf(primeira, primeira.length + segunda.length);
        System.arraycopy(segunda, 0, resultado, primeira.length, segunda.length);
        return resultado;
    }

    public static void Ejercicio2() {
        System.out.println("EJERCICIO 2");

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
        System.out.println("EJERCICIO 3");

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

    public static void Ejercicio4() {
        System.out.println("EJERCICIO 4");

        Scanner sc = new Scanner(System.in);
        List<Double> positivos = new ArrayList<>();
        List<Double> negativos = new ArrayList<>();

        while (true) {
            System.out.print("Introduce un número (0 para terminar): ");
            double n = sc.nextDouble();
            if (n == 0) break;
            if (n > 0) positivos.add(n);
            else negativos.add(n);
        }

        double sumaPos = 0;
        double sumaNeg = 0;

        for (double x : positivos) sumaPos += x;
        for (double x : negativos) sumaNeg += x;

        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Suma positivos: " + sumaPos);
        System.out.println("Suma negativos: " + sumaNeg);

        positivos.removeIf(x -> x > 10);
        negativos.removeIf(x -> x < -10);

        System.out.println("Filtrados positivos: " + positivos);
        System.out.println("Filtrados negativos: " + negativos);
    }

    public static void Ejercicio5() {
        System.out.println("EJERCICIO 5");

        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();

        while (true) {
            System.out.print("Introduce un número (-1 para terminar): ");
            int n = sc.nextInt();
            if (n == -1) break;
            if (n > 0) nums.add(n);
        }

        System.out.println("Resultado (índices pares * 100):");

        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(nums.get(i) * 100);
            }
        }
    }

    public static void Ejercicio6() {
        System.out.println("EJERCICIO 6");

        List<Integer> lista = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            lista.add(r.nextInt(10) + 1);
        }

        Set<Integer> sinRepetir = new HashSet<>(lista);

        Set<Integer> repetidos = new HashSet<>();
        Set<Integer> vistos = new HashSet<>();

        for (int x : lista) {
            if (!vistos.add(x)) repetidos.add(x);
        }

        Set<Integer> unicos = new HashSet<>();
        for (int x : lista) {
            if (Collections.frequency(lista, x) == 1) unicos.add(x);
        }

        System.out.println("Lista: " + lista);
        System.out.println("Sin repetir: " + sinRepetir);
        System.out.println("Repetidos: " + repetidos);
        System.out.println("Únicos: " + unicos);
    }

    public static <E> Set<E> union(Set<E> c1, Set<E> c2) {
        Set<E> res = new HashSet<>(c1);
        res.addAll(c2);
        return res;
    }

    public static <E> Set<E> interseccion(Set<E> c1, Set<E> c2) {
        Set<E> res = new HashSet<>(c1);
        res.retainAll(c2);
        return res;
    }

    static class Rexistro implements Serializable {
        double temp;
        LocalDateTime hora;

        Rexistro(double temp) {
            this.temp = temp;
            this.hora = LocalDateTime.now();
        }

        public String toString() {
            return temp + " " + hora;
        }
    }

    public static void Ejercicio9() throws Exception {
        System.out.println("EJERCICIO 9");

        Scanner sc = new Scanner(System.in);
        List<Rexistro> rexistros = new ArrayList<>();

        while (true) {
            System.out.println("1 Nuevo registro");
            System.out.println("2 Listar");
            System.out.println("3 Estadística");
            System.out.println("4 Salir");

            System.out.print("Opción: ");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("Introduce temperatura: ");
                double t = sc.nextDouble();
                rexistros.add(new Rexistro(t));
            } else if (op == 2) {
                System.out.println("Lista de registros:");
                for (Rexistro r : rexistros) System.out.println(r);
            } else if (op == 3) {
                double max = rexistros.stream().mapToDouble(x -> x.temp).max().orElse(0);
                double min = rexistros.stream().mapToDouble(x -> x.temp).min().orElse(0);
                double avg = rexistros.stream().mapToDouble(x -> x.temp).average().orElse(0);

                System.out.println("Máxima: " + max);
                System.out.println("Mínima: " + min);
                System.out.println("Media: " + avg);
            } else {
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
                String name = "rexistros" + LocalDateTime.now().format(f) + ".dat";

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name));
                oos.writeObject(rexistros);
                oos.close();

                break;
            }
        }
    }

    static class Produto implements Serializable {
        String codigo;
        int cantidade;

        Produto(String c, int q) {
            codigo = c;
            cantidade = q;
        }
    }

    public static void Ejercicio10() throws Exception {
        System.out.println("EJERCICIO 10");

        Scanner sc = new Scanner(System.in);
        Map<String, Produto> stock = new HashMap<>();

        while (true) {
            System.out.println("1 Alta");
            System.out.println("2 Baja");
            System.out.println("3 Actualizar");
            System.out.println("4 Listar");
            System.out.println("5 Salir");

            System.out.print("Opción: ");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("Código producto: ");
                String c = sc.next();
                System.out.print("Cantidad: ");
                int q = sc.nextInt();
                stock.put(c, new Produto(c, q));
            } else if (op == 2) {
                System.out.print("Código producto: ");
                String c = sc.next();
                stock.remove(c);
            } else if (op == 3) {
                System.out.print("Código producto: ");
                String c = sc.next();
                System.out.print("Nueva cantidad: ");
                int q = sc.nextInt();
                if (stock.containsKey(c)) stock.get(c).cantidade = q;
            } else if (op == 4) {
                System.out.println("Stock:");
                for (Produto p : stock.values()) {
                    System.out.println(p.codigo + " " + p.cantidade);
                }
            } else {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stock.dat"));
                oos.writeObject(stock);
                oos.close();
                break;
            }
        }
    }

    static class Academico implements Comparable<Academico>, Serializable {
        String nome;
        int ano;

        Academico(String n, int a) {
            nome = n;
            ano = a;
        }

        public int compareTo(Academico o) {
            return nome.compareTo(o.nome);
        }
    }

    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico novo, Character letra) {
        if (!Character.isLetter(letra)) return false;
        academia.put(letra, novo);
        return true;
    }

    public static void Ejercicio11() {
        System.out.println("EJERCICIO 11");

        Map<Character, Academico> academia = new HashMap<>();

        academia.put('A', new Academico("Ana", 2010));
        academia.put('B', new Academico("Luis", 2012));
        academia.put('C', new Academico("Pedro", 2008));
        academia.put('D', new Academico("Maria", 2015));
        academia.put('E', new Academico("Juan", 2005));

        List<Academico> lista = new ArrayList<>(academia.values());
        Collections.sort(lista);

        System.out.println("Ordenados por nombre:");
        for (Academico a : lista) {
            System.out.println(a.nome + " " + a.ano);
        }

        List<Character> letras = new ArrayList<>(academia.keySet());
        Collections.sort(letras);

        System.out.println("Ordenados por letra:");
        for (Character c : letras) {
            Academico a = academia.get(c);
            System.out.println(c + " " + a.nome + " " + a.ano);
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] primera = {1, 2, 3};
        Integer[] segunda = {4, 5, 6};

        System.out.println("EJERCICIO 1");
        System.out.println(Arrays.toString(Ejercicio1(primera, segunda)));

        Ejercicio2();
        Ejercicio3();
        Ejercicio4();
        Ejercicio5();
        Ejercicio6();
        Ejercicio9();
        Ejercicio10();
        Ejercicio11();
    }
}