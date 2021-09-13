# Order of operations

These commands are for linux/Mac, changes will need to made if you are running this in Microsoft Windows.

## Prerequisites

Docker is installed psql client is installed

## Actions

### Running PostgreSQL

1. Pull Docker Image
   `docker pull postgres`

2. Create Volume Named:
   `postgres-volume`

3. Run docker image
   `docker run --name lil-postgres -e POSTGRES_PASSWORD=password -d -v postgres-volume:/var/lib/postgresql/data -p 5432:5432 postgres`

### Stopping PostgreSQL

`docker stop lil-postgres`

### Logging into Database

* `psql -h localhost -U postgres -d hplussport`

### Creating starter data

1. `psql -h localhost -U postgres -f database.sql`
2. `psql -h localhost -U postgres -d hplussport -f customer.sql`
3. `psql -h localhost -U postgres -d hplussport -f product.sql`
4. `psql -h localhost -U postgres -d hplussport -f salesperson.sql`
5. `psql -h localhost -U postgres -d hplussport -f orders.sql`
