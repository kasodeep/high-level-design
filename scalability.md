# Key Concepts in Data Management and System Design

## Data

With the humongous amount of data generated today, its storage and computation have become increasingly complex. Storage and computation are the fundamental operations we perform on data.

---

## Scaling

### Vertical Scaling

- A strategy of adding more resources (RAM, CPU, storage) to a single machine to meet increased demand.

#### Problems

1. **Performance Ceiling**: Performance improvements diminish beyond a certain point.
2. **Single Point of Failure**: If the machine fails, the entire system goes down.
3. **Hardware Limitations**: Physical limits to increasing RAM, storage, and CPU capacity.

---

### Horizontal Scaling / Distributed Systems

- Involves connecting multiple machines over a network to form a cluster that works together to meet growing demands.

#### Challenges

1. **Network Partitioning**: A machine gets disconnected from the network, leading to incomplete or delayed data access.

#### Solutions

- **Data Replication**: Copy data to multiple machines to avoid data loss.
  - However, this introduces **consistency challenges**, as the system may take time to synchronize and become consistent.

---

## CAP Theorem

The **CAP Theorem** states that a distributed system cannot simultaneously guarantee all three of the following:

1. **C**: **Consistency**
   - Every read receives the most recent write or an error.
2. **A**: **Availability**
   - Every request receives a non-error response, without guaranteeing the most recent data.
3. **P**: **Partition Tolerance**
   - The system continues to function despite network partitions.

### Practical Implications

In modern applications, **Partition Tolerance** is non-negotiable, as network partitions are inevitable. Therefore, a trade-off must be made between:

- **Consistency** and **Availability**.

---

## Example Scenario

Suppose we have an application with a server capacity of 500 GB. If the app becomes popular, additional storage must be added to avoid data loss.

- **Vertical Scaling**: Upgrade the existing server with more storage and RAM.
- **Horizontal Scaling**: Add more servers and distribute the data among them.

### Real-World Application:

- **Consistency Preference**:
  - Banking Systems: Transactions must be accurate and consistent.
- **Availability Preference**:
  - Social Media Platforms: A slightly outdated feed is acceptable as long as the platform remains operational.

---
