
plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(Dependencies.kotlin)

    implementation(project(Projects.Annotations))

    implementation(Dependencies.autoServiceAnnotations)
    kapt(Dependencies.autoService)

    testImplementation(Dependencies.junit)
}
