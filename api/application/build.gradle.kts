dependencies {
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.trendyol:kediatr-spring-starter:1.0.18")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.mockito:mockito-inline:4.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}
