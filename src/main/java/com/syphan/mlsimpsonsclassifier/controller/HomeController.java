package com.syphan.mlsimpsonsclassifier.controller;

import com.syphan.mlsimpsonsclassifier.model.ExtractDataDto;
import com.syphan.mlsimpsonsclassifier.service.dataextraction.IDataExtractionService;
import com.syphan.mlsimpsonsclassifier.service.imageclassifier.IImageClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class HomeController {

    private final IDataExtractionService dataExtractionService;
    private final IImageClassifierService imageClassifierService;

    @Autowired
    public HomeController(
            IDataExtractionService dataExtractionService,
            IImageClassifierService imageClassifierService
    ) {
        this.dataExtractionService = dataExtractionService;
        this.imageClassifierService = imageClassifierService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("route", "home");
        return "home/home";
    }

    @PostMapping("/upload")
    public ResponseEntity<ExtractDataDto> handleUploadedImage(@RequestParam("file") MultipartFile file) {
        try {
            float[] characteristics = dataExtractionService.getImageData(file);
            String character = imageClassifierService.classifyNaiveBayes(characteristics);
            return ResponseEntity.ok(new ExtractDataDto(characteristics, character));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
