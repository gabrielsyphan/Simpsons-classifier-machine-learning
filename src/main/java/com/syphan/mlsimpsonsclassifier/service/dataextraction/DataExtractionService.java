package com.syphan.mlsimpsonsclassifier.service.dataextraction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.bytedeco.javacpp.indexer.UByteIndexer;
import org.bytedeco.javacpp.indexer.UByteRawIndexer;
import static org.bytedeco.opencv.global.opencv_core.CV_8UC;
import org.bytedeco.opencv.opencv_core.Mat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DataExtractionService implements IDataExtractionService {

    @Override
    public float[] getImageData(MultipartFile file) throws IOException {
        float orangeShirtBart = 0, blueShortBart = 0, blueShoesBart = 0;
        float bluePantsHomer = 0, brownMounthHomer = 0, grayHomerShoes = 0;
        double red, green, blue;
        float[] characteristics = new float[6];

        BufferedImage buffer = ImageIO.read(file.getInputStream());
        Mat image = bufferedImageToMat(buffer);

        UByteIndexer imgIndexer = image.createIndexer();

        for (int altura = 0; altura < imgIndexer.rows(); altura++) {
            for (int largura = 0; largura < imgIndexer.cols(); largura++) {

                // Extract the RGB of each pixel of the image
                int[] pixel = new int[3];
                imgIndexer.get(altura, largura, pixel);
                blue = pixel[0];
                green = pixel[1];
                red = pixel[2];

                // Orange Bart shirt
                if (blue >= 11 && blue <= 22
                        && green >= 85 && green <= 105
                        && red >= 240 && red <= 255) {

                    // Increment the amount of orange pixels
                    orangeShirtBart++;                }

                // Bart's blue shorts (bottom half of the image)
                if (altura > (image.rows() / 2)) {
                    if (blue >= 125 && blue <= 170
                            && green >= 0 && green <= 12
                            && red >= 0 && red <= 20) {

                        blueShortBart++;
                    }
                }

                // Bart's shoe (bottom of the image)
                if (altura > (image.rows() / 2) + (image.rows() / 3)) {
                    if (blue >= 125 && blue <= 140
                            && green >= 3 && green <= 12
                            && red >= 0 && red <= 20) {

                        blueShoesBart++;
                    }
                }

                // Homer's blue pants
                if (blue >= 150 && blue <= 180
                        && green >= 98 && green <= 120
                        && red >= 0 && red <= 90) {

                    bluePantsHomer++;
                }

                // Homer's mouth (a little more than half of the image)
                if (altura < (image.rows() / 2) + (image.rows() / 3)) {
                    if (blue >= 95 && blue <= 140
                            && green >= 160 && green <= 185
                            && red >= 175 && red <= 200) {
                        brownMounthHomer++;
                    }
                }

                // Homer's shoe (bottom of the image)
                if (altura > (image.rows() / 2) + (image.rows() / 3)) {
                    if (blue >= 25 && blue <= 45 && green >= 25
                            && green <= 45 && red >= 25 && red <= 45) {

                        grayHomerShoes++;
                    }
                }
            }
        }

        // Calculate the percentage of each characteristic
        orangeShirtBart = (orangeShirtBart / (image.rows() * image.cols())) * 100;
        blueShortBart = (blueShortBart / (image.rows() * image.cols())) * 100;
        blueShoesBart = (blueShoesBart / (image.rows() * image.cols())) * 100;
        bluePantsHomer = (bluePantsHomer / (image.rows() * image.cols())) * 100;
        brownMounthHomer = (brownMounthHomer / (image.rows() * image.cols())) * 100;
        grayHomerShoes = (grayHomerShoes / (image.rows() * image.cols())) * 100;

        // Save the characteristics in the characteristics array
        characteristics[0] = orangeShirtBart;
        characteristics[1] = blueShoesBart;
        characteristics[2] = blueShortBart;
        characteristics[3] = bluePantsHomer;
        characteristics[4] = brownMounthHomer;
        characteristics[5] = grayHomerShoes;

        return characteristics;
    }

    private Mat bufferedImageToMat(BufferedImage bi) {
        Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CV_8UC(3));

        int r, g, b;
        UByteRawIndexer indexer = mat.createIndexer();
        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int rgb = bi.getRGB(x, y);

                r = (byte) ((rgb >> 0) & 0xFF);
                g = (byte) ((rgb >> 8) & 0xFF);
                b = (byte) ((rgb >> 16) & 0xFF);

                indexer.put(y, x, 0, r);
                indexer.put(y, x, 1, g);
                indexer.put(y, x, 2, b);
            }
        }
        indexer.release();
        return mat;
    }
}
