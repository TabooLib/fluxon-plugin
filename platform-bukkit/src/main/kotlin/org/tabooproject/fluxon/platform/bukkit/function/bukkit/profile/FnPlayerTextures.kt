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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.profile.PlayerTextures"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerTextures {

    val TYPE = Type.fromClass(PlayerTextures::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerTextures::class.java)
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("clear", returnsVoid().noParams()) { it.target?.clear() }
                .function("skin", returnsObject().noParams()) { it.setReturnRef(it.target?.skin) }
                .function("setSkin", returnsVoid().params(Type.STRING)) {
                    it.target?.setSkin(URL(it.getString(0)))
                }
                .function("setSkin", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.setSkin(
                        URL(it.getString(0)),
                        it.getRef(1) as PlayerTextures.SkinModel
                    )
                }
                .function("skinModel", returnsObject().noParams()) { it.setReturnRef(it.target?.skinModel) }
                .function("cape", returnsObject().noParams()) { it.setReturnRef(it.target?.cape) }
                .function("setCape", returnsVoid().params(Type.STRING)) { it.target?.setCape(URL(it.getString(0))) }
                .function("timestamp", returns(Type.J).noParams()) { it.setReturnLong(it.target?.timestamp ?: 0L) }
                .function("isSigned", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSigned ?: false) }
        }
    }
}
