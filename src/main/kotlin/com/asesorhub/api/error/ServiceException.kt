package com.asesorhub.api.error

import java.io.Serial


class ServiceException(override val message: String, val code: Int) : RuntimeException() {
    companion object {
        @Serial
        private const val serialVersionUID = 1L
    }
}