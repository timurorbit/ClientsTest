DELETE from clients;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO clients (firstName, lastName, date_time, status, satisfaction, address, email, telephoneNumber, image) VALUES
('1 firstName', 'lastName', '2015-01-01 02:00:01','status','satisfaction','address','@mail','telephone', bytea'C:\Users\tholl\Desktop\ava14.png');
/* ('2 firstName', 'lastName', '2015-01-02 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('3 firstName', 'lastName', '2015-01-03 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('4 firstName', 'lastName', '2015-01-04 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('5 firstName', 'lastName', '2015-01-05 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('6 firstName', 'lastName', '2015-01-06 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('7 firstName', 'lastName', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea),
('8 firstName', 'lastName', '2015-01-08 02:00:01','status','satisfaction','address','@mail','telephone', pg_read_file('ava14.png')::bytea); /*
