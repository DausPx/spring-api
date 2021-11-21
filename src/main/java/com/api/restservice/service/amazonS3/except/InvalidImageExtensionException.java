package com.api.restservice.service.amazonS3.except;

import java.util.List;

public class InvalidImageExtensionException extends RuntimeException {

    List<String> validExtensions;

    public InvalidImageExtensionException(List<String> validExtensions) {
        this.validExtensions = validExtensions;
    }

    public List<String> getValidExtensions() {
        return validExtensions;
    }
}