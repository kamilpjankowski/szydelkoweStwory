package pl.szydelkowestwory.szydelkoweStwory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;
import pl.szydelkowestwory.szydelkoweStwory.service.KlientService;

import java.util.List;

@Controller
public class KlientController {

    KlientService klientService;

    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @RequestMapping("/addNewClient")
    public String addClient(Model model)
    {
        Klient klient = new Klient();
        model.addAttribute("klient",klient);
        return "add_new_client"; //HTML
    }

    @PostMapping(value = "/saveClient")
    public String addClientToList(Klient klient)
    {
        klientService.saveClient(klient);

        return "redirect:/allClients";
    }
    @GetMapping("/allClients")
    public String allClients(Model model)
    {
        List<Klient> allClients = klientService.getAllClients();
        model.addAttribute("allClients", allClients);
        return "clients_list";
    }

    @GetMapping("/editClient/{id}")
    public ModelAndView editClient(@PathVariable(name = "id") Long id)
    {

        ModelAndView mav = new ModelAndView("edit_client");
        Klient klient = klientService.findClient(id);
        mav.addObject("client", klient);
        return mav;
    }

    @RequestMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(name="id") Long id)
    {
        klientService.deleteClient(id);
        return "redirect:/allClients";


    }
}
