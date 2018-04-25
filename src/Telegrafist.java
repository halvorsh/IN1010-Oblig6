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
    }

    @Override
    public void run() {
        while(!interrupted()) {
            String tekst = kanal.lytt();

            if(tekst == null){
                interrupt();
            }else {
                System.out.println(tekst);

                Melding melding = new Melding(tekst, sekvensnummer, kanal.hentId());
                kryptertMonitor.leggTilMelding(melding);
                sekvensnummer++;
            }
        }

    }
}
