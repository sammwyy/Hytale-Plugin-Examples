plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir {
        dirs("libraries")
    }
}

dependencies {
    // Libraries
    compileOnly(files("libraries/HytaleServer.jar"))

    // Tests
    testImplementation(platform(libs.junitBom))
    testImplementation(libs.junitJupiter)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks {
    test {
        useJUnitPlatform()
    }
}