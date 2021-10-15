package pl.szydelkowestwory.szydelkoweStwory.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zamowienie")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    String data_zamowienia;
    String termin_realizacji;
    String uwagi;
    double cena;
    TypOdbioru typOdbioru;
    boolean zrealizowane;

    @OneToOne
    @JoinColumn(name = "id_klient")
    Klient klient;

    @OneToOne
    @JoinColumn(name = "id_maskotka")
    Maskotka maskotka;




    public Zamowienie() {
    }

    public Zamowienie(String uwagi, double cena, TypOdbioru typOdbioru, Klient klient, Maskotka maskotka) {
        this.uwagi = uwagi;
        this.cena = cena;
        this.typOdbioru = typOdbioru;
        this.klient = klient;
        this.maskotka = maskotka;
        this.zrealizowane = false;
    }

    public String getTermin_realizacji() {
        return termin_realizacji;
    }

    public void setTermin_realizacji(String termin_realizacji) {
        this.termin_realizacji = termin_realizacji;
    }

    public boolean isZrealizowane() {
        return zrealizowane;
    }

    public void setZrealizowane(boolean zrealizowane) {
        this.zrealizowane = zrealizowane;
    }

    public String getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(String data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public TypOdbioru getTypOdbioru() {
        return typOdbioru;
    }

    public void setTypOdbioru(TypOdbioru typOdbioru) {
        this.typOdbioru = typOdbioru;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Maskotka getMaskotka() {
        return maskotka;
    }

    public void setMaskotka(Maskotka maskotka) {
        this.maskotka = maskotka;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                ", data_zamowienia=" + data_zamowienia +
                ", uwagi='" + uwagi + '\'' +
                ", cena=" + cena +
                ", typOdbioru=" + typOdbioru +
                ", zrealizowane=" + zrealizowane +
                ", klient=" + klient +
                ", maskotka=" + maskotka +
                '}';
    }

}
