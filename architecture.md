# Key Concepts in System Design

## Server

A server is a never-ending process running on a computer that provides resources, data, services, or programs to other computers, known as clients, over a network.

## Client

Anyone requesting a piece of information or data is called a client. Usually, they request it from the server.

## Latency

- **Definition**: The time to do work.
- Also known as **Round Trip Time (RTT)**.

## Throughput

- **Definition**: The amount of work done per unit time.
- Represents the number of requests served per unit time.

### Why Measure Throughput?

1. **Performance Evaluation**.
2. **Capacity Planning**.
3. **Identifying Bottlenecks**.

### How to Improve Throughput?

- **Relation**: Reducing latency increases throughput.
- **Techniques**:
  1. Scaling.
  2. Optimized Code.
  3. Caching.
  4. Network Optimization.
  5. Parallel Processing.

## Consistency

A system is considered **consistent** if multiple queries to it return the same data.

## Availability

A system is said to be **available** if it returns some response, even if the response is an error or inconsistent data.

- **Measure**: Availability is measured in terms of "9s".
  - Example: **99% availability** implies a downtime of approximately 3.65 days per year.

## Reliability

- Defined as:
  - Reliability = 1 - P(failure)
- **High Reliability**: Implies fewer failures and better availability.
- **Key Point**: High availability does not always guarantee high reliability.

### Eventual Consistency

- In distributed systems, the system may not always return consistent data immediately.
- Over time, given no new updates, all nodes will eventually become consistent.

### Fault Tolerance

- The ability of a system to continue functioning even when one or more components fail.
- Achieved through redundancy, replication, and error handling mechanisms.

## Monolithic Architecture

A system where there is a single codebase, and every piece of code runs on the same machine. All services are grouped together.

### Example

A web application where:

- Front-end,
- Back-end,
- Database,  
  ... are all hosted together.

### Advantages/Use Cases

1. **Early-stage Development**:
   - When starting to build an application and the requirements are not clear, monolithic architecture is a good choice.
2. **Latency Sensitive Applications**:
   - Network communication is time-consuming. A monolithic app is faster for such use cases.
3. **Cost-Effective**:
   - Easier to secure and less expensive. _(Example: Tesla)_
4. **Simplified Testing**:
   - Fixed boundaries make it easier to test functionality and integration.

### Challenges

1. **Scaling Complexity**:
   - Horizontal scaling may lead to resource wastage for certain applications. _(Example: Read-heavy apps)_
2. **Single Repository**:
   - Developers are dependent on each other, leading to:
     - Less Flexibility.
     - Human Conflicts.
     - Slower Time to Production.
3. **Unified Tech Stack**:
   - Example: A monolithic app using Java on the backend and React on the frontend would face challenges as they must be deployed together.
4. **Deployment Downtime**:
   - Changing one line of CSS requires redeploying the entire app, increasing system downtime.
5. **Single Point of Failure**:
   - Failure in one component can bring down the entire application.

## Service-Oriented Architecture (SOA)

A design paradigm that emphasizes making systems granular by dividing services.

### Advantages/Use Cases

1. **Selective Scaling**:
   - Scale specific services independently.
2. **Flexible Tech Stack**:
   - Use the most suitable technologies for each service.
3. **Loosely Coupled Services**:
   - High flexibility, reduced time to production.
4. **Isolated Changes**:
   - Updates to one service do not affect others.
5. **No Single Point of Failure**.

### Challenges

1. **Increased Latency**:
   - Communication over the network adds latency.
2. **Complex Security**:
   - Maintaining integrity is more complex and expensive.
3. **Testing Complexity**:
   - Testing distributed systems is significantly harder. _(Example: Instagram testing by Facebook)_

## Microservices

A more granular and stricter version of SOA. In microservices:

- Each service must have its own resources.
- Services cannot share databases or resources.

### Challenges

1. **Expense**:
   - The inability to share resources increases costs.
