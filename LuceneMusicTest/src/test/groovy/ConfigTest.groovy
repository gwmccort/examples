/**
 * Created by gwmccort on 2/16/2016.
 */
class ConfigTest {

    static main(args) {
        println 'in main'

        // set configuration
        def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())
        def env = config.home
        if (InetAddress.localHost.hostName=='CRP22627'){
            env = config.work
        }

        println env.musicDir
    }
}
