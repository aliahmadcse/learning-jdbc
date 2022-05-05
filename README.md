# Order of operations

These commands are for linux/Mac, changes will need to made if you are running this in Microsoft Windows.

## Prerequisites

Docker is installed psql client is installed

## Actions

### Running PostgreSQL

1. Pull Docker Image
   `docker pull postgres`

2. Create Volume Using:
   `docker volume create postgres-volume`

3. Run docker image
   `docker run --name lil-postgres -e POSTGRES_PASSWORD=password -d -v postgres-volume:/var/lib/postgresql/data -p 5432:5432 postgres`

### Stopping PostgreSQL

`docker pull postgres:13.6-alpine3.15`

### Logging into Database

* `psql -h localhost -U postgres -d hplussport`

### Creating starter data

1. `psql -h localhost -U postgres -f database.sql`
2. `psql -h localhost -U postgres -d hplussport -f customer.sql`
3. `psql -h localhost -U postgres -d hplussport -f product.sql`
4. `psql -h localhost -U postgres -d hplussport -f salesperson.sql`
5. `psql -h localhost -U postgres -d hplussport -f orders.sql`
6. `psql -h localhost -U postgres -d hplussport -f stored_proc.sql`

### Creating starter data Using pgcli

1. `pgcli -h localhost -U postgres`
2. Select database to use `use hplussport`
3. Once you are into the server, run for each sql file in `resources/schema`, Run `\i filename.sql`
