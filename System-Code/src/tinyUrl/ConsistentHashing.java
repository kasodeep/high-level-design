package tinyUrl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A distributed system like Redis Cluster consists of multiple shards, each assigned to a node.
 * Managing data distribution across these nodes efficiently is a critical challenge.
 *
 * <h2>Problem Statement</h2>
 * <ul>
 *   <li><b>Node Management:</b> Dynamically adding or removing nodes without excessive data migration.</li>
 *   <li><b>Uneven Distribution:</b> Handling data skew due to poor hash functions or non-uniform key distribution.</li>
 * </ul>
 *
 * <h2>Consistent Hashing</h2>
 * <p>
 * Consistent hashing is a widely used technique in distributed systems to efficiently distribute keys
 * or data elements across multiple nodes. Its primary objective is to minimize the number of remapping
 * required when nodes are added or removed, ensuring system stability and reliability.
 * </p>
 *
 * <h3>How It Works</h3>
 * <ul>
 *   <li>The hash function’s output space is treated as a circular space, forming a <b>hash ring</b>.</li>
 *   <li>The IP address of a node is hashed to determine its position on the hash ring.</li>
 *   <li>A data object’s key is also hashed to locate its position on the hash ring.</li>
 *   <li>Each node is assigned multiple positions on the hash ring using distinct hash functions,
 *       ensuring a more uniform distribution of keys. This technique is known as <b>virtual nodes</b>
 *       and helps handle heterogeneity in the system.</li>
 * </ul>
 *
 * <h3>Benefits of Consistent Hashing</h3>
 * <ul>
 *   <li>Reduces key remapping when nodes are added or removed.</li>
 *   <li>Balances data distribution more effectively using virtual nodes.</li>
 *   <li>Enhances fault tolerance by distributing load more evenly.</li>
 * </ul>
 */
public class ConsistentHashing {

    private final TreeMap<Integer, String> hashRing = new TreeMap<>();

    private final HashMap<String, String> dataPointToNode = new HashMap<>();

    private final int numVirtualNodes;

    public ConsistentHashing(int numVirtualNodes) {
        this.numVirtualNodes = numVirtualNodes;
    }

    public void addNode(String node) {
        for (int i = 0; i < numVirtualNodes; i++) {
            String virtualNode = node + "-" + i;
            int hash = getHash(virtualNode);
            hashRing.put(hash, virtualNode);

            for (Map.Entry<String, String> entry : dataPointToNode.entrySet()) {
                String dataPoint = entry.getKey();
                if (getNode(dataPoint).equals(node)) {
                    dataPointToNode.put(dataPoint, node);
                }
            }
        }
    }

    public void removeNode(String node) {
        for (int i = 0; i < numVirtualNodes; i++) {
            String virtualNode = node + "-" + i;
            int hash = getHash(virtualNode);
            hashRing.remove(hash);

            for (Map.Entry<String, String> entry : dataPointToNode.entrySet()) {
                String dataPoint = entry.getKey();
                if (entry.getValue().equals(node)) {
                    String newNode = getNode(dataPoint);
                    dataPointToNode.put(dataPoint, newNode);
                }
            }
        }
    }

    public String getNode(String dataPoint) {
        int hash = getHash(dataPoint);
        Map.Entry<Integer, String> entry = hashRing.ceilingEntry(hash);

        if (entry == null) {
            return hashRing.firstEntry().getValue();
        }
        return entry.getValue();
    }

    private int getHash(String key) {
        return key.hashCode();
    }

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing(1);

        consistentHashing.addNode("Node1");
        consistentHashing.addNode("Node2");
        consistentHashing.addNode("Node3");

        consistentHashing.dataPointToNode.put("Data1", consistentHashing.getNode("Data1"));
        consistentHashing.dataPointToNode.put("Data2", consistentHashing.getNode("Data2"));
        consistentHashing.dataPointToNode.put("Data3", consistentHashing.getNode("Data3"));

        String dataPoint = "Data1";
        String node = consistentHashing.dataPointToNode.get(dataPoint);
        System.out.println("Data point " + dataPoint + " is assigned to node: " + node);

        consistentHashing.removeNode("Node2");

        for (Map.Entry<String, String> entry : consistentHashing.dataPointToNode.entrySet()) {
            String dp = entry.getKey();
            String n = consistentHashing.dataPointToNode.get(dp);
            System.out.println("After removing a node, data point " + dp + " is assigned to node: " + n);
        }
    }
}
