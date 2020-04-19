package com.zc;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: 用自定义基于平衡二叉树的映射类解决
 * @author: zhangchao
 * @date: 4/19/20 4:17 下午
 *
 * 349. 两个数组的交集
 *
 *给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 :
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 **/
public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1];
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new BSTMap();
        for (int i = 0; i < nums1.length; i++) {
            map.add(nums1[i],1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.contains(nums2[i])){
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;
    }

    public interface Map<K, V> {

        void add(K key, V value);
        V remove(K key);
        boolean contains(K key);
        V get(K key);
        void set(K key, V newValue);
        int getSize();
        boolean isEmpty();
    }

    public static class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

        private class Node{
            public K key;
            public V value;
            public Node left, right;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
                left = null;
                right = null;
            }
        }

        private Node root;
        private int size;

        public BSTMap(){
            root = null;
            size = 0;
        }

        @Override
        public int getSize(){
            return size;
        }

        @Override
        public boolean isEmpty(){
            return size == 0;
        }

        // 返回以node为根节点的二分搜索树中，key所在的节点--核心方法
        private Node getNode(Node node, K key){
            if (node==null){
                return null;
            }
            if(node.key.compareTo(key)==0){
                return node;
            }
            if (node.key.compareTo(key)>0){
                return getNode(node.left,key);
            }
            else{ /*(node.key.compareTo(key)<0)*/
                return getNode(node.right,key);
            }
        }
        // 向二分搜索树中添加新的元素(key, value)
        @Override
        public void add(K key, V value){
            root = add(root, key, value);
        }
        // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
        // 返回插入新节点后二分搜索树的根
        private Node add(Node node, K key, V value){
            if (node == null){
                size++;
                return new Node(key,value);
            }
            if(key.compareTo(node.key) < 0)
                node.left = add(node.left, key, value);
            else if(key.compareTo(node.key) > 0)
                node.right = add(node.right, key, value);
            else // key.compareTo(node.key) == 0
                node.value = value;

            return node;
        }


        @Override
        public boolean contains(K key){
            return getNode(root, key) != null;
        }

        @Override
        public V get(K key){

            Node node = getNode(root, key);
            return node == null ? null : node.value;
        }

        @Override
        public void set(K key, V newValue){
            Node node = getNode(root, key);
            if(node == null)
                throw new IllegalArgumentException(key + " doesn't exist!");

            node.value = newValue;
        }

        // 返回以node为根的二分搜索树的最小值所在的节点
        private Node minimum(Node node){
            if(node.left == null)
                return node;
            return minimum(node.left);
        }

        // 删除掉以node为根的二分搜索树中的最小节点
        // 返回删除节点后新的二分搜索树的根
        private Node removeMin(Node node){

            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            node.left = removeMin(node.left);
            return node;
        }

        // 从二分搜索树中删除键为key的节点
        @Override
        public V remove(K key){

            Node node = getNode(root, key);
            if(node != null){
                root = remove(root, key);
                return node.value;
            }
            return null;
        }

        private Node remove(Node node, K key){

            if( node == null )
                return null;

            if( key.compareTo(node.key) < 0 ){
                node.left = remove(node.left , key);
                return node;
            }
            else if(key.compareTo(node.key) > 0 ){
                node.right = remove(node.right, key);
                return node;
            }
            else{   // key.compareTo(node.key) == 0

                // 待删除节点左子树为空的情况
                if(node.left == null){
                    Node rightNode = node.right;
                    node.right = null;
                    size --;
                    return rightNode;
                }

                // 待删除节点右子树为空的情况
                if(node.right == null){
                    Node leftNode = node.left;
                    node.left = null;
                    size --;
                    return leftNode;
                }

                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;

                return successor;
            }
        }

    }
}
