import java.util.ArrayList;

public class Monitor {
    ArrayList<Melding> meldinger = new ArrayList <>();

    public void leggTilMelding(Melding melding){
        meldinger.add(melding);
    }

    public Melding hentUtMelding(){
        Melding melding = meldinger.get(0);
        meldinger.remove(0);
        return melding;
    }
}
