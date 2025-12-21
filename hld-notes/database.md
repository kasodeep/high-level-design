# Database Concepts

## Database

- A **physical layer** where data is stored in memory.

## File-Based Systems

- Early systems stored data directly in files and used programming languages for manipulation.

### Challenges:

1. **Data Redundancy**:
   - CRUD anomalies due to duplicate or outdated data.
   - Example: Multiple entries for "Raul" returning inconsistent results.
2. **Security Issues**:
   - Security was reliant on the OS, with no additional authentication layers.
3. **Ease of Use**:
   - Complex programming languages made these systems difficult for non-technical users.

## Database Management Systems (DBMS)

- A **management layer** around the database that simplifies interaction using SQL.
- Provides **security** and **authentication** to control access to the data.

### Examples:

- MySQL, Oracle, MongoDB.

## Relational Database Management System (RDBMS)

- Entities are represented as **tables** with **attributes** (nouns).
- Relationships between entities are defined using **foreign keys** (verbs).

### SQL Systems: Key Features

#### 1. Normalization:

- Ensures that:
  - Each entity has a separate table.
  - Reduces redundancy.
  - Example: **1NF**, **2NF**, **3NF**, **BCNF**.

#### 2. Transactions:

- A sequence of operations performed on the database, following **ACID properties**:
  - **Atomicity**: All or nothing.
  - **Consistency**: Transitions the database from one valid state to another.
  - **Isolation**: Concurrent transactions produce the same result as serial execution.
  - **Durability**: Changes persist even after system failure.

### Use Cases:

1. **Structured Data**.
2. **Fixed Schema**.
3. **Transactional Requirements**.

### Challenges:

1. **Tables**: Only structured data with fixed columns allowed.
2. **Joins**: Expensive when performed over a network.
3. **Scalability Issues**: Performance decreases when tables are distributed across machines.

### Replication Strategies:

#### 1. Master-Slave Replication:

- **Master**:
  - Handles write operations.
  - Replicates data to slaves.
- **Slaves**:
  - Handle read operations.
- **Failure Handling**:
  - Promote a slave to master if the master fails.

#### 2. Master-Master Replication:

- All nodes are masters and replicate data among themselves.
- Requires:
  - A load balancer.
  - Synchronization logic.
- **Trade-offs**:
  - Either violate ACID or incur increased write latency.

## NoSQL Databases

- Described by **BASE** principles:
  1. **Basically Available**: Always accessible.
  2. **Soft State**: State evolves over time without input.
  3. **Eventual Consistency**: System becomes consistent over time.

### Types:

1. **Key-Value Stores**:

   - Example: **Redis**.
   - **Advantages**: O(1) response time for key lookups.
   - **Use Case**: Cache databases.

2. **Document Databases**:

   - Example: **MongoDB**.
   - Combines transactions and schema flexibility.
   - Allows dynamic schema and efficient scaling.
   - RDBMS vs Document DB Mapping:
     - **Tables** → **Collections**.
     - **Rows** → **Documents**.
     - **Columns** → **Fields**.

3. **Columnar Databases**:

   - Example: **Cassandra**.
   - Data stored by **columns** instead of rows.
   - **Advantages**:
     - Fast aggregation.
     - Better compaction.
     - High performance for large-scale read/write.

4. **Graph Databases**:
   - Example: **Neo4J**.
   - Ideal for complex and hierarchical relationships.
   - Still evolving.

## Database Optimizations

### 1. Indexing:

- Creates **B-trees** for filtering columns.
- **Advantages**:
  - Improves read performance.
- **Disadvantages**:
  - Increases space requirements.
  - Degrades performance for write-heavy applications.

### 2. Partitioning/Sharding:

- **Partitioning**:
  - Splits a table into smaller parts to store on a single machine.
- **Sharding**:
  - Distributes partitions across multiple machines.

#### Types:

1. **Range-Based Partitioning**:
   - Example: Divide 24-hour sales data into ranges like 0-6, 6-16, 16-24.
2. **List-Based Partitioning**:
   - Example: Separate entries based on PIN codes.
3. **Hash-Based Partitioning**:
   - Fix the number of partitions and apply a hashing function to distribute data.
