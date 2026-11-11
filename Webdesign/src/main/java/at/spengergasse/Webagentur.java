package at.spengergasse;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class Webagentur {
    private String name;
    private ArrayList<WebProjekt> projekte;

    public Webagentur(String name){
        setName(name);
        projekte = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WebProjekt getProjekt(int index) {
        if(index < 0 || index > projekte.size())
            return null;
        return projekte.get(index);
    }

    public boolean hinzufuegen(WebProjekt projekt) throws WebdesignException{
        if(projekt == null)
            throw new WebdesignException("Fehler, kein Projekt.");
        if(projekte.contains(projekt))
            throw new WebdesignException("Fehler, Projekt schon vorhanden.");
        if(projekte.size() >= 15)
            throw new WebdesignException("Fehler, kein Platz.");

        projekte.add(projekt);
        return true;
    }

    public boolean entfernen(WebProjekt projekt) throws WebdesignException{
        if(projekt == null)
            throw new WebdesignException("Fehler, kein gültiges Projekt.");
        if(!projekte.contains(projekt))
            throw new WebdesignException("Fehler, Projekt nicht vorhanden.");
        projekte.remove(projekt);
        return true;
    }

    public int entfernen(String entwickler)throws WebdesignException{

        Iterator<WebProjekt> it = projekte.iterator();
        WebProjekt wp;
        int anz = 0;


        if(entwickler == null)
            throw new WebdesignException("Fehler, ungültige Entwicklerin.");

        while(it.hasNext()){
            wp = it.next();
            if(wp.getEntwickler().equals(entwickler)){
                it.remove();
                ++anz;}
        }

        if(anz <= 0)
            throw new WebdesignException("Fehler, Entwickler nicht vorhanden.");

        return anz;


    }

    public int anzahlPreisGesamt(float maxPreisGesamt) throws WebdesignException{
        int anz = 0;
        int anzFixPreisProjekte = 0;

        if (maxPreisGesamt < 0) {
            throw new WebdesignException("Fehler");
        }

        for (WebProjekt wp : projekte) {
            if (wp instanceof FixpreisProjekt) {
                anzFixPreisProjekte++;
                if (wp.kostenGesamt() < maxPreisGesamt) {
                    anz++;
                }
            }
        }

        if (anzFixPreisProjekte<1) {
            System.out.println("Fehler: kein Gruppenkurs!");
            return -99;
        }

        return anz;
    }

    public int anzProjekte(){return projekte.size();}

    @Override
    public String toString() {
        return super.toString();
    }
}
