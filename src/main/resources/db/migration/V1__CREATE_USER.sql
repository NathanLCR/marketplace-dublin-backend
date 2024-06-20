CREATE TABLE "olx_user" (
  id INTEGER NOT NULL,
   full_name VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   active BOOLEAN,
   created_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "olx_user" ADD CONSTRAINT uc_user_email UNIQUE (email);