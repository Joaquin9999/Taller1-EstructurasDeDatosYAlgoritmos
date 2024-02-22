import java.util.LinkedList;
import java.util.Queue;

class Fila {
    private Queue<Persona> personasEnFila;

    public Fila() {
        this.personasEnFila = new LinkedList<>();
    }

    public void agregarPersona(Persona persona) {
        personasEnFila.offer(persona);
    }

    public Persona atenderPersona() {
        return personasEnFila.poll();
    }

    public boolean isEmpty() {
        return personasEnFila.isEmpty();
    }

    public int size() {
        return personasEnFila.size();
    }

    @Override
    public String toString() {
        return "Fila{personasEnFila=" + personasEnFila + '}';
    }
}
