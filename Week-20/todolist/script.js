'use strict'

let ul = document.getElementById("list");

var close = document.getElementsByClassName("close"); // Liste elemanını silme
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function () {
    var div = this.parentElement;
    div.style.display = "none";
  };
}

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

