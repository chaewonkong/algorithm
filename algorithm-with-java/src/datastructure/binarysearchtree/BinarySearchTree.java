package datastructure.binarysearchtree;

import java.util.Comparator;

public class BinarySearchTree<K, V> {
    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Comparator<? super K> comparator) {
        this(); // 위에 있는 생성자 호출. root = null인 이진 검색트리 생성
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        if (comparator == null) {
            Comparable<K> comparable = (Comparable<K>) key1;
            return comparable.compareTo(key2);
        }

        return comparator.compare(key1, key2);
    }

    /**
     * node를 루트로 하는 서브트리에 Node<K, V>를 삽입. 재귀호출 활용
     *
     * @param node 서브트리의 root
     * @param key  넣으려는 값의 key
     * @param data 넣으려는 값의 value
     */
    private void addNode(Node<K, V> node, K key, V data) {
        int comparedRes = comp(key, node.getKey());

        if (comparedRes == 0) {
            // 이미 node가 존재함.
            return;
        }

        // 루트의 왼쪽에 삽입하는 경우
        if (comparedRes < 0) {
            if (node.getLeft() == null) {
                // 루트의 left가 없다면 삽입 진행
                node.setLeft(new Node<>(key, data, null, null));
            } else {
                // 해당 노드에게 자식 노드가 있다면 재귀적으로 탐색을 진행
                addNode(node.getLeft(), key, data);
            }
        } else { // 루트의 오른쪽에 삽입하는 경우
            if (node.getRight() == null) {
                // 루트의 right가 없다면 삽입 진행
                node.setRight(new Node<>(key, data, null, null));
            } else {
                // 해당 노드에게 자식 노드가 있다면 재귀적으로 탐색을 진행
                addNode(node.getRight(), key, data);
            }
        }
    }

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }


    public V search(K key) {
        Node<K, V> node = root;
        while (true) {
            if (node == null) { // 더 이상 검색할 수 없으면 검색을 종료 (찾기 실패)
                return null;
            }
            int comparedRes = comp(key, node.getKey());

            if (comparedRes == 0) {
                return node.getData();
            }

            if (comparedRes < 0) { // 트리의 좌측 서브트리에서 탐색 진행
                node = node.getLeft();
            } else { // 트리의 우측 서브트리에서 탐색 진행
                node = node.getRight();
            }
        }
    }

    public boolean remove(K key) {
        Node<K, V> node = root;
        Node<K, V> parent = node;
        boolean isLeftChild = true;

        // key 값을 기준으로 검색 진행
        while (true) {
            if (node == null) { // 더 이상 검색할 수 없으면 검색을 종료 (찾기 실패)
                return false;
            }

            int comparedRes = comp(key, node.getKey());
            if (comparedRes == 0) {
                break;
            }

            parent = node;
            if (comparedRes < 0) { // 트리의 좌측 서브트리에서 탐색 진행
                isLeftChild = true;
                node = node.getLeft();
            } else { // 트리의 우측 서브트리에서 탐색 진행
                isLeftChild = false;
                node = node.getRight();
            }
        }


        // 삭제 진행
        if (node.getLeft() == null) { // node가 leftchild를 가지지 않는 경우
            if (node == root) {
                root = node.getRight();
            } else if (isLeftChild) {
                parent.setLeft(node.getRight());
            } else {
                parent.setRight(node.getRight());
            }
        } else if (node.getRight() == null) { // node가 rightchild를 가지지 않는 경우
            if (node == root) {
                root = node.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(node.getLeft());
            } else {
                parent.setRight(node.getLeft());
            }
        } else { // node가 leftchild와 rightchild를 모두 가질 경우
            parent = node;
            Node<K, V> left = node.getLeft();
            isLeftChild = true;

            // 왼쪽 서브트리 가운데 가장 큰 노드 탐색
            while (left.getRight() != null) {
                parent = left;
                left = left.getRight();
                isLeftChild = false;
            }

            // parent에 node가 참조되고 있어 node의 값이 바뀌면 parent의 값도 바뀐다.
            node.setKey(left.getKey());
            node.setData(left.getData());

            if (isLeftChild) {
                parent.setLeft(left.getLeft());
            } else {
                parent.setRight(left.getLeft());
            }
        }
        return true;
    }

    private void printByOrderAsc(Node<K, V> node) {
        if (node != null) {
            printByOrderAsc(node.getLeft());
            System.out.println(node.getKey() + " : " + node.getData());
            printByOrderAsc(node.getRight());
        }
    }

    public void printByOrderAsc() {
        printByOrderAsc(root);
    }
}
