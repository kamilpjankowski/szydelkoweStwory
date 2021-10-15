package pl.szydelkowestwory.szydelkoweStwory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.szydelkowestwory.szydelkoweStwory.model.FormularzZamowienia;
import pl.szydelkowestwory.szydelkoweStwory.model.Material;
import pl.szydelkowestwory.szydelkoweStwory.model.Zamowienie;
import pl.szydelkowestwory.szydelkoweStwory.service.KlientService;
import pl.szydelkowestwory.szydelkoweStwory.service.MaskotkaService;
import pl.szydelkowestwory.szydelkoweStwory.service.ZamowienieService;

import java.util.List;

@Controller
public class ZamowienieController {

    ZamowienieService zamowienieService;
    KlientService klientService;
    MaskotkaService maskotkaService;

    @Autowired
    public ZamowienieController(ZamowienieService zamowienieService, KlientService klientService, MaskotkaService maskotkaService) {
        this.zamowienieService = zamowienieService;
        this.klientService = klientService;
        this.maskotkaService = maskotkaService;
    }

    @GetMapping("/allOrders")
    public String allOrders(Model model)
    {
        List<Zamowienie> allOrders = zamowienieService.getAllOrders();
        //List<Rezerwacja> collect = listaRezerwacji.stream().filter(r -> r.getSamochod() != null).collect(Collectors.toList());
        model.addAttribute("allOrders", allOrders);
        return "orders_list";
    }
    @GetMapping("/newOrder")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    public String newOrder(Model model) {
        FormularzZamowienia formularzZamowienia = new FormularzZamowienia();

        formularzZamowienia.setListaKlientow(klientService.getAllClients());
        formularzZamowienia.setListaMaskotek(maskotkaService.getAllMascots());
        model.addAttribute("newOrder", formularzZamowienia);
        return "add_new_order";
    }

    @PostMapping("/saveOrder")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    public String saveOrder(FormularzZamowienia formularzZamowienia)
    {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setData_zamowienia(formularzZamowienia.getData_zamowienia());
        zamowienie.setTermin_realizacji(formularzZamowienia.getTermin_realizacji());
        zamowienie.setCena(formularzZamowienia.getCena());
        zamowienie.setKlient(klientService.findClient(formularzZamowienia.getKlientId()));
        zamowienie.setMaskotka(maskotkaService.findMascot(formularzZamowienia.getMaskotkaId()));
        zamowienie.setUwagi(formularzZamowienia.getUwagi());
        zamowienie.setTypOdbioru(formularzZamowienia.getTypOdbioru());
        zamowienie.setZrealizowane(formularzZamowienia.isZrealizowane());
        zamowienieService.saveOrder(zamowienie);
        return "redirect:/allOrders";
    }

    @RequestMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable(name="id") Long id)
    {
        zamowienieService.deleteOrder(id);
        return "redirect:/allOrders";
    }

}
