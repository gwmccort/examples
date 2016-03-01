package gwm.h2

import groovy.sql.Sql

/**
 * Groovy SQL example:
 * http://mrhaki.blogspot.com/2009/10/groovy-goodness-groovy-sql.html
 * http://www.schibsted.pl/2015/06/groovy-sql-an-easy-way-to-database-scripting/
 * @author Glen
 *
 */
class GroovySql {

	static String username = 'groovy', password = 'groovy', database = 'groovy', server = 'localhost'

	static main(args) {
		def db = Sql.newInstance("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",username, password,"org.h2.Driver")

		db.execute '''
			create table languages(
				id integer not null auto_increment,
				name varchar(20) not null,
				primary key(id)
			)
'''
		db.execute 'insert into languages values(null, "Groovy")'
		
		db.eachRow("select id, name from languages") { row ->
			println row.name
		}
	}
}
