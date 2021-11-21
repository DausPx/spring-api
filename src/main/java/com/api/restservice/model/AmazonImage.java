package com.api.restservice.model;

public class AmazonImage {
    private String amazonUserImageId;

    private String imageUrl;

    public String getAmazonUserImageId() {
        return amazonUserImageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setAmazonUserImageId(String amazonUserImageId) {
        this.amazonUserImageId = amazonUserImageId;
    }
}
