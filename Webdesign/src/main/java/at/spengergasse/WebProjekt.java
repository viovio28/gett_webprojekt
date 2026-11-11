package at.spengergasse;


public abstract class WebProjekt {
    private int stunden;
    private String projektName;
    private String entwickler;

    public WebProjekt(int stunden, String projektName, String entwickler) throws WebdesignException{
        setStunden(stunden);
        setProjektName(projektName);
        setEntwickler(entwickler);
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) throws WebdesignException{
        if(stunden < 1)
            throw new WebdesignException("Fehler");

        this.stunden = stunden;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) throws WebdesignException{
        if (projektName == null)
            throw new WebdesignException("Fehler");
        this.projektName = projektName;
    }

    public String getEntwickler() {
        return entwickler;
    }

    public void setEntwickler(String entwickler) throws WebdesignException{
        if (entwickler == null)
            throw new WebdesignException("Fehler");
        this.entwickler = entwickler;
    }

    public abstract float kostenGesamt();

    public double kostenProStunde(){
       return kostenGesamt() / stunden;
    }

    public String toString(){
        return stunden + "Stunden, Projekt: " + projektName +
        "\nEntwickler:in: " + entwickler +
        "\nKosten: " + kostenGesamt() + " EUR, Kosten pro Stunde: " + kostenProStunde() + "EUR";
    }

}
