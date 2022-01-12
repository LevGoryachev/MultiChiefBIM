-- MultiChiefConstruction, version 1.1, syntax: Postgres

CREATE TABLE "construction"(
construction_id BIGSERIAL PRIMARY KEY,
object_code_number VARCHAR(80) NOT NULL,
object_name VARCHAR(80) NOT NULL,
object_description TEXT,
is_linear BOOLEAN NOT NULL DEFAULT false,
UNIQUE (object_code_number),
UNIQUE (object_name),
CHECK (object_name !='')
);

CREATE TABLE "project_type"(
project_type_id BIGSERIAL PRIMARY KEY,
type_name VARCHAR(80) NOT NULL,
UNIQUE (type_name),
CHECK (type_name !='')
);

CREATE TABLE "eir"(
eir_id BIGSERIAL PRIMARY KEY,
eir_code_number VARCHAR(80) NOT NULL,
eir_description TEXT,
link VARCHAR,
UNIQUE (eir_code_number)
);

CREATE TABLE "bim"(
bim_id BIGSERIAL PRIMARY KEY,
project_code_number VARCHAR(80) NOT NULL,
project_name VARCHAR(80) NOT NULL,
lod SMALLINT NOT NULL,
project_type_id BIGINT REFERENCES "project_type"(project_type_id) ON DELETE SET NULL,
eir_id BIGINT REFERENCES "eir"(eir_id) ON DELETE SET NULL,
link VARCHAR,
UNIQUE (project_code_number),
UNIQUE (project_name),
CHECK (project_name !='')
);

CREATE TABLE "estimate"(
estimate_id BIGSERIAL PRIMARY KEY,
estimate_code_number VARCHAR(80) NOT NULL,
link VARCHAR,
UNIQUE (estimate_code_number)
);

CREATE TABLE "site"(
site_id BIGSERIAL PRIMARY KEY,
construction_id BIGINT REFERENCES "construction"(construction_id) ON DELETE CASCADE,
bim_id BIGINT REFERENCES "bim"(bim_id) ON DELETE SET NULL,
estimate_id BIGINT REFERENCES "estimate"(estimate_id) ON DELETE SET NULL
);