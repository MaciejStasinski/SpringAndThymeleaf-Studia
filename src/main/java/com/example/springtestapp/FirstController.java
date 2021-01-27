package com.example.springtestapp;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FirstController {

    @RequestMapping("/")
    public String index() {
        return "Działający serwer";
    }

    @RequestMapping("/tajne")
    public String tajne() {
        return "Tajny adres";
    }

    @RequestMapping("/lista")
    public List<String> lista() {
        List<String> kolekcja = new ArrayList<>();
        kolekcja.add("element 1");
        kolekcja.add("element 2");
        kolekcja.add("element 3");
        kolekcja.add("element 4");
        return kolekcja;
    }

    @GetMapping(value = "/{path1}/{jakieśID}")
    public String PrzykładZPath(@PathVariable String path1, @PathVariable Long jakieśID) throws Exception {
        return "Z adresu pozyskałem następujące dane: zasob1=" + path1 + " przekazana liczba to:" + jakieśID;
    }

    @GetMapping(value = "/{path1}/{jakieśID1}/{path2}/{jakieśID2}")
    public String PrzykładZPath2(@PathVariable String path1, @PathVariable Long jakieśID1, @PathVariable String path2, @PathVariable Long jakieśID2) throws Exception {
        return "Z adresu pozyskałem następujące dane: zasob1= " + path1 + " przekazana liczba to: " + jakieśID1 + " zasób2= " + path2 + " liczba2= " + jakieśID2;
    }

    @GetMapping(value = "/{liczba1}/{liczba2}/{działanie}")
    public int kalkulator(@PathVariable int liczba1, @PathVariable int liczba2, @PathVariable String działanie) throws Exception {
        if (działanie.equals("dodawanie")) return liczba1 + liczba2;
        if (działanie.equals("odejmowanie")) return liczba1 - liczba2;
        if (działanie.equals("dzielenie")) return liczba1 / liczba2;
        if (działanie.equals("mnożenie")) return liczba1 * liczba2;
        else {
            return 0;
        }
    }

    @RequestMapping("/RequestHeader")
    @ResponseBody
    public String ExampleRequestHeader(@RequestHeader("User-Agent") String klient,
                                       @RequestHeader("Accept-Language") String lang,
                                       @RequestHeader("Cookie") String cookie,
                                       @RequestHeader("Host") String host) throws Exception {
//        return "klient: " + klient +
//                "\nlanguage: "+lang+
//                "\nCookie: "+cookie+
//                "\nHost: "+host;
        return " <b>Przeglądarka/ klient HTTP:</b><br> " + klient
                +"<br><br> <b>Język:</b><br> " + lang
                +" <br><br><b>Cookie:</b><br> " + cookie
                +"<br><br><b>Host:</b><br> " + host
                ;
    }

//    @RequestMapping("/RequestParam")
//    public String  ExampleRequestParam( @RequestParam(value = "imie",required = false) String imie,
//                                        @RequestParam(value = "miasto",required = false) String miasto) throws Exception {
//        return "Witaj " + imie+" mieszkasz w mieście: "+miasto;
//    }

//    @RequestMapping("/RequestParam")
//    public String  ExampleRequestParam( @RequestParam("imie") String imie,
//                                        @RequestParam(value = "miasto",required = false) String miasto) throws Exception {
//        String opis="";
//        if (miasto!=null)
//            opis = ". Mieszkasz w mieście:" + miasto;
//            return "Witaj " + imie + opis;
//    }

    @RequestMapping("/RequestParam")
    public String  ExampleRequestParam( @RequestParam("imie") String imie,
                                        @RequestParam("nazwisko") String nazwisko,
                                        @RequestParam("pesel") String pesel,
                                        @RequestParam(value = "e-mail",required = false) String email,
                                        @RequestParam(value = "telefon",required = false) String telefon
                                        ) throws Exception {
        String mail="";
        if (email !=null)
             mail= "<br><br><b>e-mail:</b><br> " + email;
        String tel="";
        if (telefon !=null)
             tel= "<br><br><b>telefon:</b><br> " + telefon;

        return " <b>imię:</b><br> " + imie
                +"<br><br> <b>nazwisko:</b><br> " + nazwisko
                +" <br><br><b>pesel:</b><br> " + pesel
//                + "<br><br><b>e-mail:</b><br> " + Optional.ofNullable(email).orElse("")
//                + "<br><br><b>telefon:</b><br> "+ Optional.ofNullable(telefon).orElse("")
                + mail + tel;
    }




}
