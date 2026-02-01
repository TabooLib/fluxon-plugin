package org.tabooproject.fluxon.function

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.function.registerLifeCycleTask

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.function.FnEnumGetter
 *
 * @author mical
 * @since 2026/2/1 19:55
 */
abstract class FnEnumGetter<E : Enum<E>> {

    abstract val enumClass: Class<E>
    val TYPE: Type = Type.fromClass(enumClass)

    init {
        registerLifeCycleTask(LifeCycle.INIT) {
            val className = javaClass.simpleName.removePrefix("Fn")
            val name = className[0] + className.substring(1)
            FluxonRuntime.getInstance().registerFunction(name, returns(TYPE).params(Type.STRING)) {
                it.setReturnRef(enumValue(it.getString(0)))
            }
        }
    }

    fun enumValue(value: String): E? {
        return try {
            java.lang.Enum.valueOf(enumClass, value)
        } catch (_: IllegalArgumentException) {
            null
        }
    }
}