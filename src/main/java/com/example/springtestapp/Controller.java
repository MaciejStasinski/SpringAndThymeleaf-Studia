package com.example.springtestapp;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/szablon")
    public String hello() {
        return "StronaWidok";
    }
}

@org.springframework.stereotype.Controller
class KolejnyController2 {
    @RequestMapping("/parametr")
    public String hello(Model model) {
        model.addAttribute("danzeZKontrolera", "Tekst jest parametrem (atrybutem), nie ma go w widoku");
        return "PrzekazywanieParametrow";
    }
}

@org.springframework.stereotype.Controller
class KolejnyController3 {
    @RequestMapping("/obiekt")
    public Object hello3(Model model) {
        Osoba osoba1 = new Osoba(1, "Jan", "Kowalski", "600-123-456", "przykladowy@mail.com");
        Osoba osoba2 = new Osoba(2, "Anna", "Nowak", "600-987-654", "anna@mail.com");
        model.addAttribute("osoba1", osoba1);
        model.addAttribute("osoba2", osoba2);
        return "obiektOsoba";
    }
}

@org.springframework.stereotype.Controller
class Formularz {
    @RequestMapping("/formularz")
    public Object hello3(Model model) {
        Osoba osoba3 = new Osoba(2, "Henryk", "Sienkiewicz", "123-456-789", "henryk@mail.pl");
        model.addAttribute("osoba3", osoba3);
        return "formularz";
    }
}





