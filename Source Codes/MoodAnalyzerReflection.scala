package MoodAnalyzerProject

object MoodAnalyzerReflection {
  var className:String = "MoodAnalyzerProject.MoodAnalyzer"
  def createObject(className: String = "MoodAnalyzer", message:Any = None): MoodAnalyzer = {
    createObjectHelper(className,Some(message))
  }
  def createObjectHelper(className:String, message: Option[Any]): MoodAnalyzer = {
    try {
      if (className.equals("MoodAnalyzer")) {
        message match {
          case Some(None) =>
            return checkConstructorDefault()
          case Some(msg) =>
            return checkConstructorParameterized(msg)
        }
      }
      else {
        throw new MoodAnalysisException(CustomException.wrongClassName)
      }
    }
  }

  def checkConstructorDefault(): MoodAnalyzer = {
    try {
      val methods = Class.forName(className).getConstructor()
      val obj = methods.newInstance()
      return obj.asInstanceOf[MoodAnalyzer]
    }
    catch {
      case ex: NoSuchMethodException => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }

  def checkConstructorParameterized(msg:Any): MoodAnalyzer = {
    val msgClass = msg.getClass
    try {
      val methods = Class.forName(className).getConstructor(Class.forName(msgClass.getName))
      val obj = methods.newInstance(msg.asInstanceOf[String])
      return obj.asInstanceOf[MoodAnalyzer]
    }
    catch {
      case ex:NoSuchMethodException => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }

  def checkMethodValidity(methodName:String = "analyzeMood",msg:Any = None): AnyRef ={
    try {
      val obj = createObject(message = msg)
      val method = obj.getClass().getMethod(methodName)
      return method.invoke(obj)
    }
    catch {
      case ex:NoSuchMethodException => throw new MoodAnalysisException(CustomException.noSuchMethod)
    }
  }

  def setField(methodName:String = "analyzeMood",fieldName:String = "message",fieldValue:String = "HAPPY"): AnyRef = {
    try {
      checkMethodValidity(methodName)
      val field = Class.forName(className).getDeclaredField(fieldName)
      field.setAccessible(true)
      val obj = createObject(message = fieldValue)
      field.set(obj,fieldValue)
      val method = Class.forName(className).getMethod("analyzeMood")
      return method.invoke(obj)
    }
    catch {
      case ex: NoSuchFieldException => throw new MoodAnalysisException(CustomException.noSuchField)
      case ex: NullPointerException => throw new MoodAnalysisException(CustomException.nullString)
    }
  }
}
