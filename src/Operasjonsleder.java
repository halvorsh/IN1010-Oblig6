import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Operasjonsleder {
    private Melding[] meldinger;

    public Operasjonsleder(ArrayList<Melding> meldinger){
        this.meldinger = meldinger.toArray(new Melding[meldinger.size()]);
        sorterMeldinger();
        skrivTilFil();
    }

    private void sorterMeldinger(){
        Arrays.sort(meldinger);
    }

    private void skrivTilFil(){
        int gjeldeneKanalID = 0;
        PrintWriter printWriter = null;

        for(int i = 0; i < meldinger.length; i++){
            if(meldinger[i].getKanalID() != gjeldeneKanalID){
                gjeldeneKanalID++;
                if(printWriter!= null){
                    printWriter.close();
                }
                try{
                    printWriter = new PrintWriter(gjeldeneKanalID+".txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            printWriter.write(meldinger[i].getInnhold()+"\n\n");
        }
        printWriter.close();
    }
}
