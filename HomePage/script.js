const Menubar = document.getElementById("dropdown");
const MenuDropdown = document.getElementById("menu_dropdown");
const logoutbutton = document.getElementById("logoutbutton");
const logoutconfirm = document.getElementById("logoutconfirm");
const cancel = document.getElementById("cancel");
const logout = document.getElementById("logout");
let totalResidents = 0;
let totalBlotters = 0;

const blockBackNavigation = () => history.pushState(null, "", location.href);

document.addEventListener("DOMContentLoaded", () => {
    blockBackNavigation();
    window.addEventListener("popstate", blockBackNavigation);

    renderSitioChart();
    loadResidentCount();
    loadBlotterCount();
});

Menubar.addEventListener("click", () => {
    MenuDropdown.style.display = MenuDropdown.style.display === "none" ? "block" : "none";
});

logoutbutton.addEventListener("click", () => logoutconfirm.style.display = "flex");
cancel.addEventListener("click", () => logoutconfirm.style.display = "none");

logout.addEventListener("click", () => {
    sessionStorage.clear();
    localStorage.clear();
    window.removeEventListener("popstate", blockBackNavigation);
    window.location.href = "/logout";
});

window.addEventListener("click", (e) => {
    if (e.target === logoutconfirm) logoutconfirm.style.display = "none";
});

async function loadResidentCount() {
    try {
        const response = await fetch("/api/residents");
        const residentsList = await response.json();
        totalResidents = residentsList.length;
        document.getElementById("residentsRecords").textContent = totalResidents;
    } catch (error) {
        console.error("Error loading resident count:", error);
        document.getElementById("residentsRecords").textContent = 0;
    }
}

async function loadBlotterCount() {
    try {
        const response = await fetch("/api/blotters");
        const blottersList = await response.json();
        totalBlotters = blottersList.length;
        document.getElementById("blotterRecords").textContent = totalBlotters;
    } catch (error) {
        console.error("Error loading blotter count:", error);
        document.getElementById("blotterRecords").textContent = 0;
    }
}
window.addEventListener("pageshow", (event) => {
    if (event.persisted) window.location.replace("/login");
});

document.addEventListener("keydown", (e) => {
    if ((e.ctrlKey || e.metaKey) && (e.key === 'z' || e.key === 'y')) e.preventDefault();
});
(function() {
    history.pushState(null, "", location.href);
    window.addEventListener("popstate", () => window.location.href = "/homepage");
})();



const currentResidents = document.getElementById("currentResidents");
const res2 = document.getElementById("res2");
const sitioChartContainer = document.getElementById("sitioChartContainer");

let chartRendered = false;

// Hover to show chart with fade-in
currentResidents.addEventListener("mouseenter", () => {
    res2.style.display = "none";                 // Hide text
    sitioChartContainer.style.display = "block"; // Show chart
    setTimeout(() => {
        sitioChartContainer.style.opacity = 1;    // Fade in
    }, 50);

    if (!chartRendered) {
        renderSitioChart();
        chartRendered = true;
    }
});

// Hover out to hide chart with fade-out
currentResidents.addEventListener("mouseleave", () => {
    sitioChartContainer.style.opacity = 0;       // Fade out
    setTimeout(() => {
        sitioChartContainer.style.display = "none";
        res2.style.display = "flex";             // Show text
    }, 50); // Matches CSS transition duration
});

// Chart rendering function
function renderSitioChart() {
    const ctx = document.getElementById("sitioChart");
    const sitioElements = document.querySelectorAll("#sitioData .sitio");
    const sitioNames = [];
    const sitioCounts = [];

    sitioElements.forEach(el => {
        sitioNames.push(el.getAttribute("data-name"));
        sitioCounts.push(parseInt(el.getAttribute("data-count")));
    });

    new Chart(ctx, {
        type: "bar",
        data: {
            labels: sitioNames,
            datasets: [{
                label: "Residents",
                data: sitioCounts,
                backgroundColor: ["#3B82F6", "#10B981", "#F59E0B"],
                borderRadius: 6
            }]
        },
        options: {
            indexAxis: "y",
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: { beginAtZero: true },
                y: { ticks: { color: "#000" } }
            },
            plugins: { legend: { display: false } }
        }
    });
}
