package com.zc;

/**
 * @描述:  利用自己写的二分搜索树完成  ->其实用set就可以很容易的实现
 * @author: zhangchao
 * @date: 4/14/20 8:22 上午
 *
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 * https://leetcode-cn.com/problems/unique-morse-code-words
 **/
public class UniqueMorseRepresentations {
    //字典
    private static String [] container = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public static int uniqueMorseRepresentations(String[] words) {
        BST<String> bst = new BST();

        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder();
            //每个字符串
            String word = words[i];
            for (int x = 0; x < word.length(); x++) {
                //每个字符
                char c = word.charAt(x);
                //ASC码
                byte b =(byte)c;
                int index = b - 97;
                String s = container[index];
                builder.append(s);
            }
            bst.add(builder.toString());
        }
        return bst.size;
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(words);
        System.out.println(i);
    }


    /**
     * 二分搜索树
     * @param <E>
     */
    public static class BST<E extends Comparable<E>> {

        private class Node {
            public E e;
            public Node left, right;

            public Node(E e) {
                this.e = e;
                left = null;
                right = null;
            }
        }

        private Node root;
        private int size;

        public BST(){
            root = null;
            size = 0;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        // 向二分搜索树中添加新的元素e
        public void add(E e){
            if (root==null){
                root = new Node(e);
                size++;
            }else
                add(root, e);
        }

        private void add(Node node, E e) {
            //思考一下 为什么这两步是多余的
//        // 直接赋值
//        if (node == null){
//            System.out.println("辅助1");
//            node = new Node(e);
//            return;
//        }
//        //赋值
//        if (node.e == null) {
//            System.out.println("辅助2");
//            node = new Node(e);
//            return;
//        }
            if (node.e.compareTo(e) > 0 && node.left==null){
                node.left= new Node(e);
                size++;
                return;
            }
            else if ( node.e.compareTo(e) <0 && node.right==null){
                node.right = new Node(e);;
                size++;
                return;
            }
            if ( node.e.compareTo(e) > 0 ){
                add(node.left,e);
            }
            if ( node.e.compareTo(e) < 0 ){
                add(node.right,e);
            }
        }

    }

}
