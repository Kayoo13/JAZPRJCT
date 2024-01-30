package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.util.Optional;

@Controller
public class WebController {
    private MyRestService myRestService;
    @Autowired
    public WebController(MyRestService carService) {
        this.myRestService = carService;

    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/drivers")
    public String all(Model model) {
        model.addAttribute("drivers",myRestService.getAllDrivers());
        return "drivers";
    }

    @GetMapping("/byName")
    public String byName() {
        return "byName";
    }

   @GetMapping("/driverByName")
   public String getDriverByName(@RequestParam String name, Model model) {
       model.addAttribute("NamedDrivers",myRestService.getDriverByName(name));
       return "driverByName";
    }

    @GetMapping("/byId")
    public String byId() {
        return "byId";
    }

    @GetMapping("/driverById")
    public String getDriverById(@RequestParam Long id, Model model) {
        model.addAttribute("IdDriver", myRestService.getDriverById(id));
        return "driverById";
    }

    @GetMapping("/addToDb")
    public String addDb() {
        return "addToDb";
    }

    @PutMapping("/addDriver")
    public String addDriver(@RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries, Model model) {
        DriverDTO driver = myRestService.addDriver(name, dateOfBirth, team, racingSeries);
        model.addAttribute("AddedDriver", driver);
        return "addDriver";
    }

    @GetMapping("/deleteFromDb")
    public String deleteFromDb() {
        return "deleteFromDb";
    }

    @PostMapping("/deleteDriver")
    public String deleteDriver(@RequestParam Long id, Model model) {
        myRestService.deleteDriver(id);
        model.addAttribute("DeletedDriverId", id);
        return "deleteDriver";
    }

    @PostMapping("/updateDriver")
    public String updateDriver(@RequestParam Long id, @RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries, Model model) {
        myRestService.updateDriver(id, name, dateOfBirth, team, racingSeries);
        model.addAttribute("UpdatedDriverId", id);
        return "updateDriver"; //redirect to drivers
    }


}
