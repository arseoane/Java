public class exemplosArray {

    public static void main (String [] args){
        int [] numeros = {1,2,3,4,5};
        char [] letras = new char[10];
        letras[0] = 'a';
        letras[1] = 'b';
        for (int i = 0; i<5; i++)
            System.out.println("O número é: " + numeros[i]);

        for (int i = 0; i<letras.length;i++)
            System.out.println("A letra é: " + letras[i]);

        for (int n: numeros)
            System.out.println("O número é: " + n);

        String [] nomes;
        nomes = new String[10];
        nomes [0] = "Hugo";
        nomes [1] = "Pedro";
        nomes [2] = new String ("Ana");

        Persoa [] equipo;
        equipo = new Persoa[5];
        equipo [0] = new Persoa("Ramón","4567U",41);
    }
}
