package pl.szydelkowestwory.szydelkoweStwory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormularzZamowienia {


    String data_zamowienia;
    String termin_realizacji;
    String uwagi;
    double cena;
    TypOdbioru typOdbioru;
    boolean zrealizowane;
    long klientId;
    long maskotkaId;
    List<Maskotka> listaMaskotek;
    List<Klient> listaKlientow;


    public FormularzZamowienia() {
        listaKlientow = new ArrayList<Klient>();
        listaMaskotek = new ArrayList<Maskotka>();
    }

    public String getTermin_realizacji() {
        return termin_realizacji;
    }

    public void setTermin_realizacji(String termin_realizacji) {
        this.termin_realizacji = termin_realizacji;
    }

    public String getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(String data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
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

    public boolean isZrealizowane() {
        return zrealizowane;
    }

    public void setZrealizowane(boolean zrealizowane) {
        this.zrealizowane = zrealizowane;
    }

    public long getKlientId() {
        return klientId;
    }

    public void setKlientId(long klientId) {
        this.klientId = klientId;
    }

    public long getMaskotkaId() {
        return maskotkaId;
    }

    public void setMaskotkaId(long maskotkaId) {
        this.maskotkaId = maskotkaId;
    }

    public List<Maskotka> getListaMaskotek() {
        return listaMaskotek;
    }

    public void setListaMaskotek(List<Maskotka> listaMaskotek) {
        this.listaMaskotek = listaMaskotek;
    }

    public List<Klient> getListaKlientow() {
        return listaKlientow;
    }

    public void setListaKlientow(List<Klient> listaKlientow) {
        this.listaKlientow = listaKlientow;
    }
}
