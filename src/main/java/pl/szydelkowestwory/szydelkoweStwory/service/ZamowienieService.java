package pl.szydelkowestwory.szydelkoweStwory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydelkowestwory.szydelkoweStwory.DAO.ZamowienieDAO;
import pl.szydelkowestwory.szydelkoweStwory.model.Maskotka;
import pl.szydelkowestwory.szydelkoweStwory.model.Zamowienie;

import java.util.List;

@Service
public class ZamowienieService {

    @Autowired
    ZamowienieDAO zamowienieDAO;

    public List<Zamowienie> getAllOrders()
    {
        return zamowienieDAO.findAll();
    }
    public void saveOrder(Zamowienie zamowienie) { zamowienieDAO.save(zamowienie); }
    public void deleteOrder(Long id) { zamowienieDAO.deleteById(id);}
    public Zamowienie findOrder(Long id) {return zamowienieDAO.findById(id).get();}
}
