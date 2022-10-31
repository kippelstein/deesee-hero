package com.company.poc.web.exceptions

import com.company.poc.application.common.exceptions.NotFoundException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.NativeWebRequest
import org.zalando.problem.Problem
import org.zalando.problem.Status
import org.zalando.problem.jackson.ProblemModule
import org.zalando.problem.spring.web.advice.ProblemHandling
import org.zalando.problem.violations.ConstraintViolationProblemModule

@ControllerAdvice
internal class CustomExceptionHandler(objMapper: ObjectMapper) : ProblemHandling {
    init {
        objMapper.registerModules(
            ProblemModule(),
            ConstraintViolationProblemModule()
        )
    }

    @ExceptionHandler
    fun handleException(exc: Exception, request: NativeWebRequest): ResponseEntity<Problem> {
        val problem = Problem
            .builder()
            .withStatus(Status.INTERNAL_SERVER_ERROR)
            .withTitle("An unhandled exception occurred")
            .withDetail("Please contact your administrator")
            .with("error", exc.message)
            .build()

        return create(exc, problem, request)
    }

    @ExceptionHandler
    fun handleIllegalArgumentException(
        exc: IllegalArgumentException,
        request: NativeWebRequest
    ): ResponseEntity<Problem> {
        val problem = Problem
            .builder()
            .withStatus(Status.BAD_REQUEST)
            .withTitle("Something went wrong")
            .withDetail(exc.message)
            .build()

        return create(exc, problem, request)
    }

    @ExceptionHandler
    fun handleAccessDeniedException(
        exc: NotFoundException,
        request: NativeWebRequest
    ): ResponseEntity<Problem> {
        val problem = Problem
            .builder()
            .withStatus(Status.NOT_FOUND)
            .withTitle("Hero not found")
            .withDetail(exc.message)
            .build()

        return create(exc, problem, request)
    }
}
