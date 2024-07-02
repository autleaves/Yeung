// document.getElementById("pressme").onclick = function() {
//     document.location.hash = "banana";
//     // document.location.replace("http://apress.com");
//   }

// document.onreadystatechange = function() {
//     if(document.readyState == "interactive") {
//         document.getElementById("pressme").onclick = function() {
//             document.getElementById("results").innerHTML = "Button Pressed";
//         }
//     }
// }

// var features = ["Core", "HTML", "CSS", "Selectors-API"];
// var levels = ["1.0", "2.0", "3.0"];

// document.writeln("<pre>");
// for(var i=0; i<features.length; i++) {
//     document.writeln("Checking for feature: " + features[i]);
//     for(var j=0; j<levels.length; j++) {
//         document.write(features[i] + " Level " + levels[j] + ": ");
//         document.writeln(document.implementation.hasFeature(features[i], levels[j]));
//     }
// }
// document.write("</pre>");

// var resultsElement = document.getElementById("results");
// var elems = document["apple"];
// if(elems.namedItem) {
//     for(var i=0; i<elems.length; i++) {
//         resultsElement.innerHTML += "Image Element: " + elems[i].id + "\n";
//     }
// } else {
//     resultsElement.innerHTML += "Src for element is: " + elems.src + "\n";
// }

// var resultsElement = document.getElementById("results");
// var elems = document.querySelectorAll("p, img#apple");
// resultsElement.innerHTML += "The selector matched  " + elems.length + " elements\n";

