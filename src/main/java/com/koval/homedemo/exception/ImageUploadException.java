package com.koval.homedemo.exception;

import java.io.IOException;

public class ImageUploadException extends RuntimeException {

    public ImageUploadException(String errorUploadingImageToS3, IOException e) {
    }
}
