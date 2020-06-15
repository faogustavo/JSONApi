package dev.valvassori.jsonapi

import TestAnnotation
import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
class EntityProcessor : AbstractProcessor() {

    override fun getSupportedAnnotationTypes() = setOf<String>(
        TestAnnotation::class.java.name
    )

    override fun getSupportedSourceVersion() = SourceVersion.latest()

    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment
    ): Boolean {
        println("Hello from annotation processor!")
        return false
    }
}