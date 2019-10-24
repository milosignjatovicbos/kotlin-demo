package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule

@Serializable
class ProductInfo(@Polymorphic val product: DossierApplication)

sealed class DossierApplication {
    @Serializable class DossierProFile(val instanceName: String, val description: String): DossierApplication()
    @Serializable class DossierProFileDM(
            val instanceName: String, val description: String, val isMaster: Boolean): DossierApplication()
}

val dossierApplicationModule = SerializersModule {
    polymorphic<DossierApplication> {
        DossierApplication.DossierProFile::class with DossierApplication.DossierProFile.serializer()
        DossierApplication.DossierProFileDM::class with DossierApplication.DossierProFileDM.serializer()
    }
}