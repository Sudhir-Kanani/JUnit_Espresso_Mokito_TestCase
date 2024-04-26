package com.testcase.junit_testcase.mockito.LogIn

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class userServiceTest {

    // we create userRepository mock object because we test UserService class but it's depend on userRepository class so
    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        // init mock objects
        MockitoAnnotations.openMocks(this)

        // fix userRepository behaviour so any input given in loginUser always output is INVALID_PASSWORD
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService(){
        val sut = UserService(userRepository)
       val result =  sut.loginUser("test@gmail.com","test123")
        assertEquals("password is invalid",result)
    }
}