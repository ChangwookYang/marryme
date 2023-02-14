DROP TABLE IF EXISTS `plan_comment`;

create table `plan_comment` (
  `id` bigint not null auto_increment,
  `content` varchar(255),
  `created_at` datetime(6),
  `created_by` varchar(255),
  `modified_at` datetime(6),
  `modified_by` varchar(255),
  `plan_id` bigint,
  primary key (id)
) engine=InnoDB;

LOCK TABLES `plan_comment` WRITE;

UNLOCK TABLES;
