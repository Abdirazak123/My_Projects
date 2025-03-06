package serial;

import java.util.Random;


public class GameOfLife {
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int[][] NEIGHBOR_OFFSETS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int[][] grid;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new int[rows][cols];
        initializeRandomly();
    }

    private void initializeRandomly() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextBoolean() ? ALIVE : DEAD;
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] == ALIVE ? '*' : ' ');
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        int[][] nextGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (grid[i][j] == ALIVE) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        nextGrid[i][j] = DEAD;
                    } else {
                        nextGrid[i][j] = ALIVE;
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        nextGrid[i][j] = ALIVE;
                    } else {
                        nextGrid[i][j] = DEAD;
                    }
                }
            }
        }
        grid = nextGrid;
    }

    private int countAliveNeighbors(int row, int col) {
        int aliveNeighbors = 0;
        for (int[] offset : NEIGHBOR_OFFSETS) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == ALIVE) {
                aliveNeighbors++;
            }
        }
        return aliveNeighbors;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(10, 10);
        gameOfLife.printGrid();
        for (int i = 0; i < 100; i++) {
            gameOfLife.nextGeneration();
            System.out.println("Generation " + (i + 1));
            gameOfLife.printGrid();
        }
    }
}