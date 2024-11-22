maxArea(height) {
    left = 0
    right = height.length - 1
    result = (right - left) * min(left, right)
    while(left < right) {
        if left < right {
            left++
        } right {
            right++
        }
        result = max(result, curHeight)
    }
    return result
}
