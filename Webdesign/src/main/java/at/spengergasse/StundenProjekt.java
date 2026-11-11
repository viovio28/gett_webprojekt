package at.spengergasse;

public class StundenProjekt extends WebProjekt {
    private float stundenSatz;

    public StundenProjekt (int stunden, String projektName, String entwickler, float stundenSatz) throws WebdesignException {
        super(stunden, projektName, entwickler);
        setStundenSatz(stundenSatz);
    }

    public float getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(float stundenSatz) throws WebdesignException {
        if (stundenSatz < 0.0f)
            throw new WebdesignException("Fehler");
        this.stundenSatz = stundenSatz;
    }

    @Override
    public float kostenGesamt() {
        return getStunden() * getStundenSatz();
    }

    @Override
    public String toString() {
        return "Stundenprojekt:\n" + super.toString();
    }
}
