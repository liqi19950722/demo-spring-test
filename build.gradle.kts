plugins {
    java
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

group = "io.github.demo.spring"
version = "0.0.1-SNAPSHOT"

val colaVersion by extra { "4.3.1" }
val fastjsonVersion by extra { "2.0.11" }
val mybatisSpringBootVersion by extra { "2.2.2" }
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.AMAZON)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:$mybatisSpringBootVersion")

    runtimeOnly ("mysql:mysql-connector-java")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation(platform("com.alibaba.cola:cola-components-bom:$colaVersion"))
    implementation("com.alibaba.cola:cola-component-dto")
    implementation("com.alibaba.cola:cola-component-exception")
    /* implementation("com.alibaba.cola:cola-component-catchlog-starter")
     implementation("com.alibaba:fastjson:$fastjsonVersion")*/

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:$mybatisSpringBootVersion")
}

tasks.test {
    useJUnitPlatform()
}
