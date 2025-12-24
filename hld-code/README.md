## Rate Limiting Algorithms

- Token bucket
- Leaking bucket
- Fixed window counter
- Sliding window log
- Sliding window counter

## Race Condition

1. Lua script or Sorted Set in Redis to handle it efficiently.

## Consistent Hashing

- A technique of virtual nodes is used to solve the problem of `hot or non uniform distribution`.

## Data Partition

- We can use consistent hashing to provide automatic scaling and heteroginity.
- The number of virtual nodes for a server is proportional to the server capacity.

## Consistency

1. Quorum consensus can guarantee consistency for both read and write operations.
2. N = The number of replicas
3. W = A write quorum of size W.
4. R = A read quorum of size R.

```bash
If R = 1 and W = N, the system is optimized for a fast read.
If W = 1 and R = N, the system is optimized for fast write.
If W + R > N, strong consistency is guaranteed (Usually N = 3, W = R = 2).
If W + R <= N, strong consistency is not guaranteed.
```

## Handle Failures

- A better solution is to use decentralized failure detection methods like gossip protocol.

### Handling Temporary Failures

- A technique called `sloppy quorum` is used to improve availability. Instead of enforcing
the quorum requirement, the system chooses the first W healthy servers for writes and first R
healthy servers for reads on the hash ring.
- If a server is unavailable due to network or server failures, another server will process
requests temporarily. When the down server is up, changes will be pushed back to achieve
data consistency. This process is called `hinted handoff.`

### Handling Permanent Failures

- What if a replica is permanently unavailable?
- To handle such a situation, we implement an anti-entropy protocol to keep replicas in sync. - Anti-entropy involves comparing each piece of data on replicas and updating each replica to the newest version. A Merkle tree is used for inconsistency detection and minimizing the amount of data transferred.

### Merkle Trees

- Using Merkle trees, the amount of data needed to be synchronized is proportional to the
differences between the two replicas, and not the amount of data they contain.

### SSTable <Cassandra> <Bloom Filter>

## Unique IDs

### Multi Master Replication

- This approach uses the databases’ auto_increment feature. Instead of increasing the next ID
by 1, we increase it by k, where k is the number of database servers in use.

### UUID

- A UUID is another easy way to obtain unique IDs. UUID is a 128-bit number used to identify
information in computer systems.

### Ticket Server

- Ticket servers are another interesting way to generate unique IDs. Flicker developed ticket
servers to generate distributed primary keys.
- The idea is to use a centralized auto_increment feature in a single database server.

### Twitter Snowflake Approach

#### TimeStamp

- The most important 41 bits make up the timestamp section. As timestamps grow with time, IDs are sortable by time.

## API Design

## Hashing

The hashValue consists of characters from [0-9, a-z, A-Z], containing 10 + 26 + 26 = 62
possible characters. To figure out the length of hashValue, find the smallest n such that 62^n
≥ 365 billion.

### Hash + Collision Rsolution

- To solve the collision problem, we can use in memory Bloom Filter or Guava Bloom Filter.

### Base 62 Conversion
