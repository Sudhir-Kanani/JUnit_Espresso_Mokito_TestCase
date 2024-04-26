package com.testcase.junit_testcase.AddNotes_And_Show

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import com.testcase.junit_testcase.R
import org.junit.Rule
import org.junit.Test

class AddNotes_And_ShowActivityTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<AddNotes_And_ShowActivity>()

    @Test
    fun textSubmitButton_exceptedCorrectValue() {
        onView(withId(R.id.edtTitle)).perform(typeText("Hello"))
        onView(withId(R.id.edtdes)).perform(typeText("Sk"), closeSoftKeyboard())

        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.txtMsg)).check(matches(withText("Title - Hello | Desc - Sk")))

    }
}