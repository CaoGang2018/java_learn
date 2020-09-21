package others.leecode;

/**
 * @author admin_cg
 * @data 2020/9/21 14:38
 */
public class Solution_211 {
    class TreeNode{
        TreeNode[] treeNodes;
        boolean isEnd;

        public TreeNode() {
            treeNodes = new TreeNode[26];
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                treeNodes[i] = null;
            }
        }
    }
    TreeNode root;
    /** Initialize your data structure here. */
    public Solution_211() {
        this.root = new TreeNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word){
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            if(cur.treeNodes[c - 'a'] == null)
                cur.treeNodes[c - 'a'] = new TreeNode();
            cur = cur.treeNodes[c - 'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, root);

    }

    private boolean searchHelper(String word, TreeNode root){
        TreeNode cur = root;
        for (int j = 0; j < word.length(); j++) {
            if(word.charAt(j) == '.'){
                for (int i = 0; i < 26; i++) {
                    if(cur.treeNodes[i] != null){
                        if (searchHelper(word.substring(j+1), cur.treeNodes[i]))
                            return true;
                    }
                }
                return false;
            }
            if (cur.treeNodes[word.charAt(j) - 'a'] == null)
                return false;
            cur = cur.treeNodes[word.charAt(j) - 'a'];
        }
        return cur.isEnd;
    }
}
