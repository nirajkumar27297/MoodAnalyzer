package MoodAnalyzerProject

object MoodAnalyzerReflection {
  def createObject(className: String = "MoodAnalyzer", message:Any = None): MoodAnalyzer = {
    createObjectHelper(className,Some(message))
  }
  def createObjectHelper(className:String, message: Option[Any]): MoodAnalyzer = {
    try {
      if (className.equals("MoodAnalyzer")) {
        message match {
          case Some(None) =>
            return checkConstructorDefault("MoodAnalyzerProject.MoodAnalyzer")
          case Some(msg) =>
            return checkConstructorParameterized("MoodAnalyzerProject.MoodAnalyzer",msg)
        }
      }
      else {
        throw new MoodAnalysisException(CustomException.wrongClassName)
      }
    }
  }

  def checkConstructorDefault(className: String): MoodAnalyzer = {
    try {
      val methods = Class.forName(className).getConstructor()
      val obj = methods.newInstance()
      return obj.asInstanceOf[MoodAnalyzer]
    }
    catch {
      case ex: NoSuchMethodException => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }

  def checkConstructorParameterized(className:String,msg:Any): MoodAnalyzer = {
    val msgClass = msg.getClass
    try {
      val methods = Class.forName(className).getConstructor(Class.forName(msgClass.getName))
      val obj = methods.newInstance(msg.asInstanceOf[String])
      return obj.asInstanceOf[MoodAnalyzer]
    }
    catch {
      case ex:Exception => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }

  def checkMethodValidity(methodName:String ="analyzeMood",msg:Any = None): AnyRef ={
    try {
      val obj = MoodAnalyzerFactory.createObject(message = msg)
      val methods = obj.getClass.getDeclaredMethods
      val method = obj.getClass().getMethod(methodName)
      return method.invoke(obj)
    }
    catch {
      case ex:Exception => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }
}
