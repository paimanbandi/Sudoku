package id.paiman.sudoku

class Board(val size: Int, val cells: MutableList<Cell>?) {
    fun getCell(row: Int, col: Int) = cells!![row * size + col]
}