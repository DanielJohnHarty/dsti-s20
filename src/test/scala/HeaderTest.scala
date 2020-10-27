import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._


class ExampleSpec extends AnyFlatSpec with should.Matchers {

  "Header" should "convert to PascalCase" in {
    Header.toPascalCase("STATION") should be("Station")
    Header.toPascalCase("STATION_NAME") should be("StationName")
    Header.toPascalCase("ELEVATION") should be("Elevation")
    Header.toPascalCase("LATITUDE") should be("Latitude")
    Header.toPascalCase("LONGITUDE") should be("Longitude")
    Header.toPascalCase("DATE") should be("Date")
    Header.toPascalCase("HPCP") should be("Hpcp")
    Header.toPascalCase("Measurement Flag") should be("MeasurementFlag")
    Header.toPascalCase("Quality Flag") should be("QualityFlag")
  }

  "Headers" should "convert to PascalCase" in {
    Header
    .headersToPascalCase("STATION,STATION_NAME,ELEVATION,LATITUDE,LONGITUDE,DATE,HPCP,Measurement Flag,Quality Flag") should be ("Station,StationName,Elevation,Latitude,Longitude,Date,Hpcp,MeasurementFlag,QualityFlag")
  }

}