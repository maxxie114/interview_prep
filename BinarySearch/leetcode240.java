package BinarySearch;

public class leetcode240 {
    row = 0
    col = matrx[0].length -1
    while row  < matrix.lenth and col >= 0 {
        if matrix[row][col] == target {
            return true
        } 
        if matrix[row][col] > target {
            row--
        }
        else {
            row++
        }
    }
    return false
}
