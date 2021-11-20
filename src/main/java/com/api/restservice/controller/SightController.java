package com.api.restservice.controller;

import java.util.List;

import com.api.restservice.model.Image;
import com.api.restservice.model.Sight;
import com.api.restservice.repository.ImageRepository;
import com.api.restservice.repository.SightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api")
public class SightController {

    @Autowired
    SightRepository sightRepository;

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("sight")
    public ResponseEntity<List<Sight>> getSights(@RequestParam(required = false) String title, @RequestParam(required = false) String relevance) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("sight/{id}")
    public ResponseEntity<Sight> getSight(@PathVariable(name = "id") long id){
        boolean exist = sightRepository.existsById(id);

        if(exist){
            Sight sight = sightRepository.getById(id);

            return new ResponseEntity<>(sight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

    @PostMapping("sight")
    public ResponseEntity<Sight> createSight(@RequestBody Sight sight) {
		try {
            Sight tempSight = new Sight(sight.getName(), sight.getDesciption(), sight.getActive(), sight.getRelevance(), sight.getLangitude(), sight.getLongitude());

            for(Image image : sight.getImages()){
                tempSight.addImage(new Image(image.getUrl()));
            }

			Sight createdSight = sightRepository.save(tempSight);
            
			return new ResponseEntity<>(createdSight, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("sight/{id}")
    public ResponseEntity<Sight> updateSight(@PathVariable long id, @RequestBody Sight sightParam) {
        boolean exist = sightRepository.existsById(id);

        if(exist){
            Sight tempSight = sightRepository.getById(id);
            tempSight.setName(sightParam.getName());
            tempSight.setDesciption(sightParam.getDesciption());
            tempSight.setActive(sightParam.getActive());
            tempSight.setLangitude(sightParam.getLangitude());
            tempSight.setLongitude(sightParam.getLongitude());

            tempSight.getImages().clear();

            for(Image image: sightParam.getImages()){
                tempSight.addImage(new Image(image.getUrl()));
            }

            return new ResponseEntity<>(sightRepository.save(tempSight), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("sight/{id}")
    public ResponseEntity<HttpStatus> deleteSight(@PathVariable(name = "id") long id){
        try {
            sightRepository.deleteById(id);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
