plugins {
	java
	id 'org.springframework.boot' version '2.7.7'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'org.launchcode'
version = '0.0.1-SNAPSHOT'
//java.sourceCompatibility = JavaVersion.VERSION_11
sourceCompatibility = '11'

configurations { //is this necessary?
	developmentOnly
	runtimeClasspath {
		extendsFrom developmentOnly
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'mysql:mysql-connector-java'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}

tasks.withType<Test> {
	useJUnitPlatform()
}
