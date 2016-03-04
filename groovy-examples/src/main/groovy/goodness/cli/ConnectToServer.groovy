package goodness.cli

class ConnectToServer {

	String server
	boolean debug

	static void main(args) {

		def connectToServer = new ConnectToServer()

		def cli = new CliBuilder(usage: 'groovy ConnectToServer.groovy -s[dh] "server"')
		cli.h(longOpt: 'help'  , 'usage information'   , required: false           )
		cli.s(longOpt: 'server', 'server to connect to', required: true  , args: 1 )
		cli.d(longOpt: 'debug' , 'enable debugging'    , required: false           )
		OptionAccessor opt = cli.parse(args)
		if(!opt) {
			return
		}
		// print usage if -h, --help, or no argument is given
		if(opt.h || opt.arguments().isEmpty()) {
			cli.usage()
		}
		if( opt.d ) {
			connectToServer.debug = true
		}
		if( opt.s ) {
			connectToServer.server = opt.s
		}
	}
}
