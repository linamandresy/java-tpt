
ALTER PLUGGABLE DATABASE MBDS_TPT_PDB CLOSE;

DROP PLUGGABLE DATABASE MBDS_TPT_PDB INCLUDING DATAFILES;

drop tablespace mbds;


CREATE PLUGGABLE DATABASE mbds_tpt_pdb 
  ADMIN USER egov IDENTIFIED BY egov roles=(dba)
  STORAGE (MAXSIZE 2G)
  DEFAULT TABLESPACE mbds 
    DATAFILE '/opt/oracle/oradata/XE/mbds01.dbf' SIZE 250M 
    AUTOEXTEND ON
    PATH_PREFIX = '/opt/oracle/oradata/mbds/'
    FILE_NAME_CONVERT = ('/opt/oracle/oradata/XE', 
                         '/opt/oracle/oradata/mbds');


  ALTER PLUGGABLE DATABASE mbds_tpt_pdb OPEN;
