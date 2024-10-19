package Uber.controllers;

import Uber.database.CabsManager;
import Uber.database.TripManager;
import Uber.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Uber.model.Cab;
import Uber.model.Trip;

@RestController
public class CabsController {

    private CabsManager cabsManager;
    private TripManager tripManager;

    public CabsController(CabsManager cabsManager,TripManager tripManager){
        this.cabsManager =cabsManager;
        this.tripManager =tripManager;
    }

    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    public ResponseEntity registerCab(final String cabId, final String driverName){
        cabsManager.createCab(new Cab(cabId,driverName));
        return ResponseEntity.ok("");
    }
    @RequestMapping(value = "/update/cab/location", method = RequestMethod.POST)
    public ResponseEntity updateCabLocation(
            final String cabId, final Double newX, final Double newY) {

        cabsManager.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/availability", method = RequestMethod.POST)
    public ResponseEntity updateCabAvailability(final String cabId, final Boolean newAvailability) {
        cabsManager.updateCabAvailablity(cabId, newAvailability);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/end/trip", method = RequestMethod.POST)
    public ResponseEntity endTrip(final String cabId) {
        tripManager.endTrip(cabsManager.getCab(cabId));
        return ResponseEntity.ok("");
    }

}
