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
