function validateForm() {
	var pass = document.getElementById("userpass1");
	var name = document.getElementById("username1")
	var add=document.getElementById("empadd1");
	var phn=document.getElementById("empphn1");
	
	
	if(rangeValid(pass,6,15,"Password Between 6 to 9 Charcters")){
		if(onlyAlpha(name,"User Name Must Not be Empty")){
			if(addrValid(add,"Invalid Charcter in Employee Address")){
				if(rangeValid(phn,10,10,"Phone Number Must be 10 Digit")){
					return true;
				}
			}
		}
	}
	return false;
}



//For Range Valid
function rangeValid(elem,min,max,msg)
{
if(!(elem.value.length>=min && elem.value.length<=max))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
//For Only Alpha
function onlyAlpha(elem,msg)
{
var exp=/^[ a-zA-Z]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
//For Valid Address
function addrValid(elem,msg)
{
var exp=/^[ a-zA-Z0-9\,\:\-]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
//Only Digits
function onlyDigits(elem,msg)
{
var exp=/^[0-9]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
//Range Valid
//For Range Valid1
function rangeValid1(elem,max,msg)
{
if(!( elem.value.length == max))
{
alert(msg);
elem.focus();
return false;
}
return true;
}