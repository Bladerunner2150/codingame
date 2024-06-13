// https://www.codingame.com/ide/puzzle/word-search-for-programmers

export function wordSearch() {
    const size: number = 10;
    const rows: string[] = [
        'IPLUCJMCNY',
        'AAFIIVADZN',
        'TFUUSWGHWE',
        'UBARTAGDOG',
        'YSAJIGIUGR',
        'DTEMRFEOKA',
        'HYTEBKZCHM',
        'BOMAHARBAL',
        'WOOQPUERNE',
        'HEZUYIJHNS',
    ];

    // for (let i = 0; i < size; i++) {
    // const row: string = readline();
    // rows.push(row);
    // }
    const clues: string[] =
        'Abraham Bart Homer Lisa Maggie Marge Patty Selma'.split(' ');

    console.error('Rows: ', rows);
    console.error('Clues: ', clues);

    // TODO: complete code

    console.log('grid with unused letters hidden');
}
