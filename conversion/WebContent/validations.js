function formValidation()
{
	var email = document.login.email;
	var password = document.login.password;
	var cpassword = document.login.cpassword;
	if (ValidateEmail(email)) 
	{
		if (passid_validation(password,8,15)) 
		{
			return true;
		}
	}
	return false;
}

function currencyValidation()
{
	var currencyName = document.currency.currencyName;
	var currencyNameF = document.currency.currencyNameF;
	var currencyValue = document.currency.currencyValue;
	
	if ( FT_validation(currencyName,currencyNameF)) 
	{
		if (currency_validation(currencyValue)) 
		{
			return true;
		}
	}
	return false;
}

function registerValidation()
{
	var surName = document.register.surName;
	var name = document.register.name;
	var idNumber =document.register.idNumber;
	var password =document.register.password;
	var cpassword =document.register.cpassword;
	
	
	if ( surname_validation(surName)) 
	{
		if (name_validation(name)) 
		{
			if (id_validation(idNumber)) 
			{
				if (name_validation(name)) 
				{
					if (passcompare_validation(cpassword,password)) 
					{
						if (passcompare_validation(cpassword,password)) 
						{
						return true;
						}
					}
				}
			}
		}
	}
	return false;
}

function clearregisterValidation()
{
	var surName = document.register.surName;
	var name = document.register.name;
	var idNumber =document.register.idNumber;
	var password =document.register.password;
	var cpassword =document.register.cpassword;
	var secondName =document.register.secondName;
	var email =document.register.email;
	
	surName.value ="";
	name.value =""
	idNumber.value =""
	password.value =""
	cpassword.value =""
	email.value =""
	secondName.value =""
	idNumber.focus();
	return true;
}

function updateValidation()
{
	var surName = document.register.surName;
	var name = document.register.name;
	var idNumber =document.register.idNumber;
	var email =document.register.idNumber;
	
	
	if ( surname_validation(surName)) 
	{
		if (name_validation(name)) 
		{
			if (id_validation(idNumber)) 
			{
				if (name_validation(name)) 
				{
					if(ValidateEmail(email))
					{
						return true;
					}
						
					
				}
			}
		}
	}
	return false;
}


function ValidateEmail(email)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(email.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email!");
document.login.email.focus();
document.login.email.value ="";
return false;

}
}

function passid_validation(password,mx,my)
{
var password_len = password.value.length;
if (password_len == 0 ||password_len >= my || password_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
password.focus();
return false;
}
return true;
}

function pass_validation(cpassword,mx,my)
{
var cpassword_len = cpassword.value.length;
if (cpassword_len == 0 ||cpassword_len >= my || cpassword_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
cpassword.focus();
return false;
}
return true;
}

function passcompare_validation(cpassword,password)
{
var password = password.value;
var cpassword = cpassword.value;
if (password == cpassword)
{
alert(" please re-enter password");
password.focus();
return false;
}
return true;
}
function FT_validation(currencyName,currencyNameF)
{
	
	if (currencyName.value == currencyNameF.value ) 
	{
		alert("Please select two different currency");
		currencyName.focus();
		return false;
	}
	return true;
}

function currency_validation(currencyValue)
{
	
	if (currencyValue.value != "" ) 
	{
		var numbers = /^[0-9]+$/;
		if(currencyValue.value.match(numbers))
		{
		return true;
		}
		alert("Please select two different currency");
		currencyName.focus();
		return false;
	}
	return true;
}


function id_validation(idNumber)
{
	var numbers = /^[0-9]+$/;
	var id_len = idNumber.value.length;
	if (idNumber.value != ""  && id_len==13) 
	{
		var numbers = /^[0-9]+$/;
		if(idNumber.value.match(numbers))
		{
		return true;
		}
		alert("Please select two different currency");
		idNumber.focus();
		return false;
	}
	return true;
}

function name_validation(name)
{
	var name = name.value;
	
	
	if (name.value != "") 
	{
		
		return true;
		
	}

	alert("name is required");
	name.focus();
	return false;
}

function surname_validation(surName)
{
	
	var surName = surName.value;
	
	if (surName.value != "") 
	{
		
		return true;
		
	}

	alert("name is required");
	surName.focus();
	return false;
}

function surname_validation(surName)
{
	
	var currencyValue = currencyValue.value;
	currencyValue="";
	
	return true;
}

 