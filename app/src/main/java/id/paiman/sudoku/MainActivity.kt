package id.paiman.sudoku

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BoardView.OnTouchListener {

    private lateinit var viewModel: PlayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boardView.registerListener(this)

        viewModel = ViewModelProviders.of(this).get(PlayViewModel::class.java)
        viewModel.play.selectedCellLiveData.observe(this, Observer { updateSelectedCellUI(it) })
        viewModel.play.cellsLiveData.observe(this, Observer { updateCells(it) })

        val buttons = listOf(oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn,
            sevenBtn, eightBtn, nineBtn)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { viewModel.play.handleInput(index + 1) }
        }
    }

    private fun updateCells(cells: List<Cell>?) = cells?.let {
        boardView.updateCells(cells)
    }

    private fun updateSelectedCellUI(cell: Pair<Int, Int>?) = cell?.let {
        boardView.updateSelectedCellUI(cell.first, cell.second)
    }

    override fun onCellTouched(row: Int, col: Int) {
        viewModel.play.updateSelectedCell(row, col)
    }
}