plugins {
    id("java")
}

group = "tulya-core"
version = "1.0-SNAPSHOT"

java {
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.awaitility:awaitility:4.3.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    minHeapSize = "1g"
    maxHeapSize = "16g"
}