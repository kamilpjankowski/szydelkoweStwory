package pl.szydelkowestwory.szydelkoweStwory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.szydelkowestwory.szydelkoweStwory.model.FormularzMaskotka;
import pl.szydelkowestwory.szydelkoweStwory.model.FormularzZamowienia;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;
import pl.szydelkowestwory.szydelkoweStwory.model.Maskotka;
import pl.szydelkowestwory.szydelkoweStwory.service.MaskotkaService;
import pl.szydelkowestwory.szydelkoweStwory.service.MaterialService;

import java.util.List;

@Controller
public class MaskotkaController {

    MaskotkaService maskotkaService;
    MaterialService materialService;

    @Autowired
    public MaskotkaController(MaskotkaService maskotkaService, MaterialService materialService) {
        this.maskotkaService = maskotkaService;
        this.materialService = materialService;
    }


//    @RequestMapping("/addNewMascot")
//    public String addMascot(Model model)
//    {
//        Maskotka maskotka = new Maskotka();
//        model.addAttribute("mascot",maskotka);
//        return "add_new_mascot"; //HTML
//    }

    @GetMapping("/addnewMascot")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    public String newOrder(Model model) {
        FormularzMaskotka formularzMaskotka = new FormularzMaskotka();
        formularzMaskotka.setListaMaterialow(materialService.getAllMaterials());
        model.addAttribute("newMascot", formularzMaskotka);
        return "add_new_mascot";
    }

    @PostMapping(value = "/saveMascot")
    public String addMascotToList(Maskotka maskotka)
    {
        maskotkaService.saveMascot(maskotka);

        return "redirect:/allMascots";
    }
    @GetMapping("/allMascots")
    public String allMascots(Model model)
    {
        List<Maskotka> allMasccots = maskotkaService.getAllMascots();
        model.addAttribute("allMascots", allMasccots);
        return "mascots_list";
    }

    @GetMapping("/editMascot/{id}")
    public ModelAndView editMascot(@PathVariable(name = "id") Long id)
    {

        ModelAndView mav = new ModelAndView("edit_mascot");
        Maskotka maskotka = maskotkaService.findMascot(id);
        mav.addObject("mascot", maskotka);
        return mav;
    }

    @RequestMapping("/deleteMascot/{id}")
    public String deleteMascot(@PathVariable(name="id") Long id)
    {
        maskotkaService.deleteMascot(id);
        return "redirect:/allMascots";
    }
}
