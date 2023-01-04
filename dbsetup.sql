CREATE TABLE IF NOT EXISTS `invsaver_inventories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `savedby` varchar(100) NOT NULL,
  `savedat` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifiedby` varchar(100) DEFAULT NULL,
  `modifiedat` timestamp NULL DEFAULT NULL,
  `deletedby` varchar(100) DEFAULT NULL,
  `deletedat` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;