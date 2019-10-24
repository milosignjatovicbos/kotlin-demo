package no.dossier.app.kotlindemo.backend.controllers;

import no.dossier.app.kotlindemo.api.RestEndpoint;
import no.dossier.app.kotlindemo.domain.DossierApplication
import no.dossier.app.kotlindemo.domain.ProductInfo
import no.dossier.app.kotlindemo.domain.dossierApplicationModule
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlinx.serialization.json.*

@RestController
class ProductController {

  @GetMapping(RestEndpoint.Urls.GET_PRODUCT)
  fun getProducts(@PathVariable productId: String): String /* ProductInfo */ {
    val json = Json(context = dossierApplicationModule)

    val product = ProductInfo(DossierApplication.DossierProFile(
            "Helse Vest DM", "Datamart for Helse Vest"))

    return json.stringify(ProductInfo.serializer(), product)
  }

}
