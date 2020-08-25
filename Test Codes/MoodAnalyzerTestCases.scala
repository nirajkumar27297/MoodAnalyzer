package moodAnalyzerTest
import MoodAnalyzerProject.MoodAnalyzer
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

  test("MoodAnalyzerTest_InputIs_Null_ReturnException") {
    val objMoodAnalyzer = new MoodAnalyzer(null)
    val thrown = intercept[NullPointerException] {
      objMoodAnalyzer.analyzeMood()
    }
    assert(thrown.getMessage == "HAPPY")
    }

}



