package pl.szydelkowestwory.szydelkoweStwory.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    String nazwa;
    String kolor;
    double ilosc;
    double cenaSzt;
    @ManyToMany(mappedBy = "materialy")
    Set<Maskotka> maskotki = new HashSet<>();

    public Set<Maskotka> getMaskotki() {
        return maskotki;
    }

    public void setMaskotki(Set<Maskotka> maskotki) {
        this.maskotki = maskotki;
    }

    public Material() {
    }

    public Material(String nazwa, String kolor, double ilosc, double cenaSzt) {
        this.nazwa = nazwa;
        this.kolor = kolor;
        this.ilosc = ilosc;
        this.cenaSzt = cenaSzt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public double getCenaSzt() {
        return cenaSzt;
    }

    public void setCenaSzt(double cenaSzt) {
        this.cenaSzt = cenaSzt;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", kolor='" + kolor + '\'' +
                ", ilosc=" + ilosc +
                ", cenaSzt=" + cenaSzt +
                '}';
    }
}
