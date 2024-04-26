package com.testcase.junit_testcase.mockito.LogIn

class UserRepository {

    val users = listOf<User>(
        User(1, "john", "john@gmail.com", "john123"),
        User(2, "wein", "wein@gmail.com", "wein123"),
        User(3, "emily", "emily@gmail.com", "emily123")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val users = users.filter { user: User -> user.email == email }

        return if (users.size == 1) {
            if (users[0].password == password) LOGIN_STATUS.SUCCESS else LOGIN_STATUS.INVALID_PASSWORD
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}