const departmentsList = ['A', 'B', 'C', 'D']

const studentsList = [
    {
        name: 'Marko',
        surname: 'Markovic',
        index: '1/23',
        department: 'C',
        budget: 'Budzet',
        subject: 'Uvod u kompjuterske nauke' 
    },
    {
        name: 'Marko',
        surname: 'Markovic',
        index: '2/23',
        department: 'C',
        budget: 'Budzet',
        subject: 'Racunari i programiranje' 
    },
    {
        name: 'Marko',
        surname: 'Markovic',
        index: '1/23',
        department: 'B',
        budget: 'Budzet',
        subject: 'Engleski 1' 
    },
    {
        name: 'Marko',
        surname: 'Markovic',
        index: '2/23',
        department: 'C',
        budget: 'Budzet',
        subject: 'Analiza1' 
    }
]

const subjectsLists = {
    "A": [
        "Analiza 1",
        "Linearna algebra",
        "Racunari i programiranje",
        "Uvod u matematicku logiku",
        "Engleski 1"
    ],
    "B": [
        "Analiza 1",
        "Linearna algebra",
        "Racunari i programiranje",
        "Uvod u matematicku logiku",
        "Engleski 1"
    ],
    "C": [
        "Uvod u kompjuterske nauke",
        "Racunari i programiranje",
        "Analiza 1",
        "Engleski 1",
        "Uvod u matematicku logiku"
    ],
    "D": [
        "Matematika 1",
        "Racunari i programiranje",
        "Uvod u matematicku logiku",
        "Engleski 1"
    ]
    
}

function clearSubjectsList(){
    document.querySelector('#select-predmet').innerHTML = '';
}

function fillSubjectsList(activeSubjects){
    allSubjects = []
    departmentsList.forEach(department => {
            allSubjects = allSubjects.concat(subjectsLists[department]);
        }
    )

    allSubjects = allSubjects.filter((item, pos) => {
        return allSubjects.indexOf(item) == pos;
    })

    selectElement = document.querySelector("#select-predmet")

    allSubjects.forEach(subject => {
        selectElement.innerHTML += `<option value=${subject} ${activeSubjects.includes(subject) ? "" : "disabled"}>${subject}</option>`
    })
}

function clearTable(){
    tabela = document.querySelector('tbody');
    tabela.innerHTML = "";
}

function createTableRow(student){

    tabelaRed = document.createElement('tr');
    tabelaRed.innerHTML = `
        <td>${student.name}</td>
        <td>${student.surname}</td>
        <td>${student.department}</td>
        <td>${student.index}</td>
        <td>${student.budget ? 'budzet' : 'samofinansiranje'}</td>
        <td>${student.subject}</td>
    `;

    tabelaRed.classList.add('podvuceni-tekst')

    if(student.department === 'C')
        tabelaRed.classList.add('zuti-tekst');

    if(student.department === 'B')
        tabelaRed.classList.remove('podvuceni-tekst')

    return tabelaRed
}

function fillTable(studentsList){
    tabela = document.querySelector('tbody');

    studentsList.forEach(student => {
        tabela.appendChild(createTableRow(student));
    });
}

function submit(e) {
    e.preventDefault();

    let imePrezime = document.querySelector('#input-ime-prezime').value;
    let brojIndeksa = document.querySelector('#input-broj-indeksa').value;
    let smjer = document.querySelector("input[type='radio']:checked").value;
    let budzet = document.querySelector('#budzet').checked; 

    let predmentSelector = document.querySelector('#select-predmet');
    let predmetIndex = predmentSelector.selectedIndex;
    let selectedPredemet = predmentSelector.options[predmetIndex];
    let predmetIme = selectedPredemet.value;

    let imePrezimeNiz = imePrezime.split(' ');


    studentsList.push({
        name: imePrezimeNiz[0],
        surname: imePrezimeNiz[1],
        index: brojIndeksa,
        department: smjer,
        budget: budzet,
        subject: predmetIme 
    })

    clearTable();
    fillTable(studentsList);

}

function sortTableByAttribute(attr) {
    studentsList.sort((a, b) => {
        if(a[attr] < b[attr]) return -1;
        if(a[attr] > b[attr]) return 0;
        return 1
     });
     clearTable();
     fillTable(studentsList);
}

btn = document.querySelector('#button-submit');
btn.addEventListener('click', submit)

clearTable();
fillTable(studentsList);

clearSubjectsList();
fillSubjectsList([]);

radioButtons = document.querySelectorAll('input[type="radio"]')
radioButtons.forEach(radioButton => {
    radioButton.addEventListener('click', e => {
        clearSubjectsList();
        fillSubjectsList(subjectsLists[e.target.value]);
    })
})

