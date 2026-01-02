package org.tabooproject.fluxon.function

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common5.cbool
import taboolib.library.reflex.Reflex.Companion.getProperty
import taboolib.library.reflex.Reflex.Companion.invokeMethod
import taboolib.library.reflex.Reflex.Companion.setProperty

object FunctionReflex {

    @Awake(LifeCycle.CONST)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Any::class.java)
                .function("property", listOf(1, 3)) {
                    val findToParent = it.getArgument(1)?.cbool ?: true
                    val remap = it.getArgument(2)?.cbool ?: true
                    it.target?.getProperty(it.getArgument(0).toString(), findToParent = findToParent, remap = remap)
                }
                .function("staticProperty", listOf(1, 3)) {
                    val findToParent = it.getArgument(1)?.cbool ?: true
                    val remap = it.getArgument(2)?.cbool ?: true
                    it.target?.getProperty(it.getArgument(0).toString(), isStatic = true, findToParent = findToParent, remap = remap)
                }
                .function("setProperty", listOf(2, 4)) {
                    val value = it.getArgument(1)
                    val findToParent = it.getArgument(2)?.cbool ?: true
                    val remap = it.getArgument(3)?.cbool ?: true
                    it.target?.setProperty(it.getArgument(0).toString(), value, findToParent = findToParent, remap = remap)
                }
                .function("setStaticProperty", listOf(2, 4)) {
                    val value = it.getArgument(1)
                    val findToParent = it.getArgument(2)?.cbool ?: true
                    val remap = it.getArgument(3)?.cbool ?: true
                    it.target?.setProperty(it.getArgument(0).toString(), value, isStatic = true, findToParent = findToParent, remap = remap)
                }
                .function("invokeMethod", listOf(2, 4)) {
                    val parameters = (it.getArgument(1) as List<Any?>).toTypedArray()
                    val findToParent = it.getArgument(2)?.cbool ?: true
                    val remap = it.getArgument(3)?.cbool ?: true
                    it.target?.invokeMethod(it.getArgument(0).toString(), *parameters, findToParent = findToParent, remap = remap)
                }
                .function("invokeStaticMethod", listOf(2, 4)) {
                    val parameters = (it.getArgument(1) as List<Any?>).toTypedArray()
                    val findToParent = it.getArgument(2)?.cbool ?: true
                    val remap = it.getArgument(3)?.cbool ?: true
                    it.target?.invokeMethod(it.getArgument(0).toString(), *parameters, isStatic = true, findToParent = findToParent, remap = remap)
                }
        }
    }
}