package moodAnalyzerTest
import MoodAnalyzerProject.{CustomException, MoodAnalysisException, MoodAnalyzer}
import org.scalatest.FunSuite


class MoodAnalyzerTestCases extends FunSuite {

  test("MoodAnlyzerTest_InputIs_InSadMood_ReturnSAD") {
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
}



