plugins {
    java
}

group = "xbc.tut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.hibernate:hibernate-agroal:5.3.0.Final")
    compile("com.h2database:h2:1.4.197")
    compile("javax.transaction:jta:1.1")
    //testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}