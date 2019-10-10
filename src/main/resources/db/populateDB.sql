DELETE from clients;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO clients (firstName, lastName, date_time, status, satisfaction, address, email, telephoneNumber, imagePath) VALUES
('Tomioka', 'Giyū', '2015-01-02 02:00:01','status','satisfaction','address','@mail','telephone', 'giyu tomioka.jpg'),
('Kanroji ', 'Mitsuri', '2015-01-03 02:00:01','status','satisfaction','address','@mail','telephone', 'Mitsuri Kanroji.jpg'),
('Iguro', 'Obanai', '2015-01-04 02:00:01','status','satisfaction','address','@mail','telephone', 'Obanai Iguro.jpg'),
('Shinazugawa', 'Sanemi', '2015-01-05 02:00:01','status','satisfaction','address','@mail','telephone', 'Sanemi Shinazugawa.jpg'),
('Himejima', 'Gyōmei', '2015-01-06 02:00:01','status','satisfaction','address','@mail','telephone', 'Gyomei Himejima.jpg'),
('Tokitō', 'Muichirō', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Muichiro Tokito.jpg'),
('Kyojuro', 'Rengoku', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Kyojuro Rengoku.jpg'),
('Tengen', 'Uzui', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Tengen Uzui.webp'),
('Kochō', 'Shinobu', '2015-01-08 02:00:01','status','satisfaction','address','@mail','telephone', 'Shinobu Kocho.jpg');
