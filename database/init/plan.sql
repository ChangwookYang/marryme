DROP TABLE IF EXISTS `plan`;

create table `plan` (
    `id` bigint not null auto_increment,
    `content` varchar(255),
    created_at datetime(6),
    created_by varchar(255),
    hashtag varchar(255),
    modified_at datetime(6),
    modified_by varchar(255),
    title varchar(255),
    primary key (id)
) engine=InnoDB;

LOCK TABLES `plan` WRITE;

insert into plan (content, created_at, created_by, hashtag, modified_at, modified_by, title) values
('테스트', '2022-03-01 00:00:00', 'cw', 'test', '2022-03-01 00:00:00', 'cw', 'title'),
('테스트22', '2022-03-01 00:00:00', 'cw', 'test', '2022-03-01 00:00:00', 'cw', 'title');

UNLOCK TABLES;