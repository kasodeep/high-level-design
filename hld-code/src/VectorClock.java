import java.util.HashMap;
import java.util.Map;

/**
 * To resolve inconsistencies in distributed systems, we implement a Vector Clock.
 * A Vector Clock is a data structure that helps to determine the partial ordering of events
 * in a distributed system. Each node maintains its own vector clock, which is a map from
 * node identifiers to integer counters.
 */
class VectorClock {
    private final Map<String, Integer> clock;

    public VectorClock() {
        this.clock = new HashMap<>();
    }

    // Increment the vector clock for a given node.
    public void increment(String nodeId) {
        clock.put(nodeId, clock.getOrDefault(nodeId, 0) + 1);
    }

    // Merge another vector clock into this one.
    public void merge(VectorClock other) {
        for (Map.Entry<String, Integer> entry : other.clock.entrySet()) {
            String node = entry.getKey();
            int timestamp = entry.getValue();
            clock.put(node, Math.max(clock.getOrDefault(node, 0), timestamp));
        }
    }

    // Compare two vector clocks
    public String compare(VectorClock other) {
        boolean greater = false, lesser = false;

        for (String node : clock.keySet()) {
            int thisValue = clock.getOrDefault(node, 0);
            int otherValue = other.clock.getOrDefault(node, 0);

            if (thisValue > otherValue) greater = true;
            else if (thisValue < otherValue) lesser = true;
        }

        for (String node : other.clock.keySet()) {
            if (!clock.containsKey(node) && other.clock.get(node) > 0) lesser = true;
        }

        if (greater && !lesser) return "Happened After";
        if (lesser && !greater) return "Happened Before";
        if (greater) return "Concurrent";
        return "Identical";
    }

    @Override
    public String toString() {
        return clock.toString();
    }

    public static void main(String[] args) {
        VectorClock vc1 = new VectorClock();
        vc1.increment("A");
        vc1.increment("A");

        VectorClock vc2 = new VectorClock();
        vc2.increment("B");

        System.out.println("VC1: " + vc1); // {A=2}
        System.out.println("VC2: " + vc2); // {B=1}

        System.out.println("Comparison: " + vc1.compare(vc2)); // Concurrent

        vc2.merge(vc1);
        System.out.println("Merged VC2: " + vc2); // {A=2, B=1}
    }
}
