package com.syphan.mlsimpsonsclassifier.service.dataextraction;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDataExtractionService {

    float[] getImageData(MultipartFile file) throws IOException;
}
