# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LCA:
    """
        Time Complexity : O(N) [N => Number of Nodes]
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        pathToX = self.path(root, p)
        pathToY = self.path(root, q)
        

        lca = None
        while (pathToX and pathToY):
            xPop = pathToX.pop()
            yPop = pathToY.pop()
            if xPop.val == yPop.val:
                lca = xPop
            if xPop.val != yPop.val:
                return lca
        return lca
             
    
    def path(self, root, node):
        if not root:
            return None
        if root.val == node.val:
            return [root]
        
        leftPath = self.path(root.left, node)
        if leftPath:
            leftPath.append(root)
            return leftPath
        
        rightPath = self.path(root.right, node)
        if rightPath:
            rightPath.append(root)
            return rightPath
            
        
    
        