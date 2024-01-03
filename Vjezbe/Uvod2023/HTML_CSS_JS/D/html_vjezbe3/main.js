let numStudents = 0;

let nizStudenata = [
    
    {
        ime: 'Sanja',
        prezime: 'Markovic',
        smjer: 'D',
        brIndeksa: 25,
        godUpisa: 2022
    },
    {
        ime: 'Marko',
        prezime: 'Markovic',
        smjer: 'C',
        brIndeksa: 15,
        godUpisa: 2023
    },
    {
        ime: 'Ana',
        prezime: 'Abdjusic',
        smjer: 'B',
        brIndeksa: 15,
        godUpisa: 2023
    }
];

const listaPredmeta = {
    'A': ['Analiza 1', 'Linearna algebra', 'Logika'],
    'B': ['Analiza 1', 'Linearna algebra', 'Logika', 'Racunari i programiranje'],
    'C': ['Analiza 1', 'Analiticka geometrija', 'Racunari i programiranje', 'Uvod u kompjuterske nauke'],
    'D': ['Matematika1', 'Operativni sistemi', 'Uvodu kompjuterske nauke', 'Fizika', 'Racunari i programiranje', 'Engleski 1']
};

function napraviRedTabele(student) {
    let tr = document.createElement('tr');
    tr.innerHTML = `
        <td>${student.ime}</td>
        <td>${student.prezime}</td>
        <td>${student.smjer}</td>
        <td>${student.brIndeksa}/${student.godUpisa}</td>
        `
    let td = document.createElement('td')
    let dugmeUkloniStudenta = document.createElement('button');

    dugmeUkloniStudenta.addEventListener('click', () => {
        nizStudenata = nizStudenata.filter((element) => {
            return element !== student;
        });
        popuniTabeluStudenata(nizStudenata);
    })

    dugmeUkloniStudenta.innerHTML = '-';
    td.appendChild(dugmeUkloniStudenta);
    tr.appendChild(td);

    return tr;
}

function popuniTabeluStudenata(nizStudenata) {
    tabela = document.querySelector('tbody');
    tabela.innerHTML = '';

    for(let i=0;i<nizStudenata.length;i++)
        tabela.appendChild(napraviRedTabele(nizStudenata[i]));

    let studentsNumber = document.querySelector('#total-students-number');
    studentsNumber.innerHTML = nizStudenata.length;
    
}

function popuniListuPredmeta(listaPredmeta) {
    selectElement = document.querySelector('#select-predmet');
    selectElement.innerHTML = '';

    for(let i=0;i<listaPredmeta.length;i++) {
        optionElement = document.createElement('option');
        optionElement.innerHTML = listaPredmeta[i];
        optionElement.value = listaPredmeta[i];
        selectElement.appendChild(optionElement);
    }
}

function submit(e) {
    e.preventDefault();
    imePrezime = document.querySelector('#input-ime').value;
    smjer = document.querySelector('input[type="radio"]:checked').value
    brIndeksa = document.querySelector('#input-br-index').value;
    godUpisa = document.querySelector('#input-god_upisa').value;
    budzet = document.querySelector('#input-checkbox-budzet').checked;

    if(imePrezime.split(' ').length !== 2) {
        alert("Ime i prezime moraju biti dvije rijeci")
        return;
    }

    ime = imePrezime.split(' ')[0]
    prezime = imePrezime.split(' ')[1]
    
    let sadrzi = nizStudenata.some((elem) => {
        return elem.ime === ime &&
               elem.prezime === prezime &&
               elem.brIndeksa == brIndeksa &&
               elem.godUpisa == godUpisa &&
               elem.smjer == smjer
    });

    if(sadrzi)
        return;


    nizStudenata.push({
        ime: ime,
        prezime: prezime,
        brIndeksa: brIndeksa,
        godUpisa: godUpisa,
        smjer: smjer
    });

    popuniTabeluStudenata(nizStudenata);
}

function sortirajStudente(attr){
    nizStudenata = nizStudenata.sort((a, b) => {
        if(a[attr] < b[attr]) return -1;
        if(a[attr] == b[attr]) return 0;
        return 1;
    })
    popuniTabeluStudenata(nizStudenata);
}

function sortirajStudenteIme(){
    nizStudenata = nizStudenata.sort((a, b) => {
        if(a.ime < b.ime) return -1;
        if(a.ime == b.ime) {
            if(a.prezime < b.prezime) return -1;
            if(a.prezime == b.prezime) return 0;
        };
        return 1;
    })
    popuniTabeluStudenata(nizStudenata);
}

document.querySelector('input[type="submit"]').addEventListener('click', submit);

popuniTabeluStudenata(nizStudenata);

let radioButtons = document.querySelectorAll('input[type="radio"][name="smjer"]');

for(let i=0;i<radioButtons.length;i++) 
    radioButtons[i].addEventListener('click', e => {
        smjer = radioButtons[i].value;
        popuniListuPredmeta(listaPredmeta[smjer]);
    })

popuniListuPredmeta(listaPredmeta['A']);
