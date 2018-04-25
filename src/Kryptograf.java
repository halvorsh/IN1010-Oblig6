public class Kryptograf extends Thread{
    private Monitor kryptertMonitor, dekryptertMonitor;

    public Kryptograf(Monitor kryptertMonitor, Monitor dekryptertMonitor){
        this.kryptertMonitor = kryptertMonitor;
        this.dekryptertMonitor = dekryptertMonitor;
    }

    @Override
    public void run() {
        while(true) {
            Melding melding = kryptertMonitor.hentUtMelding();

            String innhold = melding.getInnhold();
            innhold = Kryptografi.dekrypter(innhold);
            melding.setInnhold(innhold);
            dekryptertMonitor.leggTilMelding(melding);

            System.out.println(innhold);
        }
    }
}
