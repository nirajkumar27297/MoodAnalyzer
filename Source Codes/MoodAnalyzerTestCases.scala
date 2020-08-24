package moodAnalyzerTest
import MoodAnalyzerProject.MoodAnalyzer
import org.scalatest.FunSuite

class MoodAnalyzerTestCases extends FunSuite {


  test("MoodAnlyzerTest") {
    val objMoodAnalyzer = new MoodAnalyzer()
    assert {
      objMoodAnalyzer.analyzeMood("I am in SAD mood") == "SAD"
    }
  }
}



