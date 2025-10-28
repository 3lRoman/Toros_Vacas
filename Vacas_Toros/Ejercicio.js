const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Generar un numero secreto de 4 dígitos sin repetir
function generarSecreto() {
    let secreto = "";
    while (secreto.length < 4) {
        let digito = Math.floor(Math.random() * 10).toString();
        if (!secreto.includes(digito)) {
            secreto += digito;
        }
    }
    return secreto;
}

let secreto = generarSecreto();
let intentos = 0;

console.log("-- Juego: Vacas y Toros --");

function jugar() {
    rl.question("Adivina el número de 4 dígitos: ", (intento) => {
        intentos++;

        // Si no son 4 dígitos, avisar
        if (intento.length !== 4) {
            console.log("Debe tener 4 dígitos.\n");
            return jugar();
        }

        // Contar toros y vacas
        let toros = 0;
        let vacas = 0;

        for (let i = 0; i < 4; i++) {
            if (intento[i] === secreto[i]) {
                toros++;
            } else if (secreto.includes(intento[i])) {
                vacas++;
            }
        }

        console.log(`Toros: ${toros}, Vacas: ${vacas}`);

        if (toros === 4) {
            console.log(`Ganaste, El número era ${secreto}.`);
            console.log(`Intentos: ${intentos}`);
            rl.close();
        } else {
            jugar();
        }
    });
}

jugar();
