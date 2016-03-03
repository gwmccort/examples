package gwm.h2

import groovy.sql.Sql

/**
 * Groovy SQL example:
 * http://mrhaki.blogspot.com/2009/10/groovy-goodness-groovy-sql.html
 * http://www.schibsted.pl/2015/06/groovy-sql-an-easy-way-to-database-scripting/
 */
class GroovySql {

	static String username = 'groovy', password = 'groovy', database = 'groovy', server = 'localhost'

	static main(args) {

		// in memory db
		def dbUrl = 'jdbc:h2:mem:test;DB_CLOSE_DELAY=-1'
		// file db
		//		def dbUrl = "jdbc:h2:./db/fileDb"

		def sql = Sql.newInstance(dbUrl,username, password,"org.h2.Driver")

		// check if table exists
		// http://www.codereactor.net/category/groovy/
		// http://www.rgagnon.com/javadetails/java-0485.html

		//		def metadata = sql.connection.getMetaData()
		//		def tables = metadata.getTables(null, null, "languages", null)
		//		println tables.class
		//		if (!tables.next()) {
		//			println 'no table'
		//		} else {
		//			println 'table exists.'
		//		}

		/*
		 drop table test;
		 create table test(id bigint auto_increment, name varchar(255));
		 insert into test(name) values('hello');
		 insert into test(name) values('world');
		 select * from test;
		 */

		//		db.execute '''
		//			create table languages(
		//				id integer not null auto_increment,
		//				name varchar(20) not null,
		//				primary key(id)
		//			)
		//			'''

		sql.execute('drop table if exists languages')
		sql.execute '''
			create table if not exists languages(
				id bigint auto_increment,
				name varchar(20) not null,
			)
			'''
		//TBD need to use ' not " in sql
		//db.execute 'insert into languages (id, name) values(null, "Groovy")'
		sql.execute "insert into languages(id, name) values(null, 'Groovy')"
		sql.execute "insert into languages(id, name) values(null, 'Java')"

		sql.eachRow("select id, name from languages") { row -> println "$row.id $row.name" }
	}
}
