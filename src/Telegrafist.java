public class Telegrafist extends Thread{
    private Kanal kanal;
    private Monitor kryptertMonitor;
    private int sekvensnummer;

    public Telegrafist(Kanal kanal, Monitor kryptertMonitor){
        this.kanal = kanal;
        this.kryptertMonitor = kryptertMonitor;
        sekvensnummer = 0;
    }

    public void setKanal(Kanal kanal) {
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
