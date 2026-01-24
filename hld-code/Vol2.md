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