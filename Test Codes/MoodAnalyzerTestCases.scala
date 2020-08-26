package moodAnalyzerTest
import MoodAnalyzerProject.{CustomException, MoodAnalysisException, MoodAnalyzer, MoodAnalyzerFactory, MoodAnalyzerReflection}
import org.scalatest.FunSuite


class MoodAnalyzerTestCases extends FunSuite {

  test("MoodAnalyzerTest_InputIs_InSadMood_ReturnSAD") {
    val objMoodAnalyzer = new MoodAnalyzer("I am in SAD mood")
    assert {
      objMoodAnalyzer.analyzeMood() == "SAD"
    }
  }
  test("MoodAnalyzerTest_InputIs_InAnyMood_ReturnHappy") {
    val objMoodAnalyzer = new MoodAnalyzer("I am in ANY mood")
    assert {
      objMoodAnalyzer.analyzeMood() == "HAPPY"
    }
  }

  test("MoodAnalyzerTest_InputIsNull_ReturnCustomException") {
    val objMoodAnalyzer = new MoodAnalyzer(null)
    val thrown = intercept[MoodAnalysisException] {
      objMoodAnalyzer.analyzeMood()
    }
    assert(thrown.getMessage == CustomException.nullString.toString)
  }
  test("MoodAnalyzerTest_InputIsEmpty_ReturnCustomException") {
    val objMoodAnalyzer = new MoodAnalyzer("")
    val thrown = intercept[MoodAnalysisException] {
      objMoodAnalyzer.analyzeMood()
    }
    assert(thrown.getMessage == CustomException.emptyString.toString)
  }
  test("MoodAnalyzerTest_ObjectsAreEqualUsingDefaultConstructor_ReturnTrue"){
    val firstObject = MoodAnalyzerFactory.createObject("MoodAnalyzer")
    val secondObject = MoodAnalyzerFactory.createObject("MoodAnalyzer")
    assert(firstObject.isEqual(secondObject) == true)
  }
  test("MoodAnalyzerTest_PassingWrongClassName_ReturnException"){

    val thrown = intercept[MoodAnalysisException] {
      val firstObject = MoodAnalyzerFactory.createObject("moodAnalyzer")
    }
    assert(thrown.getMessage == CustomException.wrongClassName.toString)
  }
  test("MoodAnalyzerTest_PassingWrongConstructorParameter_ReturnException") {
    val thrown = intercept[MoodAnalysisException] {
    MoodAnalyzerFactory.createObject("MoodAnalyzer",5)
    }
    assert(thrown.getMessage == CustomException.noSuchMethod.toString)
  }
  test("MoodAnalyzerTest_PassingDefaultConstructorParameter_ReturnMoodAnalyzerObject") {
      val firstObject = MoodAnalyzerFactory.createObject("MoodAnalyzer")
      assert(firstObject.isInstanceOf[MoodAnalyzer] == true)
  }
  test("MoodAnalyzerTest_PassingParameterizedConstructor_ReturnMoodAnalyzerObject") {
    val firstObject = MoodAnalyzerFactory.createObject("MoodAnalyzer","Hello")
    assert(firstObject.isInstanceOf[MoodAnalyzer] == true)
  }
  test("MoodAnalyzerTest_ImproperMethod_ReturnException") {
    val firstObject = MoodAnalyzerFactory.createObject("MoodAnalyzer","Hello")
    assert(firstObject.isInstanceOf[MoodAnalyzer] == true)
  }
  test("MoodAnalyzerTest_PassingWrongMethodName_ReturnException") {
    val thrown = intercept[MoodAnalysisException] {
      MoodAnalyzerReflection.checkMethodValidity("MoodAnalyzer","HAPPY")
    }
    assert(thrown.getMessage == CustomException.noSuchMethod.toString)
  }
  test("MoodAnalyzerTest_PassingRightMethodName_ReturnHAPPY") {
      val result = MoodAnalyzerReflection.checkMethodValidity("analyzeMood","HAPPY")
      assert(result == "HAPPY")
  }
  test("MoodAnalyzerTest_InputMethodNameAndFieldNameAndFieldValue_SetFieldValueHAPPY_ReturnHAPPY") {
    val result = MoodAnalyzerReflection.setField("analyzeMood","message","HAPPY")
    assert(result == "HAPPY")
  }
  test("MoodAnalyzerTest_InputMethodNameAndWrongFieldNameAndFieldValue_ReturnException") {
    val thrown = intercept[MoodAnalysisException] {
      MoodAnalyzerReflection.setField("analyzeMood", "msg", "HAPPY")
    }
    assert(thrown.getMessage == CustomException.noSuchField.toString)
  }
  test("MoodAnalyzerTest_InputMethodNameAndFieldNameAndFieldValueAsNull_ReturnException") {
    val thrown = intercept[MoodAnalysisException] {
      MoodAnalyzerReflection.setField("analyzeMood", "message", null)
    }
    assert(thrown.getMessage == CustomException.nullString.toString)
  }


}




