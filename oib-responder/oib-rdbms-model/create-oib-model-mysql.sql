/*
   This script creates the Open Infobutton database for MySQL
   Pre-requisites:
 */

CREATE SCHEMA IF NOT EXISTS `OIB` DEFAULT CHARACTER SET utf8 ;
USE `OIB` ;

CREATE TABLE OIB.OIB_ID_SEQ (
  SEQ_NAME VARCHAR(100) NOT NULL,
  INCREMENT INT(11) NOT NULL DEFAULT '1',
  MIN_VALUE INT(11) NOT NULL DEFAULT '1',
  MAX_VALUE BIGINT(20) NOT NULL DEFAULT '9223372036854775807',
  CUR_VALUE BIGINT(20) DEFAULT '10000',
  CYCLE TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (SEQ_NAME)
);

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION OIB.NEXTVAL (`p_seq_name` VARCHAR(100)) RETURNS bigint(20)
BEGIN
    DECLARE v_cur_val BIGINT;
 
    SELECT
        CUR_VALUE INTO v_cur_val
    FROM
        OIB.OIB_ID_SEQ
    WHERE
        SEQ_NAME = p_seq_name;
 
    IF v_cur_val IS NOT NULL THEN
        UPDATE
            OIB.OIB_ID_SEQ
        SET
            cur_value = IF (
                (cur_value + INCREMENT) > max_value OR (cur_value + INCREMENT) < min_value,
                IF (
                    cycle = TRUE,
                    IF (
                        (cur_value + INCREMENT) > max_value,
                        min_value, 
                        max_value 
                    ),
                    NULL
                ),
                cur_value + INCREMENT
            )
        WHERE
            SEQ_NAME = p_seq_name;
    END IF; 
    RETURN v_cur_val;
END$$
DELIMITER ;

INSERT INTO OIB_ID_SEQ (SEQ_NAME,MIN_VALUE) VALUES('ID_SEQ',10000);

CREATE TABLE OIB.OIB_APP_PROPERTY 
(	APP_PROPERTY_ID BIGINT AUTO_INCREMENT,
	PROP_GROUP_CD VARCHAR(50 ), 
	PROP_NAME VARCHAR(100 ), 
	PROP_VALUE VARCHAR(1000 ), 
	 PRIMARY KEY (APP_PROPERTY_ID)
);

CREATE TABLE OIB.OIB_ASSET 
(	ASSET_ID BIGINT AUTO_INCREMENT,
	NAMESPACE_CD VARCHAR(100 ), 
	DISPLAY_NAME VARCHAR(255 ), 
	LAST_UPDATE_DTS DATE, 
	ASSET_URL VARCHAR(1000 ), 
	ASSET_MIME_TYPE VARCHAR(50 ), 
	 PRIMARY KEY (ASSET_ID)
);

CREATE TABLE OIB.OIB_ASSET_PROPERTY 
(	ASSET_PROPERTY_ID BIGINT NOT NULL AUTO_INCREMENT,
	ASSET_ID BIGINT NOT NULL, 
	PROP_GROUP_NUM BIGINT, 
	PROP_NAME VARCHAR(100 ) NOT NULL, 
	PROP_TYPE_CD VARCHAR(20 ) NOT NULL, 
	CODE VARCHAR(100 ), 
	CODE_SYSTEM VARCHAR(100 ), 
	DISPLAY_NAME VARCHAR(1000 ), 
	PROP_VALUE VARCHAR(1000 ), 
	GENERATED_BY_CD VARCHAR(50 ) NOT NULL, 
	 CONSTRAINT OIB_ASSET_PROPERTY_PK PRIMARY KEY (ASSET_PROPERTY_ID)
);

-- ALTER TABLE OIB_ASSET_PROPERTY
-- ADD CONSTRAINT OIB_ASSET_PROPERTY_UK1 UNIQUE (
--   ASSET_ID 
-- , PROP_GROUP_NUM 
-- , PROP_NAME 
-- );

ALTER TABLE OIB_ASSET_PROPERTY
ADD CONSTRAINT OIB_ASSET_PROPERTY_OIB_AS_FK1 FOREIGN KEY
(ASSET_ID) REFERENCES OIB_ASSET (ASSET_ID);


CREATE TABLE OIB.OIB_REQUEST_PARAMETER 
(	REQUEST_PARAMETER_ID BIGINT NOT NULL, 
	PARAMETER_NAME VARCHAR(100 ), 
	PARAMETER_DSC VARCHAR(1000 ), 
	CARDINALITY_MIN BIGINT, 
	CARDINALITY_MAX BIGINT, 
	PARAMETER_ROOT VARCHAR(50 ), 
	TYPE_CD VARCHAR(20 ), 
	PARAMETER_SUFFIX VARCHAR(50 ), 
	VALUE_SET_ID BIGINT, 
	 CONSTRAINT OIB_REQUEST_PARAMETER_PK PRIMARY KEY (REQUEST_PARAMETER_ID)
);

CREATE TABLE OIB.OIB_VALUE_SET 
(	VALUE_SET_ID BIGINT, 
	VALUE_SET_TYPE_CD VARCHAR(50 ), 
	VALUE_SET_OID VARCHAR(100 ), 
	VALUE_SET_DISPLAY_NAME VARCHAR(255 ), 
	VALUE_SET_URI VARCHAR(255 ), 
	 PRIMARY KEY (VALUE_SET_ID)
);

CREATE TABLE OIB.OIB_VALUE_SET_CODE 
(	VALUE_SET_CODE_ID BIGINT, 
	VALUE_SET_ID BIGINT, 
	CODE VARCHAR(50 ), 
	CODE_SYSTEM_OID VARCHAR(100 ), 
	CODE_DISPLAY_NAME VARCHAR(255 ), 
	LIST_ORDER BIGINT, 
	PARENT_VALUE_SET_CODE_ID BIGINT, 
	CODE_URI VARCHAR(255 ), 
	 PRIMARY KEY (VALUE_SET_CODE_ID)
);

CREATE TABLE OIB.OIB_CONCEPT (
  CONCEPT_ID BIGINT(20) NOT NULL,
  CODE VARCHAR(255) DEFAULT NULL,
  CODE_SYSTEM VARCHAR(255) DEFAULT NULL,
  CODE_SYSTEM_DISPLAY_NAME VARCHAR(255) DEFAULT NULL,
  DISPLAY_NAME VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY  (CONCEPT_ID)
);

-- --------------------------------------------------------------------
-- NEED TO SYNCH CONCEPTS between the request and responder databases
-- --------------------------------------------------------------------
INSERT INTO OIB_CONCEPT
SELECT NEXTVAL('ID_SEQ'), B.CODE, B.CODE_SYSTEM_OID, NULL, B.CODE_DISPLAY_NAME
FROM (
	SELECT DISTINCT CODE, CODE_SYSTEM_OID, CODE_DISPLAY_NAME
	FROM OIB_VALUE_SET_CODE
) B;


ALTER TABLE OIB_VALUE_SET_CODE ADD CONSTRAINT OIB_VALUE_SET_CODE_FK1 
  FOREIGN KEY (VALUE_SET_ID) REFERENCES OIB_VALUE_SET (VALUE_SET_ID);

ALTER TABLE OIB_VALUE_SET_CODE ADD CONSTRAINT OIB_VALUE_SET_CODE_OIB_VA_FK1 
  FOREIGN KEY (PARENT_VALUE_SET_CODE_ID) REFERENCES OIB_VALUE_SET_CODE (VALUE_SET_CODE_ID);
