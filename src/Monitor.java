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

    public int hentAntallMeldinger(){
        return meldinger.size();
    }

    public ArrayList<Melding> hentMeldinger(){
        return meldinger;
    }

    public Melding hentUtMelding(){
        laas.lock();
        Melding melding;
        try {
            if(meldinger.size()>0) {
                melding = meldinger.get(0);
                meldinger.remove(0);
            }else{
                melding = null;
            }
        }finally {
            laas.unlock();
        }
        return melding;
    }
}
