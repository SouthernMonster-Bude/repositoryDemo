### yarn-site.xml

```
  <property>
        <description>Indicate to clients whether Timeline service is enabled or not.
        If enabled, the TimelineClient library used by end-users will post entities
        and events to the Timeline server.</description>
        <name>yarn.timeline-service.enabled</name>
        <value>true</value>
        </property>

        <property>
        <description>The hostname of the Timeline service web application.</description>
        <name>yarn.timeline-service.hostname</name>
        <value>hadoop122</value>
        </property>

        <property>
        <description>Enables cross-origin support (CORS) for web services where
        cross-origin web response headers are needed. For example, javascript making
        a web services request to the timeline server.</description>
        <name>yarn.timeline-service.http-cross-origin.enabled</name>
        <value>true</value>
        </property>

        <property>
        <description>Publish YARN information to Timeline Server</description>
        <name> yarn.resourcemanager.system-metrics-publisher.enabled</name>
        <value>true</value>
        </property>
```





tez-site.xml

```
<property>
  <description>Enable Tez to use the Timeline Server for History Logging</description>
  <name>tez.history.logging.service.class</name>
  <value>org.apache.tez.dag.history.logging.ats.ATSHistoryLoggingService</value>
</property>

<property>
  <description>URL for where the Tez UI is hosted</description>
  <name>tez.tez-ui.history-url.base</name>
  <value>http://hadoop122/tez-ui/</value>
</property>
```

### 启动tomcat

sudo yum install -y tomcat

将用户添加到tomcat组

sudo groupmems -g tomcat -a myhadoop 

删除tomcat自带的jdk

rpm -qa | grep java- | xargs -n1 sudo rpm -e --nodeps

将运行的war包上传到

cd /var/lib/tomcat/webapps

 sudo yum install -y unzip

解压

sudo mkdir tez-ui

sudo unzip tez-ui.war -d tez-ui

 sudo mv tez-ui.war tez-ui.war.bak

sudo vim /var/lib/tomcat/webapps/tez-ui/config/configs.env

```js
ENV = {
  hosts: {
    /*
     * Timeline Server Address:
     * By default TEZ UI looks for timeline server at http://localhost:8188, uncomment and change
     * the following value for pointing to a different address.
     */
    timeline: "http://hadoop122:8188",

    /*
     * Resource Manager Address:
     * By default RM REST APIs are expected to be at http://localhost:8088, uncomment and change
     * the following value to point to a different address.
     */
    rm: "http://hadoop122:8088",

    /*
     * Resource Manager Web Proxy Address:
     * Optional - By default, value configured as RM host will be taken as proxy address
     * Use this configuration when RM web proxy is configured at a different address than RM.
     */
    rmProxy: "http://hadoop122:8088",
  },

  /*
   * Time Zone in which dates are displayed in the UI:
   * If not set, local time zone will be used.
   * Refer http://momentjs.com/timezone/docs/ for valid entries.
   */
  //timeZone: "UTC",

  /*
   * yarnProtocol:
   * If specified, this protocol would be used to construct node manager log links.
   * Possible values: http, https
   * Default value: If not specified, protocol of hosts.rm will be used
   */
  //yarnProtocol: "<value>",
};

```

sudo systemctl start tomcat



重启yarn

stop-yarn.sh

start-yarn.sh

启动timeline server

yarn -daemon start timelineserver