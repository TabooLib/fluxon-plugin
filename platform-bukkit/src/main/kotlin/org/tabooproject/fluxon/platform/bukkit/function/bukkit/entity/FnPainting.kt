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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Painting"])
@PlatformSide(Platform.BUKKIT)
object FnPainting {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Painting::class.java)
                .function("art", returnsObject().noParams()) { it.target?.art }
                .function("setArt", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setArt(it.getRef(0) as Art)
                    } else {
                        it.target?.setArt(it.getRef(0) as Art, it.getBool(1))
                    }
                }
                .function("setArt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setArt(it.getRef(0) as Art)
                    } else {
                        it.target?.setArt(it.getRef(0) as Art, it.getBool(1))
                    }
                }
        }
    }
}
