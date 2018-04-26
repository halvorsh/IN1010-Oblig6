import static java.lang.Integer.parseInt;

public class Hovedprogram {
    public static void main(String[] args) {
        int antallKanaler = parseInt(args[0]);
        int antallKryptografer = parseInt(args[1]);

        Operasjonssentral ops = new Operasjonssentral(antallKanaler);
        Kanal[] kanaler = ops.hentKanalArray();
        Monitor krypteringsMonitor = new Monitor();
        Monitor dekrypteringsMonitor = new Monitor();

        Telegrafist[] telegrafister = new Telegrafist[kanaler.length];
        for(int i = 0; i < kanaler.length; i++){
            Telegrafist telegrafist = new Telegrafist(kanaler[i], krypteringsMonitor);
            telegrafister[i] = telegrafist;
            telegrafist.start();
        }

        Kryptograf[] kryptografer = new Kryptograf[antallKryptografer];
        for(int i = 0; i < antallKryptografer; i++){
            Kryptograf kryptograf = new Kryptograf(krypteringsMonitor, dekrypteringsMonitor);
            kryptografer[i] = kryptograf;
            kryptograf.start();
        }

        boolean ferdig = false;
        while(!ferdig){
            ferdig = true;
            for(Kryptograf kryptograf : kryptografer){
                if(!kryptograf.isFerdig()){
                    ferdig = false;
                }
            }
        }

        Operasjonsleder operasjonsleder = new Operasjonsleder(dekrypteringsMonitor.hentMeldinger());

        System.out.println("Er ferdig");
    }
}
