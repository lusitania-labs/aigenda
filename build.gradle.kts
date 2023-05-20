import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	id("io.gitlab.arturbosch.detekt") version "1.22.0"

	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"

	jacoco
}

allprojects {
	group = "com.lusitania.labs"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

subprojects {

	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.gitlab.arturbosch.detekt")
	apply(plugin = "jacoco")

	dependencies {
		// Kotlin Standard Library
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		// Jackson
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

		// Spring Boot Dependencies
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")


		// Test
		testImplementation("org.springframework.boot:spring-boot-starter-test")

		// Annotation Processing Tool
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

		// development
		developmentOnly("io.netty:netty-resolver-dns-native-macos:4.1.85.Final") {
			artifact {
				classifier = "osx-aarch_64"
			}
		}
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.2")
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<BootJar> {
		enabled = false
	}

	tasks.withType<Test> {
		useJUnitPlatform()
		finalizedBy(tasks.jacocoTestReport)
	}

	tasks.jacocoTestReport {
		dependsOn(tasks.test)
		reports {
			xml.required.set(true)
			xml.outputLocation.set(File("${project.buildDir}/jacocoXml/jacocoTestReport.xml"))
		}
	}

	detekt {
		autoCorrect = true
		parallel = true
		buildUponDefaultConfig = true
		dependencies {
			detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
		}
	}
}

tasks.withType<BootJar> {
	enabled = false
}
