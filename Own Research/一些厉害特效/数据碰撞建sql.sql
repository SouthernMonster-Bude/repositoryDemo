
DROP TABLE IF EXISTS DA_CO_REL_COL_RELATION;

/*==============================================================*/
/* Table: DA_CO_REL_COL_RELATION                                */
/*==============================================================*/
CREATE TABLE DA_CO_REL_COL_RELATION
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   ELEMENT_ID           INT COMMENT '元素关系属于算子id',
   SOURCE_ID            INT COMMENT '源字段id',
   SOURCE_NAME          VARCHAR(100) COMMENT '源字段名称',
   TARGET_ID            INT COMMENT '目标字段id
            ',
   TARGET_NAME          VARCHAR(100) COMMENT '目标字段名称',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_REL_COL_RELATION COMMENT '数据碰撞算子字段映射关系表(关联字段信息)';



DROP TABLE IF EXISTS DA_CO_REL_COL_CONTENT;

/*==============================================================*/
/* Table: DA_CO_REL_COL_CONTENT                                 */
/*==============================================================*/
CREATE TABLE DA_CO_REL_COL_CONTENT
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   ELEMENT_ID           INT COMMENT '映射字段id',
   FROM_ELE_ID          INT COMMENT '字段来源元素Id',
   NAME                 VARCHAR(50) COMMENT '字段名称
            ',
   RE_NAME              VARCHAR(50) COMMENT '字段重命名',
   TYPEVALUE            VARCHAR(100) COMMENT '字段类型',
   TYPE                 TINYINT COMMENT '字段左右类型 0左 1右',
   IS_OUTPUT_COL        TINYINT DEFAULT 0 COMMENT '是否输出字段(0否1是)',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_REL_COL_CONTENT COMMENT '数据碰撞字段内容表';


DROP TABLE IF EXISTS DA_CO_FLOW_ELE_RELATION;

/*==============================================================*/
/* Table: DA_CO_FLOW_ELE_RELATION                               */
/*==============================================================*/
CREATE TABLE DA_CO_FLOW_ELE_RELATION
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   SOURCE_ELE           INT COMMENT '起点元素id',
   TARGET_ELE           INT COMMENT '终点元素ID',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_FLOW_ELE_RELATION COMMENT '数据碰撞流程图元素连接关系表(记录所有的连线信息)';


DROP TABLE IF EXISTS DA_CO_FLOW_TABLE_CONDITION;

/*==============================================================*/
/* Table: DA_CO_FLOW_TABLE_CONDITION                            */
/*==============================================================*/
CREATE TABLE DA_CO_FLOW_TABLE_CONDITION
(
   ID                   INT NOT NULL,
   ELEMENT_ID           INT COMMENT '表元素的ID',
   COLMUN_NAME          VARCHAR(100) COMMENT '字段名称',
   MATCH_TYPE           TINYINT COMMENT '条件的匹配方式 AND 或者OR',
   WHERE_TYPE           TINYINT COMMENT '条件检索项精确模糊空值',
   CONTENT_START        VARCHAR(255) COMMENT '筛选值 /开始值',
   CONTENT_END          VARCHAR(255) COMMENT '筛选结束值',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_FLOW_TABLE_CONDITION COMMENT '数据碰撞表元素筛选条件';


DROP TABLE IF EXISTS DA_CO_JOB_TASK;

/*==============================================================*/
/* Table: DA_CO_JOB_TASK                                        */
/*==============================================================*/
CREATE TABLE DA_CO_JOB_TASK
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   JOB_ID               INT COMMENT '任务id',
   JOB_NAME             VARCHAR(100) COMMENT '任务名称',
   START_TIME           DATETIME COMMENT '任务开始时间',
   END_TIME             DATETIME COMMENT '任务结束时间',
   TASK_STATUS          TINYINT COMMENT '任务运行状态(0待执行,1执行中,2执行成功,3执行失败,4执行中止)',
   TASK_SQL             LONGTEXT,
   LOG                  LONGTEXT COMMENT '运行日志信息',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_JOB_TASK COMMENT '数据碰撞任务运行历史表';


DROP TABLE IF EXISTS DA_CO_FLOW_ELEMENT;

/*==============================================================*/
/* Table: DA_CO_FLOW_ELEMENT                                    */
/*==============================================================*/
CREATE TABLE DA_CO_FLOW_ELEMENT
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   JOB_ID               INT COMMENT '任务id',
   TYPE                 TINYINT COMMENT '元素类型(0数据类型1输出元素2算子 并3算子 交4算子 差)',
   META_TABLE_ID        INT COMMENT '内容ID',
   SCRIPT               LONGTEXT COMMENT '脚本内容',
   X                    FLOAT COMMENT '元素x坐标',
   Y                    FLOAT COMMENT '元素y坐标',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_FLOW_ELEMENT COMMENT '数据碰撞流程图元素表(记录所有的节点信息)';

DROP TABLE IF EXISTS DA_CO_JOB;

/*==============================================================*/
/* Table: DA_CO_JOB                                             */
/*==============================================================*/
CREATE TABLE DA_CO_JOB
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(50) COMMENT '任务名称',
   IS_REPEAT            TINYINT DEFAULT 0 COMMENT '是否重复',
   TIMING_TYPE          TINYINT COMMENT '定时类型(0不需要定时1时间间隔2天3周4月)',
   SECOND               INT(2) COMMENT '秒',
   MINUTE               INT(2) COMMENT '分',
   HOUR                 INT(2) COMMENT '时',
   DAY                  INT(2) COMMENT '日',
   WEEK                 TINYINT COMMENT '周',
   MONTH                INT(2) COMMENT '月',
   YEAR                 INT(4) COMMENT '年',
   STATUS               TINYINT COMMENT '任务执行状态(0待执行1执行中2执行结束3执行异常)',
   SCHEDULE_STATUS      TINYINT DEFAULT 0 COMMENT '是否已配置调度(0否1是)',
   AZK_SCHEDULE_ID      VARCHAR(11) COMMENT 'azkaban schedule id',
   RESULT_TABLE_NAME    VARCHAR(150) COMMENT '任务结果表名字',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_JOB COMMENT '数据碰撞任务表';



DROP TABLE IF EXISTS DA_CO_FOLDER;

/*==============================================================*/
/* Table: DA_CO_FOLDER                                          */
/*==============================================================*/
CREATE TABLE DA_CO_FOLDER
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(50) COMMENT '文件夹名称',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_FOLDER COMMENT '数据碰撞文件夹表';

DROP TABLE IF EXISTS DA_CO_UPLOAD_TABLE;

/*==============================================================*/
/* Table: DA_CO_UPLOAD_TABLE                                    */
/*==============================================================*/
CREATE TABLE DA_CO_UPLOAD_TABLE
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   FILE_NAME            VARCHAR(50) COMMENT '文件名称',
   URL                  VARCHAR(255) COMMENT '文件路径',
   PARENT_ID            INT COMMENT '上级分类id',
   TABLE_NAME           VARCHAR(150) COMMENT '对应数据库表名字',
   IS_DELETED           TINYINT DEFAULT 0 COMMENT '是否已删除(0否1是)',
   CREATE_PERSON        VARCHAR(32) COMMENT '创建人',
   CREATE_TIME          DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_PERSON        VARCHAR(32) COMMENT '更新人',
   UPDATE_TIME          DATETIME COMMENT '更新时间',
   CREATE_PERSON_ID     VARCHAR(32) COMMENT '创建人标识',
   UPDATE_PERSON_ID     VARCHAR(32) COMMENT '更新人标识',
   PRIMARY KEY (ID)
);

ALTER TABLE DA_CO_UPLOAD_TABLE COMMENT '数据碰撞上传文件表';
