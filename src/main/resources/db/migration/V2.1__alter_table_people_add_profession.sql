alter table people add column profession_id int not null;
alter table people
    add constraint fk_people_profession
    foreign key (profession_id) references professions (id);