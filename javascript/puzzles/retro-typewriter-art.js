export function createTypeWriterArt() {
    const input = "1sp 1/ 1bS 1_ 1/ 1bS nl 1( 1sp 1o 1. 1o 1sp 1) nl 1sp 1> 1sp 1^ 1sp 1< nl 2sp 3|";

    console.error("Input: ", input);

    const commands = input.split(" ");

    let output = "";

    commands.forEach(command => {
        let char = "";
        let count = 0;

        if (command === "nl") {
            count = 1;
            char = "\n";
        } else if (command.includes("sp")) {
            count = parseInt(command.replace("sp", ""));
            char = " ";
        } else if (command.includes("bS")) {
            count = parseInt(command.replace("bS", ""));
            char = "\\";
        } else if (command.includes("sQ")) {
            count = parseInt(command.replace("sQ", ""));
            char = "'";
        } else {
            count = parseInt(command.slice(0, -1));
            char = command[command.length - 1];
        }

        output += char.repeat(count);
    });

    console.log(output);
}