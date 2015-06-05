DROP TABLE "CCBADM"."LOGGING_STORE" cascade constraints;
--------------------------------------------------------
--  DDL for Table LOGGING_STORE
--------------------------------------------------------

  CREATE TABLE "CCBADM"."LOGGING_STORE"
   (	"ID" VARCHAR2(255 CHAR),
	"CLIENT_APPLIKATION" VARCHAR2(30 CHAR),
	"CLIENT_VERSION" VARCHAR2(1024 CHAR),
	"CORRELATION_ID" VARCHAR2(64 CHAR),
	"DEBUG_INFORMATION" VARCHAR2(4000 CHAR),
	"FAULT_CODE" VARCHAR2(256 CHAR),
	"FAULT_MESSAGE" VARCHAR2(4000 CHAR),
	"FAULT_TYPE" VARCHAR2(64 CHAR),
	"SEVERITY" VARCHAR2(64 CHAR),
	"TIMESTAMP" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_CCB_DATA01" ;
REM INSERTING into CCBADM.LOGGING_STORE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0033397
--------------------------------------------------------

  CREATE UNIQUE INDEX "CCBADM"."SYS_C0033397" ON "CCBADM"."LOGGING_STORE" ("ID")
  PCTFREE 10 INITRANS 2 MAXTRANS 255
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_CCB_DATA01" ;
--------------------------------------------------------
--  Constraints for Table LOGGING_STORE
--------------------------------------------------------

  ALTER TABLE "CCBADM"."LOGGING_STORE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_CCB_DATA01"  ENABLE;
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("TIMESTAMP" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("SEVERITY" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("FAULT_TYPE" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("FAULT_MESSAGE" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("FAULT_CODE" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("DEBUG_INFORMATION" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("CORRELATION_ID" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("CLIENT_VERSION" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("CLIENT_APPLIKATION" NOT NULL ENABLE);
  ALTER TABLE "CCBADM"."LOGGING_STORE" MODIFY ("ID" NOT NULL ENABLE);
