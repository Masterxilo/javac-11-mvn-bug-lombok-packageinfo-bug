//package mypackage;
// ^^ not including this generates undebuggable error:
// [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project a: Fatal error compiling: java.lang.NullPointerException -> [Help 1]ption -> [Help 1]
//Caused by: java.lang.NullPointerException
//    at com.sun.tools.javac.tree.TreeInfo.declarationFor (TreeInfo.java:688)

/**
 * Contins the configuration (bean classes & configuration classes = factory methods)
 * necessary to connect to the
 *
 * 		BASYS MDM AMN Infrastrukturobjekte API https://confluence.sbb.ch/display/BASYS/Infrastrukturobjekte+API
 *
 * which delivers Informationsträger-Objekte updates from the DfA (Datenbank der festen Anlagen)
 *
 * The deployed MQ and ldap jndi objects are configured here: https://code.sbb.ch/projects/OM_DEL/repos/sei_messaging/browse
 * in accordance with the process described in https://confluence.sbb.ch/display/WMB/440+-+Continuous+Deployment
 *
 * Configuration was initially mostly copied from https://code.sbb.ch/projects/AM_DMD/repos/diamond-dinar-consumer
 *
 * See application[-*].properties io.jndiContext.* & mquserpassword
 *
 */
