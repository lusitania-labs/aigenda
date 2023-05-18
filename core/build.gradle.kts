import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
	implementation(project(":github"))
	implementation(project(":jira"))
	implementation(project(":outlook"))
	implementation("org.springframework.boot:spring-boot-starter-security")
}

tasks.withType<BootJar> {
	enabled = true
}