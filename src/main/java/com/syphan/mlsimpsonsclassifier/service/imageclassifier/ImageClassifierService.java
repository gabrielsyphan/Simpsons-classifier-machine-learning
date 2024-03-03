package com.syphan.mlsimpsonsclassifier.service.imageclassifier;

import org.springframework.stereotype.Service;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class ImageClassifierService implements IImageClassifierService {

    private Instances instances;

    public ImageClassifierService() {
        try {
            DataSource source = new DataSource("characteristics.arff");
            instances = source.getDataSet();
            instances.setClassIndex(instances.numAttributes() - 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String classifyNaiveBayes(float[] characteristics) throws Exception {
        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.buildClassifier(instances);

        Instance imageToClassify = new DenseInstance(instances.numAttributes());
        imageToClassify.setDataset(instances);
        for (int i = 0; i < characteristics.length; i++) {
            imageToClassify.setValue(i, characteristics[i]);
        }

        double[] result = naiveBayes.distributionForInstance(imageToClassify);
        return (result[0] > result[1] ? "Bart" : "Homer");
    }
}
