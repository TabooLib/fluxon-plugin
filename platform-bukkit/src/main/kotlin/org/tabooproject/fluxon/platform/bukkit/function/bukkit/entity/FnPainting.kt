package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Art
import org.bukkit.entity.Painting
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Painting"])
@PlatformSide(Platform.BUKKIT)
object FnPainting {

    val TYPE = Type.fromClass(Painting::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Painting::class.java)
                .function("art", returnsObject().noParams()) { it.setReturnRef(it.target?.art) }
                .function("setArt", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.setArt(it.getRef(0) as Art) ?: false)
                }
                .function("setArt", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.setArt(it.getRef(0) as Art, it.getBool(1)) ?: false)
                }
        }
    }
}
