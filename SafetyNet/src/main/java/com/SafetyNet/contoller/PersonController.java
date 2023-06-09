package com.SafetyNet.contoller;

import com.SafetyNet.DTO.*;
import com.SafetyNet.model.Person;
import com.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    //traitement des CRUD
    @PostMapping(value = "/person")
    public void addPerson(@RequestBody Person person)  {

        personService.addPerson(person);
    }

    //
    @PutMapping(value = "/person")
    public void mettreAjourPerson(@RequestBody Person person) {
        personService.update(person);
    }

    @DeleteMapping(value = "/person")
    public void supprimerPerson(@RequestBody Person person) {
        personService.deletePerson(person);


    }

    @GetMapping(value = "/allPersons")
    public List<Person> findAllPersons() {

        return personService.fibdAllPersons();
    }

    @GetMapping(value = "/allMails")
    public List<String> findAllMail() {

        return personService.findAllMails();
    }
//traitement des requettes  complexe


    //cette method retourne info dhabitant par rapport à son station num
    @GetMapping(value = "firestation/stationNumber={station_number}")
    public InfoHabitantStationDTO infoHabitantStation(@PathVariable Integer station_number) {
        return personService.infoHabitantStation(station_number);
    }

    //cette method retourne des enfants et leur info par rapport à leur adress et etourne une liste des personne de meme foyer
    @GetMapping(value = "childAlert/adress={adrs}")
    public List<EnfantDTO> enfantList(@PathVariable String adrs) throws ParseException {
        return personService.enfantList(adrs);
    }


    @GetMapping(value = "phoneAlert/firestation={fnbr}")
    public List<String> phoneAlertNumber(@PathVariable String fnbr) {
        return personService.phoneAlert(fnbr);
    }

    @GetMapping(value = "fire/adress={adss}")
    public List<InfoHabitantDTO> infoHabitant(@PathVariable String adss) throws ParseException {
        return personService.infoHabitant(adss);
    }


    @GetMapping(value = "flood/stations={stationNumber}")
    public List<FoyerDTO> getListDtoFlood(@PathVariable List<Integer> stationNumber) throws ParseException {
        return personService.getListDtoFlood(stationNumber);
    }

    @GetMapping(value = "personInfo/firstName={firstName}/lastName={lastName}")
    public List<InfoPersonDTO> personInfo(@PathVariable String firstName, @PathVariable String lastName) throws ParseException {
        return personService.personInfo(firstName, lastName);
    }

    @GetMapping(value = "/allMails/{city}")
    public List<String> findAllMailcity(@PathVariable String city) {

        return personService.findAllMailscity(city);
    }


}
