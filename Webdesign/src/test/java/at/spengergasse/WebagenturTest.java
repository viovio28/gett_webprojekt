package at.spengergasse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebagenturTest {

    private Webagentur webagentur;
    private StundenProjekt sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8;
    private FixpreisProjekt fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8;

    @BeforeEach
    void setUp(){

            try{
            webagentur = new Webagentur("Testagentur");
            sp1 = new StundenProjekt(10, "projekt 1", "ent a", 300.0f);
            sp2 = new StundenProjekt(11, "projekt 2", "ent b", 200.0f);
            sp3 = new StundenProjekt(12, "projekt 3", "ent c", 100.0f);
            sp4 = new StundenProjekt(13, "projekt 4", "ent d", 400.0f);
            sp5 = new StundenProjekt(14, "projekt 5", "ent a", 300.0f);
            sp6 = new StundenProjekt(15, "projekt 6", "ent b", 200.0f);
            sp7 = new StundenProjekt(10, "projekt 7", "ent c", 100.0f);
            sp8 = new StundenProjekt(10, "projekt 8", "ent d", 400.0f);
            fp1 = new FixpreisProjekt(20, "projekt 9", "ent a", 1000.0f);
            fp2 = new FixpreisProjekt(40, "projekt 10", "ent b", 3000.0f);
            fp3 = new FixpreisProjekt(80, "projekt 11", "ent c", 8000.0f);
            fp4 = new FixpreisProjekt(10, "projekt 12", "ent a", 1800.0f);
            fp5 = new FixpreisProjekt(22, "projekt 13", "ent b", 1300.0f);
            fp6 = new FixpreisProjekt(110, "projekt 14", "ent d", 24000.0f);
            fp7 = new FixpreisProjekt(3, "projekt 15", "ent a", 1040.0f);
            fp8 = new FixpreisProjekt(25, "projekt 16", "ent c", 1200.0f);
            assertEquals(1,1);
            } catch (WebdesignException e) {
                System.out.println(e.getMessage());
                assertEquals(1,0);
            }

    }

        @Test
        public void test_hinzufuegen_null(){
            WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.hinzufuegen(null));
            assertEquals("Fehler, kein Projekt.", e.getMessage());
        }

        @Test
        public void test_hinzufuegen_doppelt() throws WebdesignException {
            webagentur.hinzufuegen(sp1);
            WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.hinzufuegen(sp1));
            assertEquals("Fehler, Projekt schon vorhanden.", e.getMessage());
        }

        @Test
        public void test_hinzufuegen_16() throws WebdesignException {
            WebProjekt[] projekte = {sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8,fp1, fp2, fp3, fp4, fp5, fp6, fp7};

            for (WebProjekt projekt : projekte) {
                webagentur.hinzufuegen(projekt);
            }

            WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.hinzufuegen(fp8));
            assertEquals("Fehler, kein Platz.", e.getMessage());


        }

        @Test
        public void test_hinzufuegen_ok(){
            try {
                WebProjekt[] projekte = {sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8,fp1, fp2, fp3, fp4, fp5, fp6, fp7};

                for (WebProjekt projekt : projekte) {
                    webagentur.hinzufuegen(projekt);
                }
                assertEquals(15, webagentur.anzProjekte());
            } catch ( WebdesignException e){
                System.out.println(e.getMessage());
                assertEquals(1,0);
            }
        }

        @Test
        public void test_entfernen_entwickler_ok(){
        try {
            WebProjekt[] projekte = {sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8,fp1, fp2, fp3, fp4, fp5, fp6, fp7};

            for (WebProjekt projekt : projekte) {
                webagentur.hinzufuegen(projekt);
            }

            assertEquals(15, webagentur.anzProjekte());
            assertEquals(5, webagentur.entfernen("ent a"));
            assertEquals(10, webagentur.anzProjekte());

        }catch (WebdesignException e){
            System.out.println(e.getMessage());
            assertEquals(1,0);

        }
        }

        @Test
        public void test_entfernen_entwickler_null() throws WebdesignException{

                WebProjekt[] projekte = {sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, fp1, fp2, fp3, fp4, fp5, fp6, fp7};

                for (WebProjekt projekt : projekte) {
                    webagentur.hinzufuegen(projekt);
                }

               WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.entfernen((String)null));
                assertEquals("Fehler, ungültige Entwicklerin.", e.getMessage());

        }

    @Test
    public void test_entfernen_entwickler_gibt_es_nicht() throws WebdesignException{

        WebProjekt[] projekte = {sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, fp1, fp2, fp3, fp4, fp5, fp6, fp7};

        for (WebProjekt projekt : projekte) {
            webagentur.hinzufuegen(projekt);
        }

        WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.entfernen("ent 0"));
        assertEquals("Fehler, Entwickler nicht vorhanden.", e.getMessage());


    }

    @Test
    public void test_entfernen_Projekt_null(){
        WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.entfernen((WebProjekt) null));
        assertEquals("Fehler, kein gültiges Projekt.", e.getMessage());
    }

    @Test
    public void test_entfernen_Projekt_nicht_vorhanden(){
        WebdesignException e = assertThrows(WebdesignException.class, () -> webagentur.entfernen((WebProjekt)sp1));
        assertEquals("Fehler, Projekt nicht vorhanden.", e.getMessage());

    }

    @Test
    public void test_entfernen_Projekt_ok() throws WebdesignException{
        webagentur.hinzufuegen(sp1);
        assertEquals(1,webagentur.anzProjekte());
        webagentur.entfernen(sp1);
        assertEquals(0, webagentur.anzProjekte());

    }
}



