package MoodAnalyzerProject

class MoodAnalyzer {

  def analyzeMood(message: String):String = {
    if(message.contains("SAD")){
      return "SAD"
    }
    else {
      return "HAPPY"
    }

  }

}
