object Header {

    /**
      * Convert single header to Pascal case
      *
      * @param header
      * @return
      */
    def toPascalCaseSingle(header: String): String = header(0).toString.capitalize + header.substring(1).toLowerCase()
    
    /**
      * Convert multi-word header to Pascal case
      *
      * @param header
      * @return
      */
    def toPascalCase(header: String): String = header.split("[ _]").map(toPascalCaseSingle).mkString 
    
    /**
      * Convert header row to Pascal case 
      *
      * @param headers
      * @return
      */
    def headersToPascalCase(headers: String): String = headers.split("[,]").map(toPascalCase).mkString(",")
}