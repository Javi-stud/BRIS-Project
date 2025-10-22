
const Menubar = document.getElementById("dropdown");
const MenuDropdown = document.getElementById("menu_dropdown");

Menubar.addEventListener("click", () => {
  if(MenuDropdown.style.display === "none") {
    MenuDropdown.style.display = "block";
  } else {
    MenuDropdown.style.display = "none";
  }
});



