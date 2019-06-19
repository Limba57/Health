package Sebastien.Controller;

import Sebastien.Entity.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public Status sendStatus() {
        return new Status();
    }


}
