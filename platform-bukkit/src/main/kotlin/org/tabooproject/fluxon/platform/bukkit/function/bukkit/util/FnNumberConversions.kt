package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.NumberConversions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.NumberConversions"])
@PlatformSide(Platform.BUKKIT)
object FnNumberConversions {

    val TYPE = Type.fromClass(NumberConversions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NumberConversions::class.java)
                // static
                .function("floor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.floor(it.getDouble(0))) }
                // static
                .function("ceil", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.ceil(it.getDouble(0))) }
                // static
                .function("round", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.round(it.getDouble(0))) }
                // static
                .function("square", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.square(it.getDouble(0))) }
                // static
                .function("toInt", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toInt(it.getRef(0))) }
                // static
                .function("toFloat", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toFloat(it.getRef(0))) }
                // static
                .function("toDouble", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toDouble(it.getRef(0))) }
                // static
                .function("toLong", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toLong(it.getRef(0))) }
                // static
                .function("toShort", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toShort(it.getRef(0))) }
                // static
                .function("toByte", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NumberConversions.toByte(it.getRef(0))) }
                // static
                .function("isFinite", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Double -> NumberConversions.isFinite(var1)
                        is Float -> NumberConversions.isFinite(var1)
                        else -> throw IllegalArgumentException("参数必须是 Double 或 Float 类型")
                    })
                }
                // static
                .function("checkFinite", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Double -> NumberConversions.checkFinite(var1, it.getString(1)!!)
                        is Float -> NumberConversions.checkFinite(var1, it.getString(1)!!)
                        else -> throw IllegalArgumentException("第一个参数必须是 Double 或 Float 类型")
                    })
                }
        }
    }
}
