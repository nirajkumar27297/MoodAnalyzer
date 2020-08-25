package MoodAnalyzerProject

class MoodAnalysisException(msg:CustomException.Value) extends Exception(msg.toString){}

class MoodAnalyzer(message:String) {
  val this.message:String = message

  def this(){
    this("SAD")
  }
  def analyzeMood():String = {
    try {
      if(this.message.length == 0 ){
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
      case ex:NullPointerException => throw new MoodAnalysisException(CustomException.nullString)
    }

  }
}