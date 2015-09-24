import play.api.libs.json._

// Example Code from PUI
case class Link
(
  rawLink: String,
  templated: Option[Boolean] = None) {
}

object Link {
  implicit val linkReads = new Reads[Link] {
    def reads(json: JsValue): JsResult[Link] = JsSuccess {
      val href = (json \ "href").as[String]
      val templated = (json \ "templated").asOpt[Boolean]
      Link(href, templated)
    }
  }
}

case class InvoiceExtractedData
(
  sender: Option[String] = None,
  paymentAmount: Option[String] = None,
  bankAccountNumber: Option[String] = None,
  bankNumber: Option[String] = None,
  customerId: Option[String] = None,
  invoiceId: Option[String] = None,
  bic: Option[String] = None,
  iban: Option[String] = None,
  documentDate: Option[String] = None,
  paymentReference: Option[String] = None,
  _links: Option[Map[String, Link]] = None)

object InvoiceExtractedData {
  implicit val jsonReads = Json.reads[InvoiceExtractedData]
}

def invoice(): JsValue = Json.parse(
  s"""{
     |"sender": "Hans Dampf KG",
     |"paymentAmount": "45.76",
     |"iban": "DE83650501100048001559",
     |"bic": "SOLADES1RVB",
     |"customerId": "01815",
     |"invoiceId": "123456789",
     |"documentDate": "2013-01-03",
     |"_links": {
     |  "self": {
     |      "href": "http://sem/analyses/b092541d5-7171-496a-99d5-f98c72488290/invoice",
     |      "templated": false
     |  },
     |  "analysis": {
     |      "href": "http://sem/analyses/analysisId",
     |      "templated": false
     |  },
     |  "preview": {
     |      "href":"http://bro/blobs/previewId",
     |      "templated": false
     |  }
     |}
     |}
    """.stripMargin)


val invoiceExtractData: JsValue = ???
val bankAccountNumber = ???
val paymentAmount = ???