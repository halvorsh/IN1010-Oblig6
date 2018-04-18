public class Melding {
    private String innhold;
    private int sekvensnummer, kanalID;

    public Melding(String innhold, int sekvensnummer, int kanalID){
        this.innhold = innhold;
        this.sekvensnummer = sekvensnummer;
        this.kanalID = kanalID;
    }

    public String getInnhold() {
        return innhold;
    }

    public int getSekvensnummer() {
        return sekvensnummer;
    }

    public int getKanalID() {
        return kanalID;
    }
}
