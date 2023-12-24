okButton = document.querySelector('button')
studentsCnt = 0

okButton.addEventListener('click', e => {
    e.preventDefault()

    ime = document.querySelector('#name').value
    smjer = document.querySelector('input[name=smjer]:checked').value
    brIndexa = document.querySelector('#index').value

    console.log(ime.split(' ').length != 2, brIndexa === undefined)

    if(ime.split(' ').length != 2 || brIndexa === undefined)
        return
    
    tabela = document.querySelector('#students-table-body')
    
    table_row = document.createElement('tr')

    ime_td = document.createElement('td')
    ime_td.appendChild(document.createTextNode(ime.split(' ')[0]))
    table_row.appendChild(ime_td)

    prezime_td = document.createElement('td')
    prezime_td.appendChild(document.createTextNode(ime.split(' ')[1]))
    table_row.appendChild(prezime_td)

    smjer_td = document.createElement('td')
    smjer_td.appendChild(document.createTextNode(smjer))
    table_row.appendChild(smjer_td)

    brIndexa_td = document.createElement('td')
    brIndexa_td.appendChild(document.createTextNode(brIndexa))
    table_row.appendChild(brIndexa_td)

    tabela.appendChild(table_row)

    studentsCnt += 1
    document.querySelector('#total-number-of-students').innerHTML=studentsCnt

})