function ehPalindromo(palavra) {

for(var indice = 0; indice < palavra.length / 2; indice++) {
    if (palavra[indice] != palavra[palavra.length - indice - 1]) {
    return "INFELIZMENTE, NÃO SOU UM PALÍNDROMO"} else {
    return "SIM, SOU UM PALÍNDROMO"}}

}
