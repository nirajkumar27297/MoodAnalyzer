package MoodAnalyzerProject

object CustomException extends Enumeration {
  type CustomException = Value

  val nullString = Value("Message cannot be null")
  val emptyString = Value("Length should be greater than zero")
}
