package pl.szydelkowestwory.szydelkoweStwory.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "maskotka")
public class Maskotka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    String nazwa;
    double cena_podstawowa;
    int czas_wykonania;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "maskotki_materialy",
            joinColumns = @JoinColumn(name = "maskotka_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private Set<Material> materialy = new HashSet<>();

    public Maskotka() {
    }

    public Maskotka(String nazwa, double cena_podstawowa, int czas_wykonania) {
        this.nazwa = nazwa;
        this.cena_podstawowa = cena_podstawowa;
        this.czas_wykonania = czas_wykonania;
    }

    public int getCzas_wykonania() {
        return czas_wykonania;
    }

    public void setCzas_wykonania(int czas_wykonania) {
        this.czas_wykonania = czas_wykonania;
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

    public double getCena_podstawowa() {
        return cena_podstawowa;
    }

    public void setCena_podstawowa(double cena_podstawowa) {
        this.cena_podstawowa = cena_podstawowa;
    }



    public void addMaterialy(Material material)
    {
        this.materialy.add(material);
        material.getMaskotki().add(this);
    }

    public void removeMaterialy(Material material)
    {
        this.materialy.remove(material);
        material.getMaskotki().remove(material);
    }

}
