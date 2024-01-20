'use strict'

let name = prompt("Lütfen isminizi giriniz: ", "Adınız");
let documentUserName = document.getElementById("myName");

documentUserName.innerHTML = name;

let myClock = document.getElementById("myClock");


function timeStr() {
    const day = ["Pazar","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi"];
    let date = new Date();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    let dayStr = day[date.getDay()];

    if(hours < 10) {
        hours = `0${hours}`;
    }
    if(minutes < 10) {
        minutes = `0${minutes}`;
    }
    if(seconds < 10) {
        seconds = `0${seconds}`;
    }

    myClock.innerHTML = `${hours}:${minutes}:${seconds} ${dayStr}`;
}
  
setInterval(timeStr, 1000);
