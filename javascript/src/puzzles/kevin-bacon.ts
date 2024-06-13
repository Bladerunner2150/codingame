// https://www.codingame.com/training/easy/six-degrees-of-kevin-bacon

export function kevinBacon() {
    const movieCastsData = [
        'Change of Habit: Elvis Presley, Mary Tyler Moore, Barbara McNair, Jane Elliot, Ed Asner',
        'JFK: Kevin Costner, Kevin Bacon, Tommy Lee Jones, Laurie Metcalf, Gary Oldman, Ed Asner',
        'Sleepers: Kevin Bacon, Jason Patric, Brad Pitt, Robert De Niro, Dustin Hoffman',
    ];

    // ! Begin add to script
    const movieCasts = [];
    let graph: { [key: string]: string[] } = {};
    // ! End add to script

    const actorName = 'Elvis Presley';
    // const n = 3;

    for (let i = 0; i < movieCastsData.length; i++) {
        const movieCast = movieCastsData[i];

        // ! Begin add to script
        const movieName = movieCast.split(': ')[0];
        const actors = movieCast.split(': ')[1].split(', ');
        movieCasts.push({ movieName, actors });
        // ! End add to script
    }

    // Write an answer using console.log()
    // To debug: console.error('Debug messages...');

    // ! Begin add to script
    for (let movie of movieCasts) {
        for (let actor of movie.actors) {
            if (!graph[actor]) {
                graph[actor] = [];
            }

            for (let coActor of movie.actors) {
                if (actor !== coActor) {
                    graph[actor].push(coActor);
                }
            }
        }
    }

    const start = actorName;
    const queue = [{ actor: start, degree: 0 }];
    const visited = new Set(); // Set values are unique

    let baconNumber = -1;

    while (queue.length > 0) {
        console.error('Queue: ', queue);
        console.error('Visited: ', visited);
        const { actor, degree } = queue.shift()!;

        if (actor === 'Kevin Bacon') {
            console.error('Kevin Bacon found!');
            baconNumber = degree;
            break;
        }

        for (let coActor of graph[actor]) {
            if (!visited.has(coActor)) {
                queue.push({ actor: coActor, degree: degree + 1 });
                visited.add(coActor);
            }
        }
    }

    console.error('N degrees to Kevin Bacon', baconNumber);
    console.log(baconNumber);
    // ! End add to script
}
