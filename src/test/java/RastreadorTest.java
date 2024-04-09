import org.example.Leitor;
import org.example.Rastreador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RastreadorTest {

    @Test
    public void findStartCase1(){
        Leitor leitor = new Leitor(1);
        Rastreador rastreador = new Rastreador();
        rastreador.setMapa(leitor.leMapa());
        Assertions.assertEquals(5, rastreador.searchStart());
    }
    @Test
    public void reachFinalCase1(){
        Leitor leitor = new Leitor(1);
        Rastreador rastreador = new Rastreador();
        rastreador.setMapa(leitor.leMapa());
        Assertions.assertTrue(rastreador.iniciaRastreio());
    }

    @Test
    public void reachFinalAllCases(){
        Rastreador rastreador = new Rastreador();
        for (int i = 1; i < 9; i++) {
            Leitor leitor = new Leitor(i);
            rastreador.setMapa(leitor.leMapa());
            Assertions.assertTrue(rastreador.iniciaRastreio());
            System.out.println(rastreador.getValorTotal());
        }
    }

    @Test
    public void getAllMoneyCase1(){
        Leitor leitor = new Leitor(1);
        Rastreador rastreador = new Rastreador();
        rastreador.setMapa(leitor.leMapa());
        Assertions.assertTrue(rastreador.iniciaRastreio());
        System.out.println(rastreador.getValorTotal());
    }
}
