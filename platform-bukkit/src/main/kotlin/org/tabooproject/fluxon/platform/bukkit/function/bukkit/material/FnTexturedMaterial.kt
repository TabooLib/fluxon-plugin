package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.Material
import org.bukkit.material.TexturedMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.TexturedMaterial"])
@PlatformSide(Platform.BUKKIT)
object FnTexturedMaterial {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TexturedMaterial::class.java)
                .function("textures", returnsObject().noParams()) { it.setReturnRef(it.target?.textures) }
                .function("material", returnsObject().noParams()) { it.setReturnRef(it.target?.material) }
                .function("setMaterial", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaterial(it.getRef(0) as Material)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
