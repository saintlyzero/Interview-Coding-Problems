# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class ConstructTree:
    
    def buildTree(self, preorder, inorder):
      '''
        preorder -> list containing preorder traversal nodes
        
        inorder -> list containing inorder traversal nodes
        
        returns the root of the tree
      '''
      
        node_to_inorder_idx = {}
        for idx, n in enumerate(inorder):
            node_to_inorder_idx[n] = idx
        
        return self.build_tree_helper(preorder, 0, len(preorder), 0, len(inorder), node_to_inorder_idx)
    
    def build_tree_helper(self, preorder, preorder_start, preorder_end, inorder_start, inorder_end, node_to_inorder_idx):
        if (preorder_end <= preorder_start) or (inorder_end <= inorder_start):
            return None
        
        root_inorder_idx = node_to_inorder_idx[preorder[preorder_start]]
        left_subtree_size = root_inorder_idx - inorder_start

        node = TreeNode(preorder[preorder_start])
   
        node.left = self.build_tree_helper(preorder, preorder_start + 1, preorder_start + 1 + left_subtree_size, inorder_start, root_inorder_idx, node_to_inorder_idx)
        node.right = self.build_tree_helper(preorder, preorder_start + 1 + left_subtree_size, preorder_end , root_inorder_idx + 1, inorder_end, node_to_inorder_idx)
        
        return node
