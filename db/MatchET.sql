use matchet

/* create leagues table */
create table `leagues` (
  `id` int(11) not null auto_increment,
  `name` varchar(30) not null,
  `short_description` varchar(255) not null,
  primary key (`id`)
) engine=innodb auto_increment=5 default charset=utf8;

/* create teams table */
create table `teams` (
  `id` int(11) not null auto_increment,
  `name` varchar(30) not null,
  `short_name` varchar(3) not null,
  `league_id` int(11) not null,
  primary key (`id`),
  key `teams_fk_league` (`league_id`),
  constraint `teams_fk_league` foreign key (`league_id`) references `leagues` (`id`)
) engine=innodb auto_increment=8 default charset=utf8

/* create matches table */
create table `matches` (
  `id` int(11) not null auto_increment,
  `league_id` int(11) not null,
  `home_team_id` int(11) not null,
  `away_team_id` int(11) not null,
  `match_date` date not null,
  `match_hour` int(2) not null,
  `match_minutes` int(2) not null,
  `home_team_goals` int(2) not null,
  `away_team_goals` int(2) not null,
  primary key (`id`),
  key `matches_fk_league` (`league_id`),
  key `matches_fk_home_team` (`home_team_id`),
  key `matches_fk_away_team` (`away_team_id`),
  constraint `matches_fk_away_team` foreign key (`away_team_id`) references `teams` (`id`),
  constraint `matches_fk_home_team` foreign key (`home_team_id`) references `teams` (`id`),
  constraint `matches_fk_league` foreign key (`league_id`) references `leagues` (`id`)
) engine=innodb auto_increment=4 default charset=utf8