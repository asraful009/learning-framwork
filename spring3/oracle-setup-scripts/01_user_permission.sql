alter session set "_ORACLE_SCRIPT"=true;
COMMIT;
CREATE USER t0 IDENTIFIED BY t0 DEFAULT TABLESPACE USERS TEMPORARY TABLESPACE TEMP;
COMMIT;
alter user t0 account unlock;
COMMIT;

alter profile DEFAULT limit PASSWORD_REUSE_TIME unlimited;
COMMIT;
alter profile DEFAULT limit PASSWORD_LIFE_TIME  unlimited;
COMMIT;

grant all privileges to t0;
COMMIT;