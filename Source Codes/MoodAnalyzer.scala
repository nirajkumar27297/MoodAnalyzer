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

object MoodAnalyzerFactory {
  def createObject(className: String, message: String = ""): MoodAnalyzer = {
    try {
      if (className.equals("MoodAnalyzer") && message.length == 0) {
        new MoodAnalyzer()
      }
      else if (className.equals("MoodAnalyzer") && message.length > 0) {
        new MoodAnalyzer(message)
      }
      else {
        throw new MoodAnalysisException(CustomException.wrongClassName)
      }
    }

  }

  def checkConstructorDefault(Obj: Any): Unit = {
    val className = Obj.getClass
    var flag = 0
    try {
      if (Obj.getClass.toString.contains("MoodAnalyzer")) {
        //if(className.getDeclaredMethod("message").getParameterCount
        //println(methods)
        val methods = className.getDeclaredConstructors
        for (method <- methods; if method.getName.contains("MoodAnalyzer") && method.getParameterCount == 0) {
          flag = 1
          method.newInstance()
        }
      }
      if (flag == 0) {
        throw new MoodAnalysisException(CustomException.noSuchMethod)
      }
    }
  }
}