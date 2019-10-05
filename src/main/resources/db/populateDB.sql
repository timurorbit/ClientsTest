DELETE from clients;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO clients (firstName, lastName, date_time, status, satisfaction, address, email, telephoneNumber) VALUES
('1 firstName', 'lastName', '2015-01-01 02:00:01','status','satisfaction','address','@mail','telephone'),
('2 firstName', 'lastName', '2015-01-02 02:00:01','status','satisfaction','address','@mail','telephone'),
('3 firstName', 'lastName', '2015-01-03 02:00:01','status','satisfaction','address','@mail','telephone'),
('4 firstName', 'lastName', '2015-01-04 02:00:01','status','satisfaction','address','@mail','telephone'),
('5 firstName', 'lastName', '2015-01-05 02:00:01','status','satisfaction','address','@mail','telephone'),
('6 firstName', 'lastName', '2015-01-06 02:00:01','status','satisfaction','address','@mail','telephone'),
('7 firstName', 'lastName', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone'),
('8 firstName', 'lastName', '2015-01-08 02:00:01','status','satisfaction','address','@mail','telephone');
