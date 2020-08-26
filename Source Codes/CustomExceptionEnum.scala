package MoodAnalyzerProject

object CustomException extends Enumeration {
  type CustomException = Value

  val nullString = Value("Message cannot be null")
  val emptyString = Value("Length should be greater than zero")
  val wrongClassName = Value("No Such Class Error")
  val noSuchMethod = Value("No Such Method Error")
  val noSuchField = Value("No Such Field Error")
}
