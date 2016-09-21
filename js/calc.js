function clickMe(){
var v1, v2, v3, v4;
v1=document.getElementById("one").value;
v2=document.getElementById("two").value;
v3=document.getElementById("three").value;
if(v3!=="+"&&v3!=="-"&&v3!=="*"&&v3!=="/"){alert("Введено неверное действие"); return};
if(v3==="+"){v4=(+v1)+(+v2)};
if(v3==="-"){v4=v1-v2};
if(v3==="*"){v4=v1*v2};
if(v3==="/"){v4=v1/v2};
document.getElementById("res").value=v4;
 };