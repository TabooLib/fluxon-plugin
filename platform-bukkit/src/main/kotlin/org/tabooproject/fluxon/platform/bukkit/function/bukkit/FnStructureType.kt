package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.StructureType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.StructureType"])
@PlatformSide(Platform.BUKKIT)
object FnStructureType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureType::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
