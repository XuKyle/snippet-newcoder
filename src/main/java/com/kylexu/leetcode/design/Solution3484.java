package com.kylexu.leetcode.design;

public class Solution3484 {

}


class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        this.grid = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
        int[] pos = getPos(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = getPos(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        int i = formula.indexOf('+');
        String cell1 = formula.substring(1, i);
        String cell2 = formula.substring(i + 1);
        return getCellVal(cell1) + getCellVal(cell2);
    }

    private int[] getPos(String cell) {
        int x = Integer.parseInt(cell.substring(1));
        int y = cell.charAt(0) - 'A';
        return new int[]{x, y};
    }

    private int getCellVal(String cell) {
        if (Character.isLetter(cell.charAt(0))) {
            int[] pos = getPos(cell);
            return grid[pos[0]][pos[1]];
        } else {
            return Integer.parseInt(cell);
        }
    }
}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/design-spreadsheet/solutions/3772881/she-ji-dian-zi-biao-ge-by-leetcode-solut-pz39/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。