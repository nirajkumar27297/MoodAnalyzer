package MoodAnalyzerProject
class MoodAnalysisException(msg:CustomException.Value) extends Exception(msg.toString){}

class MoodAnalyzer(messageParameter: String) {
  val message: String = messageParameter.asInstanceOf[String]

  def this() {
    this("SAD")
  }


  def isEqual(secondObject: Any) =
    secondObject.isInstanceOf[MoodAnalyzer] && secondObject.asInstanceOf[MoodAnalyzer].message == message

  def analyzeMood(): String = {
    try {
      if (this.message.length == 0) {
        throw new MoodAnalysisException(CustomException.emptyString)
      }
      else if (this.message.contains("SAD")) {
        return "SAD"
      }
      else {
        return "HAPPY"
      }
    }
    catch {
      case ex: NullPointerException => throw new MoodAnalysisException(CustomException.nullString)
    }
  }
}

