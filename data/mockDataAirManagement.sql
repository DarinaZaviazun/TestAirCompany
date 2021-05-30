INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (1, 'Charter', '2012-05-07', 'Windrose');
INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (2, 'Lowcoster', '2012-05-29', 'Ryanair');
INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (3, 'Lowcoster', '2016-05-07', 'Pegasus');
INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (4, 'Charter', '2015-05-29', 'FlyDubai');
INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (5, 'Standart', '2016-08-29', 'Lufthansa');
INSERT INTO airmanagement.air_company (id, company_type, founded_at, name) VALUES (6, 'Standart', '1990-03-29', 'American Airlines');

INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (1, '2021-05-29', 700000, 50, 140000, 'A-500', 123456789, 'Airbus', 1);
INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (2, '2021-05-29', 800000, 45, 200000, 'A-737', 123456789, 'Boeing', 2);
INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (3, '2021-05-29', 250000, 66, 210000, 'A-565', 123456789, 'Airbus', 3);
INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (4, '2021-05-29', 500000, 74, 190000, 'A-400', 123456789, 'Boeing', 4);
INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (5, '2021-05-29', 650000, 51, 250000, 'A-980', 123456789, 'Airbus', 5);
INSERT INTO airmanagement.airplane (id, created_at, flight_distance, flights_number, fuel_capacity, name, serial_number, type, air_company_id) VALUES (6, '2021-05-26', 600000, 35, 125000, 'N-455', 369852147, 'Boeing', 6);

INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (1, '2021-05-29 12:26:46', null, 'France', 'USA', 6160, null, '06:20:00', 'ACTIVE', '2021-05-28 10:00:00', 1, 1);
INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (2, '2021-05-29 12:26:48', null, 'Italy', 'Spain', 2000, null, '02:00:00', 'PENDING', null, 2, 2);
INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (3, '2021-05-29 12:26:50', null, 'Ukraine', 'Turkey', 1300, null, '01:15:00', 'PENDING', null, 3, 3);
INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (4, '2021-05-29 12:26:52', null, 'United Kingdom', 'Germany', 1100, null, '01:00:00', 'PENDING', null, 4, 4);
INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (5, '2021-05-29 12:26:53', null, 'Poland', 'Ireland', 2200, null, '02:10:00', 'PENDING', null, 5, 5);
INSERT INTO airmanagement.flight (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, est_flight_time, flight_status, started_at, air_company_id, airplane_id) VALUES (6, '2021-05-29 12:26:55', '2021-05-29 10:50:00', 'Denmark', 'Maldives', 7900, '2021-05-29 20:30:00', '08:00:00', 'COMPLETED', '2021-05-29 10:25:00', 6, 6);
