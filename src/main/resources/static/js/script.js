document.getElementById("fileInput").addEventListener("change", function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();

    reader.onload = function(e) {
        var imgElement = document.createElement("img");
        imgElement.src = e.target.result;
        imgElement.style.maxWidth = "100%";
        document.getElementById("imgPreview").innerHTML = "";
        document.getElementById("imgPreview").appendChild(imgElement);
        document.getElementById("dataDisplay").style.display = "block";
    };

    reader.readAsDataURL(file);
});

document.getElementById("uploadForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData();
    var fileInput = document.getElementById("fileInput");

    formData.append("file", fileInput.files[0]);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/upload", true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log("File uploaded successfully");
            var response = JSON.parse(xhr.responseText);
            displayData(response);
        } else {
            console.error("Error uploading file");
        }
    };
    xhr.send(formData);
});

function displayData(data) {
    var dataDisplay = document.getElementById("dataDisplay");
    var descriptions = [
        "Orange Shirt Bart",
        "Blue Short Bart",
        "Blue Shoes Bart",
        "Blue Pants Homer",
        "Brown Mouth Homer",
        "Gray Homer Shoes"
    ];

    var displayString = "<p><strong>Data Collected:</strong></p>";
    displayString += "<p>Character: " + data.character + "</p>";

    for (var i = 0; i < data.dataColected.length; i++) {
        displayString += "<p>" + descriptions[i] + ": " + data.dataColected[i] + "</p>";
    }

    dataDisplay.innerHTML = displayString;
}