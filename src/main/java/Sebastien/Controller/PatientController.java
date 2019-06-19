package Sebastien.Controller;

import Sebastien.Entity.Patient;
import Sebastien.Entity.Score;
import Sebastien.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public Score sendScore(@RequestParam(value = "firstname") String firstname,
                           @RequestParam(value = "lastname") String lastname,
                           @RequestParam(value = "birthdate") String sBirthdate){

        Date birthdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

       try {
            birthdate = sdf.parse(sBirthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Patient patient = new Patient(firstname, lastname,birthdate);
        Score score = new Score(patient);

        patient.setScore(score);
        score.setPatient(patient);
        patientRepository.save(patient);

        return patient.getScore();
    }

    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public List<Patient> requests(@RequestParam(value = "query") String query) {

        return patientRepository.find(query);

    }


}
