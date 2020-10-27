case class PrecipitationSample(
    station: String, 
    stationName: String, 
    elevation: Double, 
    latitude: Double, 
    longitude: Double, 
    date: String, 
    hpcp: Int, 
    measurement: String, 
    qualityFlag: String
)

object App {

    val PATH = "/home/jlcanela/dev/dsti-s20/PRECIP_HLY_sample_csv.csv"
    val EXPECTED_HEADER = "STATION,STATION_NAME,ELEVATION,LATITUDE,LONGITUDE,DATE,HPCP,Measurement Flag,Quality Flag"

    def readFile(path: String = PATH): List[String] = scala.io.Source.fromFile(new java.io.File(path)).getLines().toList

    def validateFile(data: List[String]) = {
        if (data(0) != EXPECTED_HEADER) {
            throw new Exception("invalid header")
        }
        /*
        header not compliant: the expected header is not the right one
        header is different
        because of blank space
        because of order of columns
        data is invalid
        because of use of another separator instead of the expected one
        separator also used in the data and causes a column mismatch in the extracted data
        encoding mismatch: encoding is not the expected one
        datetime representation is not the expected one
        datetime value can also be dependant of context
        locale could be incorrect, which causes issues with datetime representation / currency / numbers
        data is too big and causes memory issues
        */
    }

    def processFile(data: List[String]) = {
        print(data(1))
    }

    /**
      * Transform CSV line into a PrecipitationSample object
      *
      * @param line
      * @return
      */
    def toPrecipitationSample(line: String): PrecipitationSample = {
        val Array(
            station: String, 
            stationName: String, 
            elevationAsString: String, 
            latitudeAsString: String, 
            longitudeAsString: String, 
            date: String, 
            hpcpAsString: String, 
            measurement: String, 
            qualityFlag: String
        ) = line.split(",")

        val ps = PrecipitationSample(
            station, 
            stationName, 
            elevationAsString.toDouble, 
            latitudeAsString.toDouble, 
            longitudeAsString.toDouble, 
            date, 
            hpcpAsString.toInt, 
            measurement, 
            qualityFlag
        )
        return ps
    }

    def main(args: Array[String]) = {
        val data = readFile("/home/jlcanela/dev/dsti-s20/BADFILE1.txt")
        validateFile(data)
        processFile(data)
    }

}
