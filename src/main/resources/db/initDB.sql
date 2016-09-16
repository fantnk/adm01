# CREATE SCHEMA IF NOT EXISTS `adm01`;
DROP TABLE IF EXISTS traffic;
DROP TABLE IF EXISTS subscriber;

CREATE TABLE subscriber (
  `id`            INT(11) NOT NULL,
  `account_number` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;
CREATE UNIQUE INDEX subscriber_unique_accountnumber_idx ON subscriber (account_number);

CREATE TABLE traffic (
  `id`            INT(11)  NOT NULL,
  `date`          DATETIME NOT NULL DEFAULT now(),
  `subscriber_id` INT(11)  NOT NULL,
  `uplink`        INT(11)  NOT NULL DEFAULT 0,
  `downlink`      INT(11)  NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  FOREIGN KEY (subscriber_id) REFERENCES subscriber (id)
    ON DELETE CASCADE
)
  ENGINE = InnoDB;
CREATE UNIQUE INDEX traffic_subscriber_date_idx ON traffic(subscriber_id, date)