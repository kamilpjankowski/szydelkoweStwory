package pl.szydelkowestwory.szydelkoweStwory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydelkowestwory.szydelkoweStwory.DAO.MaskotkaDAO;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;
import pl.szydelkowestwory.szydelkoweStwory.model.Maskotka;

import java.util.List;

@Service
public class MaskotkaService {

    @Autowired
    MaskotkaDAO maskotkaDAO;

    public List<Maskotka> getAllMascots()
    {
        return maskotkaDAO.findAll();
    }
    public void saveMascot(Maskotka maskotka) { maskotkaDAO.save(maskotka); }
    public void deleteMascot(Long id) { maskotkaDAO.deleteById(id);}
    public Maskotka findMascot(Long id) {return maskotkaDAO.findById(id).get();}
}
