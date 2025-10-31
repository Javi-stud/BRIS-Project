const residentsList = [
  {
  lastName:"Sing",
  firstName:"Javi",
  address:"Ginatilan",
  id:112312,
  age:16,
},
{
  lastName:"ding",
  firstName:"risl",
  address:"argao",
  id:"2",
  age:17,
},
{
  lastName:"pimentl",
  firstName:"jaym",
  address:"mal",
  id:"3",

  
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
    
    const id = document.createElement('div');
    id.classList.add('residentsId');
    id.textContent =`${resident.id}`;
    
    const infoLeft = document.createElement('div');
    infoLeft.append(name, address);
    
    info.append(infoLeft, id);
    
    boxInfo.append(info);
    
  });
}

renderResidents();


                        
