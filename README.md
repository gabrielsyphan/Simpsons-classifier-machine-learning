## Overview
The software system provides capabilities for classifying images of characters from the television show The Simpsons. Users interact through a web interface built with Spring MVC and Thymeleaf templates. On the homepage, they can upload an image depicting a Simpsons character via a file upload form.
Once submitted, the image is passed to a back-end service that leverages computer vision techniques to extract numeric characteristics. This process analyzes the pixel contents, detecting colors and objects to produce a characteristic vector encapsulating the image’s visual profile. For example, it may detect the percentages of orange, blue, and grey pixels corresponding to clothing articles.
The numeric characteristics are then fed into a pre-trained Naive Bayes machine learning model. This model has been optimized through training data to classify images based on visual characteristics. It analyzes the input vector and outputs a probability distribution indicating which Simpsons character the image most likely depicts. The character with the highest probability is returned and displayed to the user along with the extracted characteristics.
The application is built on Spring Boot, which handles configuration and launching the web server. This allows rapid development of the machine learning capabilities into a production-ready web application. Through this intuitive interface, users can easily classify images of Simpsons characters by leveraging the automated computer vision and machine learning techniques.

## Features
* The system shall allow users to upload image files through a web form.
* The system shall process and parse uploaded image files in standard formats like JPG, PNG, etc.
* The system shall optimize and preprocess images to prepare them for pixel analysis.
* The system shall programmatically analyze pixel colors and objects in the image.
* The system shall calculate the percentage or ratio of total image pixels with particular characteristics.
* The system shall encapsulate extracted characteristics and labels into data transfer objects.
* The system shall provide an interface for classifying images based on extracted characteristics.
* The system shall utilize a Naive Bayes machine learning model to classify image characteristics.
* The system shall have a training data set with labeled examples to build the classification model.
* The system shall classify images into known labels based on the extracted characteristics.
* The system shall return classification results to the user as JSON responses.
* The system shall update the web display dynamically to show classification results.
* The system shall utilize modular templates for consistent page structure.
* The system shall use JavaScript for dynamic page updates and asynchronous communication.
* The system shall expose a REST API through a Spring MVC backend.
* The system shall leverage Spring Boot for application initialization and configuration.
* The system shall connect to a MySQL database using Spring Data JPA.
* The system shall externalize configuration through Spring Boot properties.
* The system shall log errors and exceptions with stack traces.
* The system shall have automated tests to validate startup and integration.

## Entities
* Image: A digital picture uploaded by the user to be classified. It contains visual pixel data that is analyzed.
* Characteristic: A numeric representation of visual attributes extracted from the image, like color histograms. These form the feature vector.
* Classification: The process of analyzing an image’s characteristics to determine which Simpsons character it depicts.
* Classifier: The machine learning model that performs the classification, implemented here with Naive Bayes.
* Controller: The web component that handles image upload and classification requests.
* Service: Components that encapsulate logic for extracting image data and classifying images.
* Model: Classes that represent data like the extracted characteristics.
* Sub-systems
* Image Processing
* The Image Processing sub-system provides functionality to extract meaningful data from images uploaded by the user. It converts the raw image pixels into numerical representations that capture visual characteristics like color profiles and object shapes. This allows the semantic contents of the image to be quantified for further analysis. The value of this sub-system is it enables the software to understand the user-provided images at a granular level by transforming the raw pixels into structured data. The key artifacts that implement this are the DataExtractionService interface and class, which handle the image-to-data conversion, and the ExtractDataDto model, which encapsulates the extracted data. This differs from the Machine Learning sub-system in that it focuses strictly on image processing and quantification rather than conducting predictive analysis.

## Machine Learning
The Machine Learning sub-system provides capabilities to classify images based on the extracted visual characteristics. It applies statistical models to the numeric data from the Image Processing sub-system to predict which character an image most likely depicts. This enables the software to automatically identify the subject of the user’s uploaded image. The value of this sub-system is it allows robust classification functionality without requiring manual rules or complex logic from developers. The ImageClassifierService interface and class enable this by housing pre-trained models that can be applied to new data. This differs from the Image Processing sub-system in that it focuses on predictive modeling rather than pixel-level image analysis.

## Web Interface
The Web Interface sub-system enables user interaction through a web frontend. It provides the necessary controllers, templates, and static assets to allow image uploads and display results in the browser. This gives users an intuitive way to leverage the system’s capabilities. The value is it abstracts away the technical details of the backend services, exposing only the key interactions needed through standard web interfaces. The HomeController handles user requests and responses, supported by HTML templates, JavaScript, and CSS. This differs from the other sub-systems that focus on backend processing rather than user presentation.

## Image Processing
The Image Processing sub-system provides functionality to extract meaningful data from images uploaded by the user. It converts the raw image pixels into numerical representations that capture visual characteristics like color profiles and object shapes. This allows the semantic contents of the image to be quantified for further analysis. The value of this sub-system is it enables the software to understand the user-provided images at a granular level by transforming the raw pixels into structured data. The key artifacts that implement this are the DataExtractionService interface and class, which handle the image-to-data conversion, and the ExtractDataDto model, which encapsulates the extracted data. This differs from the Machine Learning sub-system in that it focuses strictly on image processing and quantification rather than conducting predictive analysis.

## Machine Learning
The Machine Learning sub-system provides capabilities to classify images based on the extracted visual characteristics. It applies statistical models to the numeric data from the Image Processing sub-system to predict which character an image most likely depicts. This enables the software to automatically identify the subject of the user’s uploaded image. The value of this sub-system is it allows robust classification functionality without requiring manual rules or complex logic from developers. The ImageClassifierService interface and class enable this by housing pre-trained models that can be applied to new data. This differs from the Image Processing sub-system in that it focuses on predictive modeling rather than pixel-level image analysis.

## Web Interface
The Web Interface sub-system enables user interaction through a web frontend. It provides the necessary controllers, templates, and static assets to allow image uploads and display results in the browser. This gives users an intuitive way to leverage the system’s capabilities. The value is it abstracts away the technical details of the backend services, exposing only the key interactions needed through standard web interfaces. The HomeController handles user requests and responses, supported by HTML templates, JavaScript, and CSS. This differs from the other sub-systems that focus on backend processing rather than user presentation.

## Data Flow
The system enables users to classify images of Simpsons characters through an intuitive web interface. Users start by uploading an image file depicting a character using the image upload form. This image is passed to the data extraction service, which analyzes the pixel contents to produce an array of numeric characteristics representing visual features like clothing colors and facial attributes.
The numeric characteristics array is then fed into the image classification service, which leverages a pre-trained machine learning model to predict which Simpsons character is most likely represented based on the visual data. The predicted character classification is returned.
Finally, the extracted numeric characteristics and predicted character classification are displayed back to the user on the web interface, providing them with informative results about the image they uploaded. This seamless flow from image upload to visual analysis to classification and result display allows users to easily identify Simpsons characters through an automated image analysis system.

## Required jars:
* Weka
* OpenCV
