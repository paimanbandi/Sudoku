package id.paiman.sudoku

import android.arch.lifecycle.MutableLiveData
import android.graphics.Color

class Play {

    var selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()
    var cellsLiveData = MutableLiveData<List<Cell>>()

    private var selectedRow = -1
    private var selectedCol = -1
    private var cells: MutableList<Cell> = mutableListOf<Cell>()
    private val board: Board

    init {
        board = Board(9, cells)

        var randomNumber = (1..9).asIterable().shuffled()
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if ((j > 0 && j < 8) && (i == 1)) {
                    cells.add(Cell(i, j, randomNumber[j]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if ((i == 2) && (j == 1)) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(1, 2)).asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 2 && j == 7) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 6))
                        .minusElement(getCellVal(1, 7)).asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if ((i == 3) && (j == 1)) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(2, 1)).asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 3 && j == 4) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 4))
                        .minusElement(getCellVal(3, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 3 && j == 7) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 7))
                        .minusElement(getCellVal(2, 7))
                        .minusElement(getCellVal(3, 1))
                        .minusElement(getCellVal(3, 4)).asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 4 && j == 1) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(2, 1))
                        .minusElement(getCellVal(3, 1)).asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 4 && j == 3) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 3))
                        .minusElement(getCellVal(3, 4))
                        .minusElement(getCellVal(4, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 4 && j == 5) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 5))
                        .minusElement(getCellVal(3, 4))
                        .minusElement(getCellVal(4, 1))
                        .minusElement(getCellVal(4, 3))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 4 && j == 7) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 7))
                        .minusElement(getCellVal(2, 7))
                        .minusElement(getCellVal(3, 7))
                        .minusElement(getCellVal(4, 1))
                        .minusElement(getCellVal(4, 3))
                        .minusElement(getCellVal(4, 5))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 5 && j == 1) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(2, 1))
                        .minusElement(getCellVal(3, 1))
                        .minusElement(getCellVal(4, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 5 && j == 4) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 4))
                        .minusElement(getCellVal(3, 4))
                        .minusElement(getCellVal(4, 3))
                        .minusElement(getCellVal(4, 5))
                        .minusElement(getCellVal(5, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 5 && j == 7) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 7))
                        .minusElement(getCellVal(2, 7))
                        .minusElement(getCellVal(3, 7))
                        .minusElement(getCellVal(4, 7))
                        .minusElement(getCellVal(5, 1))
                        .minusElement(getCellVal(5, 4))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 6 && j == 1) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(2, 1))
                        .minusElement(getCellVal(3, 1))
                        .minusElement(getCellVal(4, 1))
                        .minusElement(getCellVal(5, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 6 && j == 7) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 7))
                        .minusElement(getCellVal(2, 7))
                        .minusElement(getCellVal(3, 7))
                        .minusElement(getCellVal(4, 7))
                        .minusElement(getCellVal(5, 7))
                        .minusElement(getCellVal(6, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 7 && j == 1) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 1))
                        .minusElement(getCellVal(2, 1))
                        .minusElement(getCellVal(3, 1))
                        .minusElement(getCellVal(4, 1))
                        .minusElement(getCellVal(5, 1))
                        .minusElement(getCellVal(6, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 7 && j == 2) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 2))
                        .minusElement(getCellVal(7, 1))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 7 && j == 3) {
                    randomNumber = (1..9)
                        .minusElement(getCellVal(1, 3))
                        .minusElement(getCellVal(4, 3))
                        .minusElement(getCellVal(7, 1))
                        .minusElement(getCellVal(7, 2))
                        .asIterable().shuffled()
                    cells.add(Cell(i, j, randomNumber[0]))
                    selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                    cellsLiveData.postValue(board.cells)
                } else if (i == 7 && j == 4) {

                    val newRandomNumber: MutableList<Int> = mutableListOf()

                    newRandomNumber.add(getCellVal(1, 4))
                    newRandomNumber.add(getCellVal(3, 4))
                    newRandomNumber.add(getCellVal(5, 4))
                    newRandomNumber.add(getCellVal(7, 1))
                    newRandomNumber.add(getCellVal(7, 2))
                    newRandomNumber.add(getCellVal(7, 3))

                    for(x in 1..9){

                        if(!newRandomNumber.contains(x)){
                            cells.add(Cell(i, j, x))
                            selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                            cellsLiveData.postValue(board.cells)
                            break;
                        }
                    }

                } else if (i == 7 && j == 5) {

                    val newRandomNumber: MutableList<Int> = mutableListOf()

                    newRandomNumber.add(getCellVal(1, 5))
                    newRandomNumber.add(getCellVal(4, 5))
                    newRandomNumber.add(getCellVal(7, 1))
                    newRandomNumber.add(getCellVal(7, 2))
                    newRandomNumber.add(getCellVal(7, 3))
                    newRandomNumber.add(getCellVal(7, 4))

                    for(x in 1..9){

                        if(!newRandomNumber.contains(x)){
                            cells.add(Cell(i, j, x))
                            selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                            cellsLiveData.postValue(board.cells)
                            break;
                        }
                    }

                } else if (i == 7 && j == 6) {

                    val newRandomNumber: MutableList<Int> = mutableListOf()

                    newRandomNumber.add(getCellVal(1, 6))
                    newRandomNumber.add(getCellVal(7, 1))
                    newRandomNumber.add(getCellVal(7, 2))
                    newRandomNumber.add(getCellVal(7, 3))
                    newRandomNumber.add(getCellVal(7, 4))
                    newRandomNumber.add(getCellVal(7, 5))

                    for(x in 1..9){

                        if(!newRandomNumber.contains(x)){
                            cells.add(Cell(i, j, x))
                            selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                            cellsLiveData.postValue(board.cells)
                            break;
                        }
                    }

                } else if (i == 7 && j == 7) {

                    val newRandomNumber: MutableList<Int> = mutableListOf()

                    newRandomNumber.add(getCellVal(1, 7))
                    newRandomNumber.add(getCellVal(2, 7))
                    newRandomNumber.add(getCellVal(3, 7))
                    newRandomNumber.add(getCellVal(4, 7))
                    newRandomNumber.add(getCellVal(5, 7))
                    newRandomNumber.add(getCellVal(6, 7))
                    newRandomNumber.add(getCellVal(7, 1))
                    newRandomNumber.add(getCellVal(7, 2))
                    newRandomNumber.add(getCellVal(7, 3))
                    newRandomNumber.add(getCellVal(7, 4))
                    newRandomNumber.add(getCellVal(7, 5))
                    newRandomNumber.add(getCellVal(7, 6))

                    for(x in 1..9){

                        if(!newRandomNumber.contains(x)){
                            cells.add(Cell(i, j, x))
                            selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
                            cellsLiveData.postValue(board.cells)
                            break;
                        }
                    }

                } else {
                    cells.add(Cell(i, j, 0))
                }
            }
        }
    }

    fun handleInput(number: Int) {

        if (selectedRow == -1 || selectedCol == -1) return

        var totalRow = 9
        var totalCol = 9

        var listTempDuplicateSmallBlock: MutableList<Int> = mutableListOf()
        var listTempDuplicateRowBigBlock: MutableList<Int> = mutableListOf()
        var listTempDuplicateColBigBlock: MutableList<Int> = mutableListOf()

        var startRow = (selectedRow / 3) * 3
        var startCol = (selectedCol / 3) * 3

        for (i in 0 until totalRow) {
            for (j in 0 until totalCol) {
                if (i == selectedRow) {
                    for (k in startRow until (startRow + 3)) {
                        for (l in startCol until (startCol + 3)) {
                            if (getCellVal(k, l) > 0) {
                                if (!listTempDuplicateSmallBlock.contains(getCellVal(k, l))) {
                                    listTempDuplicateSmallBlock.add(getCellVal(k, l))
                                }
                            }
                        }
                    }
                    if (getCellVal(i, j) > 0) {
                        listTempDuplicateRowBigBlock.add(getCellVal(i, j))
                    }
                }

                if (j == selectedCol) {
                    if (getCellVal(i, j) > 0) {
                        listTempDuplicateColBigBlock.add(getCellVal(i, j))
                    }
                }
            }
        }

        if (listTempDuplicateSmallBlock.contains(number)) {
            BoardView.selectedCellPaint.color = Color.parseColor("#FF0000")
            cellsLiveData.postValue(board.cells)
        } else if (listTempDuplicateRowBigBlock.contains(number)) {
            BoardView.selectedCellPaint.color = Color.parseColor("#FF0000")
            cellsLiveData.postValue(board.cells)

        } else if (listTempDuplicateColBigBlock.contains(number)) {
            BoardView.selectedCellPaint.color = Color.parseColor("#FF0000")
            cellsLiveData.postValue(board.cells)

        } else {
            board.getCell(selectedRow, selectedCol).value = number
            cellsLiveData.postValue(board.cells)
            BoardView.selectedCellPaint.color = Color.parseColor("#008000")
        }
    }

    fun updateSelectedCell(row: Int, col: Int) {
        selectedRow = row
        selectedCol = col
        selectedCellLiveData.postValue(Pair(row, col))
    }

    fun getCellVal(row: Int, col: Int): Int {
        return board.getCell(row, col).value
    }

}
