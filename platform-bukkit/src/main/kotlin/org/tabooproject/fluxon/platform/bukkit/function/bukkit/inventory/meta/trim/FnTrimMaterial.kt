package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.trim

import org.bukkit.inventory.meta.trim.TrimMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.meta.trim.TrimMaterial"])
@PlatformSide(Platform.BUKKIT)
object FnTrimMaterial {

    val TYPE = Type.fromClass(TrimMaterial::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.inventory.meta.trim.TrimMaterial::class.java)
                // static getTrimMaterial
                // .function("description", returns(Type.fromClass(net.kyori.adventure.text.Component::class.java)).noParams()) { it.setReturnRef(it.target?.description()) }
                .function("getTranslationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getTranslationKey()) }
                .function("getKey", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.getKey()) }
                // .function("key", returns(Type.fromClass(net.kyori.adventure.key.Key::class.java)).noParams()) { it.setReturnRef(it.target?.key()) }
        }
    }
}
