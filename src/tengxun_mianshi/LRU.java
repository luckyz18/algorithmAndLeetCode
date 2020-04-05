package tengxun_mianshi;

import java.util.Map;

public class LRU<K, V> {
    private DoubleNodeList nodeList;
    private int capacity;
    Map<K, Node<V>> keyNodeMap;
    Map<Node<V>, K> nodeKeyMap;

    public LRU(DoubleNodeList nodeList, int capacity, Map<K, Node<V>> keyNodeMap, Map<Node<V>, K> nodeKeyMap) {
        this.nodeList = nodeList;
        this.capacity = capacity;
        this.keyNodeMap = keyNodeMap;
        this.nodeKeyMap = nodeKeyMap;
    }

    public V get(K key) {
        if (keyNodeMap.containsKey(key)) {
            Node<V> node = keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(node);
            return node.value;
        }
        return null;
    }

    public void set(K key, V value) {
        if (keyNodeMap.containsKey(key)) {
            //更新  移到尾部
            Node node = keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);

        } else {
            //添加新节点  移到尾部  判断是否需要过期数据
            Node newNode = new Node<>(value);
            this.nodeList.addNodeToTail(newNode);
            keyNodeMap.put(key, newNode);
            nodeKeyMap.put(newNode, key);
            if (this.keyNodeMap.size() == this.capacity + 1) {
                removeUnusedNode();
            }
        }
    }

    private void removeUnusedNode() {
        Node removeNode = this.nodeList.removeHead();
        K removeKey = this.nodeKeyMap.get(removeNode);
        this.keyNodeMap.remove(removeKey);
        this.keyNodeMap.remove(removeNode);
    }

}
