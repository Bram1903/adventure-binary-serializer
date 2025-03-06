plugins {
	id("java")
	id("java-library")
    id("maven-publish")
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnlyApi(libs.jetbrains.annotations)
	implementation(libs.adventure.api)

	testImplementation(libs.adventure.nbt)
	testImplementation(libs.junit.jupiter.api)
	testRuntimeOnly(libs.junit.jupiter.engine)
	testRuntimeOnly(libs.junit.jupiter.platform.launcher)
}

group = "com.deathmotion.adventure.binary.serializer"
version = "1.0.0"

java {
	toolchain.languageVersion = JavaLanguageVersion.of(21)
	disableAutoTargetJvm()
}

tasks {
	withType<JavaCompile> {
		options.encoding = Charsets.UTF_8.name()
		options.release = 17
	}

	withType<Test> {
		useJUnitPlatform()
	}

	defaultTasks("build")
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
		}
	}
}
