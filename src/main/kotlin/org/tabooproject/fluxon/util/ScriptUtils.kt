package org.tabooproject.fluxon.util

import org.tabooproject.fluxon.FluxonScript
import org.tabooproject.fluxon.profiler.FunctionCallEvent
import org.tabooproject.fluxon.runtime.Environment
import org.tabooproject.fluxon.runtime.Function
import org.tabooproject.fluxon.runtime.FunctionContextPool

fun Environment.getFluxonScript(): FluxonScript? {
    return rootVariables["__script__"] as? FluxonScript
}

// 原始的 invoke 函数，不带性能追踪
fun Function.invoke(env: Environment, args: Array<Any?>, target: Any?): Any? {
    val pool = FunctionContextPool.local()
    val borrowed = pool.borrow(this, target, args, env)
    return try {
        call(borrowed)
    } finally {
        pool.release(borrowed)
    }
}

// 原始的 invokeInline 函数，不带性能追踪
fun Function.invokeInline(env: Environment, count: Int, args0: Any?, args1: Any?, args2: Any?, args3: Any?, target: Any?): Any? {
    val pool = FunctionContextPool.local()
    val borrowed = pool.borrowInline(this, target, count, args0, args1, args2, args3, env)
    return try {
        call(borrowed)
    } finally {
        pool.release(borrowed)
    }
}

// 带性能追踪的 invoke 函数，仅在性能分析时使用
fun Function.invokeWithProfiling(env: Environment, args: Array<Any?>, target: Any?): Any? {
    val event = FunctionCallEvent()
    event.begin()
    event.functionName = name
    event.argumentCount = args.size
    event.hasTarget = target != null
    event.targetType = target?.javaClass?.simpleName ?: "null"
    return try {
        val pool = FunctionContextPool.local()
        val borrowed = pool.borrow(this, target, args, env)
        try {
            call(borrowed)
        } finally {
            pool.release(borrowed)
        }
    } finally {
        event.commit()
    }
}

// 带性能追踪的 invokeInline 函数，仅在性能分析时使用
fun Function.invokeInlineWithProfiling(env: Environment, count: Int, args0: Any?, args1: Any?, args2: Any?, args3: Any?, target: Any?): Any? {
    val event = FunctionCallEvent()
    event.begin()
    event.functionName = name
    event.argumentCount = count
    event.hasTarget = target != null
    event.targetType = target?.javaClass?.simpleName ?: "null"
    return try {
        val pool = FunctionContextPool.local()
        val borrowed = pool.borrowInline(this, target, count, args0, args1, args2, args3, env)
        try {
            call(borrowed)
        } finally {
            pool.release(borrowed)
        }
    } finally {
        event.commit()
    }
}