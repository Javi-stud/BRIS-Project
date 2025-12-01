// Inputs
const nameInput = document.getElementById("citizenName");
const addressInput = document.getElementById("citizenAddress");
const ageInput = document.getElementById("age");
const purposeInput = document.getElementById("purpose");
const dateInput = document.getElementById("issuedDate");
const officerNameInput = document.getElementById("officerNameInput");
const officerTitleInput = document.getElementById("officerTitleInput");

const provinceInput = document.getElementById("provinceInput");
const municipalityInput = document.getElementById("municipalityInput");
const barangayInput = document.getElementById("barangayInput");

// Output elements
const certBody = document.getElementById("certBody");
const issueDateEl = document.getElementById("issueDate");
const purposeText = document.getElementById("purposeText");
const officerNameEl = document.getElementById("officerName");
const officerTitleEl = document.getElementById("officerTitle");

const provinceEl = document.getElementById("Province");
const municipalityEl = document.getElementById("municipality");
const barangayEl = document.getElementById("barangay");

// Photo & signature
const photoFile = document.getElementById("photoFile");
const sigFile = document.getElementById("sigFile");
const photoPreview = document.getElementById("photoPreview");
const sigPreview = document.getElementById("sigPreview");

// Buttons
const printBtn = document.getElementById("printBtn");
const savePdfBtn = document.getElementById("savePdfBtn");
const certificateEl = document.getElementById("certificate");

// Update certificate
function updateCert() {
    const name = nameInput.value || "[Full Name]";
    const address = addressInput.value || "[Address]";
    const age = ageInput.value || "[Age]";
    const purpose = purposeInput.value || "[Purpose]";
    const date = dateInput.value || new Date().toISOString().split('T')[0];
    const officer = officerNameInput.value || "Punong Barangay";
    const title = officerTitleInput.value || "Barangay Captain";

    const province = provinceInput.value || "[Province]";
    const municipality = municipalityInput.value || "[Municipality]";
    const barangay = barangayInput.value || "[Barangay]";

    // Update header
    provinceEl.textContent = province;
    municipalityEl.textContent = municipality;
    barangayEl.textContent = barangay;

    // Update body
    certBody.innerHTML = `
        <p style="text-indent:40px;">This is to certify that <b>${name}</b>, age <b>${age}</b>, Filipino citizen residing at <b>${address}</b>.</p>
        <p style="text-indent:40px;">Further certify that the above-named person belongs to the <b>Indigent Family</b> in this Barangay.</p>
        <p style="text-indent:40px;">This Certification is being issued upon the request of the interested party in connection with any legal purpose that may serve them best.</p><br>
    `;

    // Other fields
    issueDateEl.textContent = date;
    purposeText.textContent = purpose;
    officerNameEl.textContent = officer;
    officerTitleEl.textContent = title;
}

// Live updates
[
    nameInput, addressInput, ageInput, purposeInput, dateInput,
    officerNameInput, officerTitleInput,
    provinceInput, municipalityInput, barangayInput
].forEach(el => el.addEventListener("input", updateCert));

// Photo upload
photoFile.addEventListener("change", e => {
    const file = e.target.files[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => photoPreview.innerHTML = `<img src="${reader.result}">`;
    reader.readAsDataURL(file);
});

// Signature upload
sigFile.addEventListener("change", e => {
    const file = e.target.files[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => sigPreview.innerHTML = `<img src="${reader.result}">`;
    reader.readAsDataURL(file);
});

// Set default date
dateInput.value = new Date().toISOString().split('T')[0];
updateCert();

// Print & Save PDF
printBtn.addEventListener("click", () => {
    const printWindow = window.open('', '', 'width=900,height=700');
    printWindow.document.write('<html><head><title>Print Certificate</title>');
    printWindow.document.write('<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700&display=swap" rel="stylesheet">');
    printWindow.document.write('<style>');
    printWindow.document.write(document.querySelector('style, link[rel="stylesheet"]').outerHTML);
    printWindow.document.write('</style></head><body>');
    printWindow.document.write(certificateEl.outerHTML);
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.focus();
    printWindow.print();
});

savePdfBtn.addEventListener("click", () => {
    const opt = {
        margin: 0.5,
        filename: 'certificate.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 2 },
        jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
    };
    html2pdf().set(opt).from(certificateEl).save();
});
