plugins {
    java
    jacoco
    id("com.diffplug.spotless") version "6.18.0"
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id ("com.microsoft.azure.azurewebapp") version "1.7.1"

}
azurewebapp {
    subscription = "77bc7cf0-5135-49cb-9781-a5360eeff116"
    resourceGroup = "rg-brights-realworld"
    appName = "realworldTestTerje"
    pricingTier = "B1"
    region = "westeu"


}

group = "io.shirohoo"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("com.microsoft.playwright:playwright:1.36.0")
    implementation("com.h2database:h2");
    implementation("org.postgresql:postgresql:42.5.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "junit", module = "junit")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        html.required.set(true)
        html.outputLocation.set(file("$buildDir/jacoco/html"))
    }
}

tasks.compileJava {
    dependsOn(tasks.clean)
}

spotless {
    java {
        palantirJavaFormat()
        indentWithSpaces()
        formatAnnotations()
        removeUnusedImports()
        trimTrailingWhitespace()
        importOrder("io.shirohoo", "java", "javax", "jakarta", "org", "com", "lombok")
    }

    kotlin {
        ktlint()
        indentWithSpaces()
        trimTrailingWhitespace()
    }

    kotlinGradle {
        ktlint()
        indentWithSpaces()
        trimTrailingWhitespace()
    }
}
