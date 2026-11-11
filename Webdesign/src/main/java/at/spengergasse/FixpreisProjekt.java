package at.spengergasse;

public class FixpreisProjekt extends WebProjekt{
    private float fixPreis;

    public FixpreisProjekt(int stunden, String projektName, String entwickler, float fixPreis) throws WebdesignException {
        super(stunden, projektName, entwickler);
        setFixPreis(fixPreis);
    }

    public float getFixPreis() {
        return fixPreis;
    }

    public void setFixPreis(float fixPreis) throws WebdesignException{
        if(fixPreis < 0.0f)
            throw new WebdesignException("Fehler");
        this.fixPreis = fixPreis;
    }

    @Override
    public float kostenGesamt() {
        return getFixPreis();
    }

    @Override
    public String toString() {
        return "FixpreisProjekt:\n" + super.toString();
    }
}
