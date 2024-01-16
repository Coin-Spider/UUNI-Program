package com.uuni.do_not_forget.Core.Security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class UserRole {
    ADMIN, USER;

    fun getGrantedAuthority(): Collection<GrantedAuthority> {
        return when (this) {
            ADMIN -> listOf(
                SimpleGrantedAuthority(getRole()),
                SimpleGrantedAuthority(USER.getRole())
            )
            USER -> listOf(SimpleGrantedAuthority(USER.getRole()))
        }
    }
    private fun getRole(): String = "ROLE_$name"
}