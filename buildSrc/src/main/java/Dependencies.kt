object Versions {
    val kotlin = "1.3.70"
    val junit = "4.13"

    val autoService = "1.0-rc7"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val junit = "junit:junit:${Versions.junit}"

    val autoService = "com.google.auto.service:auto-service:${Versions.autoService}"
    val autoServiceAnnotations = "com.google.auto.service:auto-service-annotations:${Versions.autoService}"
}

object Projects {
    const val Lib = ":jsonapi"
    const val Annotations = ":jsonapi-annotations"
}

object Distribution {
    const val version = "2.0.0-dev01"
    const val groupId = "dev.valvassori.jsonapi"

    object Core {
        const val artifactId = "core"
    }

    object Annotations {
        const val artifactId = "annotations"
    }
}