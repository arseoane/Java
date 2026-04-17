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


    }
}
