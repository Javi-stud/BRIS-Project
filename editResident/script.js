document.addEventListener('DOMContentLoaded', function() {

  const birthInput = document.getElementById("input_birthdate");
    const ageInput = document.getElementById("input-age");
    const seniorInput = document.getElementById("seniorStatus");

    if(birthInput.value) { 
        const birthdate = new Date(birthInput.value);
        const today = new Date();
        let age = today.getFullYear() - birthdate.getFullYear();
        const monthDiff = today.getMonth() - birthdate.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthdate.getDate())) age--;
        ageInput.value = age;
        seniorInput.value = age >= 60 ? "true" : "false";
    }

    birthInput.addEventListener("change", () => {
        const birthdate = new Date(birthInput.value);
        const today = new Date();
        let age = today.getFullYear() - birthdate.getFullYear();
        const monthDiff = today.getMonth() - birthdate.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthdate.getDate())) age--;
        ageInput.value = age;
        seniorInput.value = age >= 60 ? "true" : "false";
    });

    const fileInput = document.getElementById('fileUpload');
    const photoPreview = document.getElementById('photoPreview');
    fileInput.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                photoPreview.innerHTML = '';
                const img = document.createElement('img');
                img.src = e.target.result;
                img.alt = 'Profile Preview';
                img.style.width = '100px';
                img.style.height = '100px';
                img.style.objectFit = 'cover';
                img.style.borderRadius = '5px';
                photoPreview.appendChild(img);
            };
            reader.readAsDataURL(file);
        } else {
            photoPreview.innerHTML = '<span>No Image</span>';
        }
    });

    function handleOther(selectId, fieldName, placeholderText) {
        const select = document.getElementById(selectId);
        if(!select) return;

        if(select.value && select.value !== "Other" && !Array.from(select.options).some(o => o.value === select.value)) {
            // Create input field for unknown existing value
            const input = document.createElement("input");
            input.type = "text";
            input.name = fieldName;
            input.id = selectId;
            input.value = select.value;
            select.parentNode.replaceChild(input, select);
        }

        select.addEventListener('change', function() {
            if (select.value === "Other") {
                const input = document.createElement("input");
                input.type = "text";
                input.name = fieldName;
                input.id = selectId;
                input.placeholder = placeholderText;
                input.required = true;

                const style = window.getComputedStyle(select);
                ["width","height","padding","fontSize","fontFamily","border","boxSizing"].forEach(prop => {
                    input.style[prop] = style[prop];
                });

                select.parentNode.replaceChild(input, select);
                input.focus();

                input.addEventListener('blur', () => {
                    if(input.value.trim() === ""){
                        select.value = "";
                        input.parentNode.replaceChild(select, input);
                    }
                });
            }
        });
    }

    handleOther("select_suffix","suffix","Specify suffix");
    handleOther("select_religion","religion","Specify religion");
    handleOther("select_educationalattainment","education","Specify Educational Attainment");
});