package pl.szydelkowestwory.szydelkoweStwory.model;

import java.util.ArrayList;
import java.util.List;

public class FormularzMaskotka {

    String nazwa;
    double cena_podstawowa;
    int czas_wykonania;
    long materialId;
    List<Material> listaMaterialow;

    public FormularzMaskotka() {
        listaMaterialow = new ArrayList<Material>();
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

    public int getCzas_wykonania() {
        return czas_wykonania;
    }

    public void setCzas_wykonania(int czas_wykonania) {
        this.czas_wykonania = czas_wykonania;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public List<Material> getListaMaterialow() {
        return listaMaterialow;
    }

    public void setListaMaterialow(List<Material> listaMaterialow) {
        this.listaMaterialow = listaMaterialow;
    }
}
