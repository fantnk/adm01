DROP TABLE IF EXISTS traffic;
DROP TABLE IF EXISTS subscriber;

CREATE TABLE subscriber (
  id             INTEGER NOT NULL,
  account_number INTEGER NOT NULL,
  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX subscriber_unique_accountnumber_idx
  ON subscriber (account_number);

CREATE TABLE traffic (
  id            INTEGER   NOT NULL,
  date          TIMESTAMP NOT NULL DEFAULT now(),
  subscriber_id INTEGER   NOT NULL,
  uplink        INTEGER   NOT NULL DEFAULT 0,
  downlink      INTEGER   NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (subscriber_id) REFERENCES subscriber (id)
  ON DELETE CASCADE
);

CREATE UNIQUE INDEX id_UNIQUE
  ON traffic (id ASC);
CREATE UNIQUE INDEX traffic_subscriber_date_idx
  ON traffic (subscriber_id, date)