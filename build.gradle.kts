plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.70")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")

    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.13")
    constraints {
        testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.3.70") {
            because("compilation gives the warning to 'Consider providing an explicit dependency on kotlin-reflect 1.3 to prevent strange errors'")
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClassName = "org.bannisters.AppKt"
}
