somaTodosNumeros($array) {

    $somaTotal = 0;

    for ($i=0; $i < sizeof($array); $i++) { 
        $somaTotal = $somaTotal + $array[$i];
    }
    
    return $somaTotal;
}

$numeros = array(1,3,9,4,5,8,2,6,7,0);

$soma = somaTodosNumeros($numeros);

echo "A soma dos números do Array é: " . $soma;