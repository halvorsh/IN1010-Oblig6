public class Telegrafist extends Thread{
    private Kanal kanal;
    private int sekvensnummer;

    public Telegrafist(Kanal kanal){
        this.kanal = kanal;
        sekvensnummer = 0;
    }

    @Override
    public void run() {
        String tekst = kanal.lytt();

        Melding melding = new Melding(tekst, sekvensnummer, kanal.hentId());
        sekvensnummer++;

    }
}
