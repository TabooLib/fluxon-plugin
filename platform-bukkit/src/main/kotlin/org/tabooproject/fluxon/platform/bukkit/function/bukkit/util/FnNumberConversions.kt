package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.NumberConversions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
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
                .function("floor",returns(Type.I).params(Type.D)) { it.setReturnInt(NumberConversions.floor(it.getDouble(0))) }
                // static
                .function("ceil",returns(Type.I).params(Type.D)) { it.setReturnInt(NumberConversions.ceil(it.getDouble(0))) }
                // static
                .function("round",returns(Type.I).params(Type.D)) { it.setReturnInt(NumberConversions.round(it.getDouble(0))) }
                // static
                .function("square",returns(Type.D).params(Type.D)) { it.setReturnDouble(NumberConversions.square(it.getDouble(0))) }
                // static
                .function("toInt",returns(Type.I).params(Type.OBJECT)) { it.setReturnInt(NumberConversions.toInt(it.getRef(0))) }
                // static
                .function("toFloat",returns(Type.F).params(Type.OBJECT)) { it.setReturnFloat(NumberConversions.toFloat(it.getRef(0))) }
                // static
                .function("toDouble",returns(Type.D).params(Type.OBJECT)) { it.setReturnDouble(NumberConversions.toDouble(it.getRef(0))) }
                // static
                .function("toLong",returns(Type.J).params(Type.OBJECT)) { it.setReturnLong(NumberConversions.toLong(it.getRef(0))) }
                // static
                .function("toShort",returns(Type.I).params(Type.OBJECT)) { it.setReturnInt(NumberConversions.toShort(it.getRef(0)).toInt()) }
                // static
                .function("toByte",returns(Type.I).params(Type.OBJECT)) { it.setReturnInt(NumberConversions.toByte(it.getRef(0)).toInt()) }
                // static
                .function("isFinite", returns(Type.Z).params(Type.D)) { it.setReturnBool(NumberConversions.isFinite(it.getDouble(0))) }
                .function("isFinite", returns(Type.Z).params(Type.F)) { it.setReturnBool(NumberConversions.isFinite(it.getFloat(0))) }
                // static
                .function("checkFinite",returnsVoid().params(Type.D, Type.STRING)) { NumberConversions.checkFinite(it.getDouble(0), it.getString(1)!!) }
                .function("checkFinite",returnsVoid().params(Type.F, Type.STRING)) { NumberConversions.checkFinite(it.getFloat(0), it.getString(1)!!) }
        }
    }
}
