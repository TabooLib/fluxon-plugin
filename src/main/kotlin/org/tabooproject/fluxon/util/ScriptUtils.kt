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
@Suppress("UNCHECKED_CAST")
fun Function.invoke(env: Environment, args: Array<Any?>, target: Any?): Any? {
    val pool = FunctionContextPool.local()
    val borrowed = pool.borrow(this, target, args as Array<Any>, env)
    try {
        call(borrowed)
        return borrowed.returnRef
    } finally {
        borrowed.close()
    }
}

// 原始的 invokeInline 函数，不带性能追踪
@Suppress("UNCHECKED_CAST")
fun Function.invokeInline(env: Environment, count: Int, args0: Any?, args1: Any?, args2: Any?, args3: Any?, target: Any?): Any? {
    val pool = FunctionContextPool.local()
    val args = arrayOfNulls<Any>(count)
    if (count > 0) args[0] = args0
    if (count > 1) args[1] = args1
    if (count > 2) args[2] = args2
    if (count > 3) args[3] = args3
    val borrowed = pool.borrow(this, target, args as Array<Any>, env)
    try {
        call(borrowed)
        return borrowed.returnRef
    } finally {
        borrowed.close()
    }
}

// 带性能追踪的 invoke 函数，仅在性能分析时使用
@Suppress("UNCHECKED_CAST")
fun Function.invokeWithProfiling(env: Environment, args: Array<Any?>, target: Any?): Any? {
    val event = FunctionCallEvent()
    event.begin()
    event.functionName = name
    event.argumentCount = args.size
    event.hasTarget = target != null
    event.targetType = target?.javaClass?.simpleName ?: "null"
    try {
        val pool = FunctionContextPool.local()
        val borrowed = pool.borrow(this, target, args as Array<Any>, env)
        try {
            call(borrowed)
            return borrowed.returnRef
        } finally {
            borrowed.close()
        }
    } finally {
        event.commit()
    }
}

// 带性能追踪的 invokeInline 函数，仅在性能分析时使用
@Suppress("UNCHECKED_CAST")
fun Function.invokeInlineWithProfiling(env: Environment, count: Int, args0: Any?, args1: Any?, args2: Any?, args3: Any?, target: Any?): Any? {
    val event = FunctionCallEvent()
    event.begin()
    event.functionName = name
    event.argumentCount = count
    event.hasTarget = target != null
    event.targetType = target?.javaClass?.simpleName ?: "null"
    try {
        val pool = FunctionContextPool.local()
        val args = arrayOfNulls<Any>(count)
        if (count > 0) args[0] = args0
        if (count > 1) args[1] = args1
        if (count > 2) args[2] = args2
        if (count > 3) args[3] = args3
        val borrowed = pool.borrow(this, target, args as Array<Any>, env)
        try {
            call(borrowed)
            return borrowed.returnRef
        } finally {
            borrowed.close()
        }
    } finally {
        event.commit()
    }
}
