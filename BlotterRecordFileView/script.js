/*  const recordIdUrl = new URLSearchParams(window.location.search);
  const recordId = recordIdUrl.get('id');
  
async function filterId (record) {
  
  try {
    const response = await fetch(`somewhereidunno${record}`);
    if(!response.ok) throw new Error ('record not found');
    const blotterRecord = await response.json();
    renderInfo(blotterRecord);
  } catch(error) {
    console.error(error);
    alert(Record Not Found);
    
    if(document.referrer){
      history.back();
    } else {
      window.location.href="blotterrecord.html";
    }
  }
}

filterId(recordId);
*/


function renderInfo () {
  
 /* const info = {
    caseNum: record.caseNum,
    dateFiled: record.dateFiled,
    complianant: record.complianant,
    respondent: record.respondent,
    typeOfCompliant: record.typeOfCompliant,
    officerInCharge: record.officerInCharge,
    status: record.status,
    caseDescription: record.caseDescription,
  };
  
  */
    const info = {
    caseNum: "213",
    dateFiled: "dec/11/2012",
    complianant: "siya",
    respondent: "siya sad",
    typeOfCompliant: "wala lang",
    officerInCharge: "ambut",
    status: "Pending",
    caseDescription: "wewasdafsfssssssss ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss sad asd a  ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss ",
    complianantAge: "14",
    complianantContact: "globe",
    complianantAddress: "korea",
    respondentAge: "12",
    respondentContact: "smart",
    respondentAddress: "america",
    locationIncident: "pinas",
    actionTaken: "ambut wewasdafsfssssssss ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss sad asd a  ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss ssssssssssssss sssssssssssss sssssssssssssss sssssssssssssss ssssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssss sssssssssssssssssss",
  };
  
  Object.entries(info).forEach(([id, value]) => {
    const detail = document.getElementById(id);
    if(detail) {
      detail.innerHTML = value;
    }
  });
  
  
  const statusId = document.getElementById('status');
  const statusValue = info.status.toLowerCase();
  
  statusId.classList.remove("pending", "settled");
  
  if(statusValue === "pending")  statusId.classList.add("pending");
  if(statusValue === "settled")   statusId.classList.add("settled");
  
  
  const viewMore = document.getElementById('viewMore');
  const back = document.getElementById('back');
  const box1 = document.getElementById('box1');
  const box2 = document.getElementById('box2');
  
  viewMore.addEventListener('click', () => {
    box1.style.display="none";
    box2.style.display="block";
  });
  
  back.addEventListener('click', () => {
    box2.style.display="none";
    box1.style.display="block";
  });
  
  
}

renderInfo();


const markSettledBtn = document.getElementById("mark");
const statusElement = document.getElementById("status");
const caseNum = document.getElementById("caseNum").innerContent;

markSettledBtn.addEventListener("click", async () => {
  const confirmAction = confirm("Are you sure you want to mark this case as settled?");
  if (!confirmAction) return;

  try {
    const response = await fetch("/update-status", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        caseNum: caseNum,
        status: "Settled"
      })
    });

    if (!response.ok) throw new Error("Failed to update record");

    // Update UI
    const statusId = document.getElementById('status');
    statusId.textContent = "Settled";
    statusId.classList.remove("ongoing");
    statusId.classList.add("settled");

    alert("Case marked as settled successfully!");
  } catch (error) {
    console.error(error);
    alert("Something went wrong while updating the record.");
  }
})


const backb = document.getElementById("backb");

backb.addEventListener('click', () => {
  if(document.referrer){
  history.back();
} else {
  window.location.href="blotterrecordList.html";
}
});

const backc = document.querySelector('.back');

backc.addEventListener('click', () => {
  if(document.referrer){
  history.back();
} else {
  window.location.href="blotterrecordList.html";
}
});