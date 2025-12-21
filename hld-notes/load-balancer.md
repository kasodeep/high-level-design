# Load Balancer

## Overview

- **Purpose**: Manages traffic distribution in a horizontally scaled architecture.
- **Why Needed**: Each machine has its own IP address, which clients are unaware of. The load balancer acts as an intermediary to route client requests to available machines.

## Types of Load Balancers

### **Layer 4 Load Balancer**

- Operates at the **transport layer**.
- Decides the machine based on the **IP address** of the machines.

### **Layer 7 Load Balancer**

- Operates at the **application layer**.
- Uses request-specific data (e.g., URL or headers) to determine the machine to handle the request.
- **Example**: A machine hosting video resources handles video requests.

### **Hardware Load Balancer**

- **Characteristics**:
  - Physical device with dedicated resources.
  - Highly secure and supports encryption.
  - Handles high loads effectively.
- **Drawbacks**:
  - Expensive as they are purpose-built.
- **Example**: AWS Elastic Load Balancer (ELB).

### **Software Load Balancer**

- **Characteristics**:
  - Flexible and can be reconfigured as needed.
  - Resources are shared (e.g., Docker containers).
  - Cost-effective solution.

## Active & Passive Redundancy

- **Purpose**: Prevents single points of failure.
- **Setup**:
  - **Active**: Primary load balancer handling requests.
  - **Passive**: Backup load balancer that takes over if the active fails.

## Load Balancing Algorithms

### 1. **Round Robin**

- Sequentially assigns requests to machines.
- Cycles back to the first machine after the last.

### 2. **Least Connection**

- Routes requests to the machine with the fewest active connections.

### 3. **Least Response Time**

- Selects the machine with the shortest response time.
- As the selected machine's latency increases, the algorithm dynamically shifts to a faster one.

### 4. **Weighted Round Robin**

- Assigns requests based on machine capacity.
- **Example**:
  - A machine with 32GB RAM gets 2x requests compared to one with 16GB RAM.

### 5. **Sticky Load Balancing**

- Ensures repeat requests from the same user are directed to the same machine.
