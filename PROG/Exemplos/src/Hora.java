public class Hora {
    int horas;
    int minutos;
    int segundos;

    public Hora (){
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Hora (int horas, int minutos, int segundos){
        if (horas >= 0) this.horas = horas;
        else this.horas = 0;
        if (minutos < 60 && minutos >= 0) this.minutos = minutos;
        else this.minutos = 0;
        if (segundos >= 0 && segundos < 60) this.segundos = segundos;
        else this.segundos = 0;
    }
    public String toString(){
        return "Horas: "+ horas + " Minutos: " + minutos + " Segundos: " + segundos;
    }
    public static void main (String [] args){
        Hora h = new Hora();
        System.out.println(h);
    }
}
