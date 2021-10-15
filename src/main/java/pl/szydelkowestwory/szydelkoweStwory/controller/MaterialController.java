package pl.szydelkowestwory.szydelkoweStwory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;
import pl.szydelkowestwory.szydelkoweStwory.model.Material;
import pl.szydelkowestwory.szydelkoweStwory.service.MaterialService;

import java.util.List;

@Controller
public class MaterialController {

    MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @RequestMapping("/addNewMaterial")
    public String addMaterial(Model model)
    {
        Material material = new Material();
        model.addAttribute("material",material);
        return "add_new_material"; //HTML
    }

    @PostMapping(value = "/saveMaterial")
    public String addMaterialToList(Material material)
    {
        materialService.saveMaterial(material);

        return "redirect:/allMaterials";
    }
    @GetMapping("/allMaterials")
    public String allMaterials(Model model)
    {
        List<Material> allMaterials = materialService.getAllMaterials();
        model.addAttribute("allMaterials", allMaterials);
        return "materials_list";
    }

    @GetMapping("/editMaterial/{id}")
    public ModelAndView editMaterial(@PathVariable(name = "id") Long id)
    {

        ModelAndView mav = new ModelAndView("edit_material");
        Material material = materialService.findMaterial(id);
        mav.addObject("material", material);
        return mav;
    }

    @RequestMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable(name="id") Long id)
    {
        materialService.deleteMaterial(id);
        return "redirect:/allMaterials";
    }
}
