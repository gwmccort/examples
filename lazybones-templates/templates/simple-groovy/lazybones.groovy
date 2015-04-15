def props = [:]
props.helloWorld = ask("Define the hello world message:", "Hello World!")

processTemplates('src/main/groovy/HelloWorld.groovy', props)
