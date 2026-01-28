package org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile

import org.bukkit.profile.PlayerTextures
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.net.URL
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.profile.PlayerTextures"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerTextures {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerTextures::class.java)
                .function("isEmpty", returns(Type.Z).noParams()) { it.target?.isEmpty }
                .function("clear", returnsObject().noParams()) { it.target?.clear() }
                .function("skin", returnsObject().noParams()) { it.target?.skin }
                .function("setSkin", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setSkin(URL(it.getString(0)))
                    } else {
                        it.target?.setSkin(
                            URL(it.getString(0)),
                            it.getRef(1) as PlayerTextures.SkinModel
                        )
                    }
                }
                .function("setSkin", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setSkin(URL(it.getString(0)))
                    } else {
                        it.target?.setSkin(
                            URL(it.getString(0)),
                            it.getRef(1) as PlayerTextures.SkinModel
                        )
                    }
                }
                .function("skinModel", returnsObject().noParams()) { it.target?.skinModel }
                .function("cape", returnsObject().noParams()) { it.target?.cape }
                .function("setCape", returnsObject().params(Type.OBJECT)) { it.target?.setCape(URL(it.getString(0))) }
                .function("timestamp", returnsObject().noParams()) { it.target?.timestamp }
                .function("isSigned", returns(Type.Z).noParams()) { it.target?.isSigned }
        }
    }
}
