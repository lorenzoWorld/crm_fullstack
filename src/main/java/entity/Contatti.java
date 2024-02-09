package entity;

import java.util.Objects;

@Entity
public class Contatti {

    @ManyToOne
    @JoinColumn(name = "hr_id")
    private HR hr;

    public HR getHr() {
        return hr;
    }

    public void setHr(HR hr) {
        if (hr == null) {
            throw new IllegalArgumentException("HR cannot be null");
        }
        this.hr = hr;
    }

    public Contatti(HR hr) {
        this.hr = hr;
    }

    @Override
    public String toString() {
        return "Contatti{" +
                "hr=" + hr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contatti contatti = (Contatti) o;
        return Objects.equals(hr, contatti.hr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hr);
    }

    public void setStato(String nuovoStato) {
    }
}
