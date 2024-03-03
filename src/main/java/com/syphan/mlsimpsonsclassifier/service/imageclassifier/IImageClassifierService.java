package com.syphan.mlsimpsonsclassifier.service.imageclassifier;

public interface IImageClassifierService {

    String classifyNaiveBayes(float[] characteristics) throws Exception;
}
