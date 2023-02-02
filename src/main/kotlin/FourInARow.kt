/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */

import kotlin.random.Random

class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    override fun clearBoard() {
        // TODO Auto-generated method stub
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
            board[row][col] = 0
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        // TODO Auto-generated method stub
        var row = location / board[0].size;
        var column = location % board[0].size;
        board[row][column] = player;
    }

    override val computerMove: Int
        get() =// TODO Auto-generated method stub
//         0
        Random.nextInt(1,30)


    override fun checkForWinner(): Int {
        // TODO Auto-generated method stub
        var counter1 = 0
        var counter2 = 0
        for (row in 0 until GameConstants.ROWS) {
            counter1 = 0
            counter2 = 0
            for (col in 0 until GameConstants.COLS) {
                if (board[row][col] == 0) {
                    counter1 = 0
                    counter2 = 0
                } else if (board[row][col] == 1) {
                    counter1 = counter1 + 1
                    counter2 = 0
                    if (counter1 >= 4) {
                        return 3
                    }
                } else if (board[row][col] == 2) {
                    counter1 = 0
                    counter2 += 1
                    if (counter2 >= 4) {
                        return 2
                    }
                }
            }
        }
        for (col in 0 until GameConstants.ROWS) {
            counter1 = 0
            counter2 = 0
            for (row in 0 until GameConstants.COLS) {
                if (board[row][col] == 0) {
                    counter1 = 0
                    counter2 = 0
                } else if (board[row][col] == 1) {
                    counter1 = counter1 + 1
                    counter2 = 0
                    if (counter1 >= 4) {
                        return 3
                    }
                } else if (board[row][col] == 2) {
                    counter1 = 0
                    counter2 += 1
                    if (counter2 >= 4) {
                        return 2
                    }
                }
            }
        }
        return 0
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
    fun checkBoard(location: Int): Int {
        var row = location / board[0].size;
        var column = location % board[0].size;
        return board[row][column]
    }
}

