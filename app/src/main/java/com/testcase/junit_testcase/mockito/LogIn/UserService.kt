package com.testcase.junit_testcase.mockito.LogIn

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email:String, password:String) : String{
        val status = userRepository.loginUser(email, password)
        return  when(status)
        {
            LOGIN_STATUS.INVALID_USER -> "user does not exit"
            LOGIN_STATUS.INVALID_PASSWORD -> "password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "login successfully"
        }
    }
}