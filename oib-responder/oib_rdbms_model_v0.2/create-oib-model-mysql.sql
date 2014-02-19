/*
   This script creates the Open Infobutton database for MySQL
   Pre-requisites:
 */

CREATE SCHEMA IF NOT EXISTS `OIB` DEFAULT CHARACTER SET utf8 ;
USE `OIB` ;

CREATE TABLE OIB.OIB_APP_PROPERTY 
(	APP_PROPERTY_ID BIGINT, 
	PROP_GROUP_CD VARCHAR(50 ), 
	PROP_NAME VARCHAR(100 ), 
	PROP_VALUE VARCHAR(1000 ), 
	 PRIMARY KEY (APP_PROPERTY_ID)
);

CREATE TABLE OIB.OIB_ASSET 
(	ASSET_ID BIGINT, 
	NAMESPACE_CD VARCHAR(100 ), 
	DISPLAY_NAME VARCHAR(255 ), 
	LAST_UPDATE_DTS DATE, 
	ASSET_URL VARCHAR(1000 ), 
	ASSET_MIME_TYPE VARCHAR(50 ), 
	 PRIMARY KEY (ASSET_ID)
);

CREATE TABLE OIB.OIB_ASSET_PROPERTY 
(	ASSET_PROPERTY_ID BIGINT NOT NULL, 
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

ALTER TABLE OIB_VALUE_SET_CODE ADD CONSTRAINT OIB_VALUE_SET_CODE_FK1 
  FOREIGN KEY (VALUE_SET_ID) REFERENCES OIB_VALUE_SET (VALUE_SET_ID);

ALTER TABLE OIB_VALUE_SET_CODE ADD CONSTRAINT OIB_VALUE_SET_CODE_OIB_VA_FK1 
  FOREIGN KEY (PARENT_VALUE_SET_CODE_ID) REFERENCES OIB_VALUE_SET_CODE (VALUE_SET_CODE_ID);
