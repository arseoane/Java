public class Futbolista extends Persoa implements Comparable<Persoa> {

    public int goles = 0;

    public Futbolista(String nombre, int idade, String dni, int goles) {
        super(nombre, dni, idade);
        this.setGoles(goles);
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public int compareTo(Persoa otro) {
        if (otro.dni.equals(this.dni)) {
            return 0;
        } else {
            return this.dni.compareTo(otro.dni);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nGoles: " + this.goles;
    }
}
