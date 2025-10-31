const residentsList = [
  {
  lastName:"Sing",
  firstName:"Javi",
  address:"Ginatilan",
  age:16,
},
{
  lastName:"ding",
  firstName:"risl",
  address:"argao",
  age:17,
},
  ];

function renderResidents () {
  const boxInfo = document.getElementsByClassName('residentsList')[0];  boxInfo.innerHTML='';
  
  residentsList.forEach(resident => {
    
    const info = document.createElement('div');
    info.classList.add('residentsInfo');
    
    const name = document.createElement('div');
    name.classList.add('residentsName');
    name.textContent = ` ${resident.firstName} ${resident.lastName} `;
    
    const address= document.createElement('div');
    address.classList.add('residentsAddress');
    address.textContent = `address: ${resident.address} - age: ${resident.age}`;
    
    
    info.append(name, address);
    
    boxInfo.append(info);
    
  });
}

renderResidents();


                        
