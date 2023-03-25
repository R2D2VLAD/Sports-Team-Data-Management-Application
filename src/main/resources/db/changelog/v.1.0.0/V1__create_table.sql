create table if not exists Sports_teams
(
    id bigserial not null primary key,
    teamname varchar(255) not null,
    sporttype varchar(255) not null,
    yearsoffoundation int not null
);

create table if not exists Sports_teams_members
(
    id bigserial not null primary key,
    id_team int not null,
    lastname varchar(255) not null,
    firstname varchar(255) not null,
    patronymic varchar(255) not null,
    yearsofbirth int not null,
    positionteam varchar(255) not null,
    constraint fk_Sports_teams_members_Sports_teams foreign key (id_team) references Sports_teams (id) on delete cascade on update  no action
);