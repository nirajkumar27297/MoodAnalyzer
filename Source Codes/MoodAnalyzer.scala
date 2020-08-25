package MoodAnalyzerProject

class MoodAnalyzer(message:String) {
  val this.message:String = message

  def this(){
    this("SAD")
  }
  def analyzeMood():String = {

    try {
      if(this.message == null){
        throw new NullPointerException("HAPPY")
      }
      if (this.message.contains("SAD")) {
        return "SAD"
      }

      else {
        return "HAPPY"
      }
    }
    catch {
      case ex: NullPointerException => throw ex
    }
  }
}











