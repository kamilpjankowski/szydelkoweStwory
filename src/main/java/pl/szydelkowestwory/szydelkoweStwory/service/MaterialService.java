package pl.szydelkowestwory.szydelkoweStwory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydelkowestwory.szydelkoweStwory.DAO.MaterialDAO;
import pl.szydelkowestwory.szydelkoweStwory.model.Maskotka;
import pl.szydelkowestwory.szydelkoweStwory.model.Material;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialDAO materialDAO;

    public List<Material> getAllMaterials()
    {
        return materialDAO.findAll();
    }
    public void saveMaterial(Material material) { materialDAO.save(material); }
    public void deleteMaterial(Long id) { materialDAO.deleteById(id);}
    public Material findMaterial(Long id) {return materialDAO.findById(id).get();}
}
