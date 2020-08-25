package MoodAnalyzerProject

class MoodAnalysisException(msg:String) extends Exception(msg){}

class checkMoodException {
  @throws(classOf[MoodAnalysisException])
  def validateMood(msg:String): Unit = {
    if (msg == null) {
      throw new MoodAnalysisException("HAPPY")
    }
    else if(msg == "") {
      throw new MoodAnalysisException("EMPTY STRING")
    }
  }
}

class MoodAnalyzer(message:String) {
  val this.message:String = message

  def this(){
    this("SAD")
  }
  def analyzeMood():String = {
    val checkMood = new checkMoodException()
    try {
      checkMood.validateMood(this.message)
      if (this.message.contains("SAD")) {
        return "SAD"
      }

      else {
        return "HAPPY"
      }
    }
    catch {
      case ex: Exception => throw ex
    }
  }
}