plugins {
	java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.camdenorrb"
version = "3.1.0"

repositories {
	mavenCentral()
	maven("https://hub.spigotmc.org/nexus/content/repositories/public/") {
		name = "SpigotMC"
	}
}

dependencies {
	compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
}

tasks {
	compileJava {
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}
}