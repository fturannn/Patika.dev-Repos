'use strict'

let ul = document.getElementById("list");
let itemsArray = localStorage.getItem('items') ? JSON.parse(localStorage.getItem('items')) : [];

/*
var myNodelist = document.getElementsByTagName("LI"); // X butonu ekleme
var i;
for (i = 0; i < myNodelist.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}
*/

var close = document.getElementsByClassName("close"); // Liste elemanını silme
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function () {
    var div = this.parentElement;
    div.style.display = "none";
  };
}

/*
for(let i = 0; itemsArray.length; i++) {
    let li = document.createElement("li");
    li.textContent = itemsArray[i];
    ul.appendChild(li);
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    li.appendChild(span);

    if(close.length > 0) {
        for (i = 0; i < close.length; i++) {
            close[i].onclick = function () {
                var div = this.parentElement;
                div.style.display = "none";
            };
        }
    }
}
*/

function newElement() {
    let li = document.createElement("li");
    let inputValue = document.getElementById("task").value;
    let text = document.getElementById("task");
    
    if (inputValue === "" || inputValue.replace(/^\s+|\s+$/g, "").length == 0) {
        var toastElList = [].slice.call(document.querySelectorAll('.error'))
        var toastList = toastElList.map(function(toastEl) {
        return new bootstrap.Toast(toastEl)
        })
        toastList.forEach(toast => toast.show())
        text.value = '';
    } else {
        li.appendChild(document.createTextNode(inputValue));
        ul.appendChild(li);
        var toastElList = [].slice.call(document.querySelectorAll('.success'))
        var toastList = toastElList.map(function(toastEl) {
        return new bootstrap.Toast(toastEl)
        })
        // itemsArray.push(inputValue);
        // localStorage.setItem("items", JSON.stringify(itemsArray));
        toastList.forEach(toast => toast.show())
        text.value = '';

        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        li.appendChild(span);

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function () {
              var div = this.parentElement;
              div.style.display = "none";
            };
        }
    }
}

ul.addEventListener("click", function(selection) {
    if(selection.target.tagName === "LI") {
        selection.target.classList.toggle("checked");
    }
})

