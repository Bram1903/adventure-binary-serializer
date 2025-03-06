plugins {
	id("java")
	id("java-library")
    id("maven-publish")
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
	group = "com.deathmotion.adventure.binary.serializer"
	version = "1.0.0"
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnlyApi("org.jetbrains:annotations:24.0.0")
	implementation("net.kyori:adventure-api:4.19.0")

	testImplementation("net.kyori:adventure-nbt:4.19.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
		}
	}
}
