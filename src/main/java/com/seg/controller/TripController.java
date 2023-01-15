package com.seg.controller;

import com.seg.model.Trip;
import com.seg.repository.TripRepository;
import com.seg.service.TripService;
import com.seg.service.impl.TripServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {


    private TripService tripService;

    @Autowired
    public TripController( TripServiceImpl tripService) {
        this.tripService= tripService;
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable long id) throws Exception{
        return tripService.getTripById(id);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody Trip trip) throws Exception {
        return tripService.saveTrip(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable long id,@Valid @RequestBody Trip newTrip)throws Exception {
        return tripService.updateTrip(id, newTrip);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteTripById(@RequestBody Trip trip) {
        return tripService.deleteTrip(trip);
    }



//    @DeleteMapping("/trips")
//    public ResponseEntity<HttpStatus> deleteAllTrips() {
//       return tripService.deleteAllTrips();
//    }
}
