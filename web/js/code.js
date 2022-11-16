/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var a = 1;
function clickbtn() {
    a++;
    var b = document.querySelector(".user-menu");
    if(a%2===0)
   b.style.display = "block";
   else
   b.style.display = "none";
} 

function openinfotable() {
    document.querySelector(".infomation").style.display = "flex";
}

function closeinfotable() {
    document.querySelector(".infomation").style.display = "none";
}
 

