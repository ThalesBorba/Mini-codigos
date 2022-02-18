function buscaNumeroPrimos(n) {

var numerosPrimos = []

for(var indice = 2; indice <= n; indice ++) {
    if (ePrimo(indice)) {
    numerosPrimos.push(indice)
  }
}

function ePrimo(n) {
  for(var indice = 2; indice < n; indice++)
    if(n % indice === 0) {
        return false
    };
  return true;
}
 
  return numerosPrimos;
}
