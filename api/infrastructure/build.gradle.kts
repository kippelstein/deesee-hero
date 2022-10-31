apply {
    plugin("org.jetbrains.kotlin.plugin.spring")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    implementation("org.springframework:spring-context:5.3.22")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.trendyol:kediatr-spring-starter:1.0.18")
    implementation("org.springframework.kafka:spring-kafka:2.9.0")

    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.mockito:mockito-inline:4.7.0")
}
