package moodAnalyzerTest
import MoodAnalyzerProject.MoodAnalyzer
import org.scalatest.FunSuite

class MoodAnalyzerTestCases extends FunSuite {


  test("MoodAnlyzerTest") {
    val objMoodAnalyzer = new MoodAnalyzer("I am in SAD mood")
    assert {
      objMoodAnalyzer.analyzeMood() == "SAD"
    }
  }
  test("MoodAnalyzerTestHappy") {
    val objMoodAnalyzer = new MoodAnalyzer("I am in ANY mood")
    assert {
      objMoodAnalyzer.analyzeMood() == "HAPPY"
    }
  }
}



