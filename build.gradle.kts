import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    kotlin("jvm").version("1.3.70")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")

// Atrium https://docs.atriumlib.org
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:0.10.0")
    testImplementation("ch.tutteli.atrium:atrium-api-fluent-en_GB-kotlin_1_3:0.10.0")

// AssertK https://github.com/willowtreeapps/assertk
//    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.13")
//    constraints {
//        testImplementation(kotlin("reflect", getKotlinPluginVersion())) {
//            because("compilation gives the warning to 'Consider providing an explicit dependency on kotlin-reflect 1.3 to prevent strange errors'")
//        }
//    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClassName = "org.bannisters.AppKt"
}
