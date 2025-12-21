# Back of the Envelope Calculations

## Data Units

- **Bytes**:
  - 1 byte = 8 bits
  - 1 ASCII character = 1 byte
- **Storage Conversions**:
  - 1 KB = \(10^3\) bytes = 1024 bytes
  - 1 MB = \(10^6\) bytes = \(10^3\) KB
  - 1 GB = \(10^9\) bytes = \(10^3\) MB
  - 1 TB = \(10^{12}\) bytes = \(10^3\) GB
  - 1 PB = \(10^{15}\) bytes = \(10^3\) TB

## Time Units

- **Conversions**:
  - 1 second (s) = \(10^3\) milliseconds (ms)
  - 1 ms = \(10^3\) microseconds (µs)
  - 1 µs = \(10^3\) nanoseconds (ns)
  - Therefore:
    - 1 s = \(10^6\) µs = \(10^9\) ns

## Common Execution Times

- **Main Memory (RAM)**: 100 ns
- **L1 Cache**: 0.5 ns (fast, low space)
- **L2 Cache**: 7 ns (slower, more space)

## Reading Sequential Data (1 MB)

1. **Main Memory (RAM)**: 250 µs
2. **Network**: 10 ms
3. **Disk**: 30 ms

## Availability

- **99% Availability**:
  - Downtime = 3.65 days/year
- **99.9% Availability**:
  - Downtime = 0.365 days/year

## Question: Queries Per Second (QPS)

### Given Data:

- Daily Active Users (DAU) = 150 million
- Average posts per user per day = 2

## Observations

- High QPS requires robust horizontal scaling with caching to optimize performance.
- Network bandwidth and storage must scale proportionally with user growth.
- Reliable monitoring tools are critical to handle peak QPS effectively.
