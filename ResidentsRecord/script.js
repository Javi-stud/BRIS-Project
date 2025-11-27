let residentsList = [];

async function loadResidents() {
  try {
    const response = await fetch("/api/residents");
    residentsList = await response.json();
    renderResidents(residentsList);
  } catch (error) {
    console.error("Error fetching residents:", error);
  }
}

const placeholder = [
  {firstName:"Javi", lastName:"sing", sitio:"mangaco", age: "12", id:"1234556"},
  {firstName:"clyde", lastName:"limba", sitio:"somewherefar", age: "14", id:"17654"},
];

renderResidents(placeholder);

function renderResidents(residentsData) {
  const boxInfo = document.querySelector('.residentsList');
  boxInfo.innerHTML = '';

  if (!residentsData || residentsData.length === 0) {
    boxInfo.innerHTML = '<p style="text-align:center;">No residents found.</p>';
    return;
  }

  residentsData.forEach(resident => {
    const card = document.createElement('div');
    card.classList.add('residentsInfo');

    card.innerHTML = `
      <div class="col-name">${resident.firstName} ${resident.lastName}</div>
      <div class="col-sitio">${resident.sitio}</div>
      <div class="col-age">${resident.age}</div>
      <div class="col-id">${resident.id}</div>
    `;

    card.addEventListener("click", () => {
      window.location.href = `/residentsinfo?id=${resident.id}`;
    });

    boxInfo.append(card);
  });
}

function searchResidents() {
  const query = document.querySelector('.search').value.trim().toLowerCase();

  if (query === "") {
    renderResidents(residentsList);
    return;
  }

  const filtered = residentsList.filter(resident =>
    `${resident.firstName} ${resident.lastName} ${resident.sitio} ${resident.age}`
      .toLowerCase()
      .includes(query)
  );

  renderResidents(filtered);
}

window.addEventListener('DOMContentLoaded', () => {
  const searchInput = document.querySelector('.search');
  const searchButton = document.querySelector('.serbot');

  searchInput.addEventListener('input', searchResidents);
  searchButton.addEventListener('click', searchResidents);

  loadResidents();
});
