// Solution for leetcode 200: Number of Islands
public class leetcode200 {
    DIR = {{1,0},{-1,0},{0,1},{0,-1}};
    numIslands(grid) {
        result = 0
        queue q;
        for (row from 0 to length of the grid) {
            for (col from 0 to length of the grid[0]) {
                if grid[row][col] == '1' {
                    result++;
                    bfs(grid, row, col, q)
                }
            }
        }
    }

    bfs(grid, row, col, q) {
        q.add(row, col)
        while q is not empty {
            cur = q.poll()
            for (dir in DIR) {
                newRow = cur[0] + dir[0]
                newCol = cur[1] + dir[1]
                if newRow < 0 or newRow >= length of grid or newCol < 0 or newCol >= length of grid[0] or grid[newRow][newCol] == '0' {
                    continue
                }
                grid[newRow][newCol] = '0'
                q.add(newRow, newCol)
            }
        }
    }
}
