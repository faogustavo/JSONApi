
plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(Dependencies.kotlin)
    implementation(project(Projects.Annotations))
    kapt(project(Projects.Lib))
}
