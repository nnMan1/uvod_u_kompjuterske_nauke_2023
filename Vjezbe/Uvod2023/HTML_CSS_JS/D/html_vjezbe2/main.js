let numStudents = 0

function submit(e) {
    e.preventDefault();
    imePrezime = document.querySelector('#input-ime').value;
    smjer = document.querySelector('input[type="radio"]:checked').value
    br_index = document.querySelector('#input-br-index').value;
    god_upisa = document.querySelector('#input-god_upisa').value;
    budzet = document.querySelector('#input-checkbox-budzet').checked;

    if(imePrezime.split(' ').length !== 2) {
        alert("Ime i prezime moraju biti dvije rijeci")
        return;
    }

    ime = imePrezime.split(' ')[0]
    prezime = imePrezime.split(' ')[1]

    tableBody = document.querySelector('tbody');
    tableRow = document.createElement('tr');

    cellIme = document.createElement('td');
    cellIme.innerHTML = ime;
    tableRow.appendChild(cellIme);

    cellPrezime = document.createElement('td');
    cellPrezime.innerHTML = prezime;
    tableRow.appendChild(cellPrezime);

    cellSmjer = document.createElement('td');
    cellSmjer.innerHTML = smjer;   
    tableRow.appendChild(cellSmjer);

    cellBrojIndeksa = document.createElement('td');
    cellBrojIndeksa.innerHTML = br_index + '/' + god_upisa;   
    tableRow.appendChild(cellBrojIndeksa);

    tableBody.appendChild(tableRow);

    numStudents++;
    studentsNumber = document.querySelector('#total-students-number')
    studentsNumber.innerHTML = numStudents
}

document.querySelector('input[type="submit"]').addEventListener('click', (e) => {
    e.preventDefault();
    imePrezime = document.querySelector('#input-ime').value;
    smjer = document.querySelector('input[type="radio"]:checked').value
    brIndex = document.querySelector('#input-br-index').value;
    godUpisa = document.querySelector('#input-god_upisa').value;
    budzet = document.querySelector('#input-checkbox-budzet').checked;

    if(imePrezime.split(' ').length !== 2) {
        alert("Ime i prezime moraju biti dvije rijeci")
        return;
    }

    ime = imePrezime.split(' ')[0]
    prezime = imePrezime.split(' ')[1]

    tableBody = document.querySelector('tbody');
    tableRow = document.createElement('tr');

    tableRow.innerHTML = '<td>' +ime + '</td><td>' + prezime + '</td><td>' + smjer + '</td><td>' + brIndex + '/' + godUpisa + '</td>';
    removeStudentButton = document.createElement('button');
    removeStudentButton.innerHTML = '-';
    removeButtonCell = document.createElement('td');
    removeButtonCell.appendChild(removeStudentButton);
    
    tableRow.appendChild(removeButtonCell);
   
    tableBody.appendChild(tableRow);

    numStudents++;
    studentsNumber = document.querySelector('#total-students-number')
    studentsNumber.innerHTML = numStudents
})