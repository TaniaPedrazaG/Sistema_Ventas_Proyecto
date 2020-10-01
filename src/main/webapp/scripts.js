/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadOptions() {
    var opts = document.getElementById("opts");
    opts.length = 0;
    const op = document.getElementById("options").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", `ControllDB?option=0&op=${op}`, true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const records = JSON.parse(xhr.responseText);
            records.forEach(record => {
                let option = document.createElement("option");
                option.setAttribute("value", record.id);
                option.appendChild(document.createTextNode(record.name));
                opts.appendChild(option);
            });
        }
    };
    xhr.send(null);
}
