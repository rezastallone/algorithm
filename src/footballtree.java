public class footballtree {

    public static void main(String[] args) {
        counts(new int[]{1, 4, 2, 4}, new int[]{3, 5});
    }

    static class Node {
        Integer score;
        Node left;
        Node right;

        Node(Integer score) {
            this.score = score;
        }
    }

    private static Node insert(Integer score, Node root) {
        if (root == null) {
            return new Node(score);
        }

        if (root.score > score) {
            root.left = insert(score, root.left);
        } else {
            root.right = insert(score, root.right);
        }

        return root;
    }

    private static Integer inorder(Node root, Integer maxScore) {
        if (root == null) {
            return 0;
        }
        int c = 0;
        if ( root.score <= maxScore ){
            c++;
            c += inorder(root.right, maxScore);
        }

        if ( root.score <= maxScore ){
            c++;
            c += inorder(root.left, maxScore);
        }
        return c;
    }

    static int[] counts(int[] nums, int[] maxes) {
        Node root = null;

        for (int i = 0; i < nums.length; i++) {
            root = insert(nums[i], root);
        }

        int[] counts = new int[maxes.length];
        for ( int i = 0; i < maxes.length; i++){
            counts[i] = inorder(root,maxes[i]);
            System.out.println(counts[i]);
        }
        return counts;
    }

}
