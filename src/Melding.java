public class Melding implements Comparable{
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

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }

    @Override
    public int compareTo(Object o) {
        Melding annenMelding = (Melding) o;

        if(kanalID < annenMelding.getKanalID()){
            return -1;
        }else if(kanalID > annenMelding.getKanalID()){
            return 1;
        }else if(sekvensnummer < annenMelding.getSekvensnummer()){
            return -1;
        }else if(sekvensnummer > annenMelding.getSekvensnummer()){
            return 1;
        }else{
            System.out.println("Noe er meget galt og du kan ikke kode ordentlig Halvor.");
        }
        return 0;
    }

    @Override
    public String toString() {
        return innhold;
    }
}
