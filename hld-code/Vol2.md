# Advanced System Design

## Proximity Service

1. When designing a location based service (LBS), there should be data privacy.

### API Design

GET /api/search/nearby
- Defines the parameters, the response codes.

### Data Model

- Read/Write ratio estimations.
- Then, we move the DB Schema.

### Algorithm For Geospatial Search

1. Two Dimensional Search
2. Evenly Divide the Grid
3. Geohash
    - It usually uses base32 representation. Grid [00, 01, 10, 11] -> [00 -> 00, 01, 10, 11]
    - It has 12 precision levels.
    - the length of geohash 1 is the size of the planet. Recursive division by 4.
    - Boundary issues, where in two geohash can be different yet same place.
4. QuadTree
    - In memory solution, to query the grid using tree.
5. Google S2
    - Maps sphere to 1D index based on hilbert curve.

### Deploy

- A Blue/Green deployment strategy minimizes downtime by running two identical production environments, Blue (current) and Green (new); the new version is deployed to Green, thoroughly tested, and once verified, a router instantly switches all live traffic from Blue to Green, allowing for quick rollbacks to Blue if issues occur, all while avoiding user impact.

### Scale

### Cache

## Nearby Friends

- Since, each friend moves from one location to another.
- Redis, Pub/Sub architecture can be used to provides updates.
- We use redis pub/sub for fanout approach, indicating scalibility.

### Load Balancing

- Since, the stateful web sockets provide data, `draining` can be used to load them.

## Google Maps

1. We should have idea about how lat,long and how 3D coordinates maps to 2D coordinates.

### Map Rendering

- The process of tiling, where we send the required tiles depending on zoom levels by the client.
- With `tiles` we have zoom (0) -> 1 tile. Next, when we go from high zoom to low zoom, there is 4x reduction in storage requirements.
- We are essentially storing the tiles, for all the zoom levels.

### WebGL
