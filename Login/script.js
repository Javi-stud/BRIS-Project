const inputform = document.getElementById("login");
const username = document.getElementById("username");
const userpassword = document.getElementById("password");


username.addEventListener("focus", () => username.placeholder = "");
userpassword.addEventListener("focus", () => userpassword.placeholder = "");


username.addEventListener("blur", () => {
  if(username.value === "")username.placeholder = "Enter you username"
});

userpassword.addEventListener("blur", () => {
  if(userpassword.value === "")userpassword.placeholder = "Enter your password"
});


inputform.addEventListener("submit", function(event) {
event.preventDefault();

const username_value = document.getElementById("username").value;

const userpassword_value = document.getElementById("password").value;

   
if(username_value === "" || userpassword_value === "") {
  alert("Please input requirements");
  return;
}
  
if(username_value === "admin" && userpassword_value === "12345") {
  alert("you are in");
} else {
  alert("wrong pass");
}

});




