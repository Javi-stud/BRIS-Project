
const residentDataInfo = [
  {
    firstName: "sing",
    lastName: "vi",
    sex:"Male",
    age:"15",
    city:"manilam",
    sitio:"bohol",
    occupation:"rider",
    voterStatus:"Registered",
    householdMembers:"19",
    birthDate:"08/23/2004",
    civilStatus:"single",
    contact:"secret",
    bloodType:"O",
    email:"howow@gmail.com",
    educationalAttainment:"NOtDone",
    religion:"catholic",
    PWD:"Idunno",
    suffix:"N\A",
    senior:"nope",
    condition:"buhi pa po",
    picture: "https://cdn-icons-png.flaticon.com/128/346/346167.png",
  },
];


const pageQueryString = window.location.search;
const parsedQuery = new URLSearchParams(pageQueryString);
const urlQuery = parsedQuery.get('id');

const residentId = parseInt(urlQuery, 10);


async function getResidentInfo(residentId) {
  try {
    const response = await fetch(`local:host/hereputthelocalhost/resident/${residentId}`);
    if(!response.ok) throw new Error("Resident Not Found");
    const residentInfo = await response.json();
    displayResidentHeaderInfo(residentInfo);
    displayResidentLowerInfo(residentInfo);
  } catch(error) {
    
    console.error(error);
    alert(Resident Not Found!); // ge tangtang nakong double quotation kay sigig alert, samok
    
    if(document.referrer) {
      history.back();  
    } else {
       window.location.href = "goesbacktothepreviusepage.html";
    }
  }
}

getResidentInfo(residentId);




function displayResidentHeaderInfo (resident) {
  
  const photo = document.getElementById('residentPhoto');
  photo.src = resident.picture;
  photo.alt = `${resident.firstName} ${resident.lastName}`;
  
  const residentsHeader = document.querySelector('.residentHeaderInfo');
  residentsHeader.innerHTML = '';
  
  const name = document.createElement('div');
  name.classList.add('residentName');
  name.textContent = `${resident.firstName} ${resident.lastName}`;
  
  
  const age = document.createElement('div');
  age.classList.add('residentAge');
  age.textContent = `${resident.age}yo`;
  

  
  
 residentsHeader.append(name, age)
}

displayResidentHeaderInfo(residentDataInfo[0]);



//goes to the editing page
const idSender = document.getElementById('residentEditPage');

idSender.addEventListener('click', () =>{
  window.location.href=`editpahesomething.html?id=${residentId}`;
})






function displayResidentLowerInfo(resident) {
  
  const residentsInfo = {
    residentSex: resident.sex,
    residentOccupation: resident.occupation,
    residentSitio: resident.sitio,
    residentVoterStatus: resident.voterStatus,
    residentBirthDate: resident.birthDate,
    residentCivilStatus: resident.civilStatus,
    residentHouseholdMembers: resident.householdMembers,
    residentContact: resident.contact,
    residentBloodType: resident.bloodType,
    residentEmail: resident.email,
    residentEducationalAttainment: resident.educationalAttainment,
    residentReligion: resident.religion,
    residentPWD: resident.PWD,
    residentSuffix: resident.suffix,
    residentSenior: resident.senior,
    residentCondition: resident.condition,
  };
  
  Object.entries(residentsInfo).forEach(([id, text]) => {
    const infoContainer = document.getElementById(id);
    if(infoContainer){
      infoContainer.innerHTML = text;
    }
})
}

displayResidentLowerInfo(residentDataInfo[0]);
