let blottersList = [];

async function loadBlotters() {
  try {
    const response = await fetch("/api/blotter");
    blottersList = await response.json();
    renderBlotters(blottersList);
  } catch (error) {
    console.error("Error fetching blotters:", error);
  }
}


function renderBlotters(blottersData) {
  const boxInfo = document.querySelector('.blottersList');
  boxInfo.innerHTML = '';

  if (!blottersData || blottersData.length === 0) {
    boxInfo.innerHTML = '<p style="text-align:center;">No blotters found.</p>';
    return;
  }

  blottersData.forEach(blotter => {
    const card = document.createElement('div');
    card.classList.add('blottersInfo');

    card.innerHTML = `
      <div class="col-caseNo">${blotter.caseNo}</div>
      <div class="col-name">${blotter.firstName} ${blotter.lastName}</div>
      <div class="col-date">${blotter.date || 'N/A'}</div>
      <div class="col-status">${blotter.status}</div>
    `;

    card.addEventListener("click", () => {
      window.location.href = `/blotterinfo?caseNo=${blotter.caseNo}`;
    });

    boxInfo.append(card);
  });
}

function searchBlotters() {
  const query = document.querySelector('.search').value.trim().toLowerCase();

  if (query === "") {
    renderBlotters(blottersList);
    return;
  }

  const filtered = blottersList.filter(blotter =>
    `${blotter.caseNo} ${blotter.firstName} ${blotter.lastName} ${blotter.date || ''} ${blotter.status}`
      .toLowerCase()
      .includes(query)
  );

  renderBlotters(filtered);
}

window.addEventListener('DOMContentLoaded', () => {
  const searchInput = document.querySelector('.search');
  const searchButton = document.querySelector('.serbot');

  searchInput.addEventListener('input', searchBlotters);
  searchButton.addEventListener('click', searchBlotters);

  loadBlotters();
});
