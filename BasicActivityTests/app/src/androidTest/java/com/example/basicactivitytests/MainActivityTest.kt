package com.example.basicactivitytests

import android.app.Activity
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.PreferenceMatchers.withTitle
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.extensions.ActiveTestSuite
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun isStarted(){
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun isHeaderAndButtonDisplayed(){
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main_activity_title)).check(matches(isDisplayed()))
        onView(withId(R.id.next_button)).check(matches(isDisplayed()))
    }

    @Test
    fun isCorrectTitle(){
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_activity_title)).check(matches(withText("Main Activity")))
    }

    @Test
    fun isTitleAmdButtonVisible(){
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main_activity_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.next_button)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun isNavigated(){
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.next_button)).perform(click())

        onView(withId(R.id.second_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.second_activity_title)).check(matches(isDisplayed()))
        onView(withId(R.id.back_button)).check(matches(isDisplayed()))

    }

    @Test
    fun isNavigatedBack()
    {
        val ActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.next_button)).perform(click())

        onView(withId(R.id.back_button)).check(matches(isDisplayed()))

        onView(withId(R.id.back_button)).perform(click())

        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

}