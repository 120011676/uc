create or replace function table_create_datetime() returns trigger as
$$
begin
    new.create_datetime = now();
    RETURN new;
end
$$ language plpgsql;
create or replace function table_update_datetime() returns trigger as
$$
begin
    new.update_datetime = now();
    RETURN new;
end
$$ language plpgsql;

create table if not exists account
(
    id              varchar     not null primary key,
    username        varchar     not null,
    password        varchar,
    create_datetime timestamptz not null default now(),
    update_datetime timestamptz,
    enable          bool        not null default true
);
create or replace trigger trigger_account_create_datetime
    before insert
    on account
    for each row
execute function table_create_datetime();
create or replace trigger trigger_account_update_datetime
    before update
    on account
    for each row
execute function table_update_datetime();

create table if not exists role
(
    id              varchar     not null primary key,
    name            varchar     not null,
    create_datetime timestamptz not null default now(),
    update_datetime timestamptz,
    enable          bool        not null default true
);
create or replace trigger trigger_role_create_datetime
    before insert
    on role
    for each row
execute function table_create_datetime();
create or replace trigger trigger_role_update_datetime
    before update
    on role
    for each row
execute function table_update_datetime();

create table if not exists authority
(
    id              varchar     not null primary key,
    name            varchar     not null,
    create_datetime timestamptz not null default now(),
    update_datetime timestamptz,
    enable          bool        not null default true
);

create or replace trigger trigger_authority_create_datetime
    before insert
    on authority
    for each row
execute function table_create_datetime();
create or replace trigger trigger_authority_update_datetime
    before update
    on authority
    for each row
execute function table_update_datetime();


insert ignore into public.account(id, username, password)
values ('0', '15828395524', '123456');