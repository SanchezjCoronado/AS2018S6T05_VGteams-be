-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-01-22 16:18:27.875
-- tables
-- Table: tutoring_sessions
CREATE TABLE tutoring_sessions (
                                   tutoring_session_id uuid  NOT NULL,
                                   tutoring_team_id integer  NOT NULL,
                                   title varchar(100)  NOT NULL,
                                   description varchar(500)  NULL,
                                   start_time timestamp  NOT NULL,
                                   end_time timestamp  NOT NULL,
                                   state char(1)  NOT NULL,
                                   archived boolean  NOT NULL,
                                   session_url varchar(250)  NULL,
                                   CONSTRAINT tutoring_sessions_pk PRIMARY KEY (tutoring_session_id)
);
-- End of file.
