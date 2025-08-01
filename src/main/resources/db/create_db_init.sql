CREATE TYPE rack_status_enum AS ENUM ('ACTIVE', 'RETURNED', 'REPAIR', 'OUTDATED', 'BRICKED');
CREATE TABLE T_TEAM
(
    id   UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(255) ,
    product varchar(20) ,
    created_at  TIMESTAMP ,
    modified_at  TIMESTAMP,
    default_location VARCHAR(20)

);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;

CREATE TABLE T_RACK
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    serial_number varchar(20)      NOT NULL UNIQUE,
    status        text NOT NULL,
    team_id       UUID   ,
    product varchar(20),
    created_at  TIMESTAMP ,
    modified_at  TIMESTAMP,
    default_location varchar(20),
    assembled_at  timestamp,
    CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES T_TEAM(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;

CREATE TABLE T_TEAMMEMBER
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(225) NOT NULL,
    ctw_id varchar(20)      NOT NULL UNIQUE,
    created_at  TIMESTAMP NOT NULL,
    modified_at  TIMESTAMP,
    team_id       UUID           NOT NULL,

    CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES T_TEAM(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAMMEMBER_ID;

CREATE TABLE T_BOOKING
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(225)      NOT NULL,
    book_from  TIMESTAMP NOT NULL,
    book_to  TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at  TIMESTAMP,
    requester_id       UUID           NOT NULL,
    rack_id       UUID           NOT NULL REFERENCES T_RACK (id),

    CONSTRAINT fk_team FOREIGN KEY (requester_id) REFERENCES T_TEAMMEMBER(id),
    CONSTRAINT fk_rack FOREIGN KEY (rack_id) REFERENCES T_RACK(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;

CREATE TABLE T_RACKASSET
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(225)      NOT NULL,
    asset_tag varchar(225)      NOT NULL,
    rack_id       UUID           NOT NULL,

    CONSTRAINT fk_rack FOREIGN KEY (rack_id) REFERENCES T_RACK(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACKASSET_ID;

INSERT INTO T_TEAM (name, product, created_at, modified_at,default_location)
VALUES ('team1',
      'prod1',
      '2022-03-10T12:15:50',
      '2022-03-10T12:15:50',
      'lisboa');

INSERT INTO T_TEAM (name, product, created_at, modified_at,default_location)
VALUES ('team2',
        'prod2',
        '2022-03-10T12:15:50',
        '2022-03-10T12:15:50',
        'lisboa');

INSERT INTO T_TEAMMEMBER (name, ctw_id, created_at, modified_at, team_id)
VALUES (
           'teammember2',
           '1234',
           '2022-03-10T12:15:50',
           '2022-03-10T12:15:50',
           (SELECT id FROM T_TEAM WHERE name = 'team2' LIMIT 1)
       );



INSERT INTO T_RACK (
    serial_number, status, team_id, product, created_at, modified_at, default_location, assembled_at
) VALUES (
             '123456',
             'ACTIVE',
             (SELECT id FROM T_TEAM WHERE name = 'team1' LIMIT 1),
             'prod1',
             '2022-03-10T12:15:50',
             '2022-03-10T12:15:50',
             'lisboa',
             '2022-03-11T09:00:00'
         );

INSERT INTO T_RACK (
    serial_number, status, team_id, product, created_at, modified_at, default_location, assembled_at
) VALUES (
             '1234567',
             'ACTIVE',
             (SELECT id FROM T_TEAM WHERE name = 'team1' LIMIT 1),
             'prod1',
             '2022-03-10T12:15:50',
             '2022-03-10T12:15:50',
             'lisboa',
             '2022-03-11T09:00:00'
         );

INSERT INTO T_RACK (
    serial_number, status, team_id, product, created_at, modified_at, default_location, assembled_at
) VALUES (
             '12345678',
             'ACTIVE',
             (SELECT id FROM T_TEAM WHERE name = 'team1' LIMIT 1),
             'prod1',
             '2022-03-10T12:15:50',
             '2022-03-10T12:15:50',
             'lisboa',
             '2022-03-11T09:00:00'
         );

INSERT INTO T_RACK (
    serial_number, status, team_id, product, created_at, modified_at, default_location, assembled_at
) VALUES (
             '34567',
             'ACTIVE',
             (SELECT id FROM T_TEAM WHERE name = 'team1' LIMIT 1),
             'prod1',
             '2022-03-10T12:15:50',
             '2022-03-10T12:15:50',
             'lisboa',
             '2022-03-11T09:00:00'
         );

INSERT INTO T_RACK (
    serial_number, status, team_id, product, created_at, modified_at, default_location, assembled_at
) VALUES (
             '5672344',
             'ACTIVE',
             (SELECT id FROM T_TEAM WHERE name = 'team1' LIMIT 1),
             'prod1',
             '2022-03-10T12:15:50',
             '2022-03-10T12:15:50',
             'lisboa',
             '2022-03-11T09:00:00'
         );

INSERT INTO T_BOOKING (
    name, book_from, book_to, created_at, modified_at, requester_id, rack_id
) VALUES (
             'Booking1',
             '2022-07-01T10:00:00',
             '2022-07-02T10:00:00',
             '2022-06-20T12:00:00',
             '2022-06-20T12:00:00',
             (SELECT id FROM T_TEAMMEMBER WHERE ctw_id = '1234' LIMIT 1),
             (SELECT id FROM T_RACK WHERE serial_number = '123456' LIMIT 1)
         );


INSERT INTO T_RACKASSET (name, asset_tag, rack_id)
VALUES (
           'Asset1',
           'ASSET12345',
           (SELECT id FROM T_RACK WHERE serial_number = '123456' LIMIT 1)
       );