# CREATE SCHEMA IF NOT EXISTS `adm01`;
DROP TABLE IF EXISTS traffic;

CREATE TABLE traffic (
  `id`         INT      NOT NULL,
  `date`       DATETIME NOT NULL DEFAULT NOW(),
  `subscriber` BIGINT   NOT NULL,
  `uplink`     INT      NOT NULL DEFAULT 0,
  `downlink`   INT      NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
  ENGINE = InnoDB