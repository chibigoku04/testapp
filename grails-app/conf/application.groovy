/**
 * Created by bleu on 2/28/17.
 */

// environment specific settings
environments {

    //tests don't pass unless the embedded mongodb config for test env is defined in application.groovy
    test {
        grails {
            mongodb {
                host = "localhost"
                port = 27018
                databaseName = "testapp"
            }
        }
    }

}
