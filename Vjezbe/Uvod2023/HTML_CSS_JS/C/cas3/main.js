const smjerovi = ['A', 'B', 'C', 'D'];

let prijave = [
    {
        ime: 'Marko',
        prezime: 'Markovic',
        brIndeksa: '5/22',
        smjer: 'C',
        budzet: true,
        predmet: 'Racunari i programiranje'
    },
    {
        ime: 'Ana',
        prezime: 'Markovic',
        brIndeksa: '5/22',
        smjer: 'B',
        budzet: false,
        predmet: 'Racunari i programiranje'
    },
    {
        ime: 'Ana',
        prezime: 'Bogavac',
        brIndeksa: '7/22',
        smjer: 'A',
        budzet: false,
        predmet: 'Analiza 1'
    },
    {
        ime: 'Nikola',
        prezime: 'Bogavac',
        brIndeksa: '7/22',
        smjer: 'D',
        budzet: true,
        predmet: 'Uvod u kompjuterske nauke'
    }
]

const predmeti = {
    'A': ['Analiza 1', 'Linearna algebra', 'Uvod u matematicku logiku', 'Engleski1', 'Racunari i programiranje'],
    'B': ['Analiza 1', 'Linearna algebra', 'Uvod u matematicku logiku', 'Engleski1', 'Racunari i programiranje'],
    'C': ['Analiza 1', 'Analiticka geometrija', 'Uvod u kompjuterske nauke', 'Uvod u matematicku logiku', 'Engleski1', 'Racunari i programiranje'],
    'D': ['Matematika 1', 'Uvod u matematicku logiku', 'Engleski1', 'Racunari i programiranje'],
}

function clearTable() {
    tabela = document.querySelector('tbody');
    tabela.innerHTML = '';
}

function createTableRow(prijava) {

    tabelaRed = document.createElement('tr');
    tabelaRed.innerHTML = `
        <td>${prijava.ime}</td>
        <td>${prijava.prezime}</td>
        <td>${prijava.smjer}</td>
        <td>${prijava.brIndeksa}</td>
        <td>${prijava.budzet ? 'budzet' : 'samofinansiranje'}</td>
        <td>${prijava.predmet}</td>
    `;

    removeButtonCell = document.createElement('td');
    removeButton = document.createElement('button');
    removeButton.innerHTML = '-';

    removeButtonCell.addEventListener('click', (e) => {
        prijave = prijave.filter(item => {
            return item.brIndeksa !== prijava.brIndeksa || item.smjer !== prijava.smjer || item.predmet !== prijava.predmet;
            //mozemo da poredimo sa prijava.brIndeksa i prijava.smjer i prijava.predmet jer je arrow funkcija
        });

        clearTable();
        fillTable(prijave);
    })

    removeButtonCell.appendChild(removeButton);
    tabelaRed.appendChild(removeButtonCell);

    return tabelaRed;
}

function fillTable(prijave) {
    tabela = document.querySelector('tbody');
    
    for(let i=0; i<prijave.length;i++) {
        tabela.appendChild(createTableRow(prijave[i]));
    }
}

function sortirajPrijave(attr) {
    prijave.sort((a, b) => {
        if(a[attr]<b[attr]) return -1;
        if(a[attr] === b[attr]) return 0;
        return 1;
    })
}

function submit(e) {
    e.preventDefault();

    let imePrezime = document.querySelector('#input-ime-prezime').value;
    let brojIndeksa = document.querySelector('#input-index').value;
    let smjer = document.querySelector("input[type='radio']:checked").value;
    let budzet = document.querySelector('#budzet').checked; 

    let predmentSelector = document.querySelector('#select-predmet');
    let predmetIndex = predmentSelector.selectedIndex;
    let selectedPredemet = predmentSelector.options[predmetIndex];
    let predmetIme = selectedPredemet.value;

    let imePrezimeNiz = imePrezime.split(' ');

    prijave.push({
        ime: imePrezimeNiz[0],
        prezime: imePrezimeNiz[1],
        brIndeksa: brojIndeksa,
        smjer: smjer,
        budzet: budzet,
        predmet: predmetIme
    });

    clearTable();
    fillTable(prijave);
}

function updateSmjer1(e) {
    selectedSmjer = e.target.value;
    selectList = document.querySelector('#select-predmet');
    selectList.innerHTML = '';

    for(let i=0;i<predmeti[selectedSmjer].length;i++) {
        let option = document.createElement('option');
        option.value = predmeti[selectedSmjer][i];
        option.innerHTML = predmeti[selectedSmjer][i];

        selectList.appendChild(option);
    }
}

function fillSubjectsList(activeSubjects) {
    let allSubjects = [];

    for(let i=0;i<smjerovi.length;i++) {
        allSubjects = allSubjects.concat(predmeti[smjerovi[i]]);
    }

    allSubjects = allSubjects.filter((item, pos) => {
        return allSubjects.indexOf(item) === pos;
    });

    selectList = document.querySelector('#select-predmet');
    selectList.innerHTML = '';

    for(let i=0;i<allSubjects.length;i++) {
        let option = document.createElement('option');
        option.value = allSubjects[i];
        option.innerHTML = allSubjects[i];
        option.disabled = !activeSubjects.includes(allSubjects[i]);

        selectList.appendChild(option);
    }
}

btn = document.querySelector('#button-submit');
btn.addEventListener('click', submit);

clearTable();
fillTable(prijave);

radioByttons = document.querySelectorAll('input[type="radio"]');

fillSubjectsList([]);
// for(let i=0;i<radioByttons.length;i++)
//     radioByttons[i].addEventListener('click', updateSmjer1);

for(let i=0;i<radioByttons.length;i++)
    radioByttons[i].addEventListener('click', (e) => {
        let selectedSmjer = e.target.value;
        fillSubjectsList(predmeti[selectedSmjer]);
    });
