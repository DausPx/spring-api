package com.api.restservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sights")
public class Sight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean active;

    @Column
    private String relevance;

    @Column
    private String langitude;

    @Column
    private String longitude;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<Image>();

    public Sight(){

    }

    public Sight(String name, String description, boolean active, String relevance, String langitude, String longitude){
        this.name = name;
        this.description = description;
        this.active = active;
        this.relevance = relevance;
        this.langitude = langitude;
        this.longitude = longitude;
    }

    public Sight(String name, String description, boolean active, String relevance, String langitude, String longitude, List<Image> images){
        this.name = name;
        this.description = description;
        this.active = active;
        this.relevance = relevance;
        this.langitude = langitude;
        this.longitude = longitude;
        this.images = images;
    }

    public void addImage(Image image){
        this.images.add(image);
        image.setSight(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public String getLangitude() {
        return langitude;
    }

    public void setLangitude(String langitude) {
        this.langitude = langitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
