// https://www.codingame.com/training/easy/logic-gates

export function logicGates() {
    const inputLines = [
        'A __---___---___---___---___',
        'B ____---___---___---___---_',
    ];
    const outputLines = ['C AND A B', 'D OR A B', 'E XOR A B'];
    const inputSignals: { name: string; signal: boolean[] }[] = [];
    const expectedOutputSignals: {
        name: string;
        operator: string;
        inputs: string[];
    }[] = [];

    for (let inputLine of inputLines) {
        let inputs = inputLine.split(' ');
        inputSignals.push({
            name: inputs[0],
            signal: inputs[1].split('').map((x) => (x === '-' ? true : false)),
        });
    }
    for (let outputLine of outputLines) {
        let inputs = outputLine.split(' ');
        expectedOutputSignals.push({
            name: inputs[0],
            operator: inputs[1],
            inputs: [inputs[2], inputs[3]],
        });
    }

    console.error('Input signals: ', inputSignals);
    console.error('Expected output signals: ', expectedOutputSignals);

    for (let output of expectedOutputSignals) {
        const outputName = output.name;
        const operator = output.operator;
        const inputA = inputSignals.find((x) => x.name === output.inputs[0])!;
        const inputB = inputSignals.find((x) => x.name === output.inputs[1])!;

        const outputSignal: boolean[] = [];

        for (let i = 0; i < inputA.signal.length; i++) {
            switch (operator) {
                case 'AND':
                    outputSignal.push(inputA.signal[i] && inputB.signal[i]);
                    break;
                case 'OR':
                    outputSignal.push(inputA.signal[i] || inputB.signal[i]);
                    break;
                case 'XOR':
                    outputSignal.push(inputA.signal[i] !== inputB.signal[i]);
                    break;
                case 'NAND':
                    outputSignal.push(!(inputA.signal[i] && inputB.signal[i]));
                    break;
                case 'NOR':
                    outputSignal.push(!(inputA.signal[i] || inputB.signal[i]));
                    break;
                case 'NXOR':
                    outputSignal.push(!(inputA.signal[i] !== inputB.signal[i]));
                    break;
            }
        }

        const outputSignalString = outputSignal
            .map((x) => (x ? '-' : '_'))
            .join('');

        console.log(`${outputName} ${outputSignalString}`);
    }
}
