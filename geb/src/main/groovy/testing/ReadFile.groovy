package testing

/**
 * Created by Glen on 10/20/2015.
 */
class ReadFile {
    static main(args) {
        def fileName = 'output/test.txt'
        String[] x1 = new File(fileName)

        Set x = ['one', 'two', '999'] as Set
        x << 'sldjfljd'

        x.addAll(x1)
        println x.sort()

        new File(fileName).withWriter { out ->
            x.sort().each {
                out.println it
            }
        }

    }
}
