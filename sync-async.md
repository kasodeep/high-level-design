# Synchronous (Blocking) Systems

- **Definition**: Processes must complete in the `order` they arrive. The next request starts only after the `current` request completes.

### **Use Cases**

1. **Rate of Acceptance = Rate of Creation**: Example: Two systems capable of 50 requests/sec communicating over a network.
2. **Transaction Processing**: Example: BookMyShow must process payments before deducting inventory and confirming a seat.
3. **Order of Execution**: Tasks requiring strict sequential execution.

### **Challenges**

1. **Wait Time**: Threads remain idle while waiting, reducing resource utilization.
2. **Queue Overload**: If requests exceed server capacity, cascading failures can occur.

# Asynchronous (Non-Blocking) Systems

- **Definition**: After sending a request, the client can perform other tasks while the `operation` completes in the background.

### **Use Cases**

1. **Throughput Mismatch**: Handles varying rates of request creation and processing.

### **Advantages**

1. **Scalability**: Allows the application to handle higher loads efficiently.

## Implementation of Asynchronous Systems

### 1. **Callback Approach**

- Uses `callback` functions to handle responses once the background operation completes.

### 2. **Message Queues**

- **Definition**: Queues hold, deliver, and manage asynchronous messages.
- **Workflow**:
  1. Application publishes a job to the queue and notifies the user of its status.
  2. A worker picks up the job, processes it, and marks it complete.
  3. User is not blocked; the task runs in the background.

#### **Types**

1. **P2P (Point-to-Point)**: Communication between two specific systems.
2. **Broadcasting**: Data sent to multiple subscribers simultaneously.

# Popular Queues

### 1. **Redis**

- Simple message broker.
- **Drawback**: Messages can be lost.

### 2. **RabbitMQ**

- Implements the **AMQP protocol**.
- Requires node management.

### 3. **Kafka**

- Supports both **P2P** and **Broadcasting**.
- **Features**:
  1. Guarantees ordered message delivery.
  2. No message loss with configurable data persistence.

**Analogy**: Producer, Consumer, Topic → Offset.

## Back Pressure

- **Definition**: When a queue is full and throughput decreases, the system may respond with **503 errors** until existing messages are processed.
