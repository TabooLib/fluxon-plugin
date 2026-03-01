package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.WorldType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.WorldType"])
@PlatformSide(Platform.BUKKIT)
object FnWorldType : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.WorldType>() {

    override val enumClass: Class<org.bukkit.WorldType> = org.bukkit.WorldType::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldType::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getName()) }
                // static
                .function("getByName", returns(TYPE).params(Type.STRING)) { it.setReturnRef(WorldType.getByName(it.getString(0)!!)) }
        }
    }
}
