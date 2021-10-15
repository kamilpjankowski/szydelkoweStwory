package pl.szydelkowestwory.szydelkoweStwory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydelkowestwory.szydelkoweStwory.DAO.KlientDAO;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;

import java.util.List;

@Service
public class KlientService {

    @Autowired
    private KlientDAO klientDAO;


    public List<Klient> getAllClients() { return klientDAO.findAll(); }
    public void saveClient(Klient klient) { klientDAO.save(klient); }
    public void deleteClient(Long id) { klientDAO.deleteById(id);}
    public Klient findClient(Long id) {return klientDAO.findById(id).get();}
}
