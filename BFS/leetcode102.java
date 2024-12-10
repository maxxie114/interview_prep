import java.util.Queue;

public class leetcode102 {
    arraylist result;
    if root == null {
        return result
    }

    Queue<E> q;

    q.add(root)

    while q is not empty {
        // Size is the size of the current layer
        int size = q.size()
        arraylist curResult; // the result of the current layer
        for (i from 0 to size) {
            curNode = q.poll
            curresult.add(curnode.val)
            if curnode.left != null {
                add curnode.left to queue
            }
            if curnode.right != null {
                add curnode.right to queue
            }
        }
        result.add(curResult)
    }
    return result;
}
