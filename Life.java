import java.util.*;

public class Life {
    public static Shortcuts s = new Shortcuts();
    public static Life l = new Life();


    int[][] grid = new int[3][3];
    int[][] grid2 = new int[3][3];

    void printGrid(int[][] grid) {
        s.prntln("[");
        for (int i = 0; i < grid.length; i++) {
            s.prnt("[");
            for (int j = 0; j < grid[0].length; j++) {
                s.prnt(grid[i][j]);
            }
            s.prntln("],");
        }
        s.prntln("]");
    }

    int aliveNeighbors(int x, int y) {
        // 0 0 0
        // X X X
        // 0 0 0
        //                                      v checking
        // in code: looks like [ [0, 1, 0], [0, 1, 0], [0, 1, 0] ]
        int alive = 0;
        int maxX = l.grid.length - 1;
        int maxY = l.grid[0].length - 1;
        
        if (y > 0) {
            if (l.grid[y - 1][x] == 1) {
                alive ++;
                s.prnt("left ");
            }
        }

        if (x > 0) {
            if (l.grid[y][x - 1] == 1) {
                alive ++;
                s.prnt("above ");
            }
        }

        if (y > 0 && x > 0) {
            if (l.grid[y - 1][x - 1] == 1) {
                alive ++;
                s.prnt("above_left ");
            }
        }

        if (y < maxY) {
            if (l.grid[y + 1][x] == 1) {
                alive ++;
                s.prnt("right ");
            }
        }

        if (x < maxX) {
            if (l.grid[y][x + 1] == 1) {
                alive ++;
                s.prnt("below ");
            }
        }

        if (y < maxY && x < maxX) {
            if (l.grid[y + 1][x + 1] == 1) {
                alive ++;
                s.prnt("bottom_right ");
            }
        }

        if (y < maxY && x > 0) {
            if (l.grid[y + 1][x - 1] == 1) {
                alive ++;
                s.prnt("above_right ");
            }
        }

        if (x < maxX && y > 0) {
            if (l.grid[y - 1][x + 1] == 1) {
                alive ++;
                s.prnt("bottom_left ");
            }
        }

        s.prntln();
        
        return alive;
    }

    void showGrid() {
        for (int y = 0; y < l.grid.length; y++) {
            for (int x = 0; x < l.grid[0].length; x++) {
                if (l.grid[x][y] == 1)
                    s.prnt("X ");
                else
                    s.prnt("0 ");
            }
            s.prntln();
        }
    }

    void nextDay() {
        int al;
        for (int i = 0; i < l.grid.length; i++) {
            for (int j = 0; j < l.grid[0].length; j++) {
                al = l.aliveNeighbors(j, i);
                s.prntln("on cell x: " + i + " y: " + j + "\talive: "  + l.grid[j][i] + "\talive neighbors: " + al);
                if (l.grid[j][i] == 1) {
                    if (!(al == 2) && !(al == 3)) {
                        l.grid2[j][i] = 0;
                    } else {
                        l.grid2[j][i] = 1;
                    }
                } else {
                    if (al == 3) {
                        l.grid2[j][i] = 1;
                    } else {
                        l.grid2[j][i] = 0;
                    }
                }
            }
        }
        l.printGrid(l.grid);
        l.printGrid(l.grid2);

        for (int i = 0; i < l.grid.length; i++) {
            for (int j = 0; j < l.grid[0].length; j++) {
                l.grid[i][j] = l.grid2[i][j];
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < l.grid.length; i++) 
            for (int j = 0; j < l.grid[0].length; j++)
                l.grid[i][j] = 0;
        
        int x, y;
        do {
            s.prnt("Enter x coordinate of cell (1-"+l.grid.length+"): ");
            x = s.input.nextInt() - 1;
            s.prnt("Enter y coordinate of cell (1-"+l.grid[0].length+") (or -1 to quit): ");
            y = s.input.nextInt() - 1;
            if (y != -2)
                l.grid[x][y] = 1;
        
        } while (y != -2);

        l.showGrid();
        
        String cont = "y";
        do {
            s.prnt("Show next day? (y/n): ");
            cont = s.input.next();
            if (cont.equals("y")) {
                l.nextDay();
                l.showGrid();
            }
        } while (cont.equals("y"));

    }
}
