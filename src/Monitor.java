import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    private ArrayList<Melding> meldinger = new ArrayList <>();
    private ReentrantLock laas = new ReentrantLock();

    public void leggTilMelding(Melding melding){
        laas.lock();
        try {
            meldinger.add(melding);
        }finally {
            laas.unlock();
        }
    }

    public Melding hentUtMelding(){
        laas.lock();
        Melding melding;
        try {
            melding = meldinger.get(0);
            meldinger.remove(0);
        }finally {
            laas.unlock();
        }
        return melding;
    }
}
